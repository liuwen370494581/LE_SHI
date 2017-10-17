package star.liuwen.com.le_shi.DataEnage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
