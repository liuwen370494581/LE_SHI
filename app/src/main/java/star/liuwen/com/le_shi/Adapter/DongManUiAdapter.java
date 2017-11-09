package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;

/**
 * Created by liuwen on 2017/10/23.
 */
public class DongManUiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<String> channelList;//频道数据
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> hotPlayList;//热门播放
    private List<CoverModel> baoFengList;//暴风推荐
    private List<CoverModel> qinZiList;//亲子
    private List<CoverModel> reviewClassicList;//重温经典
    private List<CoverModel> everyDateUpdateList;//每日更新
    private Context mContext;
    private int itemWidth;

    private final static int BANNER_VIEW_TYPE = 0;
    private final static int CHANNEL_VIEW_TYPE = 1;
    private final static int HOT_PLAY_VIEW_TYPE = 2;//热播剧
    private final static int BAO_FENG_VIEW_TYPE = 3;//暴风推荐
    private final static int EVERY_DATE_UPDATE_VIEW_TYPE = 4;//每日更新
    private final static int QIN_ZI_VIEW_TYPE = 5;//亲子
    private final static int REVIEW_CLASSICLIST_VIEW_TYPE = 6;//重温经典
    private final static int END_VIEW_TYPE = 7;


    public DongManUiAdapter(Context context, List<String> channelList, List<CoverModel> coverList, List<CoverModel> hotPlayList, List<CoverModel> baoFengList, List<CoverModel> qinZiList, List<CoverModel> reviewClassicList, List<CoverModel> everyDateUpdateList, int itemWidth) {
        mContext = context;
        this.channelList = channelList;
        this.coverList = coverList;
        this.hotPlayList = hotPlayList;
        this.baoFengList = baoFengList;
        this.qinZiList = qinZiList;
        this.reviewClassicList = reviewClassicList;
        this.everyDateUpdateList = everyDateUpdateList;
        this.itemWidth = itemWidth;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return CHANNEL_VIEW_TYPE;
        } else if (position == 2) {
            return HOT_PLAY_VIEW_TYPE;
        } else if (position == 3) {
            return BAO_FENG_VIEW_TYPE;
        } else if (position == 4) {
            return EVERY_DATE_UPDATE_VIEW_TYPE;
        } else if (position == 5) {
            return QIN_ZI_VIEW_TYPE;
        } else if (position == 6) {
            return REVIEW_CLASSICLIST_VIEW_TYPE;
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

    public void updateQinZiList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            qinZiList = list;
        } else {
            qinZiList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateReviewClassicList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            reviewClassicList = list;
        } else {
            reviewClassicList.clear();
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

    public void updateEveryDateUpdateList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            everyDateUpdateList = list;
        } else {
            everyDateUpdateList.clear();
        }
        notifyDataSetChanged();
    }

    public static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }


    private View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
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
        } else if (viewType == BAO_FENG_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new VarietyUIAdapter.BaoFengHolder(view);
        } else if (viewType == EVERY_DATE_UPDATE_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new EveryDateUpdateHolder(view);
        } else if (viewType == QIN_ZI_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new QinZiPlayHolder(view);
        } else if (viewType == REVIEW_CLASSICLIST_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new ReviewClassicHolder(view);
        } else {
            view = getView(R.layout.item_end);
            return new HomeUIAdapter.EndHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HomeUIAdapter.BannerHolder) {
            HomeUIAdapter.BannerHolder bannerHolder = (HomeUIAdapter.BannerHolder) holder;
            setBanner(bannerHolder);
        } else if (holder instanceof HomeUIAdapter.ChannelHolder) {
            HomeUIAdapter.ChannelHolder channelHolder = (HomeUIAdapter.ChannelHolder) holder;
            ChannelAdapter channelAdapter = new ChannelAdapter(channelList,mContext);
            final GridLayoutManager manager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            channelHolder.mRecyclerView.setLayoutManager(manager);
            channelHolder.mRecyclerView.setAdapter(channelAdapter);
        } else if (holder instanceof QinZiPlayHolder) {
            QinZiPlayHolder qinZiPlayHolder = (QinZiPlayHolder) holder;
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            qinZiPlayHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            CommAdapter mAdapter = new CommAdapter(qinZiPlayHolder.mRecyclerView);
            mAdapter.setData(qinZiList);
            qinZiPlayHolder.mRecyclerView.setAdapter(mAdapter);
            if (qinZiList.size() != 0) {
                qinZiPlayHolder.ReHead.setVisibility(View.VISIBLE);
                qinZiPlayHolder.tvType.setText(qinZiList.get(0).getCoverType());
            }
        } else if (holder instanceof ReviewClassicHolder) {
            ReviewClassicHolder reviewClassicHolder = (ReviewClassicHolder) holder;
            CommAdapter mAdapter = new CommAdapter(reviewClassicHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            reviewClassicHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            mAdapter.setData(reviewClassicList);
            reviewClassicHolder.mRecyclerView.setAdapter(mAdapter);
            if (reviewClassicList.size() != 0) {
                reviewClassicHolder.ReHead.setVisibility(View.VISIBLE);
                reviewClassicHolder.tvType.setText(reviewClassicList.get(0).getCoverType());
            }

        } else if (holder instanceof VarietyUIAdapter.BaoFengHolder) {
            VarietyUIAdapter.BaoFengHolder baoFengHolder = (VarietyUIAdapter.BaoFengHolder) holder;
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            baoFengHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            CommAdapter mAdapter = new CommAdapter(baoFengHolder.mRecyclerView);
            mAdapter.setData(baoFengList);
            baoFengHolder.mRecyclerView.setAdapter(mAdapter);
            if (baoFengList.size() != 0) {
                baoFengHolder.ReHead.setVisibility(View.VISIBLE);
                baoFengHolder.tvType.setText(baoFengList.get(0).getCoverType());
            }
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
        } else if (holder instanceof EveryDateUpdateHolder) {
            EveryDateUpdateHolder everyDateUpdateHolder = (EveryDateUpdateHolder) holder;
            EveryDateUpdateAdapter mAdapter = new EveryDateUpdateAdapter(everyDateUpdateHolder.mRecyclerView);
            mAdapter.setData(everyDateUpdateList);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 5, LinearLayoutManager.VERTICAL, false);
            everyDateUpdateHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            everyDateUpdateHolder.mRecyclerView.setAdapter(mAdapter);

            if (everyDateUpdateList.size() != 0) {
                everyDateUpdateHolder.ReHead.setVisibility(View.VISIBLE);
                everyDateUpdateHolder.tvType.setText(everyDateUpdateList.get(0).getCoverType());
            }

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
        return 7;
    }


    private void setBanner(HomeUIAdapter.BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext, coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }


    public static class QinZiPlayHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public QinZiPlayHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class ReviewClassicHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public ReviewClassicHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class EveryDateUpdateHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public EveryDateUpdateHolder(View itemView) {
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

    private static class EveryDateUpdateAdapter extends BGARecyclerViewAdapter<CoverModel> {

        public EveryDateUpdateAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_every_date_update);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, CoverModel model) {
            GlideUtils.loadImage(helper.getImageView(R.id.image_hot), model.getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
            helper.setText(R.id.txt_name, model.getCoverTitle());
            helper.setText(R.id.txt_desc, model.getCoverDesc());
            if (model.getCoverPage() != null) {
                helper.setText(R.id.tv_page, model.getCoverPage());
            }

        }
    }
}
