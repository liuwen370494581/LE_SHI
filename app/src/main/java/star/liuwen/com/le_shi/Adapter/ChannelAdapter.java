package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import star.liuwen.com.le_shi.Listener.OnChannelListener;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/11/3.
 */
public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder> {

    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnChannelListener mListener;

    public void setListener(OnChannelListener listener) {
        this.mListener = listener;
    }


    public ChannelAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_channerl_2, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.btn.setText(mList.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onItemClickListener(position, mList);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        Button btn;

        public MyViewHolder(View view) {
            super(view);
            btn = (Button) view.findViewById(R.id.btn_name);
        }
    }
}
