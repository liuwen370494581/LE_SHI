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

/**
 * Created by liuwen on 2017/10/18.
 */
public class PopAndCityLoveAndXuanningAdapter extends RecyclerView.Adapter<PopAndCityLoveAndXuanningAdapter.MyViewHolder> {


    private Context mContext;
    private List<CoverModel> mList;
    private List<CoverModel> mList2;

    public PopAndCityLoveAndXuanningAdapter(Context context, List<CoverModel> list, List<CoverModel> list2) {
        mContext = context;
        mList = list;
        mList2 = list2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_edit_over_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    public void updateList(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            mList = list;
        } else {
            mList.clear();
        }
        notifyDataSetChanged();
    }

    public void updateList2(List<CoverModel> list) {
        if (isListNotEmpty(list)) {
            mList2 = list;
        } else {
            mList2.clear();
        }
        notifyDataSetChanged();
    }

    public static boolean isListNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvVideoName.setText(mList.get(position).getCoverTitle());
        GlideUtils.loadImage(holder.imgUrl, mList.get(position).getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
        if (mList2.size() != 0 && mList2.size() == mList.size()) {
            holder.tvVideoDesc.setText(mList2.get(position).getCoverDesc());
            holder.tvVideoPage.setText(mList2.get(position).getCoverScore() + "分");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvVideoName;
        TextView tvVideoDesc;
        TextView tvVideoPage;
        ImageView imgUrl;

        public MyViewHolder(View view) {
            super(view);
            imgUrl = (ImageView) view.findViewById(R.id.image_hot);
            tvVideoDesc = (TextView) view.findViewById(R.id.txt_desc);
            tvVideoName = (TextView) view.findViewById(R.id.txt_name);
            tvVideoPage = (TextView) view.findViewById(R.id.tv_page);
        }
    }
}
