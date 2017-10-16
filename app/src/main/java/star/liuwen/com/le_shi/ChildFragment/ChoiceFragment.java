package star.liuwen.com.le_shi.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.HotAction;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DensityUtil;
import star.liuwen.com.le_shi.Utils.GlideUtils;
import star.liuwen.com.le_shi.Utils.ToastUtils;

/**
 * Created by liuwen on 2017/10/13.
 * 精选
 */
public class ChoiceFragment extends BaseFragment {

    private List<CoverModel> mList = new ArrayList<>();
    private HotAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private int itemWidth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choice, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        itemWidth = DensityUtil.getScreenWidth(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_choice);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new HotAdapter(mRecyclerView);
        mAdapter.setData(mList);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void initData() {
        LoadData();
    }

    private void LoadData() {
        showLoadingDialog("", true, null);
        HotAction.searchCoverData(getActivity(), new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mAdapter.setData((List<CoverModel>) object);
                hideLoadingDialog();
            }

            @Override
            public void failed(Object object) {
                ToastUtils.showToast(getActivity(), object.toString());
                hideLoadingDialog();
            }
        });
    }


    private class HotAdapter extends BGARecyclerViewAdapter<CoverModel> {

        public HotAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.hot_item);
        }


        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, CoverModel model) {
            GlideUtils.loadImage(helper.getImageView(R.id.image_hot), model.getCoverUrl(), R.mipmap.default_book, R.mipmap.default_book);
            helper.setText(R.id.txt_hot, model.getCoverTitle());
        }
    }
}
