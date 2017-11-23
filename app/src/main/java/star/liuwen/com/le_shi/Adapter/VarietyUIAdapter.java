package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Activity.WebActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Listener.OnChannelListener;
import star.liuwen.com.le_shi.Listener.OnCommonListener;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;

/**
 * Created by liuwen on 2017/10/19.
 */
public class VarietyUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> channelList;//频道数据
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> highlightsList;//精彩看点
    private List<CoverModel> highlightsList2;
    private List<CoverModel> hotPlayList;//最热播放
    private List<CoverModel> varietyList;//内地综艺
    private List<CoverModel> varietyList2;
    private List<CoverModel> baoFengList;//暴风出品
    private List<CoverModel> baoFengList2;
    private int itemWidth;

    private final static int BANNER_VIEW_TYPE = 0;
    private final static int CHANNEL_VIEW_TYPE = 1;
    private final static int HIGHLIGHT_VIEW_TYPE = 2;//精彩看点
    private final static int HOT_PLAY_VIEW_TYPE = 3;//热播剧
    private final static int VARIETY_VIEW_TYPE = 4;//内地综艺
    private final static int BAO_FENG_VIEW_TYPE = 5;//暴风出品
    private final static int END_VIEW_TYPE = 6;
    private Context mContext;

    private OnChannelListener mOnChannelListener;

    public void setListener(OnChannelListener listener) {
        mOnChannelListener = listener;
    }


    public VarietyUIAdapter(Context context, List<String> channelList, List<CoverModel> coverList, List<CoverModel> highlightsList, List<CoverModel> highlightsList2, List<CoverModel> hotPlayList, List<CoverModel> varietyList, List<CoverModel> varietyList2, List<CoverModel> baoFengList, List<CoverModel> baoFengList2, int itemWidth) {
        mContext = context;
        this.channelList = channelList;
        this.coverList = coverList;
        this.highlightsList = highlightsList;
        this.highlightsList2 = highlightsList2;
        this.hotPlayList = hotPlayList;
        this.varietyList = varietyList;
        this.varietyList2 = varietyList2;
        this.baoFengList = baoFengList;
        this.baoFengList2 = baoFengList2;
        this.itemWidth = itemWidth;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return CHANNEL_VIEW_TYPE;
        } else if (position == 2) {
            return HIGHLIGHT_VIEW_TYPE;
        } else if (position == 3) {
            return HOT_PLAY_VIEW_TYPE;
        } else if (position == 4) {
            return VARIETY_VIEW_TYPE;
        } else if (position == 5) {
            return BAO_FENG_VIEW_TYPE;
        } else {
            return END_VIEW_TYPE;
        }
    }

    public void updateChannelList(List<String> list) {
        if (isListNotEmpty(list)) {
            channelList = list;
        } else {
            channelList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateCoverList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            coverList = list;
        } else {
            coverList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHotPlayList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            hotPlayList = list;
        } else {
            hotPlayList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHighlightsList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            highlightsList = list;
        } else {
            highlightsList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHighlightsList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            highlightsList2 = list;
        } else {
            highlightsList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateVarietyList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            varietyList = list;
        } else {
            varietyList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateVarietyList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            varietyList2 = list;
        } else {
            varietyList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateBaoFengList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baoFengList = list;
        } else {
            baoFengList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateBaoFengList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baoFengList2 = list;
        } else {
            baoFengList2.clear();
        }
        notifyDataSetChanged();
    }
    public void clearAllData() {
        channelList.clear();
        coverList.clear();
        highlightsList.clear();
        highlightsList2.clear();
        hotPlayList.clear();
        varietyList.clear();
        varietyList2.clear();
        baoFengList.clear();
        baoFengList2.clear();
    }

    public static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == BANNER_VIEW_TYPE) {
            view = getView(R.layout.head_banner);
            HomeUIAdapter.BannerHolder holder = new HomeUIAdapter.BannerHolder(view);
            return holder;
        } else if (viewType == CHANNEL_VIEW_TYPE) {
            view = getView(R.layout.channel_recycler_view);
            return new HomeUIAdapter.ChannelHolder(view);
        } else if (viewType == HOT_PLAY_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new TvUIAdapter.HotPlayHolder(view);
        } else if (viewType == HIGHLIGHT_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new HighlightHolder(view);
        } else if (viewType == VARIETY_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new VarietyHolder(view);
        } else if (viewType == BAO_FENG_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new BaoFengHolder(view);
        } else {
            view = getView(R.layout.item_end);
            return new HomeUIAdapter.EndHolder(view);
        }
    }

    private View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HomeUIAdapter.BannerHolder) {
            HomeUIAdapter.BannerHolder bannerHolder = (HomeUIAdapter.BannerHolder) holder;
            setBanner(bannerHolder);
        } else if (holder instanceof HomeUIAdapter.ChannelHolder) {
            HomeUIAdapter.ChannelHolder channelHolder = (HomeUIAdapter.ChannelHolder) holder;
            ChannelAdapter channelAdapter = new ChannelAdapter(channelList, mContext);
            final GridLayoutManager manager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            channelHolder.mRecyclerView.setLayoutManager(manager);
            channelHolder.mRecyclerView.setAdapter(channelAdapter);
            channelAdapter.setListener(new OnChannelListener() {
                @Override
                public void onItemClickListener(int position, List<String> list) {
                    if (mOnChannelListener != null) {
                        mOnChannelListener.onItemClickListener(position, list);
                    }
                }
            });
        } else if (holder instanceof HighlightHolder) {
            HighlightHolder highlightHolder = (HighlightHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, highlightsList, highlightsList2, true);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            highlightHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            highlightHolder.mRecyclerView.setAdapter(mAdapter);
            if (highlightsList.size() != 0) {
                highlightHolder.ReHead.setVisibility(View.VISIBLE);
                highlightHolder.tvType.setText(highlightsList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, listOne.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + listOne.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof VarietyHolder) {
            VarietyHolder varietyHolder = (VarietyHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, varietyList, varietyList2, true);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            varietyHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            varietyHolder.mRecyclerView.setAdapter(mAdapter);
            if (varietyList.size() != 0) {
                varietyHolder.ReHead.setVisibility(View.VISIBLE);
                varietyHolder.tvType.setText(varietyList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, listOne.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + listOne.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof BaoFengHolder) {
            BaoFengHolder baoFengHolder = (BaoFengHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, baoFengList, baoFengList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            baoFengHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            baoFengHolder.mRecyclerView.setAdapter(mAdapter);
            if (baoFengList.size() != 0) {
                baoFengHolder.ReHead.setVisibility(View.VISIBLE);
                baoFengHolder.tvType.setText(baoFengList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, listOne.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + listOne.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof TvUIAdapter.HotPlayHolder) {
            TvUIAdapter.HotPlayHolder hotPlayHolder = (TvUIAdapter.HotPlayHolder) holder;
            CommAdapter commAdapter = new CommAdapter(hotPlayHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            hotPlayHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(hotPlayList);
            hotPlayHolder.mRecyclerView.setAdapter(commAdapter);
            if (hotPlayList.size() != 0) {
                hotPlayHolder.ReHead.setVisibility(View.VISIBLE);
                hotPlayHolder.tvType.setText(hotPlayList.get(0).getCoverType());
            }
            commAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, hotPlayList.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + hotPlayList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof HomeUIAdapter.EndHolder) {
            HomeUIAdapter.EndHolder endHolder = (HomeUIAdapter.EndHolder) holder;
//            if (itemWidth != 0) {
//                endHolder.lyItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                endHolder.tvTitle.setGravity(Gravity.CENTER);
//            }
//            if (editList.size() != 0 && tvList.size() != 0 && movieList.size() != 0 && weiMovieList.size() != 0 && musicList.size() != 0 && zongYiList.size() != 0 && education.size() != 0 && dongManList.size() != 0) {
//                endHolder.lyItem.setVisibility(View.VISIBLE);
//            }
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    private void setBanner(HomeUIAdapter.BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext, coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }


    public static class HighlightHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public HighlightHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class VarietyHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public VarietyHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class BaoFengHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public BaoFengHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class CommAdapter extends BGARecyclerViewAdapter<CoverModel> {

        public CommAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.hot_item);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, CoverModel model) {
            GlideUtils.loadImage(helper.getImageView(R.id.image_hot), model.getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
            helper.setText(R.id.txt_name, model.getCoverTitle());
            helper.setVisibility(R.id.txt_desc, View.VISIBLE);
            helper.setText(R.id.txt_desc, model.getCoverDesc());
            if (model.getCoverPage() != null) {
                helper.setText(R.id.tv_page, model.getCoverPage());
            }
        }
    }

}
