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


    public static List<String> getContentDate() {
        List<String> list = new ArrayList<>();
        list.add("电影");
        list.add("电视剧");
        list.add("动漫");
        list.add("纪录片");
        return list;
    }

    public static List<String> getSortDate() {
        List<String> list = new ArrayList<>();
        list.add("最热");
        list.add("最新");
        list.add("好评");
        return list;
    }

    public static List<String> getTypeDate() {
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("喜剧");
        list.add("动作");
        list.add("恐怖");
        list.add("动画");
        list.add("警匪");
        list.add("武侠");
        list.add("战争");
        list.add("短片");
        list.add("爱情");
        list.add("科幻");
        list.add("奇幻");
        list.add("犯罪");
        list.add("冒险");
        list.add("灾难");
        list.add("伦理");
        list.add("传记");
        list.add("家庭");
        list.add("记录");
        list.add("惊悚");
        list.add("历史");
        list.add("悬疑");
        list.add("歌舞");
        list.add("体育");
        return list;
    }

    public static List<String> getMoneyDate() {
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("免费");
        list.add("影视会员");
        return list;
    }

    public static List<String> getLocDate() {
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("内地");
        list.add("美国");
        list.add("香港");
        list.add("英国");
        list.add("法国");
        list.add("俄罗斯");
        list.add("新加坡");
        list.add("加拿大");
        list.add("台湾");
        list.add("韩国");
        list.add("泰国");
        list.add("印度");
        list.add("冒险");
        list.add("日本");
        list.add("西班牙");
        list.add("马来西亚");
        return list;
    }

    public static List<String> getYearDate() {
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("2017");
        list.add("2016");
        list.add("2015");
        list.add("2014");
        list.add("2013");
        list.add("2012");
        list.add("2011");
        list.add("2010");
        list.add("00年代");
        list.add("90年代");
        list.add("更早");
        return list;
    }


    public static List<HashMap<String, Object>> getChannelList() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("title", "热门独享");
        map1.put("pic", R.mipmap.icon_video);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("title", "跳过广告");
        map2.put("pic", R.mipmap.icon_add);
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("title", "大剧抢先看");
        map3.put("pic", R.mipmap.icon_daju);
        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("title", "加速通道");
        map4.put("pic", R.mipmap.icon_speed);
        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("title", "独享缓存");
        map5.put("pic", R.mipmap.icon_huancun);
        HashMap<String, Object> map6 = new HashMap<>();
        map6.put("title", "多视频缓存");
        map6.put("pic", R.mipmap.icon_duo_mei_ti);
        HashMap<String, Object> map7 = new HashMap<>();
        map7.put("title", "1080p高清");
        map7.put("pic", R.mipmap.icon_hd);
        HashMap<String, Object> map8 = new HashMap<>();
        map8.put("title", "多屏同步");
        map8.put("pic", R.mipmap.icon_duo);
        HashMap<String, Object> map9 = new HashMap<>();
        map9.put("title", "生态福利");
        map9.put("pic", R.mipmap.icon_fu_li);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        return list;
    }


    public static List<String> getMalChannelList() {
        List<String> list = new ArrayList<>();
        list.add("暴风TV");
        list.add("暴风魔镜");
        list.add("暴风VIP");
        list.add("娱乐周边");
        list.add("超值套餐");
        list.add("汽车车品");
        list.add("运动户外");
        list.add("鞋靴箱包");
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
