package star.liuwen.com.le_shi.Utils;

/**
 * Created by liuwen on 2017/6/22.
 */

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.io.File;

/**
 * 用Glide框架加载图片的时候根据图片尺寸让ImageView自适应
 * Created by gc on 2016/11/6.
 */
public class GlideUtils {
    public static void loadImage(ImageView view, String url, int loadingImgRes, int errorImgRes) {
        Glide.with(view.getContext())
                //得到需要设置的图片,可以写文件路径等等
                //load(Uri uri)，load(File file)，load(Integer resourceId)，load(URL url)，load(byte[] model)，load(T model)，loadFromMediaStore(Uri uri)
                .load(url)
//                .asBitmap()
//                .centerCrop()//会裁剪图片将imageView填满
                //设置占位图
                .placeholder(loadingImgRes)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //设置发生错误的图片
                .error(errorImgRes)
                //fitCenter()         会绽放图像, 将图像全显示出来 ,一般不用
                .crossFade()//渐变动画
//                .dontAnimate()//没有动画
                .into(view);
    }

    public static void loadImage(ImageView view, File file, int loadingImgRes, int errorImgRes, BitmapTransformation transformation) {
        Glide.with(view.getContext())
                .load(file)
                .placeholder(loadingImgRes)
                .bitmapTransform(transformation)
                .error(errorImgRes)
                .crossFade()
                .into(view);
    }

    public static void loadImage(ImageView view, String url, int loadingImgRes, int errorImgRes, BitmapTransformation transformation) {
        Glide.with(view.getContext())
                //得到需要设置的图片,可以写文件路径等等
                //load(Uri uri)，load(File file)，load(Integer resourceId)，load(URL url)，load(byte[] model)，load(T model)，loadFromMediaStore(Uri uri)
                .load(url)
                .bitmapTransform(transformation)
//                .asBitmap()
//                .centerCrop()//会裁剪图片将imageView填满
                //设置占位图
                .placeholder(loadingImgRes)
                //设置发生错误的图片
                .error(errorImgRes)
                //fitCenter()         会绽放图像, 将图像全显示出来 ,一般不用
                .crossFade()//渐变动画
//                .dontAnimate()//没有动画
                .into(view);
    }

    public static void loadLocalImage(ImageView view, int localImgRes) {
        //with()需要设置多久生命周期
        Glide.with(view.getContext())
                .load(localImgRes)
                .crossFade()//渐变动画
                .into(view);
    }


}
