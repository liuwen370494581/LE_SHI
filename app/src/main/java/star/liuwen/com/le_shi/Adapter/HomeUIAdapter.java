package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;
import star.liuwen.com.le_shi.Utils.ToastUtils;

/**
 * Created by liuwen on 2017/10/16.
 */
public class HomeUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private final static int BANNER_VIEW_TYPE = 0;//轮播图
    private final static int CHANNEL_VIEW_TYPE = 1;//频道
    private final static int EDIT_VIEW_TYPE = 2;//编辑推荐
    private final static int TV_TYPE = 3;// 电视剧
    private final static int MOVIE_TYPE = 4;//电影
    private final static int DONG_MAN_TYPE = 5; //动漫
    private final static int ZONG_YI_TYPE = 6; //综艺
    private final static int SPORTS_TYPE = 7;//体育
    private final static int EDUCATION_TYPE = 8; //教育
    private final static int WEI_MOVIE_TYPE = 9; //微电影
    private final static int MUSIC_TYPE = 10; //音乐
    private final static int OVER_VIEW_TYPE = 11;//全景
    private final static int END_VIEW_TYPE = 12;//结束


    private List<HashMap<String, Object>> channelList;//频道数据
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> editList;//编辑推荐
    private List<CoverModel> editList2;//编辑推荐
    private List<CoverModel> sportsList;// 体育
    private List<CoverModel> tvList;//电视剧
    private List<CoverModel> movieList;//电影
    private List<CoverModel> dongManList;//动漫
    private List<CoverModel> zongYiList;//综艺
    private List<CoverModel> education;//教育
    private List<CoverModel> weiMovieList;//微电影
    private List<CoverModel> musicList;//音乐
    private List<CoverModel> overViewList;//全景
    private List<CoverModel> overViewList2;

    private int itemWidth;

    public HomeUIAdapter(Context context, List<HashMap<String, Object>> channelList, List<CoverModel> coverList, List<CoverModel> editList, List<CoverModel> editList2, List<CoverModel> sportsList, List<CoverModel> tvList, List<CoverModel> movieList, List<CoverModel> dongManList, List<CoverModel> zongYiList, List<CoverModel> education, List<CoverModel> weiMovieList, List<CoverModel> musicList, List<CoverModel> overViewList, List<CoverModel> overViewList2, int itemWidth) {
        mContext = context;
        this.channelList = channelList;
        this.coverList = coverList;
        this.editList = editList;
        this.editList2 = editList2;
        this.sportsList = sportsList;
        this.tvList = tvList;
        this.movieList = movieList;
        this.dongManList = dongManList;
        this.zongYiList = zongYiList;
        this.education = education;
        this.weiMovieList = weiMovieList;
        this.musicList = musicList;
        this.overViewList = overViewList;
        this.overViewList2 = overViewList2;
        this.itemWidth = itemWidth;
    }

    public void clearAllData() {
        coverList.clear();//封面数据
        editList.clear();//编辑推荐
        editList2.clear();//编辑推荐
        sportsList.clear();// 体育
        tvList.clear();//电视剧
        movieList.clear();//电影
        dongManList.clear();//动漫
        zongYiList.clear();//综艺
        education.clear();//教育
        weiMovieList.clear();//微电影
        musicList.clear();//音乐
        overViewList.clear();//全景
        overViewList2.clear();
    }

    public void updateCoverList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            coverList = list;
        } else {
            coverList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateSports(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            sportsList = list;
        } else {
            sportsList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateEditList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            editList = list;
        } else {
            editList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateEditList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            editList2 = list;
        } else {
            editList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateTvList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            tvList = list;
        } else {
            tvList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateMovieList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            movieList = list;
        } else {
            movieList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateDongManList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            dongManList = list;
        } else {
            dongManList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateZongYiList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            zongYiList = list;
        } else {
            zongYiList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateEducationList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            education = list;
        } else {
            education.clear();
        }
        notifyDataSetChanged();
    }

    public void updateWeiMovieList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            weiMovieList = list;
        } else {
            weiMovieList.clear();
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

    public void updateOverViewList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            overViewList = list;
        } else {
            overViewList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateOverViewList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            overViewList2 = list;
        } else {
            overViewList2.clear();
        }
        notifyDataSetChanged();
    }


    public static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return CHANNEL_VIEW_TYPE;
        } else if (position == 2) {
            return EDIT_VIEW_TYPE;
        } else if (position == 3) {
            return TV_TYPE;
        } else if (position == 4) {
            return MOVIE_TYPE;
        } else if (position == 5) {
            return DONG_MAN_TYPE;
        } else if (position == 6) {
            return ZONG_YI_TYPE;
        } else if (position == 7) {
            return SPORTS_TYPE;
        } else if (position == 8) {
            return EDUCATION_TYPE;
        } else if (position == 9) {
            return WEI_MOVIE_TYPE;
        } else if (position == 10) {
            return MUSIC_TYPE;
        } else if (position == 11) {
            return OVER_VIEW_TYPE;
        } else {
            return END_VIEW_TYPE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == BANNER_VIEW_TYPE) {
            view = getView(R.layout.head_banner);
            BannerHolder holder = new BannerHolder(view);
            return holder;
        } else if (viewType == CHANNEL_VIEW_TYPE) {
            view = getView(R.layout.channel_recycler_view);
            ChannelHolder holder = new ChannelHolder(view);
            return holder;
        } else if (viewType == SPORTS_TYPE) {
            view = getView(R.layout.item_common);
            return new SportsHolder(view);
        } else if (viewType == EDIT_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new EditHolder(view);
        } else if (viewType == TV_TYPE) {
            view = getView(R.layout.item_common);
            return new TvHolder(view);
        } else if (viewType == MOVIE_TYPE) {
            view = getView(R.layout.item_common);
            return new MovieHolder(view);
        } else if (viewType == DONG_MAN_TYPE) {
            view = getView(R.layout.item_common);
            return new DongManHolder(view);
        } else if (viewType == ZONG_YI_TYPE) {
            view = getView(R.layout.item_common);
            return new ZongYiHolder(view);
        } else if (viewType == EDUCATION_TYPE) {
            view = getView(R.layout.item_common);
            return new EducationHolder(view);
        } else if (viewType == WEI_MOVIE_TYPE) {
            view = getView(R.layout.item_common);
            return new WeiMovieHolder(view);
        } else if (viewType == MUSIC_TYPE) {
            view = getView(R.layout.item_common);
            return new MusicHolder(view);
        } else if (viewType == OVER_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new OverViewHolder(view);
        } else {
            view = getView(R.layout.item_end);
            return new EndHolder(view);
        }
    }

    private View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerHolder) {
            BannerHolder bannerHolder = (BannerHolder) holder;
            setBanner(bannerHolder);
        } else if (holder instanceof ChannelHolder) {
            ChannelHolder channelHolder = (ChannelHolder) holder;
            ChannelAdapter channelAdapter = new ChannelAdapter(channelHolder.mRecyclerView);
            final GridLayoutManager manager = new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false);
            channelHolder.mRecyclerView.setLayoutManager(manager);
            channelAdapter.setData(channelList);
            channelHolder.mRecyclerView.setAdapter(channelAdapter);
            channelAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                @Override
                public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                    ToastUtils.showToast(mContext, channelList.get(position).get("title").toString());
                }
            });
        } else if (holder instanceof SportsHolder) {
            SportsHolder sportsHolder = (SportsHolder) holder;
            CommAdapter commAdapter = new CommAdapter(sportsHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            sportsHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(sportsList);
            sportsHolder.mRecyclerView.setAdapter(commAdapter);
            if (sportsList.size() != 0) {
                sportsHolder.ReHead.setVisibility(View.VISIBLE);
                sportsHolder.tvType.setText(sportsList.get(0).getCoverType());
            }
        } else if (holder instanceof EditHolder) {
            EditHolder editHolder = (EditHolder) holder;
            EditAndOverViewAdapter editAndOverViewAdapter = new EditAndOverViewAdapter(mContext, editList, editList2);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            editHolder.mRecyclerView.setLayoutManager(manager);
            editHolder.mRecyclerView.setAdapter(editAndOverViewAdapter);
            if (editList.size() != 0) {
                editHolder.ReHead.setVisibility(View.VISIBLE);
                editHolder.tvType.setText(editList.get(0).getCoverType());
            }

        } else if (holder instanceof TvHolder) {
            TvHolder tvHolder = (TvHolder) holder;
            TvAndMovieAdapter commAdapter = new TvAndMovieAdapter(tvHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            tvHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(tvList);
            tvHolder.mRecyclerView.setAdapter(commAdapter);
            if (tvList.size() != 0) {
                tvHolder.ReHead.setVisibility(View.VISIBLE);
                tvHolder.tvType.setText(tvList.get(0).getCoverType());
            }

        } else if (holder instanceof MovieHolder) {
            MovieHolder movieHolder = (MovieHolder) holder;
            TvAndMovieAdapter commAdapter = new TvAndMovieAdapter(movieHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            movieHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(movieList);
            movieHolder.mRecyclerView.setAdapter(commAdapter);
            if (movieList.size() != 0) {
                movieHolder.ReHead.setVisibility(View.VISIBLE);
                movieHolder.tvType.setText(movieList.get(0).getCoverType());
            }
        } else if (holder instanceof DongManHolder) {
            DongManHolder dongManHolder = (DongManHolder) holder;
            CommAdapter commAdapter = new CommAdapter(dongManHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            dongManHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(dongManList);
            dongManHolder.mRecyclerView.setAdapter(commAdapter);
            if (dongManList.size() != 0) {
                dongManHolder.ReHead.setVisibility(View.VISIBLE);
                dongManHolder.tvType.setText(dongManList.get(0).getCoverType());
            }
        } else if (holder instanceof ZongYiHolder) {
            ZongYiHolder zongYiHolder = (ZongYiHolder) holder;
            CommAdapter commAdapter = new CommAdapter(zongYiHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            zongYiHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(zongYiList);
            zongYiHolder.mRecyclerView.setAdapter(commAdapter);
            if (zongYiList.size() != 0) {
                zongYiHolder.ReHead.setVisibility(View.VISIBLE);
                zongYiHolder.tvType.setText(zongYiList.get(0).getCoverType());
            }

        } else if (holder instanceof EducationHolder) {
            EducationHolder educationHolder = (EducationHolder) holder;
            CommAdapter commAdapter = new CommAdapter(educationHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            educationHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(education);
            educationHolder.mRecyclerView.setAdapter(commAdapter);
            if (education.size() != 0) {
                educationHolder.ReHead.setVisibility(View.VISIBLE);
                educationHolder.tvType.setText(education.get(0).getCoverType());
            }

        } else if (holder instanceof WeiMovieHolder) {
            WeiMovieHolder weiMovieHolder = (WeiMovieHolder) holder;
            CommAdapter commAdapter = new CommAdapter(weiMovieHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            weiMovieHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(weiMovieList);
            weiMovieHolder.mRecyclerView.setAdapter(commAdapter);
            if (weiMovieList.size() != 0) {
                weiMovieHolder.ReHead.setVisibility(View.VISIBLE);
                weiMovieHolder.tvType.setText(weiMovieList.get(0).getCoverType());
            }

        } else if (holder instanceof MusicHolder) {
            MusicHolder musicHolder = (MusicHolder) holder;
            CommAdapter commAdapter = new CommAdapter(musicHolder.mRecyclerView);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            musicHolder.mRecyclerView.setLayoutManager(manager);
            commAdapter.setData(musicList);
            musicHolder.mRecyclerView.setAdapter(commAdapter);
            if (musicList.size() != 0) {
                musicHolder.ReHead.setVisibility(View.VISIBLE);
                musicHolder.tvType.setText(musicList.get(0).getCoverType());
            }

        } else if (holder instanceof OverViewHolder) {
            OverViewHolder overViewHolder = (OverViewHolder) holder;
            EditAndOverViewAdapter editAndOverViewAdapter = new EditAndOverViewAdapter(mContext, overViewList, overViewList2);
            GridLayoutManager manager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            overViewHolder.mRecyclerView.setLayoutManager(manager);
            overViewHolder.mRecyclerView.setAdapter(editAndOverViewAdapter);
            if (overViewList.size() != 0) {
                overViewHolder.ReHead.setVisibility(View.VISIBLE);
                overViewHolder.tvType.setText(overViewList.get(0).getCoverType());
            }
        } else if (holder instanceof EndHolder) {
            EndHolder endHolder = (EndHolder) holder;
            if (itemWidth != 0) {
                endHolder.lyItem.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                endHolder.tvTitle.setGravity(Gravity.CENTER);
            }
            if (editList.size() != 0 && tvList.size() != 0 && movieList.size() != 0 && weiMovieList.size() != 0 && musicList.size() != 0 && zongYiList.size() != 0 && education.size() != 0 && dongManList.size() != 0) {
                endHolder.lyItem.setVisibility(View.VISIBLE);
            }
        }

    }


    private void setBanner(BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext, coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }

    @Override
    public int getItemCount() {
        return 12;
    }


    //======================================================这是一条分割线=======================================
    public static class BannerHolder extends RecyclerView.ViewHolder {
        LoopViewPager viewpager; //头部banner
        CircleIndicator indicator;//头部banner

        public BannerHolder(View itemView) {
            super(itemView);
            viewpager = (LoopViewPager) itemView.findViewById(R.id.viewpager);
            indicator = (CircleIndicator) itemView.findViewById(R.id.indicator);
        }
    }


    public static class ChannelHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;

        public ChannelHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.channel_recycler_view);
        }
    }


    public static class EditHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public EditHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class SportsHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public SportsHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class TvHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public TvHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public MovieHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class DongManHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public DongManHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class ZongYiHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public ZongYiHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class EducationHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public EducationHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class WeiMovieHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public WeiMovieHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class MusicHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public MusicHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class OverViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public OverViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    public static class EndHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private LinearLayout lyItem;

        public EndHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_name);
            lyItem = (LinearLayout) itemView.findViewById(R.id.id_item_layout);
        }
    }


    private class ChannelAdapter extends BGARecyclerViewAdapter<HashMap<String, Object>> {

        public ChannelAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_channel);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, HashMap<String, Object> model) {
            if (itemWidth != 0) {
                helper.getView(R.id.id_item_layout).setLayoutParams(new ViewGroup.LayoutParams(itemWidth / 4, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            helper.setText(R.id.tv_channel, model.get("title").toString());
            Glide.with(mContext).load(model.get("pic")).into(helper.getImageView(R.id.iv_logo));

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
            if (model.getCoverPage() != null) {
                helper.setText(R.id.tv_page, model.getCoverPage());
            }
            if (model.getCoverDesc() != null) {
                helper.setText(R.id.txt_desc, model.getCoverDesc());
                helper.setVisibility(R.id.txt_desc, View.VISIBLE);
            }

        }
    }

    private static class TvAndMovieAdapter extends BGARecyclerViewAdapter<CoverModel> {

        public TvAndMovieAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_tv_movie);
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
