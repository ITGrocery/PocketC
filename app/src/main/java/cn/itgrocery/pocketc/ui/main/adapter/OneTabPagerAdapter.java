package cn.itgrocery.pocketc.ui.main.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.itgrocery.pocketc.ui.main.fragment.TestFragment;
import cn.itgrocery.pocketc.ui.main.fragment.onetab.HotTopicsFragment;

/**
 * Created by chenxl on 2017/12/27.
 */

public class OneTabPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] labels = new String[]{"热点","关注"};

    public OneTabPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(HotTopicsFragment.newInstance());
        fragmentList.add(TestFragment.newInstance(labels[1]));
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return labels[position];
    }
}
