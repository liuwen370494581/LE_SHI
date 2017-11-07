package star.liuwen.com.le_shi.Jsoup.Action;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import star.liuwen.com.le_shi.Jsoup.HtmlParserUtil;
import star.liuwen.com.le_shi.Model.BbsModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/11/6.
 * java的设计模式 单一职责模式
 */
public class BbsAction {

    public static void searchBBSData(final Context context, final String url, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<BbsModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<BbsModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchBBSDate(url));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<BbsModel>>() {
            @Override
            public void accept(@NonNull List<BbsModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }



    public static void searchBBSImgData(final Context context, final String url, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchBBSImgData(url));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(@NonNull List<String> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }

}
