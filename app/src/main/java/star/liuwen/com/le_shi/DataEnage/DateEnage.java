package star.liuwen.com.le_shi.DataEnage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import star.liuwen.com.le_shi.Model.IndexModel;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/16.
 */
public class DateEnage {


    public static List<HashMap<String, Object>> getChannelList() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("title", "排行榜");
        map1.put("pic", R.mipmap.main_bottom_nav_home_click);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("title", "分类");
        map2.put("pic", R.mipmap.main_bottom_nav_home_click);
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("title", "三江榜");
        map3.put("pic", R.mipmap.main_bottom_nav_home_click);
        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("title", "专题");
        map4.put("pic", R.mipmap.main_bottom_nav_home_click);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        return list;
    }



    //精选
    public static List<String> getChoiceChannelList() {
        List<String> list = new ArrayList<>();
        list.add("电视剧");
        list.add("电影");
        list.add("动漫");
        list.add("综艺");
        list.add("体育");
        list.add("教育");
        list.add("微电影");
        list.add("音乐");
        return list;
    }
   //电视剧
    public static List<String> getTvChannelList() {
        List<String> list = new ArrayList<>();
        list.add("同步热播");
        list.add("暴风出品");
        list.add("内地");
        list.add("自制");
        list.add("影视会员");
        list.add("排行");
        list.add("片花");
        list.add("筛选");
        return list;
    }
 //电影
    public static List<String> getMovieChannelList() {
        List<String> list = new ArrayList<>();
        list.add("精选");
        list.add("影视会员");
        list.add("内地");
        list.add("欧美");
        list.add("港台");
        list.add("片花");
        list.add("环球之声");
        list.add("筛选");

        return list;
    }
  //综艺
    public static List<String> getZongYiChannelList() {
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("真人秀");
        list.add("搞笑");
        list.add("情感");
        list.add("脱口秀");
        list.add("音乐");
        list.add("网综");
        list.add("节目单");
        return list;
    }
 //动漫
    public static List<String> getDongManChannelList() {
        List<String> list = new ArrayList<>();
        list.add("热播");
        list.add("少儿");
        list.add("中国");
        list.add("美国");
        list.add("日本");
        list.add("追番剧");
        list.add("专题");
        list.add("筛选");
        return list;
    }

    //vip
    public static List<String> getVipChannelList() {
        List<String> list = new ArrayList<>();
        list.add("独播");
        list.add("福利");
        list.add("热映");
        list.add("爱情");
        list.add("动作");
        list.add("喜剧");
        list.add("悬疑");
        list.add("筛选");
        return list;
    }

    public static List<IndexModel> getBBSDate() {
        List<IndexModel> list = new ArrayList<>();
        list.add(new IndexModel("全部", "http://bbs.baofeng.com/forum-179-1.html"));
        list.add(new IndexModel("左眼键", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=37"));
        list.add(new IndexModel("3D专区", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=106"));
        list.add(new IndexModel("功能", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=38"));
        list.add(new IndexModel("画质", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=39"));
        list.add(new IndexModel("错误代码", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=42"));
        list.add(new IndexModel("盒子展现", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=44"));
        list.add(new IndexModel("宝贵建议", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=53"));
        list.add(new IndexModel("画面卡", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=73"));
        list.add(new IndexModel("飞屏", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=286"));
        list.add(new IndexModel("推广联盟", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=144"));
        list.add(new IndexModel("软件无法使用", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=40"));
        list.add(new IndexModel("在线内容", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=45"));
        list.add(new IndexModel("字幕", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=47"));
        list.add(new IndexModel("不可播", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=48"));
        list.add(new IndexModel("广告", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=76"));
        list.add(new IndexModel("下载", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=75"));
        list.add(new IndexModel("缓冲卡", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=74"));
        list.add(new IndexModel("其他", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=90"));
        list.add(new IndexModel("声音", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=43"));
        list.add(new IndexModel("新闻播报", "http://bbs.baofeng.com/forum.php?mod=forumdisplay&fid=179&filter=typeid&typeid=55"));
        return list;

    }
}
