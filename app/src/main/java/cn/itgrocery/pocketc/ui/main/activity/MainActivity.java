package cn.itgrocery.pocketc.ui.main.activity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
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

    @Override
    protected void initEventAndData() {
//        mPresenter.testDagger();
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.bottom_navigation_label_one,
                R.mipmap.ic_home,R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.bottom_navigation_label_two,
                R.mipmap.ic_flag,R.color.color_tab_1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.bottom_navigation_label_three,
                R.mipmap.ic_message,R.color.color_tab_1);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.bottom_navigation_label_four,
                R.mipmap.ic_volume,R.color.color_tab_1);
        bottomNavigation.addItems(Arrays.asList(item1,item2,item3,item4));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                viewPager.setCurrentItem(position,false);
                return true;
            }
        });
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
