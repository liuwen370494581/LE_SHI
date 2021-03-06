package star.liuwen.com.le_shi.Base;

import android.os.Environment;

/**
 * Created by liuwen on 2017/10/12.
 */
public class Config {
    // url  mark
    public static final String TAG = "MainActivity";
    public static final String BAO_FENG_URL = "http://www.baofeng.com/";
    public static final String BAO_FENG_URL_2 = "http://www.baofeng.com";
    public static final String BAO_FENG_TV_URL = "http://www.baofeng.com/tv.html";
    public static final String BAO_FENG_MOIVE_URL = "http://www.baofeng.com/movie.html";
    public static final String BAO_FENG_ZONG_YI_URL = "http://www.baofeng.com/enc.html";
    public static final String BAO_FENFG_DONG_MAN_URL = "http://www.baofeng.com/comic.html";
    public static final String BAO_FENG_ZI_XUN_URL = "http://www.baofeng.com/micvideo.html";
    public static final String BAO_FENG_WEI_MOVIE_URL = "http://hd.baofeng.com/mv/29/list-type-70-ishot-1-sid-1-p-1.shtml";
    public static final String BAO_FENG_VIP_URL = "http://vip.baofeng.com/";
    public static final String BAO_FENG_BBS_ALL = "http://bbs.baofeng.com/forum-179-1.html";
    public static final String BAO_FENG_MAL_URL = "http://mall.baofeng.com/?order_ad=10096";


    //Intent mark
    public static final String INTENT_BBS_URL = "BBS_URL";
    public static final String INTENT_COMM_MODEL = "COMM_MODEL";
    public static final String INTENT_AREA_CODE = "AreaCode";
    public static final String INTENT_MODIFY = "modify";
    public static final String INTENT_ADDRESS = "address";
    public static final String INTENT_NICK_NAME = "nickName";


    //channel mark

    public static final String CHANNEL_CHOICE = "choice";
    public static final String CHANNEL_TV = "tv";
    public static final String CHANNEL_MOVIE = "moive";
    public static final String CHANNEL_ZONG_YI = "zongyi";
    public static final String CHANNEL_DONG_MAN = "dongMan";
    public static final String CHANNEL_VIP = "vip";
    public static final String CHANNEL_MAL = "mal";


    //SharedPreferences mark
    public static final String SdRootPath = Environment.getExternalStorageDirectory().getPath() + "/le_shi";
    public static final String CACHE_IMG_PATH = SdRootPath + "/images/";//图片缓存路径
    public static final String SHARD_USER_NAME = "userName";
    public static final String SHARD_USER_TEL = "userTel";
    public static final String SHARD_USER_PASSWORD = "userPassWord";
    public static final String SHARE_LOGO = SdRootPath + "/share/logo/";//分享功能资源路径

}
