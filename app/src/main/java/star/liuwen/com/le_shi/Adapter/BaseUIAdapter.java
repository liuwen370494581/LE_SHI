package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liuwen on 2017/11/15.
 */
public abstract class BaseUIAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private View mView;
    private Context mContext;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    private View getView(int view) {
        View view1 = View.inflate(mContext, view, null);
        return view1;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
