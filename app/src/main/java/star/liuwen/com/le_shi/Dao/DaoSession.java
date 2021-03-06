package star.liuwen.com.le_shi.Dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.Model.UserModel;

import star.liuwen.com.le_shi.Dao.CoverModelDao;
import star.liuwen.com.le_shi.Dao.UserModelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig coverModelDaoConfig;
    private final DaoConfig userModelDaoConfig;

    private final CoverModelDao coverModelDao;
    private final UserModelDao userModelDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        coverModelDaoConfig = daoConfigMap.get(CoverModelDao.class).clone();
        coverModelDaoConfig.initIdentityScope(type);

        userModelDaoConfig = daoConfigMap.get(UserModelDao.class).clone();
        userModelDaoConfig.initIdentityScope(type);

        coverModelDao = new CoverModelDao(coverModelDaoConfig, this);
        userModelDao = new UserModelDao(userModelDaoConfig, this);

        registerDao(CoverModel.class, coverModelDao);
        registerDao(UserModel.class, userModelDao);
    }
    
    public void clear() {
        coverModelDaoConfig.clearIdentityScope();
        userModelDaoConfig.clearIdentityScope();
    }

    public CoverModelDao getCoverModelDao() {
        return coverModelDao;
    }

    public UserModelDao getUserModelDao() {
        return userModelDao;
    }

}
