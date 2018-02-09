package star.liuwen.com.le_shi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import java.util.HashMap;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.le_shi.Listener.WatchHistoryListener;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/07 15:52
 * desc   :
 */
public class WatchHistoryAdapter extends BGARecyclerViewAdapter<CoverModel> {
    private HashMap<String, Boolean> isHeadChecked;
    private boolean isMultiSelect;
    private HashMap<Long, Boolean> isBodyChecked;
    private WatchHistoryListener mListener;

    public WatchHistoryAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_watch_history);

    }

    public HashMap<Long, Boolean> getIsBodyChecked() {
        return isBodyChecked;
    }

    public void setIsBodyChecked(HashMap<Long, Boolean> isBodyChecked) {
        this.isBodyChecked = isBodyChecked;
    }

    public HashMap<String, Boolean> getIsHeadChecked() {
        return isHeadChecked;
    }

    public void setIsHeadChecked(HashMap<String, Boolean> isHeadChecked) {
        this.isHeadChecked = isHeadChecked;
    }

    public void setHeadListener(WatchHistoryListener watchListener) {
        this.mListener = watchListener;
    }

    private boolean needTitle(int position) {
        if (position == 0) {
            return true;
        }
        if (position < 0) {
            return false;
        }
        CoverModel currentEntity = (CoverModel) getItem(position);
        CoverModel previousEntity = (CoverModel) getItem(position - 1);
        if (null == currentEntity || null == previousEntity) {
            return false;
        }
        String currentTitle = currentEntity.getCoverWatchDate();
        String previousTitle = previousEntity.getCoverWatchDate();

        if (null == previousTitle || null == currentTitle) {
            return false;
        }
        if (currentTitle.equals(previousTitle)) {
            return false;
        }
        return true;
    }

    public void setMultiSelect(boolean checkBox) {
        this.isMultiSelect = checkBox;
        notifyDataSetChanged();
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper helper, int viewType) {
        helper.setItemChildClickListener(R.id.cb_choice_head);
        helper.setItemChildClickListener(R.id.cb_choice_body);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, final int position, final CoverModel model) {
        final CheckBox cbChoiceHead = helper.getView(R.id.cb_choice_head);
        final CheckBox cbChoiceBody = helper.getView(R.id.cb_choice_body);
        helper.setText(R.id.item_watch_history_title, model.getCoverWatchDate());
        helper.setText(R.id.watch_title, model.getCoverTitle());
        helper.setText(R.id.item_watch_history_page, model.getCoverPage());
        GlideUtils.loadImage(helper.getImageView(R.id.item_watch_history_pic), model.getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
        if (needTitle(position)) {
            helper.setVisibility(R.id.item_msg_re_show, View.VISIBLE);
        } else {
            helper.setVisibility(R.id.item_msg_re_show, View.GONE);
        }

        if (isMultiSelect) {
            cbChoiceBody.setVisibility(View.VISIBLE);
            cbChoiceHead.setVisibility(View.VISIBLE);
        } else {
            cbChoiceBody.setVisibility(View.GONE);
            cbChoiceHead.setVisibility(View.GONE);
        }

        if (isHeadChecked.get(model.getCoverWatchDate()) == null) {
            isHeadChecked.put(model.getCoverWatchDate(), false);
        }
        cbChoiceHead.setChecked(isHeadChecked.get(model.getCoverWatchDate()));

        if (isBodyChecked.get(model.getId()) == null) {
            isBodyChecked.put(model.getId(), false);
        }

        cbChoiceBody.setChecked(isBodyChecked.get(model.getId()));


        if (isMultiSelect) {
            cbChoiceBody.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cbChoiceBody.isChecked()) {
                        mListener.onWatchHistoryBodyClickListenerTrue(model);
                    } else {
                        mListener.OnWatchHistoryBodyClickListenerFalse(model);
                    }
                }
            });
        }

        if (isMultiSelect) {
            cbChoiceHead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cbChoiceHead.isChecked()) {
                        isHeadChecked.put(model.getCoverWatchDate(), true);
                        mListener.OnWatchHistoryHeadClickListenerTrue(model);
                    } else {
                        isHeadChecked.put(model.getCoverWatchDate(), false);
                        mListener.OnWatchHistoryHeadClickListenerFalse(model);
                    }
                }
            });
        }

    }


}
