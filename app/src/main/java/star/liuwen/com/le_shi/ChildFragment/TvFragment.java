package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.HomeUIAdapter;
import star.liuwen.com.le_shi.Adapter.TvUIAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;

/**
 * Created by liuwen on 2017/10/12.
 * 电视剧
 */
public class TvFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private int itemWidth;
    private TvUIAdapter mAdapter;

    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> hotPlayList;
    private List<CoverModel> popularList;
    private List<CoverModel> popularList2;
    private List<CoverModel> cityLoveList;
    private List<CoverModel> cityLoveList2;
    private List<CoverModel> xuanNingList;
    private List<CoverModel> xuanNingList2;
    private List<CoverModel> netWorkList;
    private List<CoverModel> kangWarList;
    private boolean isLoaded = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        init();
        initView(view);
        return view;
    }


    private void init() {
        coverList = new ArrayList<>();//封面数据
        hotPlayList = new ArrayList<>();
        popularList = new ArrayList<>();
        popularList2 = new ArrayList<>();
        cityLoveList = new ArrayList<>();
        cityLoveList2 = new ArrayList<>();
        xuanNingList = new ArrayList<>();
        xuanNingList2 = new ArrayList<>();
        netWorkList = new ArrayList<>();
        kangWarList = new ArrayList<>();
    }

    private void initView(View view) {
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_tv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TvUIAdapter(getActivity(), DateEnage.getChannelList(),
                coverList, hotPlayList, popularList, popularList2, cityLoveList,
                cityLoveList2, xuanNingList, xuanNingList2,
                netWorkList, kangWarList, itemWidth);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        if (!isLoaded) {
            LoadData();
            isLoaded = true;
        }
    }

    private void LoadData() {
        showLoadingDialog("", true, null);
        MainUIAction.searchCoverData(getActivity(), Config.BAO_FENG_TV_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 0, 8, true, false, "最受欢迎",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        popularList.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updatePopularList(popularList);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 0, 8, false, true, "最受欢迎",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        popularList2.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updatePopularList(popularList2);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 8, 14, true, false, "都市爱情",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        cityLoveList.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateCityLoveList(cityLoveList);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 8, 14, false, true, "都市爱情",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        cityLoveList2.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateCityLoveList2(cityLoveList2);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 14, 20, true, false, "悬念侦破",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        xuanNingList.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateXuanNingList(xuanNingList);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 14, 20, false, true, "悬念侦破",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        xuanNingList2.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateXuanNingList2(xuanNingList2);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });

        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_TV_URL, 0, 8, "热播剧", new ActionCallBack() {
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
        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_TV_URL, 8, 10, "网络剧", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                netWorkList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateNetWorkList(netWorkList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_TV_URL, 10, 16, "抗战经典", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                kangWarList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateKangWarList(kangWarList);
            }

            @Override
            public void failed(Object object) {

            }
        });
    }
}
