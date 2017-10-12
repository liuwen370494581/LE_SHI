package star.liuwen.com.le_shi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/12.
 */
public class LiveFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        return view;
    }
    @Override
    public void initData() {

    }
}
