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
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/11/10.
 */
public class MalAction {

    public static void searchMalData(final Context context, final String url, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMalDate(url));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<CoverModel>>() {
            @Override
            public void accept(@NonNull List<CoverModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }

    public static void searchMalImgData(final Context context, final String url, final String type, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMalImgDate(url, type));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<CoverModel>>() {
            @Override
            public void accept(@NonNull List<CoverModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }

    public static void searchMalDailySpecialData(final Context context, final String url, final String type, final boolean isDate1, final boolean isDate2, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMalDailySpecialDate(url, type, isDate1, isDate2));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<CoverModel>>() {
            @Override
            public void accept(@NonNull List<CoverModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }

    public static void searchMalTVData(final Context context, final String url, final String type, final boolean isDate1, final boolean isDate2, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMalTVDate(url, type, isDate1, isDate2));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<CoverModel>>() {
            @Override
            public void accept(@NonNull List<CoverModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }

    public static void searchMalAllData(final Context context, final String url, final String type, final int start, final int end, final boolean isDate1, final boolean isDate2, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMalAllDate(url, type, start, end, isDate1, isDate2));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<CoverModel>>() {
            @Override
            public void accept(@NonNull List<CoverModel> models) throws Exception {
                if (models != null && models.size() != 0) {
                    callBack.ok(models);
                } else {
                    callBack.failed(context.getResources().getString(R.string.find_no_result));
                }
            }
        });
    }


}
