package star.liuwen.com.le_shi.Activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Adapter.ChannelAdapter;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;

/**
 * Created by liuwen on 2017/11/9.
 */
public class OpenVipActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private int itemWidth;
    private VipChannelAdapter mAdapter;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_open_vip;
    }

    @Override
    protected void initView() {
        itemWidth = DensityUtil.getScreenWidth(this);
        showLeftView();
        setCenterText("暴风影视会员");
        mRecyclerView = getView(R.id.recycler_vip);
        GridLayoutManager manager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new VipChannelAdapter(mRecyclerView);
        mAdapter.setData(DateEnage.getChannelList());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setItemWidth(itemWidth);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    private static class VipChannelAdapter extends BGARecyclerViewAdapter<HashMap<String, Object>> {
        private int itemWidth;

        public VipChannelAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_channel);
        }


        public void setItemWidth(int itemWidth) {
            this.itemWidth = itemWidth;
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, HashMap<String, Object> model) {
            if (itemWidth != 0) {
                helper.getView(R.id.id_item_layout).setLayoutParams(new ViewGroup.LayoutParams(itemWidth / 3, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            helper.setText(R.id.tv_channel, model.get("title").toString());
            Glide.with(mContext).load(model.get("pic")).into(helper.getImageView(R.id.iv_logo));

        }
    }
}
