package star.liuwen.com.le_shi.Model;

import java.io.Serializable;

/**
 * Created by liuwen on 2017/10/13.
 */
public class CoverModel implements Serializable {

    private String coverVideoUrl;//播放视频url
    private String coverDesc;
    private String coverTitle;
    private String coverUrl;//封面
    private String coverPage;//集数
    private String coverScore;//评分
    private String coverType;//类型

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
}
