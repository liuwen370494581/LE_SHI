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
import star.liuwen.com.le_shi.Jsoup.Action.MainUIAction;
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
        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 0, 8, true, true, true, "最受欢迎",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {

                    }

                    @Override
                    public void failed(Object object) {

                    }
                });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 8, 14, true, true, true, "都市爱情",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {

                    }

                    @Override
                    public void failed(Object object) {

                    }
                });


        TvAction.searchTvHotPlayData(getActivity(), Config.BAO_FENG_TV_URL, 14, 20, true, true, true, "悬念侦破",
                new ActionCallBack() {
                    @Override
                    public void ok(Object object) {

                    }

                    @Override
                    public void failed(Object object) {

                    }
                });


//        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_TV_URL, 0, 8, "热播剧", new ActionCallBack() {
//            @Override
//            public void ok(Object object) {
//
//            }
//
//            @Override
//            public void failed(Object object) {
//
//            }
//        });
//        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_TV_URL, 8, 10, "网络剧", new ActionCallBack() {
//            @Override
//            public void ok(Object object) {
//
//            }
//
//            @Override
//            public void failed(Object object) {
//
//            }
//        });
//
//        MainUIAction.searchTvData(getActivity(), Config.BAO_FENG_TV_URL, 10, 16, "抗战经典", new ActionCallBack() {
//            @Override
//            public void ok(Object object) {
//
//            }
//
//            @Override
//            public void failed(Object object) {
//
//            }
//        });
    }
}
