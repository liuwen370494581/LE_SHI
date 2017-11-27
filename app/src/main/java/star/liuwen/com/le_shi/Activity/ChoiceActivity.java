package star.liuwen.com.le_shi.Activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.ChoiceConditionAdapter;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.Listener.OnCommonBarListener;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;

/**
 * Created by liuwen on 2017/11/23.
 */
public class ChoiceActivity extends BaseActivity {
    private RecyclerView conditionRecyclerView;
    private ChoiceConditionAdapter mAdapter;
    private RelativeLayout mRelativeLayout;
    private int itemWidth;

    @Override
    protected int setLayoutRes() {
        return R.layout.choice_activity;

    }

    @Override
    protected void initView() {
        setCenterText("筛选");
        showLeftView();
        itemWidth = DensityUtil.getScreenWidth(this);
        //mRecyclerView = getView(R.id.activity_choice_recycler_view);
        conditionRecyclerView = getView(R.id.choice_condition_recycler_view);
        mRelativeLayout = getView(R.id.choice_condition);

        setRightListener(new OnCommonBarListener() {
            @Override
            public void onRightChoiceListener() {
                if (mRelativeLayout.getVisibility() == View.VISIBLE) {
                    mRelativeLayout.setVisibility(View.GONE);
                } else {
                    mRelativeLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void initData() {
        mRelativeLayout.setVisibility(View.VISIBLE);
        mAdapter = new ChoiceConditionAdapter(this, DateEnage.getContentDate(), DateEnage.getSortDate(), DateEnage.getMoneyDate()
                , DateEnage.getTypeDate(), DateEnage.getLocDate(), DateEnage.getYearDate(), itemWidth);
        conditionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        conditionRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {

    }
}
