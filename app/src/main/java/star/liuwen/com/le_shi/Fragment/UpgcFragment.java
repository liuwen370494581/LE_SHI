package star.liuwen.com.le_shi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.github.nukc.stateview.StateView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.MalAdapter;
import star.liuwen.com.le_shi.Adapter.MalUIAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Jsoup.Action.MalAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;
import star.liuwen.com.le_shi.Utils.NetUtil;

/**
 * Created by liuwen on 2017/10/12.
 * 商城
 */
public class UpgcFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private StateView mStateView;
    private FrameLayout flameLayout;

    private List<CoverModel> mCoverList = new ArrayList<>();
    private List<String> channelList = new ArrayList<>();
    private List<CoverModel> bannerList = new ArrayList<>();
    private List<CoverModel> dailySpecialList = new ArrayList<>(); //今日特价
    private List<CoverModel> dailySpecialList2 = new ArrayList<>();
    private List<CoverModel> baoFengTVList = new ArrayList<>();
    private List<CoverModel> baoFengTVList2 = new ArrayList<>();
    private List<CoverModel> baofengMirror = new ArrayList<>();
    private List<CoverModel> baofengMirror2 = new ArrayList<>();
    private List<CoverModel> funList = new ArrayList<>();
    private List<CoverModel> funList2 = new ArrayList<>();
    private List<CoverModel> clothesList = new ArrayList<>();
    private List<CoverModel> clothesList2 = new ArrayList<>();
    private List<CoverModel> sportsList = new ArrayList<>();
    private List<CoverModel> sportsList2 = new ArrayList<>();
    private List<CoverModel> milkList = new ArrayList<>();
    private List<CoverModel> milkList2 = new ArrayList<>();
    private MalUIAdapter mAdapter;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upgc, container, false);
        initView(view);
        init();
        setListener();
        return view;
    }

    private void init() {
        LoadDate();
    }


    private void initView(View view) {
        int itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_mal);
        flameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        mStateView = StateView.inject(flameLayout);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new MalUIAdapter(mCoverList, channelList, bannerList, dailySpecialList, dailySpecialList2, baoFengTVList, baoFengTVList2,
                baofengMirror, baofengMirror2, funList, funList2, clothesList, clothesList2, sportsList, sportsList2, milkList, milkList2, getActivity(), itemWidth);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void setListener() {
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                LoadDate();
            }
        });

    }

    private void LoadDate() {
        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        MainUIAction.searchChannelDate(getActivity(), Config.CHANNEL_MAL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                channelList.addAll((Collection<? extends String>) object);
                mAdapter.updateChannelList(channelList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MalAction.searchMalData(getActivity(), Config.BAO_FENG_MAL_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mCoverList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateCoverList(mCoverList);
            }

            @Override
            public void failed(Object object) {

            }
        });

        MalAction.searchMalImgData(getActivity(), Config.BAO_FENG_MAL_URL, "", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                bannerList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBannerList(bannerList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {

            }
        });

        MalAction.searchMalDailySpecialData(getActivity(), Config.BAO_FENG_MAL_URL, "今日特价", true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                dailySpecialList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateDailySpecialList(dailySpecialList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {

            }
        });

        MalAction.searchMalDailySpecialData(getActivity(), Config.BAO_FENG_MAL_URL, "今日特价", false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                dailySpecialList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateDailySpecialList2(dailySpecialList2);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {

            }
        });


        MalAction.searchMalTVData(getActivity(), Config.BAO_FENG_MAL_URL, "暴风TV", true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                baoFengTVList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBaoFengTVList(baoFengTVList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        MalAction.searchMalTVData(getActivity(), Config.BAO_FENG_MAL_URL, "暴风TV", false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                baoFengTVList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBaoFengTVList2(baoFengTVList2);
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });


        //暴风魔镜
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "暴风魔镜", 0, 6, true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                baofengMirror.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBaoFengMirrorList(baofengMirror);
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });
        //暴风魔镜
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "暴风魔镜", 0, 6, false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                baofengMirror2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateBaoFengMirrorList2(baofengMirror2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        //娱乐周边
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "娱乐周边", 6, 12, true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                funList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateFunList(funList);

            }

            @Override
            public void failed(Object object) {

            }
        });
        //娱乐周边
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "娱乐周边", 6, 12, false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                funList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateFunList2(funList2);
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });

        //服饰鞋帽
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "服饰鞋帽", 12, 18, true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                clothesList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateClothList(clothesList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        //服饰鞋帽
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "服饰鞋帽", 12, 18, false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                clothesList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateClothList2(clothesList2);
            }

            @Override
            public void failed(Object object) {

            }
        });

        //运动户外
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "运动户外", 18, 24, true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                sportsList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateSportsList(sportsList);
            }

            @Override
            public void failed(Object object) {

            }
        });
        //运动户外
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "运动户外", 18, 24, false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                sportsList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateSportsList2(sportsList2);
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });
        // 母婴玩具
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "母婴玩具", 24, 30, true, false, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                milkList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMilkList(milkList);

                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {

            }
        });
        MalAction.searchMalAllData(getActivity(), Config.BAO_FENG_MAL_URL, "母婴玩具", 24, 30, false, true, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                milkList2.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateMilkList2(milkList2);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {
                mStateView.showRetry();
            }
        });
    }

    @Override
    public void initData() {
    }
}
