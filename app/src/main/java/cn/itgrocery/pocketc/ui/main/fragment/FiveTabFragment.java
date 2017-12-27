package cn.itgrocery.pocketc.ui.main.fragment;

import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.BaseFragment;
import cn.itgrocery.pocketc.base.SimpleFragment;

/**
 * Created by chenxl on 2017/12/27.
 */

public class FiveTabFragment extends SimpleFragment {

    public static FiveTabFragment newInstance(){
        return new FiveTabFragment();
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_tab_five;
    }
}
