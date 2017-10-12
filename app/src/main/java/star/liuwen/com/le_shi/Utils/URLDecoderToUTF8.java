package star.liuwen.com.le_shi.Utils;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuwen on 2017/7/31.
 */
public class URLDecoderToUTF8 {

    public static String StringToUTF8(String url) {

        //中文的utf-8范围
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        //找到中文url中的中文
        Matcher m = p.matcher(url);
        //依次递推，查找下一个单个文字，然后把他替换成utf-8
        while (m.find()) {
            String group = m.group();
            try {
                url = url.replaceFirst(group, URLEncoder.encode(group, "utf-8"));
            } catch (Exception e) {
                // do nothing
            }
        }
        return url;

    }
}
