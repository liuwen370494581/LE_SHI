package star.liuwen.com.le_shi.Activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import star.liuwen.com.le_shi.Adapter.WatchHistoryAdapter;
import star.liuwen.com.le_shi.Base.App;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Dao.DaoCoverQuery;
import star.liuwen.com.le_shi.Listener.WatchHistoryListener;
import star.liuwen.com.le_shi.Listener.onRightListener;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.UIUtils;

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
    private RelativeLayout mLayoutShowDelete;
    private TextView tvCount;
    private boolean isAllAndCancel = true;
    private List<CoverModel> mList = new ArrayList<>();
    private List<CoverModel> deleteList = new ArrayList<>();
    private HashMap<String, Boolean> isHeadChecked = new HashMap<>();
    private HashMap<Long, Boolean> isBodyChecked = new HashMap<>();

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_watch_history;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    hideLoadDialog();
                    UIUtils.showToast("删除成功");
                    mAdapter.notifyDataSetChanged();
                    clearAllDate();
                    break;
                case 1:
                    hideLoadDialog();
                    UIUtils.showToast("删除失败");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("全部历史");
        mRecyclerView = getView(R.id.watch_history_recycler_view);
        mSpringView = getView(R.id.watch_history_sping_view);
        mLayoutShowDelete = getView(R.id.watch_history_re);
        tvCount = getView(R.id.watch_history_count);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new WatchHistoryAdapter(mRecyclerView);
        mAdapter.setIsBodyChecked(isBodyChecked);
        mAdapter.setIsHeadChecked(isHeadChecked);

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
        mAdapter.setHeadListener(new WatchHistoryListener() {
            @Override
            public void OnWatchHistoryHeadClickListenerTrue(CoverModel coverModel) {
                for (int i = 0; i < mAdapter.getItemCount(); i++) {
                    CoverModel temModel = mAdapter.getItem(i);
                    mList.add(temModel);
                    if (temModel.getCoverWatchDate().equals(coverModel.getCoverWatchDate())) {
                        deleteList.add(temModel);
                        isBodyChecked.put(temModel.getId(), true);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void OnWatchHistoryHeadClickListenerFalse(CoverModel coverModel) {
                for (int i = 0; i < mAdapter.getItemCount(); i++) {
                    CoverModel temModel = mAdapter.getItem(i);
                    mList.remove(temModel);
                    if (temModel.getCoverWatchDate().equals(coverModel.getCoverWatchDate())) {
                        deleteList.remove(temModel);
                        isBodyChecked.put(temModel.getId(), false);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onWatchHistoryBodyClickListenerTrue(CoverModel coverModel) {
                isBodyChecked.put(coverModel.getId(), true);
                mList.add(coverModel);
                deleteList.add(coverModel);
            }

            @Override
            public void OnWatchHistoryBodyClickListenerFalse(CoverModel coverModel) {
                isBodyChecked.put(coverModel.getId(), false);
                mList.remove(coverModel);
                deleteList.remove(coverModel);
            }

        });


        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.clear();
                mAdapter.setData(DaoCoverQuery.queryByTel(App.getUserInfoTel()));
                mSpringView.onFinishFreshAndLoad();

            }

            @Override
            public void onLoadmore() {
                UIUtils.showToast("没有多余的数据");
                mSpringView.onFinishFreshAndLoad();
            }
        });

        mSpringView.setHeader(new DefaultHeader(getActivityContext()));
        mSpringView.setFooter(new DefaultFooter(getActivityContext()));
    }

    private void AllAndCancel() {
        setRightText(isAllAndCancel ? "编辑" : "取消", new onRightListener() {
            @Override
            public void rightTextListener() {
                if (isAllAndCancel) {
                    //编辑
                    All();
                } else {
                    //取消
                    Cancel();
                }
            }
        });
    }

    private void Cancel() {
        mAdapter.setMultiSelect(false);
        isAllAndCancel = true;
        mLayoutShowDelete.setVisibility(View.GONE);
        clearAllDate();
        AllAndCancel();
    }

    private void All() {
        mAdapter.setMultiSelect(true);
        isAllAndCancel = false;
        AllAndCancel();
        mLayoutShowDelete.setVisibility(View.VISIBLE);
    }


    public void ClickDelete(View view) {
        if (deleteList.size() == 0) {
            UIUtils.showToast("请选择要删除的观看记录");
            return;
        }
        showLoadDialog("正在删除");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < mList.size(); i++) {
                        for (int j = 0; j < deleteList.size(); j++) {
                            if (mList.get(i).getId() == deleteList.get(j).getId()) {
                                mAdapter.removeItem(mList.get(i));
                                DaoCoverQuery.deleteByModel(mList.get(i));
                            }
                        }
                        mHandler.sendEmptyMessage(0);
                    }
                } catch (Exception e) {
                    mHandler.sendEmptyMessage(1);
                }
            }
        }, 1500);

    }

    @Override
    public void onBackPressed() {
        if (mLayoutShowDelete != null && mLayoutShowDelete.isShown()) {
            clearAllDate();
            mLayoutShowDelete.setVisibility(View.GONE);
            isAllAndCancel = true;
            AllAndCancel();
        } else {
            super.onBackPressed();
        }
    }

    private void clearAllDate() {
        mList.clear();
        deleteList.clear();
        isBodyChecked.clear();
        isHeadChecked.clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler = null;
    }
}
