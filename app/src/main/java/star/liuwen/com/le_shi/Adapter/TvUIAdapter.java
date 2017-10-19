package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
 * Created by liuwen on 2017/10/18.
 */
public class TvUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int BANNER_VIEW_TYPE = 0;
    private final int CHANNEL_VIEW_TYPE = 1;
    private final int HOT_PLAY_VIEW_TYPE = 2;//热播剧
    private final int POPULAR_VIEW_TYPE = 3;//最受欢迎
    private final int CITY_LOVE_VIEW_TYPE = 4;//都市爱情
    private final int XUAN_NING_VIEW_TYPE = 5;//悬拟
    private final int NETWORK_VIEW_TYPE = 6;//网络
    private final int KANG_WAR_TYPE = 7;//抗战
    private final int END_VIEW_TYPE = 8;
    private Context mContext;
    private int itemWidth;

    private List<HashMap<String, Object>> channelList;//频道数据
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> hotPlayList;
    private List<CoverModel> popularList;
    private List<CoverModel> popularList2;
    private List<CoverModel> cityLoveList;
    private List<CoverModel> cityLoveList2;
    private List<CoverModel> xuanNingList;
    private List<CoverModel> xuanNingList2;
    private List<CoverModel> netWorkList;
    private List<CoverModel> kangWarList;


    public TvUIAdapter(Context context, List<HashMap<String, Object>> channelList, List<CoverModel> coverList, List<CoverModel> hotPlayList, List<CoverModel> popularList, List<CoverModel> popularList2, List<CoverModel> cityLoveList, List<CoverModel> cityLoveList2, List<CoverModel> xuanNingList, List<CoverModel> xuanNingList2, List<CoverModel> netWorkList, List<CoverModel> kangWarList, int itemWidth) {
        mContext = context;
        this.channelList = channelList;
        this.coverList = coverList;
        this.hotPlayList = hotPlayList;
        this.popularList = popularList;
        this.popularList2 = popularList2;
        this.cityLoveList = cityLoveList;
        this.cityLoveList2 = cityLoveList2;
        this.xuanNingList = xuanNingList;
        this.xuanNingList2 = xuanNingList2;
        this.netWorkList = netWorkList;
        this.kangWarList = kangWarList;
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
            return POPULAR_VIEW_TYPE;
        } else if (position == 4) {
            return CITY_LOVE_VIEW_TYPE;
        } else if (position == 5) {
            return XUAN_NING_VIEW_TYPE;
        } else if (position == 6) {
            return NETWORK_VIEW_TYPE;
        } else if (position == 7) {
            return KANG_WAR_TYPE;
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

    public void updateHotPlayList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            hotPlayList = list;
        } else {
            hotPlayList.clear();
        }
        notifyDataSetChanged();
    }

    public void updatePopularList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            popularList = list;
        } else {
            popularList.clear();
        }
        notifyDataSetChanged();
    }

    public void updatePopularList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            popularList2 = list;
        } else {
            popularList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateCityLoveList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            cityLoveList = list;
        } else {
            cityLoveList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateCityLoveList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            cityLoveList2 = list;
        } else {
            cityLoveList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateXuanNingList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            xuanNingList = list;
        } else {
            xuanNingList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateXuanNingList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            xuanNingList2 = list;
        } else {
            xuanNingList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateNetWorkList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            netWorkList = list;
        } else {
            netWorkList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateKangWarList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            kangWarList = list;
        } else {
            kangWarList.clear();
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
        } else if (viewType == CHANNEL_VIEW_TYPE) {
            view = getView(R.layout.channel_recycler_view);
            return new HomeUIAdapter.ChannelHolder(view);
        } else if (viewType == HOT_PLAY_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new HotPlayHolder(view);
        } else if (viewType == POPULAR_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new PopularHolder(view);
        } else if (viewType == CITY_LOVE_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new CityLoveHolder(view);
        } else if (viewType == XUAN_NING_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new XuanNingHolder(view);
        } else if (viewType == NETWORK_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new NetWorkHolder(view);
        } else if (viewType == KANG_WAR_TYPE) {
            view = getView(R.layout.item_common);
            return new KangWarHolder(view);
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
        } else if (holder instanceof HotPlayHolder) {
            HotPlayHolder hotPlayHolder = (HotPlayHolder) holder;
            CommAdapter commAdapter = new CommAdapter(hotPlayHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            hotPlayHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(hotPlayList);
            hotPlayHolder.mRecyclerView.setAdapter(commAdapter);
            if (hotPlayList.size() != 0) {
                hotPlayHolder.ReHead.setVisibility(View.VISIBLE);
                hotPlayHolder.tvType.setText(hotPlayList.get(0).getCoverType());
            }
        } else if (holder instanceof PopularHolder) {
            PopularHolder popularHolder = (PopularHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, popularList, popularList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            popularHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            popularHolder.mRecyclerView.setAdapter(mAdapter);
            if (popularList.size() != 0) {
                popularHolder.ReHead.setVisibility(View.VISIBLE);
                popularHolder.tvType.setText(popularList.get(0).getCoverType());
            }

        } else if (holder instanceof CityLoveHolder) {
            CityLoveHolder cityLoveHolder = (CityLoveHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, cityLoveList, cityLoveList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            cityLoveHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            cityLoveHolder.mRecyclerView.setAdapter(mAdapter);
            if (cityLoveList.size() != 0) {
                cityLoveHolder.ReHead.setVisibility(View.VISIBLE);
                cityLoveHolder.tvType.setText(cityLoveList.get(0).getCoverType());
            }
        } else if (holder instanceof XuanNingHolder) {
            XuanNingHolder xuanNingHolder = (XuanNingHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, xuanNingList, xuanNingList2);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            xuanNingHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            xuanNingHolder.mRecyclerView.setAdapter(mAdapter);
            if (xuanNingList.size() != 0) {
                xuanNingHolder.ReHead.setVisibility(View.VISIBLE);
                xuanNingHolder.tvType.setText(xuanNingList.get(0).getCoverType());
            }
        } else if (holder instanceof NetWorkHolder) {
            NetWorkHolder netWorkHolder = (NetWorkHolder) holder;
            CommAdapter commAdapter = new CommAdapter(netWorkHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            netWorkHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(netWorkList);
            if (netWorkList.size() != 0) {
                netWorkHolder.ReHead.setVisibility(View.VISIBLE);
                netWorkHolder.tvType.setText(netWorkList.get(0).getCoverType());
            }
            netWorkHolder.mRecyclerView.setAdapter(commAdapter);
        } else if (holder instanceof KangWarHolder) {
            KangWarHolder kangWarHolder = (KangWarHolder) holder;
            CommAdapter commAdapter = new CommAdapter(kangWarHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            kangWarHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(kangWarList);
            kangWarHolder.mRecyclerView.setAdapter(commAdapter);
            if (kangWarList.size() != 0) {
                kangWarHolder.ReHead.setVisibility(View.VISIBLE);
                kangWarHolder.tvType.setText(kangWarList.get(0).getCoverType());
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


    private void setBanner(HomeUIAdapter.BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext, coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }


    @Override
    public int getItemCount() {
        return 8;
    }

    public static class HotPlayHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public HotPlayHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class PopularHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public PopularHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class CityLoveHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public CityLoveHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class XuanNingHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public XuanNingHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class NetWorkHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public NetWorkHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class KangWarHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public KangWarHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
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


    private class CommAdapter extends BGARecyclerViewAdapter<CoverModel> {

        public CommAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.hot_item);
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
