package star.liuwen.com.le_shi.Listener;

import java.util.List;

import star.liuwen.com.le_shi.Model.BbsModel;

/**
 * Created by liuwen on 2017/11/7.
 */
public interface OnBbsListener {

    void onItemClickListener(int position, List<BbsModel> models);
}
