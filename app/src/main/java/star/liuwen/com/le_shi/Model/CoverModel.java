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

    public CoverModel() {
    }

    public CoverModel(String coverVideoUrl, String coverDesc, String coverTitle, String coverUrl) {
        this.coverVideoUrl = coverVideoUrl;
        this.coverDesc = coverDesc;
        this.coverTitle = coverTitle;
        this.coverUrl = coverUrl;
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
}
