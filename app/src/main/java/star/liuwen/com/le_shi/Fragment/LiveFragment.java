package star.liuwen.com.le_shi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGADivider;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Adapter.BbsAdapter;
import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.DataEnage.DateEnage;
import star.liuwen.com.le_shi.Jsoup.Action.ActionCallBack;
import star.liuwen.com.le_shi.Jsoup.Action.BbsAction;
import star.liuwen.com.le_shi.Model.BbsModel;
import star.liuwen.com.le_shi.Model.IndexModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/12.
 */
public class LiveFragment extends BaseFragment {

    private RecyclerView oneRecyclerView, twoRecycleView;
    private oneAdapter mAdapter;
    private BbsAdapter bbsAdapter;
    private List<BbsModel> mList = new ArrayList<>();
    private List<String> picList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        oneRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_one);
        twoRecycleView = (RecyclerView) view.findViewById(R.id.recycler_two);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        oneRecyclerView.setLayoutManager(manager);
        twoRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new oneAdapter(oneRecyclerView);
        bbsAdapter = new BbsAdapter(getActivity(), mList, picList);
        twoRecycleView.addItemDecoration(BGADivider.newShapeDivider());
        oneRecyclerView.addItemDecoration(BGADivider.newShapeDivider());
        mAdapter.setData(DateEnage.getBBSDate());
        oneRecyclerView.setAdapter(mAdapter);
        twoRecycleView.setAdapter(bbsAdapter);
        LoadDate(Config.BAO_FENG_BBS_ALL);
        setListener();
    }


    private void LoadDate(String url) {
        showLoadingDialog("", true, null);
        BbsAction.searchBBSData(getActivity(), url, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                mList.addAll((Collection<? extends BbsModel>) object);
                bbsAdapter.updateList(mList);
                hideLoadingDialog();
            }

            @Override
            public void failed(Object object) {
                hideLoadingDialog();
            }
        });

        BbsAction.searchBBSImgData(getActivity(), url, new ActionCallBack() {
            @Override
            public void ok(Object object) {
                picList.addAll((Collection<? extends String>) object);
                bbsAdapter.updatePicList(picList);

            }

            @Override
            public void failed(Object object) {
                hideLoadingDialog();
            }
        });


    }

    private void setListener() {

        mAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                mAdapter.setPosition(position);
                mList.clear();
                picList.clear();
                LoadDate(DateEnage.getBBSDate().get(position).getUrl());
            }
        });
    }


    private class oneAdapter extends BGARecyclerViewAdapter<IndexModel> {
        private int mPosition = 0;

        public oneAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_bbs);
        }

        public void setPosition(int position) {
            this.mPosition = position;
            mAdapter.notifyDataSetChanged();

        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, IndexModel model) {
            helper.setText(R.id.tv_bbs, model.getName());
            if (mPosition == position) {
                helper.setTextColor(R.id.tv_bbs, ContextCompat.getColor(getActivity(), R.color.colorAccent));
            } else {
                helper.setTextColor(R.id.tv_bbs, ContextCompat.getColor(getActivity(), R.color.text_color_66));
            }
        }
    }


    @Override
    public void initData() {

    }
}
