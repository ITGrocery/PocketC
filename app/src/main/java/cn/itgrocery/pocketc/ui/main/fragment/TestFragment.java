package cn.itgrocery.pocketc.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.SimpleFragment;

/**
 * Created by xc on 2017/12/24.
 */

public class TestFragment extends SimpleFragment {

    @BindView(R.id.fs_title)
    TextView fs_title;

    public static TestFragment newInstance(String title) {
        TestFragment simpleFragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("title", title);
        simpleFragment.setArguments(bundle);
        return simpleFragment;
    }

    @Override
    protected void initEventAndData() {
        String title = getArguments().getCharSequence("title", "no title").toString();
        fs_title.setText(title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_simple;
    }

}
