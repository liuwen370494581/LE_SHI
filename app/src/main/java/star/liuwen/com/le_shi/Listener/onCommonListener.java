package star.liuwen.com.le_shi.Listener;

import java.util.List;

import star.liuwen.com.le_shi.Model.CoverModel;

/**
 * Created by liuwen on 2017/11/3.
 */
public interface OnCommonListener {

    void onItemClickListener(int position, List<CoverModel> listOne, List<CoverModel> listTwo);

}
