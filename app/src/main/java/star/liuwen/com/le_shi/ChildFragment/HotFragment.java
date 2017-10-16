package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.BannerAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/12.
 * 热点
 */
public class HotFragment extends BaseFragment {


    LoopViewPager viewpager; //头部banner
    CircleIndicator indicator;//头部banner
    private BannerAdapter mBannerAdapter;
    private List<CoverModel> mBannerList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewpager = (LoopViewPager) view.findViewById(R.id.viewpager);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        mBannerAdapter = new BannerAdapter(getActivity(), mBannerList);

    }

    @Override
    public void initData() {
        showLoadingDialog("", true, null);
        MainUIAction.searchCoverData(getActivity(), new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mBannerList.addAll((Collection<? extends CoverModel>) object);
                mBannerAdapter.updateList(mBannerList);
                viewpager.setAdapter(mBannerAdapter);
                viewpager.setLooperPic(true);
                indicator.setViewPager(viewpager);
                hideLoadingDialog();
            }

            @Override
            public void failed(Object object) {
                hideLoadingDialog();
            }
        });

    }
}
