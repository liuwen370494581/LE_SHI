package star.liuwen.com.le_shi.View;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import star.liuwen.com.le_shi.R;


/**
 * Created by liuwen on 2017/6/26.
 */
public class LoadingProgressDialog extends Dialog {
    private TextView mTxtT;
    private LinearLayout mLinearLayout;
    private ILoadingDialogListener mListener;
    private ImageView mImageView;

    public LoadingProgressDialog(Context context, String toastContent) {
        super(context, R.style.CustomDialogStyle);
        setContentView(R.layout.layout_loading);
        mLinearLayout = (LinearLayout) findViewById(R.id.dialog_toast_bg);
        // mLinearLayout.getBackground().setAlpha(150);
        mImageView = (ImageView) findViewById(R.id.img_show);
        mImageView.setBackgroundResource(R.drawable.load_animal);
        AnimationDrawable animationDrawable= (AnimationDrawable) mImageView.getBackground();
        animationDrawable.start();
        mTxtT = (TextView) this.findViewById(R.id.txt);
        mTxtT.setText(toastContent);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (null != mListener)
                    mListener.onCancelEvent();
            }
        });
    }

    public void setListener(ILoadingDialogListener listener) {
        mListener = listener;
    }

    /**
     * 设置为不可取消
     */
    public void setCannotCancel() {
        setCancelable(false);
    }

    public void closeDialog() {
        if (isShowing())
            dismiss();
    }

    /**
     * @param @param toastContent 设定文件
     * @return void 返回类型
     * @throws
     * @Title: setTextMsg
     * @Description: TODO(设置提示问题)
     */
    public void setTextMsg(String toastContent) {
        mTxtT.setVisibility(View.VISIBLE);
        mTxtT.setText(toastContent);
    }

    public interface ILoadingDialogListener {
        void onCancelEvent();
    }
}
