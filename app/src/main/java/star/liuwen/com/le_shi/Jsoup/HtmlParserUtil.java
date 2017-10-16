package star.liuwen.com.le_shi.Jsoup;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Model.CoverModel;


/**
 * Created by liuwen on 2017/6/22.
 * jsoup爬取网页封装类
 */
public class HtmlParserUtil {

    //获取起点数据info 排行榜
    public static List<CoverModel> searchCoverData() {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(Config.LE_SHI_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Element element = document.getElementsByAttributeValue("class", "change-pic-list").first();
            Elements links = element.getElementsByTag("a");
            //   Log.e(Config.TAG, links.size() + "");
            for (Element link : links) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(link.attr("data-pic"));
                model.setCoverTitle(link.attr("title"));
                model.setCoverVideoUrl(link.attr("href"));
//                Log.e(Config.TAG, "cover====" + link.attr("data-pic"));
//                Log.e(Config.TAG, "coverTitle====" + link.attr("title"));
//                Log.e(Config.TAG, "coverUrl====" + link.attr("href"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<CoverModel> searchHotData() {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(Config.LE_SHI_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.news-list-picbox");
            Log.e(Config.TAG, elements.size() + "");
            //  Log.e(Config.TAG, elements.toString());
            for (Element element : elements) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(element.select("p.news-list-pic").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(element.select("p.news-list-pic").select("a").attr("title"));
                model.setCoverVideoUrl(element.select("p.news-list-pic").select("a").attr("href"));
                Log.e(Config.TAG, "videoUrl====" + element.select("p.news-list-pic").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + element.select("p.news-list-pic").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + element.select("p.news-list-pic").select("a").select("img").attr("data-ersrc"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
