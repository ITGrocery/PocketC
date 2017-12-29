package cn.itgrocery.pocketc.ui.main.activity;

import android.support.design.widget.FloatingActionButton;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.Arrays;

import butterknife.BindView;
import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.BaseActivity;
import cn.itgrocery.pocketc.base.contract.main.MainContract;
import cn.itgrocery.pocketc.presenter.main.MainPresenter;
import cn.itgrocery.pocketc.ui.main.adapter.MainViewPagerAdapter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.view_pager)
    AHBottomNavigationViewPager viewPager;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;
    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;

    @Override
    protected void initEventAndData() {

        AHBottomNavigationAdapter ahBottomNavigationAdapter = new AHBottomNavigationAdapter(this,R.menu.bottom_navigation_bottom);
        ahBottomNavigationAdapter.setupWithBottomNavigation(bottomNavigation);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                viewPager.setCurrentItem(position,false);
                return true;
            }
        });

        mPresenter.testRetrofit2();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showMessage(String info) {
        showErrorMsg(info);
    }

}
