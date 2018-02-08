package star.liuwen.com.le_shi.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by liuwen on 2017/10/13.
 */
@Entity
public class CoverModel implements Serializable {
    @Id(autoincrement = true)
    private long id;
    private String userTel;//在这里来确定账号唯一性 根据账号可以返回一个
    private String coverVideoUrl;//播放视频url
    private String coverDesc;
    private String coverTitle;
    private String coverUrl;//封面
    private String coverPage;//集数
    @Transient
    private String coverScore;//评分
    @Transient
    private String coverType;//类型
    private String coverWatchDate;//观看日期 这个是来显示
    private String compareTime;//根据这个时间来排序

    public CoverModel() {
    }


    public CoverModel(String coverVideoUrl, String coverDesc, String coverTitle, String coverUrl) {
        this.coverVideoUrl = coverVideoUrl;
        this.coverDesc = coverDesc;
        this.coverTitle = coverTitle;
        this.coverUrl = coverUrl;
    }

    public CoverModel(String coverVideoUrl, String coverDesc, String coverTitle, String coverUrl, String coverPage) {
        this.coverVideoUrl = coverVideoUrl;
        this.coverDesc = coverDesc;
        this.coverTitle = coverTitle;
        this.coverUrl = coverUrl;
        this.coverPage = coverPage;
    }


    @Generated(hash = 2147446524)
    public CoverModel(long id, String userTel, String coverVideoUrl, String coverDesc, String coverTitle, String coverUrl,
            String coverPage, String coverWatchDate, String compareTime) {
        this.id = id;
        this.userTel = userTel;
        this.coverVideoUrl = coverVideoUrl;
        this.coverDesc = coverDesc;
        this.coverTitle = coverTitle;
        this.coverUrl = coverUrl;
        this.coverPage = coverPage;
        this.coverWatchDate = coverWatchDate;
        this.compareTime = compareTime;
    }


    public String getCoverVideoUrl() {
        return coverVideoUrl;
    }

    public void setCoverVideoUrl(String coverVideoUrl) {
        this.coverVideoUrl = coverVideoUrl;
    }

    public String getCoverDesc() {
        return coverDesc;
    }

    public void setCoverDesc(String coverDesc) {
        this.coverDesc = coverDesc;
    }

    public String getCoverTitle() {
        return coverTitle;
    }

    public void setCoverTitle(String coverTitle) {
        this.coverTitle = coverTitle;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCoverPage() {
        return coverPage;
    }

    public void setCoverPage(String coverPage) {
        this.coverPage = coverPage;
    }

    public String getCoverScore() {
        return coverScore;
    }

    public void setCoverScore(String coverScore) {
        this.coverScore = coverScore;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }


    public String getCoverWatchDate() {
        return this.coverWatchDate;
    }


    public void setCoverWatchDate(String coverWatchDate) {
        this.coverWatchDate = coverWatchDate;
    }


    public long getId() {
        return this.id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getUserTel() {
        return this.userTel;
    }


    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }


    public String getCompareTime() {
        return this.compareTime;
    }


    public void setCompareTime(String compareTime) {
        this.compareTime = compareTime;
    }
}
