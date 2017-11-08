package star.liuwen.com.le_shi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.github.nukc.stateview.StateView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.VipUIAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;
import star.liuwen.com.le_shi.Utils.NetUtil;

/**
 * Created by liuwen on 2017/10/12.
 */
public class VipFragment extends BaseFragment {

    private List<CoverModel> coverList = new ArrayList<>();//封面数据
    private List<CoverModel> mostPopularList = new ArrayList<>();//最受欢迎
    private List<CoverModel> mostPopularList2 = new ArrayList<>();//最受欢迎
    private List<CoverModel> newFilmRecommendList = new ArrayList<>();//新片推荐
    private List<CoverModel> newFilmRecommendList2 = new ArrayList<>();//新片推荐
    private List<CoverModel> choiceList = new ArrayList<>();//精选
    private List<CoverModel> choiceList2 = new ArrayList<>();//精选
    private List<CoverModel> educationList = new ArrayList<>();//教育
    private List<CoverModel> educationList2 = new ArrayList<>();//教育
    private List<CoverModel> qinZiList = new ArrayList<>();//亲子
    private List<CoverModel> qinZiList2 = new ArrayList<>();//亲子
    private List<CoverModel> horrorFilmList = new ArrayList<>();//恐怖片
    private List<CoverModel> horrorFilmList2 = new ArrayList<>();//恐怖片
    private int itemWidth;

    private RecyclerView mRecyclerView;
    private VipUIAdapter mAdapter;
    private StateView mStateView;
    private FrameLayout mFrameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vip, container, false);
        initView(view);
        init();
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


    private void initView(View view) {
        mFrameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        mStateView = StateView.inject(mFrameLayout);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.vip_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new VipUIAdapter(getActivity(), DateEnage.getVipChannelList(),
                coverList, mostPopularList, mostPopularList2, newFilmRecommendList, newFilmRecommendList2, choiceList,
                choiceList2, educationList, educationList2, qinZiList, qinZiList2,
                horrorFilmList, horrorFilmList2, itemWidth);
        mRecyclerView.setAdapter(mAdapter);

    }


    private void init() {
      //  LoadData();
    }

    private void LoadData() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        MainUIAction.searchCoverData(getActivity(), Config.BAO_FENG_VIP_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                coverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(coverList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 1, 7, true, false, "最受欢迎", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mostPopularList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMostPopularList(mostPopularList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 1, 7, false, true, "最受欢迎", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mostPopularList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMostPopularList2(mostPopularList2);
            }

            @Override
            public void failed(Object object) {

            }
        });


        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 7, 13, true, false, "新片推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                newFilmRecommendList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateNewFilmRecommendList(newFilmRecommendList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 7, 13, false, true, "新片推荐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                newFilmRecommendList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateNewFilmRecommendList2(newFilmRecommendList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 14, 41, true, false, "为您精选", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                choiceList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateChoiceList(choiceList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 14, 41, false, true, "为您精选", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                choiceList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateChoiceList2(choiceList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 42, 48, true, false, "教育", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                educationList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateEducationList(educationList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 42, 48, false, true, "教育", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                educationList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateEducationList2(educationList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 49, 55, true, false, "亲子频道 寓教于乐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                qinZiList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateQinZiList(qinZiList);

            }

            @Override
            public void failed(Object object) {

            }
        });
        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 49, 55, false, true, "亲子频道 寓教于乐", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                qinZiList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateQinZiList2(qinZiList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 56, 62, true, false, "夜深时分,生人勿近", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                horrorFilmList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateHorrorFilmList(horrorFilmList);

            }

            @Override
            public void failed(Object object) {

            }
        });

        TvAction.searchAllVipMovieData(getActivity(), Config.BAO_FENG_VIP_URL, 56, 62, false, true, "夜深时分,生人勿近", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                horrorFilmList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateHorrorFilmList2(horrorFilmList2);
            }

            @Override
            public void failed(Object object) {

            }
        });
    }


    @Override
    public void initData() {

    }
}
