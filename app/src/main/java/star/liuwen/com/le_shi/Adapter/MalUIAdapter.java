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

import star.liuwen.com.le_shi.Activity.WebActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Listener.OnChannelListener;
import star.liuwen.com.le_shi.Listener.OnCommonListener;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/11/10.
 */
public class MalUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CoverModel> mCoverList;
    private List<String> channelList;
    private List<CoverModel> bannerList;
    private List<CoverModel> dailySpecialList; //今日特价
    private List<CoverModel> dailySpecialList2;
    private List<CoverModel> baoFengTVList;
    private List<CoverModel> baoFengTVList2;
    private List<CoverModel> baofengMirror;
    private List<CoverModel> baofengMirror2;
    private List<CoverModel> funList;
    private List<CoverModel> funList2;
    private List<CoverModel> clothesList;
    private List<CoverModel> clothesList2;
    private List<CoverModel> sportsList;
    private List<CoverModel> sportsList2;
    private List<CoverModel> milkList;
    private List<CoverModel> milkList2;

    private Context mContext;
    private int itemWidth;
    private final static int BANNER_VIEW_TYPE = 0;//轮播图
    private final static int CHANNEL_VIEW_TYPE = 1;//频道
    private final static int DAO_BANNER_VIEW_TYPE = 2;
    private final static int DAILY_SPECIAL_VIEW_TYPE = 3;//今日特价
    private final static int TV_TYPE = 4;// 电视
    private final static int MIRROR_TYPE = 5;//暴风魔镜
    private final static int FUN_TYPE = 6; //娱乐
    private final static int CLOTHES_TYPE = 7; //衣服
    private final static int SPORTS_TYPE = 8;//体育
    private final static int MILK_TYPE = 9;//奶粉
    private final static int END_VIEW_TYPE = 10;//结束

    private OnChannelListener mOnChannelListener;

    public void setListener(OnChannelListener listener) {
        mOnChannelListener = listener;
    }


    public MalUIAdapter(List<CoverModel> coverList, List<String> channelList, List<CoverModel> dailySpecialList, List<CoverModel> dailySpecialList2, List<CoverModel> baoFengTVList, List<CoverModel> baoFengTVList2, List<CoverModel> baofengMirror, List<CoverModel> baofengMirror2, List<CoverModel> funList, List<CoverModel> funList2, List<CoverModel> clothesList, List<CoverModel> clothesList2, List<CoverModel> sportsList, List<CoverModel> sportsList2, Context context, int itemWidth) {
        mCoverList = coverList;
        this.channelList = channelList;
        this.dailySpecialList = dailySpecialList;
        this.dailySpecialList2 = dailySpecialList2;
        this.baoFengTVList = baoFengTVList;
        this.baoFengTVList2 = baoFengTVList2;
        this.baofengMirror = baofengMirror;
        this.baofengMirror2 = baofengMirror2;
        this.funList = funList;
        this.funList2 = funList2;
        this.clothesList = clothesList;
        this.clothesList2 = clothesList2;
        this.sportsList = sportsList;
        this.sportsList2 = sportsList2;
        mContext = context;
        this.itemWidth = itemWidth;
    }

    public MalUIAdapter(List<CoverModel> coverList, List<String> channelList, List<CoverModel> bannerList, List<CoverModel> dailySpecialList, List<CoverModel> dailySpecialList2, List<CoverModel> baoFengTVList, List<CoverModel> baoFengTVList2, List<CoverModel> baofengMirror, List<CoverModel> baofengMirror2, List<CoverModel> funList, List<CoverModel> funList2, List<CoverModel> clothesList, List<CoverModel> clothesList2, List<CoverModel> sportsList, List<CoverModel> sportsList2, List<CoverModel> milkList, List<CoverModel> milkList2, Context context, int itemWidth) {
        mCoverList = coverList;
        this.channelList = channelList;
        this.bannerList = bannerList;
        this.dailySpecialList = dailySpecialList;
        this.dailySpecialList2 = dailySpecialList2;
        this.baoFengTVList = baoFengTVList;
        this.baoFengTVList2 = baoFengTVList2;
        this.baofengMirror = baofengMirror;
        this.baofengMirror2 = baofengMirror2;
        this.funList = funList;
        this.funList2 = funList2;
        this.clothesList = clothesList;
        this.clothesList2 = clothesList2;
        this.sportsList = sportsList;
        this.sportsList2 = sportsList2;
        this.milkList = milkList;
        this.milkList2 = milkList2;
        mContext = context;
        this.itemWidth = itemWidth;
    }

    public void clearAllData() {
        mCoverList.clear();
        channelList.clear();
        bannerList.clear();
        dailySpecialList.clear(); //今日特价
        dailySpecialList2.clear();
        baoFengTVList.clear();
        baoFengTVList2.clear();
        baofengMirror.clear();
        baofengMirror2.clear();
        funList.clear();
        funList2.clear();
        clothesList.clear();
        clothesList2.clear();
        sportsList.clear();
        sportsList2.clear();
        milkList.clear();
        milkList2.clear();
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
            mCoverList = list;
        } else {
            mCoverList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateBannerList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            bannerList = list;
        } else {
            bannerList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateDailySpecialList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            dailySpecialList = list;
        } else {
            dailySpecialList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateDailySpecialList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            dailySpecialList2 = list;
        } else {
            dailySpecialList2.clear();
        }
        notifyDataSetChanged();
    }

    public void updateBaoFengTVList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baoFengTVList = list;
        } else {
            baoFengTVList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateBaoFengTVList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baoFengTVList2 = list;
        } else {
            baoFengTVList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateBaoFengMirrorList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baofengMirror = list;
        } else {
            baofengMirror.clear();
        }
        notifyDataSetChanged();
    }

    public void updateBaoFengMirrorList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baofengMirror2 = list;
        } else {
            baofengMirror2.clear();
        }
        notifyDataSetChanged();
    }

    public void updateFunList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            funList = list;
        } else {
            funList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateFunList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            funList2 = list;
        } else {
            funList2.clear();
        }
        notifyDataSetChanged();
    }

    public void updateClothList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            clothesList = list;
        } else {
            clothesList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateClothList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            clothesList2 = list;
        } else {
            clothesList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateSportsList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            sportsList = list;
        } else {
            sportsList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateSportsList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            sportsList2 = list;
        } else {
            sportsList2.clear();
        }
        notifyDataSetChanged();
    }

    public void updateMilkList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            milkList = list;
        } else {
            milkList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateMilkList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            milkList2 = list;
        } else {
            milkList2.clear();
        }
        notifyDataSetChanged();
    }


    private static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return CHANNEL_VIEW_TYPE;
        } else if (position == 2) {
            return DAO_BANNER_VIEW_TYPE;
        } else if (position == 3) {
            return DAILY_SPECIAL_VIEW_TYPE;
        } else if (position == 4) {
            return TV_TYPE;
        } else if (position == 5) {
            return MIRROR_TYPE;
        } else if (position == 6) {
            return FUN_TYPE;
        } else if (position == 7) {
            return CLOTHES_TYPE;
        } else if (position == 8) {
            return SPORTS_TYPE;
        } else if (position == 9) {
            return MILK_TYPE;
        } else {
            return END_VIEW_TYPE;
        }
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
            HomeUIAdapter.ChannelHolder holder = new HomeUIAdapter.ChannelHolder(view);
            return holder;
        } else if (viewType == DAO_BANNER_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new BannerViewHolder(view);
        } else if (viewType == DAILY_SPECIAL_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new DailySpecialViewHolder(view);
        } else if (viewType == TV_TYPE) {
            view = getView(R.layout.item_common);
            return new TvViewHolder(view);
        } else if (viewType == MIRROR_TYPE) {
            view = getView(R.layout.item_common);
            return new MirrorViewHolder(view);
        } else if (viewType == FUN_TYPE) {
            view = getView(R.layout.item_common);
            return new FunViewHolder(view);
        } else if (viewType == CLOTHES_TYPE) {
            view = getView(R.layout.item_common);
            return new ClothesViewHolder(view);
        } else if (viewType == SPORTS_TYPE) {
            view = getView(R.layout.item_common);
            return new SportsViewHolder(view);
        } else if (viewType == MILK_TYPE) {
            view = getView(R.layout.item_common);
            return new MilkViewHolder(view);
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
        } else if (holder instanceof BannerViewHolder) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, bannerList, bannerList, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            bannerViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            bannerViewHolder.mRecyclerView.setAdapter(mAdapter);

        } else if (holder instanceof SportsViewHolder) {
            SportsViewHolder sportsHolder = (SportsViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, sportsList, sportsList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            sportsHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            sportsHolder.mRecyclerView.setAdapter(mAdapter);
            if (sportsList.size() != 0) {
                sportsHolder.ReHead.setVisibility(View.VISIBLE);
                sportsHolder.tvType.setText(sportsList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, sportsList2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + sportsList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof DailySpecialViewHolder) {
            DailySpecialViewHolder dailySpecialViewHolder = (DailySpecialViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, dailySpecialList, dailySpecialList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            dailySpecialViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            dailySpecialViewHolder.mRecyclerView.setAdapter(mAdapter);

            if (dailySpecialList.size() != 0) {
                dailySpecialViewHolder.ReHead.setVisibility(View.VISIBLE);
                dailySpecialViewHolder.tvType.setText(dailySpecialList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, dailySpecialList2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + dailySpecialList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof TvViewHolder) {
            TvViewHolder tvViewHolder = (TvViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, baoFengTVList, baoFengTVList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            tvViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            tvViewHolder.mRecyclerView.setAdapter(mAdapter);
            if (baoFengTVList.size() != 0) {
                tvViewHolder.ReHead.setVisibility(View.VISIBLE);
                tvViewHolder.tvType.setText(baoFengTVList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, baoFengTVList2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + baoFengTVList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof MirrorViewHolder) {
            MirrorViewHolder mirrorViewHolder = (MirrorViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, baofengMirror, baofengMirror2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            mirrorViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            mirrorViewHolder.mRecyclerView.setAdapter(mAdapter);
            if (baofengMirror.size() != 0) {
                mirrorViewHolder.ReHead.setVisibility(View.VISIBLE);
                mirrorViewHolder.tvType.setText(baofengMirror.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, baofengMirror2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + baofengMirror.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof FunViewHolder) {
            FunViewHolder funViewHolder = (FunViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, funList, funList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            funViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            funViewHolder.mRecyclerView.setAdapter(mAdapter);
            if (funList.size() != 0) {
                funViewHolder.ReHead.setVisibility(View.VISIBLE);
                funViewHolder.tvType.setText(funList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, funList2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + funList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof ClothesViewHolder) {
            ClothesViewHolder clothesViewHolder = (ClothesViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, clothesList, clothesList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            clothesViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            clothesViewHolder.mRecyclerView.setAdapter(mAdapter);
            if (clothesList.size() != 0) {
                clothesViewHolder.ReHead.setVisibility(View.VISIBLE);
                clothesViewHolder.tvType.setText(clothesList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, clothesList2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + clothesList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });

        } else if (holder instanceof MilkViewHolder) {
            MilkViewHolder milkViewHolder = (MilkViewHolder) holder;
            MalAdapter mAdapter = new MalAdapter(mContext, milkList, milkList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            milkViewHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            milkViewHolder.mRecyclerView.setAdapter(mAdapter);
            if (milkList.size() != 0) {
                milkViewHolder.ReHead.setVisibility(View.VISIBLE);
                milkViewHolder.tvType.setText(milkList.get(0).getCoverType());
            }
            mAdapter.setListener(new OnCommonListener() {
                @Override
                public void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra(Config.INTENT_COMM_MODEL, milkList2.get(position));
                    intent.putExtra(Config.INTENT_BBS_URL, Config.BAO_FENG_URL_2 + milkList.get(position).getCoverVideoUrl());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof HomeUIAdapter.EndHolder) {
            HomeUIAdapter.EndHolder endHolder = (HomeUIAdapter.EndHolder) holder;
//            if (itemWidth != 0) {
//                endHolder.lyItem.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                endHolder.tvTitle.setGravity(Gravity.CENTER);
//            }
//            if (editList.size() != 0 && tvList.size() != 0 && movieList.size() != 0 && weiMovieList.size() != 0 && musicList.size() != 0 && zongYiList.size() != 0 && education.size() != 0 && dongManList.size() != 0) {
//                endHolder.lyItem.setVisibility(View.VISIBLE);
//            }
        }
    }

    private void setBanner(HomeUIAdapter.BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext.getApplicationContext(), mCoverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    private static class DailySpecialViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public DailySpecialViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class BannerViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
//        RelativeLayout ReHead;
//        private TextView tvType;

        public BannerViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
//            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
//            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class TvViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public TvViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class MirrorViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public MirrorViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class FunViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public FunViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    private static class ClothesViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public ClothesViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class SportsViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public SportsViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private static class MilkViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public MilkViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
