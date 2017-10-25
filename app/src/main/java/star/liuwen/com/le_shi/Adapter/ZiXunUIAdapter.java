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
public class ZiXunUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> ziXunRecommendList;//资讯途径
    private List<CoverModel> headlinesList;//焦点头条
    private List<CoverModel> baoXiaoRecommendList;//爆笑推荐
    private List<CoverModel> strangeList;//人间奇闻
    private List<CoverModel> funList;//娱乐新闻
    private List<CoverModel> starList;//明星资讯
    private List<CoverModel> sportList;//体育资讯
    private List<CoverModel> scienceList;//科技资讯
    private List<CoverModel> musicList;//音乐资讯
    private List<CoverModel> gameList;//游戏资讯

    private final int BANNER_VIEW_TYPE = 0;
    private final int ZI_XUN_RECOMMEND_VIEW_TYPE = 1;
    private final int HEAD_LINES_VIEW_TYPE = 2;
    private final int BAO_XIAO_RECOMMEND_VIEW_TYPE = 3;
    private final int STRANGE_VIEW_TYPE = 4;
    private final int FUNNY_VIEW_TYPE = 5;
    private final int STAR_VIEW_TYPE = 6;
    private final int SPORTS_VIEW_TYPE = 7;
    private final int SCIENCE_VIEW_TYPE = 8;
    private final int MUSIC_VIEW_TYPE = 9;
    private final int GAME_VIEW_TYPE = 10;
    private final int END_VIEW_TYPE = 11;
    private Context mContext;

    public ZiXunUIAdapter(Context context, List<CoverModel> coverList, List<CoverModel> ziXunRecommendList, List<CoverModel> headlinesList, List<CoverModel> baoXiaoRecommendList, List<CoverModel> strangeList, List<CoverModel> funList, List<CoverModel> starList, List<CoverModel> sportList, List<CoverModel> scienceList, List<CoverModel> musicList, List<CoverModel> gameList) {
        mContext = context;
        this.coverList = coverList;
        this.ziXunRecommendList = ziXunRecommendList;
        this.headlinesList = headlinesList;
        this.baoXiaoRecommendList = baoXiaoRecommendList;
        this.strangeList = strangeList;
        this.funList = funList;
        this.starList = starList;
        this.sportList = sportList;
        this.scienceList = scienceList;
        this.musicList = musicList;
        this.gameList = gameList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return ZI_XUN_RECOMMEND_VIEW_TYPE;
        } else if (position == 2) {
            return HEAD_LINES_VIEW_TYPE;
        } else if (position == 3) {
            return BAO_XIAO_RECOMMEND_VIEW_TYPE;
        } else if (position == 4) {
            return STRANGE_VIEW_TYPE;
        } else if (position == 5) {
            return FUNNY_VIEW_TYPE;
        } else if (position == 6) {
            return STAR_VIEW_TYPE;
        } else if (position == 7) {
            return SPORTS_VIEW_TYPE;
        } else if (position == 8) {
            return SCIENCE_VIEW_TYPE;
        } else if (position == 9) {
            return MUSIC_VIEW_TYPE;
        } else if (position == 10) {
            return GAME_VIEW_TYPE;
        } else {
            return END_VIEW_TYPE;
        }
    }


    public void updateCoverList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            coverList = list;
        } else {
            coverList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateZiXunRecommendList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            ziXunRecommendList = list;
        } else {
            ziXunRecommendList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHeadlinesList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            headlinesList = list;
        } else {
            headlinesList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateBaoXiaoRecommendList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            baoXiaoRecommendList = list;
        } else {
            baoXiaoRecommendList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateStrangeList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            strangeList = list;
        } else {
            strangeList.clear();
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

    public void updateStarList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            starList = list;
        } else {
            starList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateSportList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            sportList = list;
        } else {
            sportList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateScienceList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            scienceList = list;
        } else {
            scienceList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateMusicList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            musicList = list;
        } else {
            musicList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateGameList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            gameList = list;
        } else {
            gameList.clear();
        }
        notifyDataSetChanged();
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
        } else if (viewType == ZI_XUN_RECOMMEND_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new ZiXunRecommendHolder(view);
        } else if (viewType == HEAD_LINES_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new HeadLinesHolder(view);
        } else if (viewType == BAO_XIAO_RECOMMEND_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new BaoXiaoRecommendHolder(view);
        } else if (viewType == STRANGE_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new StrangeHolder(view);
        } else if (viewType == FUNNY_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new FunnyHolder(view);
        } else if (viewType == STAR_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new StarHolder(view);
        } else if (viewType == SPORTS_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new SportsHolder(view);
        } else if (viewType == SCIENCE_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new ScienceHolder(view);
        } else if (viewType == MUSIC_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new MusicHolder(view);
        } else if (viewType == GAME_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new GameHolder(view);
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
        } else if (holder instanceof HeadLinesHolder) {
            HeadLinesHolder headLinesHolder = (HeadLinesHolder) holder;
            CommAdapter commAdapter = new CommAdapter(headLinesHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            headLinesHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(headlinesList);
            headLinesHolder.mRecyclerView.setAdapter(commAdapter);
            if (headlinesList.size() != 0) {
                headLinesHolder.ReHead.setVisibility(View.VISIBLE);
                headLinesHolder.tvType.setText(headlinesList.get(0).getCoverType());
            }
        } else if (holder instanceof ZiXunRecommendHolder) {
            ZiXunRecommendHolder highlightHolder = (ZiXunRecommendHolder) holder;
            CommAdapter commAdapter = new CommAdapter(highlightHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            highlightHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(ziXunRecommendList);
            highlightHolder.mRecyclerView.setAdapter(commAdapter);
            if (ziXunRecommendList.size() != 0) {
                highlightHolder.ReHead.setVisibility(View.VISIBLE);
                highlightHolder.tvType.setText(ziXunRecommendList.get(0).getCoverType());
            }
        } else if (holder instanceof BaoXiaoRecommendHolder) {
            BaoXiaoRecommendHolder baoXiaoRecommendHolder = (BaoXiaoRecommendHolder) holder;
            CommAdapter commAdapter = new CommAdapter(baoXiaoRecommendHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            baoXiaoRecommendHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(baoXiaoRecommendList);
            baoXiaoRecommendHolder.mRecyclerView.setAdapter(commAdapter);
            if (baoXiaoRecommendList.size() != 0) {
                baoXiaoRecommendHolder.ReHead.setVisibility(View.VISIBLE);
                baoXiaoRecommendHolder.tvType.setText(baoXiaoRecommendList.get(0).getCoverType());
            }

        } else if (holder instanceof StrangeHolder) {
            StrangeHolder strangeHolder = (StrangeHolder) holder;
            CommAdapter commAdapter = new CommAdapter(strangeHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            strangeHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(strangeList);
            strangeHolder.mRecyclerView.setAdapter(commAdapter);
            if (strangeList.size() != 0) {
                strangeHolder.ReHead.setVisibility(View.VISIBLE);
                strangeHolder.tvType.setText(strangeList.get(0).getCoverType());
            }
        } else if (holder instanceof FunnyHolder) {
            FunnyHolder funnyHolder = (FunnyHolder) holder;
            CommAdapter commAdapter = new CommAdapter(funnyHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            funnyHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(funList);
            funnyHolder.mRecyclerView.setAdapter(commAdapter);
            if (funList.size() != 0) {
                funnyHolder.ReHead.setVisibility(View.VISIBLE);
                funnyHolder.tvType.setText(funList.get(0).getCoverType());
            }
        } else if (holder instanceof StarHolder) {
            StarHolder starHolder = (StarHolder) holder;
            CommAdapter commAdapter = new CommAdapter(starHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            starHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(starList);
            starHolder.mRecyclerView.setAdapter(commAdapter);
            if (starList.size() != 0) {
                starHolder.ReHead.setVisibility(View.VISIBLE);
                starHolder.tvType.setText(starList.get(0).getCoverType());
            }
        } else if (holder instanceof SportsHolder) {
            SportsHolder sportsHolder = (SportsHolder) holder;
            CommAdapter commAdapter = new CommAdapter(sportsHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            sportsHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(sportList);
            sportsHolder.mRecyclerView.setAdapter(commAdapter);
            if (sportList.size() != 0) {
                sportsHolder.ReHead.setVisibility(View.VISIBLE);
                sportsHolder.tvType.setText(sportList.get(0).getCoverType());
            }
        } else if (holder instanceof ScienceHolder) {
            ScienceHolder scienceHolder = (ScienceHolder) holder;
            CommAdapter commAdapter = new CommAdapter(scienceHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            scienceHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(scienceList);
            scienceHolder.mRecyclerView.setAdapter(commAdapter);
            if (scienceList.size() != 0) {
                scienceHolder.ReHead.setVisibility(View.VISIBLE);
                scienceHolder.tvType.setText(scienceList.get(0).getCoverType());
            }

        } else if (holder instanceof MusicHolder) {
            MusicHolder musicHolder = (MusicHolder) holder;
            CommAdapter commAdapter = new CommAdapter(musicHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            musicHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(musicList);
            musicHolder.mRecyclerView.setAdapter(commAdapter);
            if (musicList.size() != 0) {
                musicHolder.ReHead.setVisibility(View.VISIBLE);
                musicHolder.tvType.setText(musicList.get(0).getCoverType());
            }
        } else if (holder instanceof GameHolder) {
            GameHolder gameHolder = (GameHolder) holder;
            CommAdapter commAdapter = new CommAdapter(gameHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            gameHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(gameList);
            gameHolder.mRecyclerView.setAdapter(commAdapter);
            if (gameList.size() != 0) {
                gameHolder.ReHead.setVisibility(View.VISIBLE);
                gameHolder.tvType.setText(gameList.get(0).getCoverType());
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
        return 11;
    }


    private void setBanner(HomeUIAdapter.BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext, coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }


    public static class ZiXunRecommendHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public ZiXunRecommendHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class HeadLinesHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public HeadLinesHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    public static class BaoXiaoRecommendHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public BaoXiaoRecommendHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class StrangeHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public StrangeHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class FunnyHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public FunnyHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    public static class StarHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public StarHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class SportsHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public SportsHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class ScienceHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public ScienceHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class MusicHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public MusicHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class GameHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public GameHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private class CommAdapter extends BGARecyclerViewAdapter<CoverModel> {

        public CommAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.hot_item);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, CoverModel model) {
            GlideUtils.loadImage(helper.getImageView(R.id.image_hot), model.getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
            helper.setText(R.id.txt_name, model.getCoverTitle());
        }
    }

}
