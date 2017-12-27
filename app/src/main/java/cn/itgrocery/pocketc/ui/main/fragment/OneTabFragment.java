package cn.itgrocery.pocketc.ui.main.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.SimpleFragment;
import cn.itgrocery.pocketc.ui.main.adapter.OneTabPagerAdapter;

/**
 * Created by xc on 2017/12/25.
 */

public class OneTabFragment extends SimpleFragment {

    @BindView(R.id.tl_main_one_tab)
    TabLayout tlMainOneTab;
    @BindView(R.id.iv_main_one_tab_head_search)
    ImageView ivMainOneTabHeadSearch;
    @BindView(R.id.ll_main_one_tab_head_container)
    LinearLayout llMainOneTabHeadContainer;
    @BindView(R.id.vp_main_one_tab)
    ViewPager vpMainOneTab;

    public static OneTabFragment newInstance() {
        return new OneTabFragment();
    }

    @Override
    protected void initEventAndData() {
        vpMainOneTab.setAdapter(new OneTabPagerAdapter(getChildFragmentManager()));
        tlMainOneTab.setupWithViewPager(vpMainOneTab);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_tab_one;
    }

}
