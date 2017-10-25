package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import star.liuwen.com.le_shi.Adapter.PopAndCityLoveAndXuanningAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.ToastUtils;
import star.liuwen.com.le_shi.View.DefineBAGRefreshWithLoadView;

/**
 * Created by liuwen on 2017/10/23.
 */
public class WeiMovieFragment extends BaseFragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private boolean isLoad;

    //下拉刷新控件
    private DefineBAGRefreshWithLoadView mDefineBAGRefreshWithLoadView = null;
    private BGARefreshLayout mBGARefreshLayout;
    private RecyclerView mRecyclerView;
    private PopAndCityLoveAndXuanningAdapter mAdapter;
    private List<CoverModel> mList;
    private List<CoverModel> mList2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_w_movie, container, false);
        init();
        initView(view);
        return view;
    }

    private void init() {
        mList = new ArrayList<>();
        mList2 = new ArrayList<>();
    }


    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.wei_movie_recycler_view);
        mBGARefreshLayout = (BGARefreshLayout) view.findViewById(R.id.define_bga_refresh_with_load);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new PopAndCityLoveAndXuanningAdapter(getActivity(), mList, mList2, false);
        mRecyclerView.setAdapter(mAdapter);
        setListener();
    }

    private void setListener() {
        mBGARefreshLayout.setDelegate(this);
        mDefineBAGRefreshWithLoadView = new DefineBAGRefreshWithLoadView(getActivity(), true, true);
        //设置刷新样式
        mBGARefreshLayout.setRefreshViewHolder(mDefineBAGRefreshWithLoadView);
        mDefineBAGRefreshWithLoadView.setRefreshingText("正在加载中...");
        mDefineBAGRefreshWithLoadView.setPullDownRefreshText("正在加载中...");
        mDefineBAGRefreshWithLoadView.setReleaseRefreshText("下拉刷新中...");
    }


    @Override
    public void initData() {
        if (!isLoad)
            loadDate();
        isLoad = true;
    }

    private void loadDate() {
        showLoadingDialog("", true, null);
        TvAction.searchAllWeiMovieData(getActivity(), Config.BAO_FENG_WEI_MOVIE_URL, true, false, "微电影", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateList(mList);
                hideLoadingDialog();
            }

            @Override
            public void failed(Object object) {
                ToastUtils.showToast(getActivity(), object.toString());
                hideLoadingDialog();
            }
        });

        TvAction.searchAllWeiMovieData(getActivity(), Config.BAO_FENG_WEI_MOVIE_URL, false, true, "微电影", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateList2(mList2);
            }

            @Override
            public void failed(Object object) {
                ToastUtils.showToast(getActivity(), object.toString());
                hideLoadingDialog();
            }
        });
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mDefineBAGRefreshWithLoadView.showLoadingMoreImg();
        //  page = 1;
        mList.clear();
        mList2.clear();
        loadDate();
        mBGARefreshLayout.endRefreshing();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
