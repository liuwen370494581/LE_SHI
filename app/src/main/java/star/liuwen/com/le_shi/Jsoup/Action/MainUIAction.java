package star.liuwen.com.le_shi.Jsoup.Action;

import android.content.Context;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Jsoup.HtmlParserUtil;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/13.
 */
public class MainUIAction {


    public static void searchCoverData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchCoverData());
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


    public static void searchLovelyData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchLovely());
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

    public static void searchEditRecommendData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchEditRecommend());
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

    public static void searchEditRecommendData2(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchEditRecommend2());
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
    public static void searchTvData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchTV());
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

    public static void searchMovieData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMovie());
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

    public static void searchDongManData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchDongMan());
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

    public static void searchZongYiData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchZongYi());
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


    public static void searchEducationData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchEducation());
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

    public static void searchWeiMovieData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchWeiMovie());
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

    public static void searchMVData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchMv());
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

    public static void searchSportsData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchSports());
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


    public static void searchOverAllViewData(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchOverAllView());
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

    public static void searchOverAllViewData2(final Context context, final ActionCallBack callBack) {
        Observable.create(new ObservableOnSubscribe<List<CoverModel>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CoverModel>> e) throws Exception {
                e.onNext(HtmlParserUtil.searchOverAllView2());
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
