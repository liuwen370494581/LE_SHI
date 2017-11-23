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

import star.liuwen.com.le_shi.Adapter.VarietyUIAdapter;
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
 * Created by liuwen on 2017/10/12.
 * 综艺
 */
public class VarietyFragment extends BaseFragment {
    private List<String> channelList;
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> highlightsList;//精彩看点
    private List<CoverModel> highlightsList2;
    private List<CoverModel> hotPlayList;//最热播放
    private List<CoverModel> varietyList;//内地综艺
    private List<CoverModel> varietyList2;
    private List<CoverModel> baoFengList;//暴风出品
    private List<CoverModel> baoFengList2;
    private int itemWidth;
    private boolean isLoad;

    private RecyclerView mRecyclerView;
    private VarietyUIAdapter mAdapter;
    private StateView mStateView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_variey, container, false);
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
                loadData();
            }
        });
    }

    private void init() {
        channelList = new ArrayList<>();
        coverList = new ArrayList<>();//封面数据
        highlightsList = new ArrayList<>();
        highlightsList2 = new ArrayList<>();
        hotPlayList = new ArrayList<>();
        varietyList = new ArrayList<>();
        varietyList2 = new ArrayList<>();
        baoFengList = new ArrayList<>();
        baoFengList2 = new ArrayList<>();
    }


    private void initView(View view) {
        mStateView = StateView.inject(view);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.variey_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void initData() {
        if (!isLoad)
            loadData();
        isLoad = true;
        mAdapter = new VarietyUIAdapter(getActivity(), channelList,
                coverList, highlightsList, highlightsList2, hotPlayList, varietyList, varietyList2,
                baoFengList, baoFengList2, itemWidth);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadData() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        TvAction.searchZiYiCoverData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 0, 6, true, false, "精彩看点",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        highlightsList.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateHighlightsList(highlightsList);
                        mStateView.showContent();
                    }

                    @Override
                    public void failed(Object object) {
                        mStateView.showRetry();
                    }
                });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 0, 6, false, true, "精彩看点",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        highlightsList2.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateHighlightsList2(highlightsList2);

                    }

                    @Override
                    public void failed(Object object) {

                    }
                });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 37, 51, true, false, "内地综艺",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        varietyList.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateVarietyList(varietyList);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 37, 51, false, true, "内地综艺",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        varietyList2.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateVarietyList2(varietyList2);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 51, 57, true, false, "暴风出品",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        baoFengList.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateBaoFengList(baoFengList);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });

        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 51, 57, false, true, "暴风出品",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {
                        baoFengList2.addAll((Collection<? extends CoverModel>) object);
                        mAdapter.updateBaoFengList2(baoFengList2);
                    }

                    @Override
                    public void failed(Object object) {

                    }
                });

        TvAction.searchAllMovieData(getActivity(), Config.BAO_FENG_ZONG_YI_URL, 0, 10, "强档热播", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                hotPlayList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateHotPlayList(hotPlayList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchChannelDate(getActivity(), Config.CHANNEL_ZONG_YI, new ActionCallBack() {
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
}
