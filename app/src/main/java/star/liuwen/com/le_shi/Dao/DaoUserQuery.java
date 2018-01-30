package star.liuwen.com.le_shi.Dao;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Model.UserModel;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/29 15:18
 * desc   : Dao类
 */
public class DaoUserQuery {

    public static void insert(UserModel model) {
        DaoManager.getInstance().getDaoSession().getUserModelDao().insert(model);
    }

    public static void deleteByModel(UserModel model) {
        DaoManager.getInstance().getDaoSession().getUserModelDao().delete(model);
    }

    public static void deleteAllData() {
        DaoManager.getInstance().getDaoSession().getUserModelDao().deleteAll();
    }

    public static void update(UserModel model) {
        DaoManager.getInstance().getDaoSession().getUserModelDao().update(model);
    }

    public static List<UserModel> query() {
        List<UserModel> list = new ArrayList<>();
        list = DaoManager.getInstance().getDaoSession().getUserModelDao().queryBuilder().list();
        return list;
    }

    public static long getCount() {
        return DaoManager.getInstance().getDaoSession().getUserModelDao().count();
    }

}
