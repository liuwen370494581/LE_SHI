package star.liuwen.com.le_shi.Model;

import java.io.Serializable;

/**
 * Created by liuwen on 2017/11/6.
 */
public class IndexModel implements Serializable {


    private String name;
    private String url;


    public IndexModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
