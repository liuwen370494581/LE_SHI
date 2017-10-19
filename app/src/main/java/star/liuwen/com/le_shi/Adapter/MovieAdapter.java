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
import star.liuwen.com.le_shi.View.CornerLabelView;

/**
 * Created by liuwen on 2017/10/19.
 */
public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HashMap<String, Object>> channelList;//频道数据
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> vipList;//会员
    private List<CoverModel> vipList2;
    private List<CoverModel> mostPopularList;//最受欢迎
    private List<CoverModel> mostPopularList2;
    private List<CoverModel> huaYuList; //华语
    private List<CoverModel> huaYuList2;
    private List<CoverModel> ouMeiList;//欧美
    private List<CoverModel> ouMeiList2;
    private List<CoverModel> whiteLoveList;//白色爱情
    private List<CoverModel> dongHuaList;//动漫
    private int itemWidth;

    private final int BANNER_VIEW_TYPE = 0;
    private final int CHANNEL_VIEW_TYPE = 1;
    private final int ViP_VIEW_TYPE = 2;//Vip
    private final int POPULAR_VIEW_TYPE = 3;//最受欢迎
    private final int HUY_YU_VIEW_TYPE = 4;//华语
    private final int OU_MEI_VIEW_TYPE = 5;//欧美
    private final int WHITE_LOVER_VIEW_TYPE = 6;//白色爱情
    private final int DOAG_HUA_TYPE = 7;//动画
    private final int END_VIEW_TYPE = 8;
    private Context mContext;


    public MovieAdapter(Context context, List<HashMap<String, Object>> channelList, List<CoverModel> coverList, List<CoverModel> vipList, List<CoverModel> vipList2, List<CoverModel> mostPopularList, List<CoverModel> mostPopularList2, List<CoverModel> huaYuList, List<CoverModel> huaYuList2, List<CoverModel> ouMeiList, List<CoverModel> ouMeiList2, List<CoverModel> whiteLoveList, List<CoverModel> dongHuaList, int itemWidth) {
        mContext = context;
        this.channelList = channelList;
        this.coverList = coverList;
        this.vipList = vipList;
        this.vipList2 = vipList2;
        this.mostPopularList = mostPopularList;
        this.mostPopularList2 = mostPopularList2;
        this.huaYuList = huaYuList;
        this.huaYuList2 = huaYuList2;
        this.ouMeiList = ouMeiList;
        this.ouMeiList2 = ouMeiList2;
        this.whiteLoveList = whiteLoveList;
        this.dongHuaList = dongHuaList;
        this.itemWidth = itemWidth;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW_TYPE;
        } else if (position == 1) {
            return CHANNEL_VIEW_TYPE;
        } else if (position == 2) {
            return ViP_VIEW_TYPE;
        } else if (position == 3) {
            return POPULAR_VIEW_TYPE;
        } else if (position == 4) {
            return HUY_YU_VIEW_TYPE;
        } else if (position == 5) {
            return OU_MEI_VIEW_TYPE;
        } else if (position == 6) {
            return WHITE_LOVER_VIEW_TYPE;
        } else if (position == 7) {
            return DOAG_HUA_TYPE;
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

    public void updateVipList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            vipList = list;
        } else {
            vipList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateVipList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            vipList2 = list;
        } else {
            vipList2.clear();
        }
        notifyDataSetChanged();
    }

    public void updatePopularList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            mostPopularList = list;
        } else {
            mostPopularList.clear();
        }
        notifyDataSetChanged();
    }

    public void updatePopularList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            mostPopularList2 = list;
        } else {
            mostPopularList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateHuaYuList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            huaYuList = list;
        } else {
            huaYuList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHuaYuList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            huaYuList2 = list;
        } else {
            huaYuList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateOuMeiList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            ouMeiList = list;
        } else {
            ouMeiList.clear();
        }
        notifyDataSetChanged();
    }


    public void updateOuMeiList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            ouMeiList2 = list;
        } else {
            ouMeiList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateWhiteLoveList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            whiteLoveList = list;
        } else {
            whiteLoveList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateDongHuaList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            dongHuaList = list;
        } else {
            dongHuaList.clear();
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
        } else if (viewType == ViP_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new VipHolder(view);
        } else if (viewType == POPULAR_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new PopularHolder(view);
        } else if (viewType == HUY_YU_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new HuaYuHolder(view);
        } else if (viewType == OU_MEI_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new OuMeiHolder(view);
        } else if (viewType == WHITE_LOVER_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new WhiteLoveHolder(view);
        } else if (viewType == DOAG_HUA_TYPE) {
            view = getView(R.layout.item_common);
            return new DongHuaHolder(view);
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
        } else if (holder instanceof VipHolder) {
            VipHolder vipHolder = (VipHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, vipList, vipList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            vipHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            vipHolder.mRecyclerView.setAdapter(mAdapter);
            if (vipList.size() != 0) {
                vipHolder.ReHead.setVisibility(View.VISIBLE);
                vipHolder.tvType.setText(vipList.get(0).getCoverType());
            }
        } else if (holder instanceof PopularHolder) {
            PopularHolder popularHolder = (PopularHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, mostPopularList, mostPopularList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            popularHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            popularHolder.mRecyclerView.setAdapter(mAdapter);
            if (mostPopularList.size() != 0) {
                popularHolder.ReHead.setVisibility(View.VISIBLE);
                popularHolder.tvType.setText(mostPopularList.get(0).getCoverType());
            }

        } else if (holder instanceof HuaYuHolder) {
            HuaYuHolder huaYuHolder = (HuaYuHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, huaYuList, huaYuList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            huaYuHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            huaYuHolder.mRecyclerView.setAdapter(mAdapter);
            if (huaYuList.size() != 0) {
                huaYuHolder.ReHead.setVisibility(View.VISIBLE);
                huaYuHolder.tvType.setText(huaYuList.get(0).getCoverType());
            }
        } else if (holder instanceof OuMeiHolder) {
            OuMeiHolder ouMeiHolder = (OuMeiHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, ouMeiList, ouMeiList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            ouMeiHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            ouMeiHolder.mRecyclerView.setAdapter(mAdapter);
            if (ouMeiList.size() != 0) {
                ouMeiHolder.ReHead.setVisibility(View.VISIBLE);
                ouMeiHolder.tvType.setText(ouMeiList.get(0).getCoverType());
            }
        } else if (holder instanceof WhiteLoveHolder) {
            WhiteLoveHolder whiteLoveHolder = (WhiteLoveHolder) holder;
            CommAdapter commAdapter = new CommAdapter(whiteLoveHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            whiteLoveHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(whiteLoveList);
            if (whiteLoveList.size() != 0) {
                whiteLoveHolder.ReHead.setVisibility(View.VISIBLE);
                whiteLoveHolder.tvType.setText(whiteLoveList.get(0).getCoverType());
            }
            whiteLoveHolder.mRecyclerView.setAdapter(commAdapter);
        } else if (holder instanceof DongHuaHolder) {
            DongHuaHolder dongHuaHolder = (DongHuaHolder) holder;
            CommAdapter commAdapter = new CommAdapter(dongHuaHolder.mRecyclerView);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            dongHuaHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            commAdapter.setData(dongHuaList);
            dongHuaHolder.mRecyclerView.setAdapter(commAdapter);
            if (dongHuaList.size() != 0) {
                dongHuaHolder.ReHead.setVisibility(View.VISIBLE);
                dongHuaHolder.tvType.setText(dongHuaList.get(0).getCoverType());
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
        return 8;
    }


    private void setBanner(HomeUIAdapter.BannerHolder channelHolder) {
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext, coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }

    public static class VipHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public VipHolder(View itemView) {
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


    public static class HuaYuHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public HuaYuHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class OuMeiHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public OuMeiHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    public static class WhiteLoveHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public WhiteLoveHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    public static class DongHuaHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        private TextView tvType;

        public DongHuaHolder(View itemView) {
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
            CornerLabelView cVTitle = helper.getView(R.id.label);
            GlideUtils.loadImage(helper.getImageView(R.id.image_hot), model.getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
            helper.setText(R.id.txt_name, model.getCoverTitle());
            helper.setVisibility(R.id.txt_desc, View.VISIBLE);
            helper.setText(R.id.txt_desc, model.getCoverDesc());
            if (model.getCoverScore() != null) {
                helper.setText(R.id.tv_page, model.getCoverScore() + "分");
            }
        }
    }
}
