package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.ToastUtils;

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
    private ArrayMap<String, Integer> contentMap;
    private ArrayMap<String, Integer> sortMap;
    private ArrayMap<String, Integer> moneyMap;
    private ArrayMap<String, Integer> typeMap;
    private ArrayMap<String, Integer> locMap;
    private ArrayMap<String, Integer> yearMap;

    public ChoiceConditionAdapter(Context context, List<String> contentList, List<String> sortList, List<String> moneyList, List<String> typeList, List<String> locList, List<String> yearList, int itemWidth) {
        mContext = context;
        this.contentList = contentList;
        this.sortList = sortList;
        this.moneyList = moneyList;
        this.typeList = typeList;
        this.locList = locList;
        this.yearList = yearList;
        this.itemWidth = itemWidth;
        init();
    }

    private void init() {
        contentMap = new ArrayMap<>();
        sortMap = new ArrayMap<>();
        moneyMap = new ArrayMap<>();
        typeMap = new ArrayMap<>();
        locMap = new ArrayMap<>();
        yearMap = new ArrayMap<>();
        contentMap.put("内容", 0);
        sortMap.put("分类", 0);
        moneyMap.put("资费", 0);
        typeMap.put("类型", 0);
        locMap.put("地区", 0);
        yearMap.put("年代", 0);
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
            final ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(contentList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("内容");
            commonAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    contentMap.clear();
                    contentMap.put("内容", position);
                    commonAdapter.setContentColor(contentMap);
                }
            });
        } else if (holder instanceof SortHolder) {
            SortHolder contentHolder = (SortHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            final ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(sortList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("分类");
            commonAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    sortMap.clear();
                    sortMap.put("分类", position);
                    commonAdapter.setSortColor(sortMap);
                }
            });
        } else if (holder instanceof MoneyHolder) {
            MoneyHolder contentHolder = (MoneyHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            final ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(moneyList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("资费");
            commonAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    moneyMap.clear();
                    moneyMap.put("资费", position);
                    commonAdapter.setMoneyColor(moneyMap);
                }
            });
        } else if (holder instanceof TypeHolder) {
            TypeHolder contentHolder = (TypeHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            final ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(typeList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("类型");
            commonAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    typeMap.clear();
                    typeMap.put("类型", position);
                    commonAdapter.setTypeColor(typeMap);
                }
            });
        } else if (holder instanceof LocHolder) {
            LocHolder contentHolder = (LocHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            final ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(locList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("地区");
            commonAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    locMap.clear();
                    locMap.put("地区", position);
                    commonAdapter.setLocColor(locMap);
                }
            });
        } else if (holder instanceof YearHolder) {
            YearHolder contentHolder = (YearHolder) holder;
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            contentHolder.mRecyclerView.setLayoutManager(layoutManager);
            final ChoiceCommonAdapter commonAdapter = new ChoiceCommonAdapter(contentHolder.mRecyclerView);
            commonAdapter.setData(yearList);
            contentHolder.mRecyclerView.setAdapter(commonAdapter);
            contentHolder.tvType.setText("年代");
            commonAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    yearMap.clear();
                    yearMap.put("年代", position);
                    commonAdapter.setYearColor(yearMap);
                }
            });
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

    private class ChoiceCommonAdapter extends BGARecyclerViewAdapter<String> {

        public ChoiceCommonAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_bbs);
        }

        public void setContentColor(ArrayMap<String, Integer> map) {
            contentMap = map;
            notifyDataSetChanged();

        }

        public void setSortColor(ArrayMap<String, Integer> map) {
            sortMap = map;
            notifyDataSetChanged();

        }

        public void setMoneyColor(ArrayMap<String, Integer> map) {
            moneyMap = map;
            notifyDataSetChanged();

        }

        public void setLocColor(ArrayMap<String, Integer> map) {
            locMap = map;
            notifyDataSetChanged();

        }

        public void setTypeColor(ArrayMap<String, Integer> map) {
            typeMap = map;
            notifyDataSetChanged();

        }

        public void setYearColor(ArrayMap<String, Integer> map) {
            yearMap = map;
            notifyDataSetChanged();
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, String model) {
            helper.setText(R.id.tv_bbs, model);
            if (locMap.get("地区") == position||yearMap.get("年代") == position||typeMap.get("类型") == position
            ||moneyMap.get("资费") == position||sortMap.get("分类") == position||contentMap.get("内容") == position) {
                helper.setTextColor(R.id.tv_bbs, ContextCompat.getColor(mContext, R.color.colorAccent));
            } else {
                helper.setTextColor(R.id.tv_bbs, ContextCompat.getColor(mContext, R.color.text_color_66));
            }
        }

    }
}
