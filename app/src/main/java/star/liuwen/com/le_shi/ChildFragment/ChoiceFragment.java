package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.nukc.stateview.StateView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.HomeUIAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Listener.OnChannelListener;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;
import star.liuwen.com.le_shi.Utils.NetUtil;

/**
 * Created by liuwen on 2017/10/13.
 * 精选
 */
public class ChoiceFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private ImageView btnClickMe;
    private int itemWidth;
    private HomeUIAdapter mAdapter;

    private List<String> channelList;
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> editList;//编辑推荐
    private List<CoverModel> editList2;
    private List<CoverModel> sportsList;//体育
    private List<CoverModel> tvList;//电视剧
    private List<CoverModel> movieList;//电影
    private List<CoverModel> dongManList;//动漫
    private List<CoverModel> zongYiList;//综艺
    private List<CoverModel> education;//教育
    private List<CoverModel> weiMovieList;//微电影
    private List<CoverModel> musicList;//音乐
    private List<CoverModel> overViewList;//全景
    private List<CoverModel> overViewList2;
    private boolean isLoaded = false;
    private LinearLayoutManager mLayoutManager;
    private StateView mStateView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choice, container, false);
        init();
        initView(view);
        setListener();
        return view;
    }

    private void init() {
        channelList = new ArrayList<>();
        coverList = new ArrayList<>();
        editList = new ArrayList<>();
        editList2 = new ArrayList<>();
        sportsList = new ArrayList<>();
        tvList = new ArrayList<>();
        movieList = new ArrayList<>();
        dongManList = new ArrayList<>();
        zongYiList = new ArrayList<>();
        education = new ArrayList<>();
        weiMovieList = new ArrayList<>();
        musicList = new ArrayList<>();
        overViewList = new ArrayList<>();
        overViewList2 = new ArrayList<>();
    }

    private void initView(View view) {
        mStateView = StateView.inject(view);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_choice);
        btnClickMe = (ImageView) view.findViewById(R.id.img_click_me);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeUIAdapter(getActivity(), channelList,
                coverList, editList, editList2, sportsList, tvList, movieList,
                dongManList, zongYiList, education, weiMovieList, musicList,
                overViewList, overViewList2, itemWidth);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void setListener() {

        mAdapter.setListener(new OnChannelListener() {
            @Override
            public void onItemClickListener(int position, List<String> list) {
                mRecyclerView.smoothScrollToPosition(position + 3);
                btnClickMe.setVisibility(View.VISIBLE);
            }
        });
        /**
         * dx > 0 时为手指向左滚动,列表滚动显示右面的内容
         dx < 0 时为手指向右滚动,列表滚动显示左面的内容
         dy > 0 时为手指向上滚动,列表滚动显示下面的内容
         dy < 0 时为手指向下滚动,列表滚动显示上面的内容
         */
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy == 0) //向下滚动
                {
                    int visibleItemCount = mLayoutManager.getChildCount();
                    int totalItemCount = mLayoutManager.getItemCount();
                    int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        btnClickMe.setVisibility(View.VISIBLE);
                    }
                } else {
                    btnClickMe.setVisibility(View.GONE);
                }
            }
        });

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.smoothScrollToPosition(0);
            }
        });
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                mAdapter.clearAllData();
                LoadData();
            }
        });
    }

    @Override
    public void initData() {
        if (!isLoaded) {
            LoadData();
            isLoaded = true;
        }
    }

    private void LoadData() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        MainUIAction.searchCoverData(getActivity(), Config.BAO_FENG_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();

            }
        });

        MainUIAction.searchSportsData(getActivity(), Config.BAO_FENG_URL, "体育", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                sportsList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateSports(sportsList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {
            }
        });

        MainUIAction.searchEditRecommendData(getActivity(), Config.BAO_FENG_URL, "编辑推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                editList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateEditList(editList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchEditRecommendData2(getActivity(), Config.BAO_FENG_URL, "编辑推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                editList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateEditList2(editList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_URL, 0, 12, "电视剧", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                tvList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateTvList(tvList);
            }

            @Override
            public void failed(Object object) {

            }
        });


        MainUIAction.searchMovieData(getActivity(), Config.BAO_FENG_URL, "电影", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                movieList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMovieList(movieList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchDongManData(getActivity(), Config.BAO_FENG_URL, "动漫", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                dongManList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateDongManList(dongManList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchZongYiData(getActivity(), Config.BAO_FENG_URL, "综艺", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                zongYiList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateZongYiList(zongYiList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchEducationData(getActivity(), Config.BAO_FENG_URL, "教育", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                education.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateEducationList(education);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchWeiMovieData(getActivity(), Config.BAO_FENG_URL, "微电影", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                weiMovieList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateWeiMovieList(weiMovieList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchMVData(getActivity(), Config.BAO_FENG_URL, "音乐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                musicList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMusicList(musicList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MainUIAction.searchOverAllViewData(getActivity(), Config.BAO_FENG_URL, "全景", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                overViewList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateOverViewList(overViewList);
            }

            @Override
            public void failed(Object object) {
            }
        });

        MainUIAction.searchOverAllViewData2(getActivity(), Config.BAO_FENG_URL, "全景", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                overViewList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateOverViewList2(overViewList2);
            }

            @Override
            public void failed(Object object) {
            }
        });

        MainUIAction.searchChannelDate(getActivity(), Config.CHANNEL_CHOICE, new ActionCallBack() {
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
