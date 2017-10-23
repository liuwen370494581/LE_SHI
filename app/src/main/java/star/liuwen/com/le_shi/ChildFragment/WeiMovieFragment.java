package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/23.
 */
public class WeiMovieFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_w_movie, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }


    @Override
    public void initData() {

    }
}
