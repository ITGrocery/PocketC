package cn.itgrocery.pocketc.di.module;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.itgrocery.pocketc.BuildConfig;
import cn.itgrocery.pocketc.app.Constants;
import cn.itgrocery.pocketc.model.http.api.TestApi;
import cn.itgrocery.pocketc.util.SystemUtil;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenxl on 2017/12/28.
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {return new Retrofit.Builder();}

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {return new OkHttpClient.Builder();}

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder){

        if(BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CAHE);
        Cache cahe = new Cache(cacheFile,1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if(!SystemUtil.isNetworkConnected()){
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);

                if(SystemUtil.isNetworkConnected()){
                    int maxAge = 0;
                    response.newBuilder()
                            .header("Cache-Control","public,max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                }else {
                    int maxStale = 60 * 60 *24 *28;
                    response.newBuilder()
                            .header("Cache-Control","public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cahe);

        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20,TimeUnit.SECONDS);
        builder.writeTimeout(20,TimeUnit.SECONDS);

        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client,TestApi.HOST);
    }

    @Singleton
    @Provides
    TestApi provideTestApi(Retrofit retrofit){
        return retrofit.create(TestApi.class);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, String url){
        return builder
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
