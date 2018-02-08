package star.liuwen.com.le_shi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import java.util.HashMap;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
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
    private HashMap<Long, Boolean> isHeadChecked = new HashMap<>();
    private boolean isMultiSelect;
    private HashMap<Long, Boolean> isBodyChecked = new HashMap<>();


    public WatchHistoryAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.item_watch_history);
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
    protected void fillData(BGAViewHolderHelper helper, int position, CoverModel model) {
        CheckBox cbChoiceHead = helper.getView(R.id.cb_choice_head);
        CheckBox cbChoiceBody = helper.getView(R.id.cb_choice_body);
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

        if (isHeadChecked.get(model.getId()) == null) {
            isHeadChecked.put(model.getId(), false);
        }
        cbChoiceHead.setChecked(isHeadChecked.get(model.getId()));

        if (isBodyChecked.get(model.getId()) == null) {
            isBodyChecked.put(model.getId(), false);
        }

        cbChoiceBody.setChecked(isBodyChecked.get(model.getId()));

    }

}
