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
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.DongManUiAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;
import star.liuwen.com.le_shi.Utils.NetUtil;

/**
 * Created by liuwen on 2017/10/13.
 * 动漫
 */
public class MangaFragment extends BaseFragment {
    private List<String> channelList;
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> hotPlayList;
    private List<CoverModel> baoFengList;
    private List<CoverModel> qinZiList;
    private List<CoverModel> reviewClassicList;//重温经典
    private List<CoverModel> everyDateUpdateList;//每日更新

    private RecyclerView mRecyclerView;
    private DongManUiAdapter mAdapter;
    private int itemWidth;
    private boolean isLoad = false;

    private int start = 0;
    private int size = 1;
    private String date = "周一";
    private StateView mStateView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
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
                LoadDate();
            }
        });
    }

    private void init() {
        channelList = new ArrayList<>();
        hotPlayList = new ArrayList<>();
        coverList = new ArrayList<>();//封面数据
        baoFengList = new ArrayList<>();
        qinZiList = new ArrayList<>();
        reviewClassicList = new ArrayList<>();//重温经典
        everyDateUpdateList = new ArrayList<>();//每日更新

    }

    private void initView(View view) {
        mStateView = StateView.inject(view);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.dongman_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getWeek();
    }

    @Override
    public void initData() {
        if (!isLoad) {
            LoadDate();
            isLoad = true;
        }
        mAdapter = new DongManUiAdapter(getFragmentContext(), channelList,
                coverList, hotPlayList, baoFengList, qinZiList, reviewClassicList,
                everyDateUpdateList, itemWidth);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void LoadDate() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        TvAction.searchZiYiCoverData(getActivity(), Config.BAO_FENFG_DONG_MAN_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchDongManData(getActivity(), Config.BAO_FENFG_DONG_MAN_URL, 0, 10, "热门影视", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                hotPlayList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateHotPlayList(hotPlayList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchDongManData(getActivity(), Config.BAO_FENFG_DONG_MAN_URL, 10, 20, "暴风推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                baoFengList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBaoFengList(baoFengList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchDongManData(getActivity(), Config.BAO_FENFG_DONG_MAN_URL, 20, 34, "亲子动画", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                qinZiList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateQinZiList(qinZiList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchDongManData(getActivity(), Config.BAO_FENFG_DONG_MAN_URL, 34, 48, "重温经典", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                reviewClassicList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateReviewClassicList(reviewClassicList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchDongManEveryUpdateDate(getActivity(), Config.BAO_FENFG_DONG_MAN_URL, start, size, date, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                everyDateUpdateList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateEveryDateUpdateList(everyDateUpdateList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchChannelDate(getActivity(), Config.CHANNEL_DONG_MAN, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                channelList.addAll((Collection<? extends String>) object);
                mAdapter.updateChannelList(channelList);
            }

            @Override
            public void failed(Object object) {

            }
        });
    }

    private void getWeek() {
        try {
            Calendar cal = Calendar.getInstance();
            int i = cal.get(Calendar.DAY_OF_WEEK);
            switch (i) {
                case 1:
                    start = 6;
                    size = 7;
                    date = "周日更新";
                    break;
                case 2:
                    start = 0;
                    size = 1;
                    date = "周一更新";
                    break;
                case 3:
                    start = 1;
                    size = 2;
                    date = "周二更新";
                    break;
                case 4:
                    start = 2;
                    size = 3;
                    date = "周三更新";
                    break;
                case 5:
                    start = 3;
                    size = 4;
                    date = "周四更新";
                    break;
                case 6:
                    start = 4;
                    size = 5;
                    date = "周五更新";
                    break;
                case 7:
                    start = 5;
                    size = 6;
                    date = "周六更新";
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
