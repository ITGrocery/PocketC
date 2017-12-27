package cn.itgrocery.pocketc.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.itgrocery.pocketc.ui.main.fragment.SimpleFragment;

/**
 * Created by xc on 2017/12/24.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(SimpleFragment.newInstance("title_1"));
        fragments.add(SimpleFragment.newInstance("title_2"));
        fragments.add(SimpleFragment.newInstance("title_3"));
        fragments.add(SimpleFragment.newInstance("title_4"));
        fragments.add(SimpleFragment.newInstance("title_5"));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
