package star.liuwen.com.le_shi.Jsoup;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Model.CoverModel;


/**
 * Created by liuwen on 2017/6/22.
 * jsoup爬取网页封装类
 */
public class HtmlParserUtil {

    public static List<CoverModel> searchCoverData(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Element element = document.getElementsByAttributeValue("class", "change-pic-list").first();
            Elements links = element.getElementsByTag("a");
            Log.e(Config.TAG, links.toString());
            for (Element link : links) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(link.attr("data-pic"));
                model.setCoverTitle(link.attr("title"));
                model.setCoverVideoUrl(link.attr("href"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //今日热点
    public static List<CoverModel> searchHotData(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.news-list-picbox");
            Log.e(Config.TAG, elements.size() + "");
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

    //猜你喜欢
    public static List<CoverModel> searchLovely(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("ul.js-guest-like-list").select("div.js-collect");
            //  Log.e(Config.TAG, elements.toString());
            Log.e(Config.TAG, elements.size() + "");

            for (Element element : elements) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(element.select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(element.select("a").attr("title"));
                model.setCoverVideoUrl(element.select("a").attr("href"));
                Log.e(Config.TAG, "猜你喜欢videoUrl====" + element.select("a").attr("href"));
                Log.e(Config.TAG, "猜你喜欢title====" + element.select("a").attr("title"));
                Log.e(Config.TAG, "猜你喜欢image====" + element.select("a").select("img").attr("data-ersrc"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //编辑推荐
    public static List<CoverModel> searchEditRecommend(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.js-editor-recommend").select("div.js-collect");
            Log.e(Config.TAG, elements.size() + "");

            for (Element element : elements) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(element.select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(element.select("a").attr("title"));
                model.setCoverVideoUrl(element.select("a").attr("href"));
                Log.e(Config.TAG, "videoUrl====" + element.select("a").attr("href"));
                Log.e(Config.TAG, "title====" + element.select("a").attr("title"));
                Log.e(Config.TAG, "image====" + element.select("a").select("img").attr("data-ersrc"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<CoverModel> searchEditRecommend2(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.js-editor-recommend").select("div.hot-pic-text-box");
            Log.e(Config.TAG, elements.size() + "");

            for (Element element : elements) {
                CoverModel model = new CoverModel();
                model.setCoverDesc(element.select("p.hot-pic-tip").text());
                model.setCoverScore(element.select("p.hot-pic-tit").select("span").first().text());
                Log.e(Config.TAG, "评分===" + element.select("p.hot-pic-tit").select("span").first().text());
                Log.e(Config.TAG, "desc==" + element.select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //电视剧
    public static List<CoverModel> searchTV(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");

            for (int i = 0; i < 12; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "集数===" + elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //电影
    public static List<CoverModel> searchMovie(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 12; i < 24; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                // model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //动漫
    public static List<CoverModel> searchDongMan(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 24; i < 34; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "集数===" + elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //综艺
    public static List<CoverModel> searchZongYi(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 34; i < 42; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "集数===" + elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //教育
    public static List<CoverModel> searchEducation(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 44; i < 50; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                // model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //微电影
    public static List<CoverModel> searchWeiMovie(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 50; i < 58; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                // model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //音乐
    public static List<CoverModel> searchMv(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 58; i < elements.size(); i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("src"));
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                // model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //体育
    public static List<CoverModel> searchSports(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("ul.education-list").select("div.js-collect");
//            Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");

            for (int i = 0; i < 6; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("a").select("img").attr("src"));
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("a").select("img").attr("data-ersrc"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //全景
    public static List<CoverModel> searchOverAllView(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements = document.select("ul.education-list").select("div.js-collect");
//            Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");

            for (int i = 7; i < elements.size(); i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("a").select("img").attr("src"));
                model.setCoverPage(elements.get(i).select("p").last().text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "集数===" + elements.get(i).select("p").last().text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //全景
    public static List<CoverModel> searchOverAllView2(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements1 = document.select("ul.education-list").select("div.hot-pic-text-box");
            for (int i = 7; i < elements1.size(); i++) {
                CoverModel model = new CoverModel();
                model.setCoverDesc(elements1.get(i).select("p.hot-pic-tip").text());
                model.setCoverScore(elements1.get(i).select("p.hot-pic-tit").select("span").first().text());
                Log.e(Config.TAG, "评分===" + elements1.get(i).select("p.hot-pic-tit").select("span").first().text());
                Log.e(Config.TAG, "desc==" + elements1.get(i).select("p.hot-pic-tip").text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //============================================电视剧数据===============================================


    public static List<CoverModel> searchTvHotPlay(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(40000).get();
            Elements elements1 = document.select("ul.movie-guesslike-list");
            for (int i = 0; i < elements1.size(); i++) {

                for (int j = 0; j < elements1.select("div.js-collect").size(); j++) {
                    CoverModel model = new CoverModel();
                    model.setCoverVideoUrl(elements1.select("div.js-collect").get(j).select("a").attr("href"));
                    model.setCoverTitle(elements1.select("div.js-collect").get(j).select("a").attr("title"));
                    model.setCoverUrl(elements1.select("div.js-collect").get(j).select("a").select("img").attr("data-ersrc"));
                    model.setCoverType("热播剧");
                    Log.e(Config.TAG, "videoUrl====" + elements1.select("div.js-collect").get(j).select("a").attr("href"));
                    Log.e(Config.TAG, "title====" + elements1.select("div.js-collect").get(j).select("a").attr("title"));
                    Log.e(Config.TAG, "image====" + elements1.select("div.js-collect").get(j).select("a").select("img").attr("data-ersrc"));
                    list.add(model);
                }
                for (int n = 0; n < elements1.select("p.hot-pic-text").size(); n++) {
                    CoverModel model = new CoverModel();
                    model.setCoverPage(elements1.select("p.hot-pic-text").get(n).select("a").text());
                    Log.e(Config.TAG, "集数===" + elements1.select("p.hot-pic-text").get(n).select("a").text());
                    list.add(model);
                }

                for (int m = 0; m < elements1.select("div.hot-pic-text-box").size(); m++) {
                    CoverModel model = new CoverModel();
                    model.setCoverScore(elements1.select("div.hot-pic-text-box").get(m).select("p.hot-pic-tit").select("span").first().text());
                    model.setCoverDesc(elements1.select("div.hot-pic-text-box").get(m).select("p.hot-pic-tip").text());
                    Log.e(Config.TAG, "评分===" + elements1.select("div.hot-pic-text-box").get(m).select("p.hot-pic-tit").select("span").first().text());
                    Log.e(Config.TAG, "desc===" + elements1.select("div.hot-pic-text-box").get(m).select("p.hot-pic-tip").text());
                    list.add(model);

                }
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
