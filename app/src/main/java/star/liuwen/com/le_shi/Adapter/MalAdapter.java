package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;
import star.liuwen.com.le_shi.View.CornerLabelView;

/**
 * Created by liuwen on 2017/11/10.
 */
public class MalAdapter extends RecyclerView.Adapter<MalAdapter.MyViewHolder> {

    private Context mContext;
    private List<CoverModel> mList;
    private List<CoverModel> mList2;
    private boolean isBannerOrTV = true;


    public MalAdapter(Context context, List<CoverModel> list, List<CoverModel> list2) {
        mContext = context;
        mList = list;
        mList2 = list2;
    }

    public MalAdapter(Context context, List<CoverModel> list, List<CoverModel> list2, boolean isBannerOrTV) {
        mContext = context;
        mList = list;
        mList2 = list2;
        this.isBannerOrTV = isBannerOrTV;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(isBannerOrTV ? R.layout.item_mal : R.layout.item_mal_2, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GlideUtils.loadImage(holder.imgUrl, mList.get(position).getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
        if (mList2.size() != 0 && mList2.size() == mList.size()) {
            if (mList.get(position).getCoverType() != null) {
                if (mList2.get(position).getCoverType().equals("今日特价")) {
                    holder.tvPrice.setText("原价：" + mList2.get(position).getCoverPage());
                    holder.tvName.setText(mList2.get(position).getCoverTitle());
                    holder.tvDesc.setText("折后价:" + mList2.get(position).getCoverScore());
                } else if (mList2.get(position).getCoverType().equals("暴风TV")) {
                    holder.tvName.setText(mList2.get(position).getCoverTitle());
                    holder.tvDesc.setText(mList2.get(position).getCoverDesc());
                    holder.tvPrice.setText(mList2.get(position).getCoverScore());
                } else {
                    holder.tvName.setText(mList2.get(position).getCoverTitle());
                    holder.tvDesc.setText(mList2.get(position).getCoverScore());
                    holder.tvPrice.setVisibility(View.GONE);
                }
            } else {
                holder.tvPrice.setVisibility(View.GONE);
                holder.tvDesc.setVisibility(View.GONE);
                holder.tvName.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imgUrl;
        CornerLabelView cvTitle;
        TextView tvPrice;


        public MyViewHolder(View view) {
            super(view);
            imgUrl = (ImageView) view.findViewById(R.id.image_hot);
            tvDesc = (TextView) view.findViewById(R.id.txt_desc);
            tvName = (TextView) view.findViewById(R.id.txt_name);
            cvTitle = (CornerLabelView) view.findViewById(R.id.label);
            tvPrice = (TextView) view.findViewById(R.id.txt_price);
        }
    }
}
