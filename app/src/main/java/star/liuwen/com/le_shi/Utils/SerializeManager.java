package star.liuwen.com.le_shi.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2017/12/22 10:46
 * desc   :  序列化文件
 */
public class SerializeManager {


    public static void saveObj(Object object, String path) {
        FileOutputStream fos = null;
        try {
            File file = new File(path);
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static Object loadObj(String filePath) {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try {
            f = new File(filePath);
            if (f.exists()) {
                fis = new FileInputStream(f);
                oin = new ObjectInputStream(fis);
                Object obj = oin.readObject();
                return obj;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != oin) {
                    oin.close();
                }
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
