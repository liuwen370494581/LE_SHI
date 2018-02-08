package star.liuwen.com.le_shi.Jsoup;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Model.BbsModel;
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
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
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
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
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
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
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
    public static List<CoverModel> searchEditRecommend(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.js-editor-recommend").select("div.js-collect");
            Log.e(Config.TAG, elements.size() + "");

            for (Element element : elements) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
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

    public static List<CoverModel> searchEditRecommend2(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.js-editor-recommend").select("div.hot-pic-text-box");
            Log.e(Config.TAG, elements.size() + "");

            for (Element element : elements) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
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
    public static List<CoverModel> searchTV(String url, int start, int size, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
            Log.e(Config.TAG, "电视剧" + elements.toString());
            for (int i = start; i < size; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                model.setCoverType(tvType);
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
    public static List<CoverModel> searchMovie(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 12; i < 24; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
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
    public static List<CoverModel> searchDongMan(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 24; i < 34; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
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
    public static List<CoverModel> searchZongYi(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 34; i < 42; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
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
    public static List<CoverModel> searchEducation(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 44; i < 50; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
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
    public static List<CoverModel> searchWeiMovie(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 50; i < 58; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
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
    public static List<CoverModel> searchMv(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
//           Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");
            //
            for (int i = 58; i < elements.size(); i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
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
    public static List<CoverModel> searchSports(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("ul.education-list").select("div.js-collect");
//            Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");

            for (int i = 0; i < 6; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("a").attr("href"));
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
    public static List<CoverModel> searchOverAllView(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("ul.education-list").select("div.js-collect");
//            Log.e(Config.TAG, elements.toString());
//            Log.e(Config.TAG, elements.size() + "");

            for (int i = 7; i < 13; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
                model.setCoverUrl(elements.get(i).select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("a").attr("href"));
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
    public static List<CoverModel> searchOverAllView2(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements1 = document.select("ul.education-list").select("div.hot-pic-text-box");
            for (int i = 7; i < 13; i++) {
                CoverModel model = new CoverModel();
                model.setCoverType(type);
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
    public static List<CoverModel> searchTvHotPlay(String url, int start, int size, boolean isDate1, boolean isDate2, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements1 = document.select("ul.movie-guesslike-list");
            Elements elements2 = elements1.select("div.js-collect");
            Elements elements4 = elements1.select("div.hot-pic-text-box");
            if (isDate1)
                for (int j = start; j < size; j++) {
                    CoverModel model = new CoverModel();
                    model.setCoverVideoUrl(elements2.get(j).select("a").attr("href"));
                    model.setCoverTitle(elements2.get(j).select("a").attr("title"));
                    model.setCoverUrl(elements2.get(j).select("a").select("img").attr("data-ersrc"));
                    model.setCoverType(tvType);
                    Log.e(Config.TAG, "videoUrl====" + elements2.get(j).select("a").attr("href"));
                    Log.e(Config.TAG, "title====" + elements2.get(j).select("a").attr("title"));
                    Log.e(Config.TAG, "image====" + elements2.get(j).select("a").select("img").attr("data-ersrc"));
                    list.add(model);
                }

            if (isDate2)
                for (int m = start; m < size; m++) {
                    CoverModel model = new CoverModel();
                    model.setCoverType(tvType);
                    model.setCoverScore(elements4.get(m).select("p.hot-pic-tit").select("span").first().text());
                    model.setCoverDesc(elements4.get(m).select("p.hot-pic-tip").text());
                    Log.e(Config.TAG, "评分===" + elements4.get(m).select("p.hot-pic-tit").select("span").first().text());
                    Log.e(Config.TAG, "desc===" + elements4.get(m).select("p.hot-pic-tip").text());
                    list.add(model);
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //===================================================电影数据===========================================
    //各种电影数据
    public static List<CoverModel> searchALLMovie(String url, int start, int size, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
            for (int i = start; i < size; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                model.setCoverScore(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tit").select("span").first().text());
                model.setCoverType(tvType);
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                Log.e(Config.TAG, "分数===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tit").select("span").first().text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //===============================================综艺数据=============================================

    public static List<CoverModel> searchZongYiCoverData(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Element element = document.getElementsByAttributeValue("class", "channel-pic-list").first();
            Elements links = element.getElementsByTag("a");
            // Log.e(Config.TAG, links.toString());
            for (Element link : links) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(link.attr("data-pic"));
                model.setCoverTitle(link.attr("title"));
                model.setCoverVideoUrl(link.attr("href"));
                model.setCoverDesc(link.attr("data-value"));
                Log.e(Config.TAG, "img===" + link.attr("data-pic"));
                Log.e(Config.TAG, "desc===" + link.attr("title"));
                Log.e(Config.TAG, "href===" + link.attr("href"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //==============================================动漫资源=============================================

    public static List<CoverModel> searchDongManEveryUpdateData(String url, int start, int size, String date) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("ul.update-list");
            for (int i = start; i < size; i++) {
                Elements links = elements.get(i).getElementsByTag("li");
                for (int j = 0; j < links.size(); j++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "动漫 videoUrl====" + links.get(j).select("a").attr("href"));
                    Log.e(Config.TAG, "动漫title====" + links.get(j).select("a").attr("title"));
                    Log.e(Config.TAG, "动漫img====" + links.get(j).select("a").select("img").attr("data-ersrc"));
                    Log.e(Config.TAG, "动漫 集数===" + links.get(j).select("div.dailyupdate-info").select("p").text());
                    model.setCoverVideoUrl(links.get(j).select("a").attr("href"));
                    model.setCoverTitle(links.get(j).select("a").attr("title"));
                    model.setCoverPage(links.get(j).select("div.dailyupdate-info").select("p").text());
                    model.setCoverUrl(links.get(j).select("a").select("img").attr("data-ersrc"));
                    model.setCoverType(date);
                    list.add(model);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<CoverModel> searchDongMan(String url, int start, int size, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
            for (int i = start; i < size; i++) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                model.setCoverTitle(elements.get(i).select("div.js-collect").select("a").attr("title"));
                model.setCoverVideoUrl(elements.get(i).select("div.js-collect").select("a").attr("href"));
                model.setCoverDesc(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                model.setCoverScore(elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tit").select("span").first().text());
                model.setCoverType(tvType);
                model.setCoverPage(elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.js-collect").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.js-collect").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.js-collect").select("a").select("img").attr("data-ersrc"));
                Log.e(Config.TAG, "desc===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tip").text());
                Log.e(Config.TAG, "集数===" + elements.get(i).select("div.js-collect").select("p.hot-pic-text").select("a").text());
                Log.e(Config.TAG, "分数===" + elements.get(i).select("div.hot-pic-text-box").select("p.hot-pic-tit").select("span").first().text());
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //==============================================资讯资源=============================================

    public static List<CoverModel> searchZiXunCoverData(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Element element = document.getElementsByAttributeValue("class", "hd-info-pic").first();
            Elements links = element.getElementsByTag("a");
            for (Element link : links) {
                CoverModel model = new CoverModel();
                model.setCoverUrl(link.select("img").attr("src"));
                model.setCoverTitle(link.select("img").attr("alt"));
                model.setCoverVideoUrl(link.attr("href"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<CoverModel> searchZiXunAll(String url, int start, int size, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.tv-landscape-con");
            for (int i = start; i < size; i++) {
                CoverModel model = new CoverModel();
                model.setCoverVideoUrl(elements.get(i).select("div.hot-pic-like").select("a").attr("href"));
                model.setCoverTitle(elements.get(i).select("div.hot-pic-like").select("a").attr("title"));
                model.setCoverUrl(elements.get(i).select("div.hot-pic-like").select("a").select("img").attr("data-ersrc"));
                model.setCoverType(tvType);
                Log.e(Config.TAG, "videoUrl====" + elements.get(i).select("div.hot-pic-like").select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("div.hot-pic-like").select("a").attr("title"));
                Log.e(Config.TAG, "image====" + elements.get(i).select("div.hot-pic-like").select("a").select("img").attr("data-ersrc"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //微电影的数据
    public static List<CoverModel> searchAllWeiMovie(String url, boolean isDate1, boolean isDate2, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements1 = document.select("ul.hd-sort-list");
            Elements elements2 = elements1.select("div.js-collect");
            Elements elements4 = elements1.select("div.hot-pic-text-box");
            if (isDate1)
                for (int j = 0; j < elements2.size(); j++) {
                    CoverModel model = new CoverModel();
                    model.setCoverVideoUrl(elements2.get(j).select("a").attr("href"));
                    model.setCoverTitle(elements2.get(j).select("a").attr("title"));
                    model.setCoverUrl(elements2.get(j).select("a").select("img").attr("data-ersrc"));
                    model.setCoverType(tvType);
                    Log.e(Config.TAG, "videoUrl====" + elements2.get(j).select("a").attr("href"));
                    Log.e(Config.TAG, "title====" + elements2.get(j).select("a").attr("title"));
                    Log.e(Config.TAG, "image====" + elements2.get(j).select("a").select("img").attr("data-ersrc"));
                    list.add(model);
                }

            if (isDate2)
                for (int m = 0; m < elements4.size(); m++) {
                    CoverModel model = new CoverModel();
                    model.setCoverType(tvType);
                    model.setCoverScore(elements4.get(m).select("p.hot-pic-tit").select("span").first().text());
                    model.setCoverDesc(elements4.get(m).select("p.hot-pic-tip").text());
                    Log.e(Config.TAG, "评分===" + elements4.get(m).select("p.hot-pic-tit").select("span").first().text());
                    Log.e(Config.TAG, "desc===" + elements4.get(m).select("p.hot-pic-tip").text());
                    list.add(model);
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //vip资源

    public static List<CoverModel> searchAllVipMovie(String url, int start, int size, boolean isDate1, boolean isDate2, String tvType) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements1 = document.select("ul.vipcenter-list");
            Elements elements2 = elements1.select("div.js-collect");
            Elements elements4 = elements1.select("div.hot-pic-text-box");
            if (isDate1)
                for (int j = start; j < size; j++) {
                    CoverModel model = new CoverModel();
                    model.setCoverVideoUrl(elements2.get(j).select("a").attr("href"));
                    model.setCoverTitle(elements2.get(j).select("a").attr("title"));
                    model.setCoverUrl(elements2.get(j).select("a").select("img").attr("src"));
                    model.setCoverType(tvType);
                    Log.e(Config.TAG, "videoUrl====" + elements2.get(j).select("a").attr("href"));
                    Log.e(Config.TAG, "title====" + elements2.get(j).select("a").attr("title"));
                    Log.e(Config.TAG, "image====" + elements2.get(j).select("a").select("img").attr("src"));
                    list.add(model);
                }

            if (isDate2)
                for (int m = start; m < size; m++) {
                    CoverModel model = new CoverModel();
                    model.setCoverType(tvType);
                    model.setCoverScore(elements4.get(m).select("p.hot-pic-tit").select("span").first().text());
                    model.setCoverDesc(elements4.get(m).select("p.hot-pic-tip").text());
                    Log.e(Config.TAG, "评分===" + elements4.get(m).select("p.hot-pic-tit").select("span").first().text());
                    Log.e(Config.TAG, "desc===" + elements4.get(m).select("p.hot-pic-tip").text());
                    list.add(model);
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //搜索bbs资源
    public static List<BbsModel> searchBBSDate(String url) {
        List<BbsModel> list = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(10000).get();
            Elements elements2 = document.select("div.tl_ct");
            Log.e(Config.TAG, document.select("div.tl_ct").size() + "");
            for (int i = 0; i < elements2.size(); i++) {
                BbsModel model = new BbsModel();
                Log.e(Config.TAG, "url===" + elements2.get(i).select("a").last().attr("href"));
                Log.e(Config.TAG, "发表日期===" + elements2.get(i).select("span").last().text());
                model.setUrl(elements2.get(i).select("a").last().attr("href"));
                model.setStartDate(elements2.get(i).select("span").last().text());
                Log.e(Config.TAG, "views===" + elements2.get(i).select("a").text());
                if (elements2.get(i).select("a").get(0).text().equals("隐藏置顶帖")) {
                    model.setViews(elements2.get(i).select("a").get(1).text());
                    model.setLookView(elements2.get(i).select("a").get(2).text());
                    model.setTitle(elements2.get(i).select("a").get(3).text());
                    model.setUserName(elements2.get(i).select("a").get(4).text());
                    model.setEndDate(elements2.get(i).select("a").get(5).text());
                } else {
                    model.setViews(elements2.get(i).select("a").get(0).text());
                    model.setLookView(elements2.get(i).select("a").get(1).text());
                    model.setTitle(elements2.get(i).select("a").get(2).text());
                    if (elements2.get(i).select("a").get(3).text().contains("2016") || elements2.get(i).select("a").get(3).text().contains("2017")
                            || elements2.get(i).select("a").get(3).text().contains("2018")) {
                        model.setEndDate(elements2.get(i).select("a").get(3).text());
                    } else {
                        model.setUserName(elements2.get(i).select("a").get(3).text());
                        model.setEndDate(elements2.get(i).select("a").get(4).text());
                    }
                }
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Config.TAG, "网络错误码" + e.getLocalizedMessage());
        }

        return list;
    }


    public static List<String> searchBBSImgData(String url) {
        List<String> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements3 = document.select("div.avatarbox");

            for (int i = 0; i < elements3.size(); i++) {
                //  Log.e(Config.TAG, "img===" + elements3.get(i).select("a").select("img").attr("src"));
                list.add(elements3.get(i).select("a").select("img").attr("src"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //商城资源
    public static List<CoverModel> searchMalDate(String url) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.slides-ul").select("div.item");
            for (int i = 0; i < elements.size(); i++) {
                CoverModel model = new CoverModel();
                String str = elements.get(i).attr("style");
                model.setCoverUrl(str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")));
                model.setCoverVideoUrl(elements.get(i).select("a").attr("href"));
                model.setCoverTitle(elements.get(i).select("a").last().text());
                Log.e(Config.TAG, "Video====" + elements.get(i).select("a").attr("href"));
                Log.e(Config.TAG, "title====" + elements.get(i).select("a").last().text());
                Log.e(Config.TAG, "sub===" + str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")));
                list.add(model);

            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<CoverModel> searchMalImgDate(String url, String type) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.s-banner").select("li.banner-category");
            Log.e(Config.TAG, "banner===" + elements.size());
            for (int i = 0; i < elements.size(); i++) {
                CoverModel model = new CoverModel();
//                Log.e(Config.TAG, "url====" + elements.get(i).select("a").select("img").attr("src"));
//                Log.e(Config.TAG, "video===" + elements.get(i).select("a").attr("href"));
                model.setCoverUrl(elements.get(i).select("a").select("img").attr("src"));
                model.setCoverVideoUrl(elements.get(i).select("a").attr("href"));
                list.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    ///商城今日特价
    public static List<CoverModel> searchMalDailySpecialDate(String url, String type, boolean isDate1, boolean isDate2) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("ul.news-list-wrap").select("li.item");
            Elements elements1 = elements.select("div.pro-info");
            if (isDate1)
                for (int i = 0; i < elements.size(); i++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "url====" + elements.get(i).select("a").select("img").attr("src"));
                    Log.e(Config.TAG, "video===" + elements.get(i).select("a").attr("href"));
                    model.setCoverUrl(elements.get(i).select("a").select("img").attr("src"));
                    model.setCoverVideoUrl(elements.get(i).select("a").attr("href"));
                    model.setCoverType(type);
                    list.add(model);
                }

            if (isDate2)
                for (int j = 0; j < elements1.size(); j++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "title====" + elements.get(j).select("a").text());
                    Log.e(Config.TAG, "Dprice===" + elements.get(j).select("div.price").select("span.price-value").text());
                    Log.e(Config.TAG, "price===" + elements.get(j).select("div.price").select("del.ori-price-value").text());
                    model.setCoverTitle(elements.get(j).select("a").text());
                    model.setCoverScore(elements.get(j).select("div.price").select("span.price-value").text());
                    model.setCoverPage(elements.get(j).select("div.price").select("del.ori-price-value").text());
                    model.setCoverType(type);
                    list.add(model);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //暴风TV
    public static List<CoverModel> searchMalTVDate(String url, String type, boolean isDate1, boolean isDate2) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("div.index-box-list").select("a");
            Log.e("yichao", document.select("div.index-box-list").toString());
            Elements elements1 = elements.select("a");
            Elements elements2 = elements.select("div.info");
            Log.e(Config.TAG, elements.size() + "");
            if (isDate1)
                for (int i = 0; i < 4; i++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "url====" + elements1.get(i).select("a").select("img").attr("src"));
                    model.setCoverUrl(elements1.get(i).select("a").select("img").attr("src"));
                    model.setCoverType(type);
                    list.add(model);
                }
            if (isDate2)
                for (int j = 0; j < 4; j++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "video===" + elements1.get(j).select("a").attr("href"));
                    Log.e(Config.TAG, "title===" + elements1.get(j).select("span.name").text());
                    model.setCoverTitle(elements1.get(j).select("a").attr("title"));
                    model.setCoverVideoUrl(elements1.get(j).select("a").attr("href"));
                    model.setCoverType(type);
                    list.add(model);
                }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<CoverModel> searchMalAllDate(String url, String type, int start, int end, boolean isDate1, boolean isDate2) {
        List<CoverModel> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(4000).get();
            Elements elements = document.select("ul.center-side");
            Elements elements1 = elements.select("a").select("img");
            Elements elements2 = elements.select("a.product-info");
            if (isDate1)
                for (int i = start; i < end; i++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "url====" + elements1.get(i).attr("src"));
                    model.setCoverUrl(elements1.get(i).attr("src"));
                    model.setCoverType(type);
                    list.add(model);
                }
            if (isDate2)
                for (int j = start; j < end; j++) {
                    CoverModel model = new CoverModel();
                    Log.e(Config.TAG, "Videourl====" + elements2.get(j).attr("href"));
                    Log.e(Config.TAG, "title===" + elements2.get(j).select("span.name").text());
                    Log.e(Config.TAG, "price===" + elements2.get(j).select("span.activity").text());
                    model.setCoverVideoUrl(elements2.get(j).attr("href"));
                    model.setCoverTitle(elements2.get(j).select("span.name").text());
                    model.setCoverScore(elements2.get(j).select("span.activity").text());
                    model.setCoverType(type);
                    list.add(model);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
