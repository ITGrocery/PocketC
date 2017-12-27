package cn.itgrocery.pocketc.ui.main.fragment.onetab;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.itgrocery.pocketc.R;
import cn.itgrocery.pocketc.base.SimpleFragment;

/**
 * Created by chenxl on 2017/12/27.
 */

public class HotTopicsFragment extends SimpleFragment {
    @BindView(R.id.tv_main_tab_one_hot_topics_error_info)
    TextView tvMainTabOneHotTopicsErrorInfo;
    @BindView(R.id.rv_main_tab_one_hot_topics)
    RecyclerView rvMainTabOneHotTopics;
    @BindView(R.id.srl_main_tab_one_hot_topics)
    SwipeRefreshLayout srlMainTabOneHotTopics;

    public static HotTopicsFragment newInstance(){
        return new HotTopicsFragment();
    }

    @Override
    protected void initEventAndData() {
        rvMainTabOneHotTopics.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        rvMainTabOneHotTopics.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = getLayoutInflater().inflate(R.layout.item_topic_preview, null);
                return new TopicPreviewItemViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });

        srlMainTabOneHotTopics.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlMainTabOneHotTopics.setRefreshing(false);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_tab_one_hot_topics;
    }


    static class TopicPreviewItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_topic_preview_sender_photo)
        ImageView ivTopicPreviewSenderPhoto;
        @BindView(R.id.tv_topic_preview_sender_name)
        TextView tvTopicPreviewSenderName;
        @BindView(R.id.tv_topic_preview_community_name)
        TextView tvTopicPreviewCommunityName;
        @BindView(R.id.tv_topic_preview_topic_send_time)
        TextView tvTopicPreviewTopicSendTime;
        @BindView(R.id.tv_topic_preview_cover)
        ImageView tvTopicPreviewCover;
        @BindView(R.id.tv_topic_preview_content)
        TextView tvTopicPreviewContent;
        @BindView(R.id.tv_topic_preview_watch_num)
        TextView tvTopicPreviewWatchNum;
        @BindView(R.id.tv_topic_preview_discuss_num)
        TextView tvTopicPreviewDiscussNum;
        @BindView(R.id.tv_topic_preview_like_num)
        TextView tvTopicPreviewLikeNum;

        TopicPreviewItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
