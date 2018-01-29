package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.nukc.stateview.StateView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.PopAndCityLoveAndXuanningAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.NetUtil;
import star.liuwen.com.le_shi.Utils.ToastUtils;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * Created by liuwen on 2017/10/23.
 */
public class WeiMovieFragment extends BaseFragment {
    private boolean isLoad;
    private RecyclerView mRecyclerView;
    private PopAndCityLoveAndXuanningAdapter mAdapter;
    private List<CoverModel> mList;
    private List<CoverModel> mList2;
    private StateView mStateView;
    //下拉刷新控件
    private SpringView mSpringView;

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
        mStateView = StateView.inject(view);
        mStateView.setLoadingResource(R.layout.loading);
        mStateView.setRetryResource(R.layout.base_retry);
        mSpringView = (SpringView) view.findViewById(R.id.my_springView);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.wei_movie_recycler_view);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new PopAndCityLoveAndXuanningAdapter(UIUtils.getContext(), mList, mList2, false);
        mRecyclerView.setAdapter(mAdapter);
        setListener();
    }

    private void setListener() {
        mSpringView.setHeader(new DefaultHeader(getFragmentContext()));
        mSpringView.setFooter(new DefaultFooter(getFragmentContext()));
        mSpringView.setType(SpringView.Type.FOLLOW);
        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.clearAllData();
                loadDate();
                mSpringView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                UIUtils.showToast(UIUtils.getString(R.string.no_more_data));
                mSpringView.onFinishFreshAndLoad();

            }
        });
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                mAdapter.clearAllData();
                loadDate();
            }
        });
    }


    @Override
    public void initData() {
        if (!isLoad)
            loadDate();
        isLoad = true;
    }

    private void loadDate() {

        mStateView.showLoading();
        if (!NetUtil.checkNet(getActivity())) {
            mStateView.showRetry();
            return;
        }
        TvAction.searchAllWeiMovieData(getActivity(), Config.BAO_FENG_WEI_MOVIE_URL, true, false, "微电影", new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mList.addAll((Collection<? extends CoverModel>) object);
                mAdapter.updateList(mList);
                mStateView.showContent();
            }

            @Override
            public void failed(Object object) {
                mStateView.showContent();
                ToastUtils.showToast(getActivity(), object.toString());

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
                mStateView.showContent();
                ToastUtils.showToast(getActivity(), object.toString());
            }
        });
    }

}
