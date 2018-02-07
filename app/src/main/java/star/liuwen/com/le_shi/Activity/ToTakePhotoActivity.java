package star.liuwen.com.le_shi.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import star.liuwen.com.le_shi.Utils.TakePhotoHelper;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/06 09:49
 * desc   :
 */
public class ToTakePhotoActivity extends TakePhotoActivity {
    private int mType;

    public enum EChoosePhotoFrom {
        Album,
        TakePhoto
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getIntent().getExtras().getInt("EChoosePhotoFrom", -1);
        TakePhotoHelper helper = new TakePhotoHelper(getTakePhoto()).isCompress(true, TakePhotoHelper.ECompressTool.Luban).setImgWidthHeight(400, 400)
                .setIsShowCompressProgressBar(true).setAlbumType(TakePhotoHelper.EAlbumFrom.SystemAlbum).setCropToolType(TakePhotoHelper.ECropTool.System);
        if (mType == 0) {
            //相册
            helper.openAlbumToChooseOneAndCrop();
        } else if (mType == 1) {
            //拍照
            helper.openTakePhotoAndCrop();
        } else {
            finish();
        }
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
        finish();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
        finish();
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        TImage image = result.getImage();
        if (image != null) {
            Intent intent = new Intent();
            intent.putExtra("ImgLocalPath", image.getCompressPath());
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
