package star.liuwen.com.le_shi.Listener;

import star.liuwen.com.le_shi.Model.CoverModel;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/08 10:01
 * desc   :
 */
public interface WatchHistoryListener {

    void OnWatchHistoryHeadClickListenerTrue(CoverModel coverModel);

    void OnWatchHistoryHeadClickListenerFalse(CoverModel coverModel);

    void onWatchHistoryBodyClickListenerTrue(CoverModel coverModel);

    void OnWatchHistoryBodyClickListenerFalse(CoverModel coverModel);

}
