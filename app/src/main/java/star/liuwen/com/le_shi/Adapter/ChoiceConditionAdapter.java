package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/11/23.
 */
public class ChoiceConditionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private final static int CONTENT_VIEW_TYPE = 0;//内容
    private final static int SORT_VIEW_TYPE = 1;//排序
    private final static int MONEY_VIEW_TYPE = 2;//资费
    private final static int TYPE_VIEW_TYPE = 3;// 类型
    private final static int LOC_VIEW_TYPE = 4;//地区
    private final static int YEAR_MAN_TYPE = 5; //年份
    private final static int END_VIEW_TYPE = 6;
    private List<String> contentList;
    private List<String> sortList;
    private List<String> moneyList;
    private List<String> typeList;
    private List<String> locList;
    private List<String> yearList;
    private int itemWidth;

    public ChoiceConditionAdapter(Context context, List<String> contentList, List<String> sortList, List<String> moneyList, List<String> typeList, List<String> locList, List<String> yearList, int itemWidth) {
        mContext = context;
        this.contentList = contentList;
        this.sortList = sortList;
        this.moneyList = moneyList;
        this.typeList = typeList;
        this.locList = locList;
        this.yearList = yearList;
        this.itemWidth = itemWidth;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return CONTENT_VIEW_TYPE;
        } else if (position == 1) {
            return SORT_VIEW_TYPE;
        } else if (position == 2) {
            return MONEY_VIEW_TYPE;
        } else if (position == 3) {
            return TYPE_VIEW_TYPE;
        } else if (position == 4) {
            return LOC_VIEW_TYPE;
        } else if (position == 5) {
            return YEAR_MAN_TYPE;
        } else {
            return END_VIEW_TYPE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == CONTENT_VIEW_TYPE) {
            view = getView(R.layout.item_choice_condition_comm);
            return new ContentHolder(view);
        } else if (viewType == SORT_VIEW_TYPE) {
            view = getView(R.layout.item_choice_condition_comm);
            return new SortHolder(view);
        } else if (viewType == MONEY_VIEW_TYPE) {
            view = getView(R.layout.item_choice_condition_comm);
            return new MoneyHolder(view);
        } else if (viewType == TYPE_VIEW_TYPE) {
            view = getView(R.layout.item_choice_condition_comm);
            return new TypeHolder(view);
        } else if (viewType == LOC_VIEW_TYPE) {
            view = getView(R.layout.item_choice_condition_comm);
            return new LocHolder(view);
        } else if (viewType == YEAR_MAN_TYPE) {
            view = getView(R.layout.item_choice_condition_comm);
            return new YearHolder(view);
        } else {
            view = getView(R.layout.item_end);
            return new HomeUIAdapter.EndHolder(view);
        }
    }

    protected View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentHolder) {
            ContentHolder contentHolder = (ContentHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(contentList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("内容");
        } else if (holder instanceof SortHolder) {
            SortHolder contentHolder = (SortHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(sortList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("分类");
        } else if (holder instanceof MoneyHolder) {
            MoneyHolder contentHolder = (MoneyHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(moneyList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("资费");
        } else if (holder instanceof TypeHolder) {
            TypeHolder contentHolder = (TypeHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(typeList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("类型");
        } else if (holder instanceof LocHolder) {
            LocHolder contentHolder = (LocHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(locList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("地区");
        } else if (holder instanceof YearHolder) {
            YearHolder contentHolder = (YearHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(yearList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("年份");
        } else {
            //
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class ContentHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        TextView tvType;

        public ContentHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_choice_condition_recycler_view);
            tvType = (TextView) itemView.findViewById(R.id.common_title);
        }
    }

    private static class SortHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        TextView tvType;

        public SortHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_choice_condition_recycler_view);
            tvType = (TextView) itemView.findViewById(R.id.common_title);
        }
    }

    private static class MoneyHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        TextView tvType;

        public MoneyHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_choice_condition_recycler_view);
            tvType = (TextView) itemView.findViewById(R.id.common_title);
        }
    }

    private static class TypeHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        TextView tvType;

        public TypeHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_choice_condition_recycler_view);
            tvType = (TextView) itemView.findViewById(R.id.common_title);
        }
    }

    private static class LocHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        TextView tvType;

        public LocHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_choice_condition_recycler_view);
            tvType = (TextView) itemView.findViewById(R.id.common_title);
        }
    }

    private static class YearHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        TextView tvType;

        public YearHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_choice_condition_recycler_view);
            tvType = (TextView) itemView.findViewById(R.id.common_title);
        }
    }

    private static class ChoiceCommonAdapter extends BGARecyclerViewAdapter<String> {

        public ChoiceCommonAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_bbs);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, String model) {
            helper.setText(R.id.tv_bbs, model);
        }
    }
}
