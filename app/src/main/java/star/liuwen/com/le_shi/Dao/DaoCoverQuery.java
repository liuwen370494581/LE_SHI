package star.liuwen.com.le_shi.Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import star.liuwen.com.le_shi.Model.CoverModel;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/07 15:01
 * desc   :
 */
public class DaoCoverQuery {

    public static void insert(CoverModel model) {
        DaoManager.getInstance().getDaoSession().getCoverModelDao().insert(model);
    }

    public static void deleteByModel(CoverModel model) {
        DaoManager.getInstance().getDaoSession().getCoverModelDao().delete(model);
    }

    public static void deleteAllData() {
        DaoManager.getInstance().getDaoSession().getUserModelDao().deleteAll();
    }

    public static void update(CoverModel model) {
        DaoManager.getInstance().getDaoSession().getCoverModelDao().update(model);
    }

    public static List<CoverModel> query() {
        List<CoverModel> list = new ArrayList<>();
        list = DaoManager.getInstance().getDaoSession().getCoverModelDao().queryBuilder().list();

        return list;
    }

    public static List<CoverModel> queryByTel(String tel) {
        List<CoverModel> list = new ArrayList<>();
        list = DaoManager.getInstance().getDaoSession().getCoverModelDao().queryBuilder().
                where(CoverModelDao.Properties.UserTel.eq(tel)).build().list();
        Collections.sort(list, new Comparator<CoverModel>() {
            @Override
            public int compare(CoverModel model, CoverModel model2) {
                return model2.getCompareTime().compareTo(model.getCompareTime());
            }
        });
        return list;
    }

    public static long getCount() {
        return DaoManager.getInstance().getDaoSession().getCoverModelDao().count();
    }

    public static int getListSize() {
        return DaoCoverQuery.query().size();
    }

}
