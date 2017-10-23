package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.DongManUiAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DateTimeUtils;
import star.liuwen.com.le_shi.Utils.DensityUtil;

/**
 * Created by liuwen on 2017/10/13.
 * 动漫
 */
public class MangaFragment extends BaseFragment {
    private List<HashMap<String, Object>> channelList;//频道数据
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

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);
        init();
        initView(view);
        return view;
    }

    private void init() {
        hotPlayList = new ArrayList<>();
        channelList = new ArrayList<>();//频道数据
        coverList = new ArrayList<>();//封面数据
        baoFengList = new ArrayList<>();
        qinZiList = new ArrayList<>();
        reviewClassicList = new ArrayList<>();//重温经典
        everyDateUpdateList = new ArrayList<>();//每日更新

    }

    private void initView(View view) {
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.dongman_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new DongManUiAdapter(getActivity(), DateEnage.getChannelList(),
                coverList, hotPlayList, baoFengList, qinZiList, reviewClassicList,
                everyDateUpdateList, itemWidth);
        mRecyclerView.setAdapter(mAdapter);
        initSizeAndDate();
    }

    @Override
    public void initData() {
        if (!isLoad)
            LoadDate();
        isLoad = true;


    }

    private void LoadDate() {
        showLoadingDialog("", true, null);
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
                hideLoadingDialog();
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
    }

    private void initSizeAndDate() {
        try {
            String currentWeek = DateTimeUtils.getWeekOfDate(getActivity(), DateTimeUtils.getCurrentDateObject());
            if (currentWeek.equals(mContext.getString(R.string.mon))) {
                start = 0;
                size = 1;
                date = "周一更新";
            } else if (currentWeek.equals(getString(R.string.tue))) {
                start = 1;
                size = 2;
                date = "周二更新";
            } else if (currentWeek.equals(mContext.getString(R.string.wed))) {
                start = 2;
                size = 3;
                date = "周三更新";
            } else if (currentWeek.equals(mContext.getString(R.string.thu))) {
                start = 3;
                size = 4;
                date = "周四更新";
            } else if (currentWeek.equals(mContext.getString(R.string.wed))) {
                start = 4;
                size = 5;
                date = "周五更新";
            } else if (currentWeek.equals(mContext.getString(R.string.sun))) {
                start = 5;
                size = 6;
                date = "周六更新";
            } else if (currentWeek.equals(mContext.getString(R.string.sat))) {
                start = 6;
                size = 7;
                date = "周日更新";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
