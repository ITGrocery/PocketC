package cn.itgrocery.pocketc.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xc on 2017/12/23.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
