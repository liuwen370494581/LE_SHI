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
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.ZiXunUIAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.NetUtil;

/**
 * Created by liuwen on 2017/10/23.
 */
public class ZiXunFragment extends BaseFragment {
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> ziXunRecommendList;//资讯途径
    private List<CoverModel> headlinesList;//焦点头条
    private List<CoverModel> baoXiaoRecommendList;//爆笑推荐
    private List<CoverModel> strangeList;//人间奇闻
    private List<CoverModel> funList;//娱乐新闻
    private List<CoverModel> starList;//明星资讯
    private List<CoverModel> sportList;//体育资讯
    private List<CoverModel> scienceList;//科技资讯
    private List<CoverModel> musicList;//音乐资讯
    private List<CoverModel> gameList;//游戏资讯

    private RecyclerView mRecyclerView;
    private ZiXunUIAdapter mAdapter;
    private boolean isLoad = false;
    protected StateView mStateView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zi_xun, container, false);
        init();
        initView(view);
        setListener();
        return view;
    }

    private void setListener() {
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                mAdapter.clearAllData();
                loadDate();
            }
        });
    }

    private void init() {
        coverList = new ArrayList<>();
        ziXunRecommendList = new ArrayList<>();//资讯途径
        headlinesList = new ArrayList<>();//焦点头条
        baoXiaoRecommendList = new ArrayList<>();//爆笑推荐
        strangeList = new ArrayList<>();//人间奇闻
        funList = new ArrayList<>();//娱乐新闻
        starList = new ArrayList<>();//明星资讯
        sportList = new ArrayList<>();//体育资讯
        scienceList = new ArrayList<>();//科技资讯
        musicList = new ArrayList<>();//音乐资讯
        gameList = new ArrayList<>();//游戏资讯
    }

    private void initView(View view) {
        mStateView = StateView.inject(view);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.zi_xun_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void initData() {


        if (!isLoad) {
            loadDate();
            isLoad = true;
        }
        mAdapter = new ZiXunUIAdapter(getActivity(),
                coverList, ziXunRecommendList, headlinesList, baoXiaoRecommendList, strangeList, funList,
                starList, sportList, scienceList, musicList, gameList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadDate() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        TvAction.searchZiXunCoverData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 0, 12, "资讯推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                ziXunRecommendList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateZiXunRecommendList(ziXunRecommendList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });

        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 15, 25, "焦点头条", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                headlinesList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateHeadlinesList(headlinesList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 25, 35, "爆笑推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                baoXiaoRecommendList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBaoXiaoRecommendList(baoXiaoRecommendList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 35, 39, "人间奇闻", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                strangeList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateStrangeList(strangeList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 39, 49, "娱乐新闻", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                funList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateFunList(funList);

            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 49, 51, "明星资讯", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                starList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateStarList(starList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 51, 57, "体育资讯", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                sportList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateSportList(sportList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 58, 64, "科技资讯", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                scienceList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateScienceList(scienceList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 65, 69, "音乐资讯", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                musicList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMusicList(musicList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchZiXunAllData(getActivity(), Config.BAO_FENG_ZI_XUN_URL, 70, 72, "游戏资讯", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                gameList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateGameList(gameList);
            }

            @Override
            public void failed(Object object) {

            }
        });
    }
}
