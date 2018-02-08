package star.liuwen.com.le_shi.Activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.WatchHistoryAdapter;
import star.liuwen.com.le_shi.Base.App;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Dao.DaoCoverQuery;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/07 15:21
 * desc   :
 */
public class WatchHistoryActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private SpringView mSpringView;
    private WatchHistoryAdapter mAdapter;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_watch_history;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("全部历史");
        mRecyclerView = getView(R.id.watch_history_recycler_view);
        mSpringView = getView(R.id.watch_history_sping_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new WatchHistoryAdapter(mRecyclerView);

    }

    @Override
    protected void initData() {
        if (DaoCoverQuery.getListSize() != 0) {
            List<CoverModel> temList = DaoCoverQuery.queryByTel(App.getUserInfoTel());
            mAdapter.setData(temList);
        } else {
            mAdapter.setData(new ArrayList<CoverModel>());
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {
        //全选或者取消事件
        AllAndCancel();
    }

    private void AllAndCancel() {

    }


}
