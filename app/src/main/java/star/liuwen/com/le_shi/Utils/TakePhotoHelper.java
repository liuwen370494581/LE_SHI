package star.liuwen.com.le_shi.Utils;

import android.net.Uri;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.LubanOptions;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;

import star.liuwen.com.le_shi.Base.Config;

/**
 * Created by zhangweijun on 2017/5/8.
 */

public class TakePhotoHelper {
    private TakePhoto mTakePhoto;
    private Uri mImgUri;
    //---------------------------压缩配置---------------------------------
    private boolean mIsCompress = true;//是否压缩
    private int mImgMaxSize = 102400;//图片最大的大小，单位Byte
    private int mImgWidth = 800, mImgHeight = 800;//图片宽高，单位px
    private boolean mIsShowCompressProgressBar = true;
    //---------------------------压缩工具的选择---------------------------------
    private ECompressTool mCompressToolType = ECompressTool.LibCustom;

    public enum ECompressTool {
        LibCustom, //库自带压缩算法
        Luban //鲁班图片压缩算法
    }

    //---------------------------从相册选择图片的配置-------------------------------
    private EAlbumFrom mAlbumFrom = EAlbumFrom.SystemAlbum;

    public enum EAlbumFrom {
        LibCustom,//库提供的相册，可自定义
        SystemAlbum//系统自带相册
    }

    //---------------------------裁剪配置---------------------------------
    private boolean mIsCrop = true;
    private int mImgCropWidth = 480, mImgCropHeight = 800;
    private boolean mAccordingToSize = true;//true按照设定尺寸,false按照width设定的大小，1:1比例
    private ECropTool mCropToolType = ECropTool.System;

    public enum ECropTool {
        LibCustom,//库提供的裁剪界面，可自定义
        System//系统自带裁剪
    }

    //---------------------------其他---------------------------------
    private boolean mIsKeepSourceImg = false;//拍照后是否保存原图
    private boolean mIsCorrectAngle = false;//是否修正照片角度

    public TakePhotoHelper(TakePhoto takePhoto) {
        mTakePhoto = takePhoto;
        init(takePhoto);
    }

    private TakePhotoHelper init(TakePhoto takePhoto) {
        File file = new File(Config.CACHE_IMG_PATH + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();//Application中已经有创建，这里防止被认为手动删除
        mImgUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        return this;
    }

    public TakePhotoHelper isCompress(boolean isCompress, ECompressTool type) {
        mIsCompress = isCompress;
        if (type != null)
            mCompressToolType = type;
        return this;
    }

    public TakePhotoHelper setImgMaxSize(int maxSize) {
        mImgMaxSize = maxSize;
        return this;
    }

    public TakePhotoHelper setImgWidthHeight(int width, int height) {
        mImgCropHeight = width;
        mImgCropHeight = height;
        return this;
    }

    public TakePhotoHelper setIsShowCompressProgressBar(boolean isShow) {
        mIsShowCompressProgressBar = isShow;
        return this;
    }

    public TakePhotoHelper setAlbumType(EAlbumFrom albumType) {
        mAlbumFrom = albumType;
        return this;
    }

    public TakePhotoHelper setCropToolType(ECropTool toolType){
        mCropToolType = toolType;
        return this;
    }
    public TakePhotoHelper setIsCorrectAngle(boolean isCorrect) {
        mIsCorrectAngle = isCorrect;
        return this;
    }

    public TakePhotoHelper setIsAccordingToSize(boolean isAccordingToSize) {
        mAccordingToSize = isAccordingToSize;
        return this;
    }

    /**
     * 打开相机
     */
    public void openTakePhoto() {
        mTakePhoto.onPickFromCapture(mImgUri);
    }

    /**
     * 打开相机，裁剪
     */
    public void openTakePhotoAndCrop() {
        mTakePhoto.onPickFromCaptureWithCrop(mImgUri, getCropOptions());
    }

    /**
     * 打开相册选择一张
     */
    public void openAlbumToChooseOne() {
        mTakePhoto.onPickFromGallery();
    }

    /**
     * 打开相册选择一张,裁剪
     */
    public void openAlbumToChooseOneAndCrop() {
        mTakePhoto.onPickFromGalleryWithCrop(mImgUri, getCropOptions());
    }

    /**
     * 打开文件夹选择一张
     */
    public void openDocumentChooseOne() {
        mTakePhoto.onPickFromDocuments();
    }

    /**
     * 打开文件夹选择一张,裁剪
     */
    public void openDocumentToChooseOneAndCrop() {
        mTakePhoto.onPickFromDocumentsWithCrop(mImgUri,getCropOptions());
    }

    /**
     * 打开相册选择多张
     *
     * @param size 选择数量
     */
    public void openAlbumToChooseMulti(int size) {
        mTakePhoto.onPickMultiple(size);
    }

    /**
     * 打开相册选择多张，裁剪
     *
     * @param size
     */
    public void openAlbumToChooseMultiAndCrop(int size) {
        mTakePhoto.onPickMultipleWithCrop(size, getCropOptions());
    }


    /**
     * 压缩配置
     *
     * @param takePhoto
     */
    private void configCompress(TakePhoto takePhoto) {
        if (!mIsCompress) {
            takePhoto.onEnableCompress(null, false);
            return;
        }
        int maxSize = Integer.parseInt(mImgMaxSize + "");
        int width = Integer.parseInt(mImgWidth + "");
        int height = Integer.parseInt(mImgHeight + "");
        CompressConfig config = null;
        if (mCompressToolType == ECompressTool.LibCustom || mCompressToolType == null) {
            config = new CompressConfig.Builder()
                    .setMaxSize(maxSize)
                    .setMaxPixel(width >= height ? width : height)
                    .enableReserveRaw(mIsKeepSourceImg)
                    .create();
        } else if (mCompressToolType == ECompressTool.Luban) {
            LubanOptions option = new LubanOptions.Builder()
                    .setMaxHeight(height)
                    .setMaxWidth(width)
                    .setMaxSize(maxSize)
                    .create();
            config = CompressConfig.ofLuban(option);
            config.enableReserveRaw(mIsKeepSourceImg);
        }
        takePhoto.onEnableCompress(config, mIsShowCompressProgressBar);
    }

    /**
     * 配置从相册选择图片的方式、配置是否纠正图片角度
     *
     * @param takePhoto
     */
    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        if (mAlbumFrom == EAlbumFrom.LibCustom) {
            builder.setWithOwnGallery(true);
        }
        if (mIsCorrectAngle) {
            builder.setCorrectImage(true);
        }
        takePhoto.setTakePhotoOptions(builder.create());
    }

    /**
     * 获取裁剪配置对象
     *
     * @return
     */
    private CropOptions getCropOptions() {
        if (!mIsCrop)
            return null;
        int height = Integer.parseInt(mImgCropHeight + "");
        int width = Integer.parseInt(mImgCropWidth + "");
        CropOptions.Builder builder = new CropOptions.Builder();
        if (mAccordingToSize) {
            builder.setAspectX(width).setAspectY(height);
        } else {
            builder.setOutputX(width).setOutputY(height);
        }
        builder.setWithOwnCrop(mCropToolType == ECropTool.LibCustom);
        return builder.create();
    }
}
