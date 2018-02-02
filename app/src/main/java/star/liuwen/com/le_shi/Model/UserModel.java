package star.liuwen.com.le_shi.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

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
    private String userName;//用户昵称
    private String userTel;//用户电话号码
    private String userPassword;//用户密码
    private String userPhoto;//用户头像



    @Generated(hash = 974438033)
    public UserModel(Long userId, String userName, String userTel,
            String userPassword, String userPhoto) {
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.userPassword = userPassword;
        this.userPhoto = userPhoto;
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

    public String getUserPhoto() {
        return this.userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
