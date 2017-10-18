package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.TvAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/12.
 * 电视剧
 */
public class TvFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }

    @Override
    public void initData() {
        LoadData();
    }

    private void LoadData() {
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, new ActionCallBack() {
            @Override
            public void ok(Object object) {

            }

            @Override
            public void failed(Object object) {

            }
        });
    }
}
