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


    public MalAdapter(Context context, List<CoverModel> list, List<CoverModel> list2) {
        mContext = context;
        mList = list;
        mList2 = list2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mal, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GlideUtils.loadImage(holder.imgUrl, mList.get(position).getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
        if (mList2.size() != 0 && mList2.size() == mList.size()) {
            holder.tvVideoDesc.setText(mList2.get(position).getCoverDesc());
            holder.tvVideoName.setText(mList2.get(position).getCoverTitle());
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
        private CornerLabelView cvTitle;


        public MyViewHolder(View view) {
            super(view);
            imgUrl = (ImageView) view.findViewById(R.id.image_hot);
            tvVideoDesc = (TextView) view.findViewById(R.id.txt_desc);
            tvVideoName = (TextView) view.findViewById(R.id.txt_name);
            tvVideoPage = (TextView) view.findViewById(R.id.tv_page);
            cvTitle = (CornerLabelView) view.findViewById(R.id.label);
        }
    }
}
