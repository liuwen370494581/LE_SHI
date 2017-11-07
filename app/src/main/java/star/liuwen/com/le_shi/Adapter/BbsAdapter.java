package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import star.liuwen.com.le_shi.Model.BbsModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;
import star.liuwen.com.le_shi.View.CircleImageView;

/**
 * Created by liuwen on 2017/11/6.
 */
public class BbsAdapter extends RecyclerView.Adapter<BbsAdapter.MyViewHolder> {
    private List<BbsModel> mList;
    private List<String> picList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;


    public BbsAdapter(Context context, List<BbsModel> list, List<String> picList) {
        mContext = context;
        mList = list;
        this.picList = picList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void updateList(List<BbsModel> list) {
        if (isListNotEmpty(list)) {
            mList = list;
        } else {
            mList.clear();
        }
        notifyDataSetChanged();
    }

    public void updatePicList(List<String> list) {
        if (isListNotEmpty(list)) {
            picList = list;
        } else {
            picList.clear();
        }
        notifyDataSetChanged();
    }


    public static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_bbs_2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(mList.get(position).getTitle());
        holder.tvUserName.setText(mList.get(position).getUserName());
        holder.startDate.setText("于 " + mList.get(position).getStartDate() + " 发表");
        holder.endDate.setText("最后回复:" + mList.get(position).getEndDate());
        holder.views.setText("观看次数:"+mList.get(position).getViews());
        if (mList.size() != 0 && picList.size() == mList.size()) {
            GlideUtils.loadImage(holder.imgUser, picList.get(position), R.mipmap.icon_head, R.mipmap.icon_head);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgUser;
        TextView tvTitle;
        TextView tvUserName;
        TextView startDate;
        TextView endDate;
        TextView views;


        public MyViewHolder(View itemView) {
            super(itemView);
            imgUser = (CircleImageView) itemView.findViewById(R.id.img_user);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_user_name);
            startDate = (TextView) itemView.findViewById(R.id.tv_start_date);
            endDate = (TextView) itemView.findViewById(R.id.tv_end_date);
            views = (TextView) itemView.findViewById(R.id.tv_views);
        }
    }
}
