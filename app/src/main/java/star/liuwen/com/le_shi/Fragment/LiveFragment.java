package star.liuwen.com.le_shi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.github.nukc.stateview.StateView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGADivider;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Activity.WebActivity;
import star.liuwen.com.le_shi.Adapter.BbsAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.BbsAction;
import star.liuwen.com.le_shi.Listener.OnBbsListener;
import star.liuwen.com.le_shi.Model.BbsModel;
import star.liuwen.com.le_shi.Model.IndexModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.NetUtil;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * Created by liuwen on 2017/10/12.
 * BBS页面
 */
public class LiveFragment extends BaseFragment {

    private RecyclerView oneRecyclerView, twoRecycleView;
    private oneAdapter mAdapter;
    private BbsAdapter bbsAdapter;
    private List<BbsModel> mList = new ArrayList<>();
    private List<String> picList = new ArrayList<>();
    private StateView mStateView;
    private FrameLayout mFrameLayout;
    private int pos = 0;

    private SpringView mSpringView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        mFrameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        oneRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_one);
        twoRecycleView = (RecyclerView) view.findViewById(R.id.recycler_two);
        mStateView = StateView.inject(mFrameLayout);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        mSpringView = (SpringView) view.findViewById(R.id.live_spring_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        oneRecyclerView.setLayoutManager(manager);
        twoRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new oneAdapter(oneRecyclerView);
        bbsAdapter = new BbsAdapter(getFragmentContext(), mList, picList);
        twoRecycleView.addItemDecoration(BGADivider.newShapeDivider());
        oneRecyclerView.addItemDecoration(BGADivider.newShapeDivider());
        mAdapter.setData(DateEnage.getBBSDate());
        oneRecyclerView.setAdapter(mAdapter);
        twoRecycleView.setAdapter(bbsAdapter);
        LoadDate(Config.BAO_FENG_BBS_ALL);
        setListener();
    }


    private void LoadDate(String url) {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        BbsAction.searchBBSData(getActivity(), url, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mList.addAll((Collection<? extends BbsModel>) object);
                bbsAdapter.updateList(mList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });

        BbsAction.searchBBSImgData(getActivity(), url, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                picList.addAll((Collection<? extends String>) object);
                bbsAdapter.updatePicList(picList);

            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });
    }

    private void setListener() {

        mAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                mAdapter.setPosition(position);
                pos = position;
                mList.clear();
                picList.clear();
                LoadDate(DateEnage.getBBSDate().get(position).getUrl());
            }
        });

        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                LoadDate(DateEnage.getBBSDate().get(pos).getUrl());
            }
        });

        bbsAdapter.setListener(new OnBbsListener() {
            @Override
            public void onItemClickListener(int position, List<BbsModel> models) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra(Config.INTENT_BBS_URL, models.get(position).getUrl());
                startActivity(intent);
            }
        });

        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                bbsAdapter.clearAllDate();
                LoadDate(Config.BAO_FENG_BBS_ALL);
                mSpringView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                UIUtils.showToast(UIUtils.getString(R.string.no_more_data));
                mSpringView.onFinishFreshAndLoad();
            }
        });

        mSpringView.setHeader(new DefaultHeader(getActivity()));
        mSpringView.setFooter(new DefaultFooter(getActivity()));
    }


    private class oneAdapter extends BGARecyclerViewAdapter<IndexModel> {
        private int mPosition = 0;

        public oneAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_bbs);
        }

        public void setPosition(int position) {
            this.mPosition = position;
            notifyDataSetChanged();

        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, IndexModel model) {
            helper.setText(R.id.tv_bbs, model.getName());
            if (mPosition == position) {
                helper.setTextColor(R.id.tv_bbs, ContextCompat.getColor(getActivity(), R.color.colorAccent));
            } else {
                helper.setTextColor(R.id.tv_bbs, ContextCompat.getColor(getActivity(), R.color.text_color_66));
            }
        }
    }


    @Override
    public void initData() {
    }
}
