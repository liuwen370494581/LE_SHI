package star.liuwen.com.le_shi.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/29 15:05
 * desc   :
 */
@Entity
public class UserModel implements Serializable {
    @Id(autoincrement = true)
    private Long userId;
    private String userName;
    private String userTel;
    private String userPassword;



    @Generated(hash = 561583006)
    public UserModel(Long userId, String userName, String userTel,
            String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.userPassword = userPassword;
    }

    @Generated(hash = 782181818)
    public UserModel() {
    }

    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
