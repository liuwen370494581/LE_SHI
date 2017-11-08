package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.nukc.stateview.StateView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.MovieAdapter;
import star.liuwen.com.le_shi.Adapter.TvUIAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.EventBus.C;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;
import star.liuwen.com.le_shi.Utils.NetUtil;

/**
 * Created by liuwen on 2017/10/12.
 * 电影
 */
public class MovieFragment extends BaseFragment {
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> vipList;//会员
    private List<CoverModel> vipList2;
    private List<CoverModel> mostPopularList;//最受欢迎
    private List<CoverModel> mostPopularList2;
    private List<CoverModel> huaYuList; //华语
    private List<CoverModel> huaYuList2;
    private List<CoverModel> ouMeiList;//欧美
    private List<CoverModel> ouMeiList2;
    private List<CoverModel> whiteLoveList;//白色爱情
    private List<CoverModel> dongHuaList;//动漫
    private int itemWidth;

    private RecyclerView mRecyclerView;
    private boolean isLoad = false;
    private MovieAdapter mAdapter;
    private StateView mStateView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        init();
        initView(view);
        setListener();
        return view;
    }

    private void setListener() {
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                LoadData();
            }
        });
    }

    private void init() {
        coverList = new ArrayList<>();
        vipList = new ArrayList<>();
        vipList2 = new ArrayList<>();
        mostPopularList = new ArrayList<>();
        mostPopularList2 = new ArrayList<>();
        huaYuList = new ArrayList<>();
        huaYuList2 = new ArrayList<>();
        ouMeiList = new ArrayList<>();
        ouMeiList2 = new ArrayList<>();
        whiteLoveList = new ArrayList<>();
        dongHuaList = new ArrayList<>();
    }

    private void initView(View view) {
        mStateView = StateView.inject(view);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.movie_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new MovieAdapter(getActivity(), DateEnage.getMovieChannelList(),
                coverList, vipList, vipList2, mostPopularList, mostPopularList2,
                huaYuList, huaYuList2, ouMeiList,
                ouMeiList2, whiteLoveList, dongHuaList, itemWidth);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        if (!isLoad)
            LoadData();
        isLoad = true;
    }

    private void LoadData() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        MainUIAction.searchCoverData(getActivity(), Config.BAO_FENG_MOIVE_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList = (List<CoverModel>) object;
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 0, 7, true, false, "会员专区", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                vipList = (List<CoverModel>) object;
                mAdapter.updateVipList(vipList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 0, 7, false, true, "会员专区", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                vipList2 = (List<CoverModel>) object;
                mAdapter.updateVipList2(vipList2);

            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 7, 14, true, false, "最受欢迎", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mostPopularList = (List<CoverModel>) object;
                mAdapter.updatePopularList(mostPopularList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 7, 14, false, true, "最受欢迎", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mostPopularList2 = (List<CoverModel>) object;
                mAdapter.updatePopularList2(mostPopularList2);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 14, 20, true, false, "华语", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                huaYuList = (List<CoverModel>) object;
                mAdapter.updateHuaYuList(huaYuList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 14, 20, false, true, "华语", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                huaYuList2 = (List<CoverModel>) object;
                mAdapter.updateHuaYuList2(huaYuList2);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 20, 26, true, false, "欧美", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                ouMeiList = (List<CoverModel>) object;
                mAdapter.updateOuMeiList(ouMeiList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_MOIVE_URL, 20, 26, false, true, "欧美", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                ouMeiList2 = (List<CoverModel>) object;
                mAdapter.updateOuMeiList2(ouMeiList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllMovieData(getActivity(), Config.BAO_FENG_MOIVE_URL, 0, 2, "白色爱情", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                whiteLoveList = (List<CoverModel>) object;
                mAdapter.updateWhiteLoveList(whiteLoveList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllMovieData(getActivity(), Config.BAO_FENG_MOIVE_URL, 2, 9, "动画", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                dongHuaList = (List<CoverModel>) object;
                mAdapter.updateDongHuaList(dongHuaList);
            }

            @Override
            public void failed(Object object) {

            }
        });
    }

}
