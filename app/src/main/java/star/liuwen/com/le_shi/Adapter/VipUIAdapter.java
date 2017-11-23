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

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Activity.WebActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Listener.OnChannelListener;
import star.liuwen.com.le_shi.Listener.OnCommonListener;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/25.
 */
public class VipUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> channelList = new ArrayList<>();
    private List<CoverModel> coverList;//封面数据
    private List<CoverModel> mostPopularList;//最受欢迎
    private List<CoverModel> mostPopularList2;//最受欢迎
    private List<CoverModel> newFilmRecommendList;//新片推荐
    private List<CoverModel> newFilmRecommendList2;//新片推荐
    private List<CoverModel> choiceList;//精选
    private List<CoverModel> choiceList2;//精选
    private List<CoverModel> educationList;//教育
    private List<CoverModel> educationList2;//教育
    private List<CoverModel> qinZiList;//亲子
    private List<CoverModel> qinZiList2;//亲子
    private List<CoverModel> horrorFilmList;//恐怖片
    private List<CoverModel> horrorFilmList2;//恐怖片
    private int itemWidth;
    private Context mContext;

    private final static int BANNER_VIEW_TYPE = 0;
    private final static int CHANNEL_VIEW_TYPE = 1;
    private final static int POPULAR_VIEW_TYPE = 2;//最受欢迎
    private final static int NEW_FILM_RECOMMEND_VIEW_TYPE = 3;//新片推荐
    private final static int CHOICE_VIEW_TYPE = 4;//精选
    private final static int EDUCATION_VIEW_TYPE = 5;//教育
    private final static int QIN_ZI_VIEW_TYPE = 6;//亲子
    private final static int HORROR_FILM_TYPE = 7;//恐怖
    private final static int END_VIEW_TYPE = 8;

    private OnChannelListener mOnChannelListener;

    public void setListener(OnChannelListener listener) {
        mOnChannelListener = listener;
    }


    public VipUIAdapter(Context context, List<String> channelList, List<CoverModel> coverList, List<CoverModel> mostPopularList, List<CoverModel> mostPopularList2, List<CoverModel> newFilmRecommendList, List<CoverModel> newFilmRecommendList2, List<CoverModel> choiceList, List<CoverModel> choiceList2, List<CoverModel> educationList, List<CoverModel> educationList2, List<CoverModel> qinZiList, List<CoverModel> qinZiList2, List<CoverModel> horrorFilmList, List<CoverModel> horrorFilmList2, int itemWidth) {
        mContext = context;
        this.channelList = channelList;
        this.coverList = coverList;
        this.mostPopularList = mostPopularList;
        this.mostPopularList2 = mostPopularList2;
        this.newFilmRecommendList = newFilmRecommendList;
        this.newFilmRecommendList2 = newFilmRecommendList2;
        this.choiceList = choiceList;
        this.choiceList2 = choiceList2;
        this.educationList = educationList;
        this.educationList2 = educationList2;
        this.qinZiList = qinZiList;
        this.qinZiList2 = qinZiList2;
        this.horrorFilmList = horrorFilmList;
        this.horrorFilmList2 = horrorFilmList2;
        this.itemWidth = itemWidth;
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

    public void updateMostPopularList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            mostPopularList = list;
        } else {
            mostPopularList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateMostPopularList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            mostPopularList2 = list;
        } else {
            mostPopularList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateNewFilmRecommendList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            newFilmRecommendList = list;
        } else {
            newFilmRecommendList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateNewFilmRecommendList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            newFilmRecommendList2 = list;
        } else {
            newFilmRecommendList2.clear();
        }
        notifyDataSetChanged();
    }

    public void updateChoiceList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            choiceList = list;
        } else {
            choiceList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateChoiceList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            choiceList2 = list;
        } else {
            choiceList2.clear();
        }
        notifyDataSetChanged();
    }


    public void updateEducationList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            educationList = list;
        } else {
            educationList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateEducationList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            educationList2 = list;
        } else {
            educationList2.clear();
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

    public void updateQinZiList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            qinZiList2 = list;
        } else {
            qinZiList2.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHorrorFilmList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            horrorFilmList = list;
        } else {
            horrorFilmList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateHorrorFilmList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            horrorFilmList2 = list;
        } else {
            horrorFilmList2.clear();
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
            return POPULAR_VIEW_TYPE;
        } else if (position == 3) {
            return NEW_FILM_RECOMMEND_VIEW_TYPE;
        } else if (position == 4) {
            return CHOICE_VIEW_TYPE;
        } else if (position == 5) {
            return EDUCATION_VIEW_TYPE;
        } else if (position == 6) {
            return QIN_ZI_VIEW_TYPE;
        } else if (position == 7) {
            return HORROR_FILM_TYPE;
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
            return new HomeUIAdapter.ChannelHolder(view);
        } else if (viewType == POPULAR_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new TvUIAdapter.PopularHolder(view);
        } else if (viewType == NEW_FILM_RECOMMEND_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new NewFilmRecommendHolder(view);
        } else if (viewType == CHOICE_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new ChoiceHolder(view);
        } else if (viewType == EDUCATION_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new HomeUIAdapter.EducationHolder(view);
        } else if (viewType == QIN_ZI_VIEW_TYPE) {
            view = getView(R.layout.item_common);
            return new DongManUiAdapter.QinZiPlayHolder(view);
        } else if (viewType == HORROR_FILM_TYPE) {
            view = getView(R.layout.item_common);
            return new HorrorFilmHolder(view);
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
        } else if (holder instanceof TvUIAdapter.PopularHolder) {
            TvUIAdapter.PopularHolder popularHolder = (TvUIAdapter.PopularHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, mostPopularList, mostPopularList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            popularHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            popularHolder.mRecyclerView.setAdapter(mAdapter);
            if (mostPopularList.size() != 0) {
                popularHolder.ReHead.setVisibility(View.VISIBLE);
                popularHolder.tvType.setText(mostPopularList.get(0).getCoverType());
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
        } else if (holder instanceof NewFilmRecommendHolder) {
            NewFilmRecommendHolder newFilmRecommendHolder = (NewFilmRecommendHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, newFilmRecommendList, newFilmRecommendList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            newFilmRecommendHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            newFilmRecommendHolder.mRecyclerView.setAdapter(mAdapter);
            if (newFilmRecommendList.size() != 0) {
                newFilmRecommendHolder.ReHead.setVisibility(View.VISIBLE);
                newFilmRecommendHolder.tvType.setText(newFilmRecommendList.get(0).getCoverType());
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
        } else if (holder instanceof ChoiceHolder) {
            ChoiceHolder choiceHolder = (ChoiceHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, choiceList, choiceList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            choiceHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            choiceHolder.mRecyclerView.setAdapter(mAdapter);
            if (choiceList.size() != 0) {
                choiceHolder.ReHead.setVisibility(View.VISIBLE);
                choiceHolder.tvType.setText(choiceList.get(0).getCoverType());
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
        } else if (holder instanceof HomeUIAdapter.EducationHolder) {
            HomeUIAdapter.EducationHolder educationHolder = (HomeUIAdapter.EducationHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, educationList, educationList2, true);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
            educationHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            educationHolder.mRecyclerView.setAdapter(mAdapter);
            if (educationList.size() != 0) {
                educationHolder.ReHead.setVisibility(View.VISIBLE);
                educationHolder.tvType.setText(educationList.get(0).getCoverType());
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
        } else if (holder instanceof DongManUiAdapter.QinZiPlayHolder) {
            DongManUiAdapter.QinZiPlayHolder qinZiPlayHolder = (DongManUiAdapter.QinZiPlayHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, qinZiList, qinZiList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            qinZiPlayHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            qinZiPlayHolder.mRecyclerView.setAdapter(mAdapter);
            if (qinZiList.size() != 0) {
                qinZiPlayHolder.ReHead.setVisibility(View.VISIBLE);
                qinZiPlayHolder.tvType.setText(qinZiList.get(0).getCoverType());
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
        } else if (holder instanceof HorrorFilmHolder) {
            HorrorFilmHolder horrorFilmHolder = (HorrorFilmHolder) holder;
            PopAndCityLoveAndXuanningAdapter mAdapter = new PopAndCityLoveAndXuanningAdapter(mContext, horrorFilmList, horrorFilmList2, false);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
            horrorFilmHolder.mRecyclerView.setLayoutManager(gridLayoutManager);
            horrorFilmHolder.mRecyclerView.setAdapter(mAdapter);
            if (horrorFilmList.size() != 0) {
                horrorFilmHolder.ReHead.setVisibility(View.VISIBLE);
                horrorFilmHolder.tvType.setText(horrorFilmList.get(0).getCoverType());
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
        BannerAdapter mBannerAdapter = new BannerAdapter(mContext.getApplicationContext(), coverList);
        channelHolder.viewpager.setAdapter(mBannerAdapter);
        channelHolder.viewpager.setLooperPic(true);
        channelHolder.indicator.setViewPager(channelHolder.viewpager);
    }
    public static class NewFilmRecommendHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public NewFilmRecommendHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class ChoiceHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public ChoiceHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }


    public static class HorrorFilmHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        RelativeLayout ReHead;
        TextView tvType;

        public HorrorFilmHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.common_recycler_view);
            ReHead = (RelativeLayout) itemView.findViewById(R.id.re_show);
            tvType = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
