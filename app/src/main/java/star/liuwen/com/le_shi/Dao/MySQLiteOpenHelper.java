package star.liuwen.com.le_shi.Dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;


/**
 * @data 2017/2/17 0017
 * @aurher Administrator
 */


public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.e("greenDAO",
                "Upgrading schema from version " + oldVersion + " to " + newVersion + " by migrating all tables data");
        //完全自动升级本地数据库 要升级那个bean 只需要调用下面这个方法
        // MigrationHelper.getInstance().migrate(db, xxx.class);
        //  MigrationHelper.getInstance().migrate(db, TestDao.class);
        //如果要升级的时候 在改变version号即可
        MigrationHelper.getInstance().migrate(db, UserModelDao.class);
    }
}
