package star.liuwen.com.le_shi.Model;

import java.io.Serializable;

/**
 * Created by liuwen on 2017/11/6.
 */
public class BbsModel implements Serializable {

    private String url;//详细地址
    private String hideTop;//隐藏置顶
    private String views;//观看了多少次
    private String lookView;//预览
    private String title;//内容
    private String userName;//用户名
    private String startDate;//开始日志
    private String endDate;//结算日期
    private String top;//置顶

    public BbsModel() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHideTop() {
        return hideTop;
    }

    public void setHideTop(String hideTop) {
        this.hideTop = hideTop;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLookView() {
        return lookView;
    }

    public void setLookView(String lookView) {
        this.lookView = lookView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
