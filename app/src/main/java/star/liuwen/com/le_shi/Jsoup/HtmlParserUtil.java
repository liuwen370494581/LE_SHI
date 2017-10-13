package star.liuwen.com.le_shi.Jsoup;

import android.util.Log;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liuwen on 2017/6/22.
 * jsoup爬取网页封装类
 */
public class HtmlParserUtil {

//    //获取起点数据info 排行榜
//    public static List<BookModel> searchQiDianRanking(String url, int indexPage, int typePage) {
//        List<BookModel> list = new ArrayList<>();
//        try {
//            Document document = Jsoup.connect(String.format(url, indexPage) + typePage).timeout(40000).get();
//            Log.e("MyTag", String.format(url, typePage) + indexPage);
//            Elements elements = document.select("div.book-mid-info");
//            for (int i = 0; i < elements.size(); i++) {
//                BookModel model = new BookModel();
//                Log.e(Config.TAG, "bookDetailUrl====" + elements.get(i).select("a").attr("href"));
//                Log.e(Config.TAG, "bookName====" + elements.get(i).select("h4").text());
//                Log.e(Config.TAG, "bookAuthor===" + elements.get(i).select("p").first().text());
//                Log.e(Config.TAG, "bookAuthorUrl===" + elements.get(i).select("p").select("a").attr("href"));
//                Log.e(Config.TAG, "bookUpdateContent===" + elements.get(i).select("p").select("a").last().text());
//                Log.e(Config.TAG, "bookDesc======" + elements.get(i).select("p.intro").text());
//                Log.e(Config.TAG, "bookUpdateTime====" + elements.get(i).select("p").select("span").last().text());
//                model.setBookDetailUrl(elements.get(i).select("a").attr("href"));
//                model.setBooKName(elements.get(i).select("h4").text());
//                model.setBookAuthorUrl(elements.get(i).select("p").select("a").attr("href"));
//                String updateContent = elements.get(i).select("p").select("a").last().text().replace("最新更新", "");
//                model.setBookDesc(elements.get(i).select("p.intro").text());
//                model.setBookAuthor(elements.get(i).select("p").first().text());
//                model.setBookUpdateContent(updateContent);
//                model.setBookUpdateTime(elements.get(i).select("p").select("span").last().text());
//                list.add(model);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    //获取起点图书的img 排行榜
//    public static List<String> searchQiDianRankingPic(String url, int indexPage, int typePage) {
//        List<String> list = new ArrayList<>();
//        try {
//            Document document = Jsoup.connect(String.format(url, indexPage) + typePage).timeout(40000).get();
//            Elements elements1 = document.select("div.book-img-box");
//            for (int j = 0; j < elements1.size(); j++) {
//                list.add(elements1.get(j).select("a").select("img").attr("src"));
//                Log.e("MainActivity", "bookUrl" + elements1.get(j).select("a").select("img").attr("src"));
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
