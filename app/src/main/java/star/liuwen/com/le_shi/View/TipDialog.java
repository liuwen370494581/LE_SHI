package star.liuwen.com.le_shi.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/07/26 11:21
 * desc   : 防IOS的提示框
 */
public class TipDialog extends Dialog implements View.OnClickListener {

    private String mContent = "";
    private TextView mTvLeft;
    private TextView mTvRight;
    private TextView mSLine, mTvCheckTip;
    private RelativeLayout mReLayout;
    private CheckBox mCheckBox;
    private TextView mTxtContent;
    private ITipDialogListener mListener;


    public TipDialog(@NonNull Context context, String content) {
        super(context, R.style.CustomDialogStyle);
        this.mContent = content;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tip_dialog);
        mTxtContent = ((TextView) findViewById(R.id.dialog_tv));
        mTxtContent.setText(mContent);
        mSLine = (TextView) findViewById(R.id.line_s);
        mTvCheckTip = (TextView) findViewById(R.id.id_check_tip_tv);
        mReLayout = (RelativeLayout) findViewById(R.id.layout);
        mCheckBox = (CheckBox) findViewById(R.id.cb);
        this.setCancelable(true);
        mTvLeft = (TextView) findViewById(R.id.dialog_left);
        mTvRight = (TextView) findViewById(R.id.dialog_right);
        mTvLeft.setOnClickListener(this);
        mTvRight.setOnClickListener(this);
    }

    public void setCanCancelAble(boolean flag) {
        setCancelable(flag);
        setCanceledOnTouchOutside(flag);
    }

    public interface ITipDialogListener {
        void clickLeft();

        void clickRight();
    }

    public void setDeleteOtherDevicesVisible() {
        mReLayout.setVisibility(View.VISIBLE);
    }

    public boolean isChecked() {
        return mCheckBox.isChecked();
    }

    public void setListener(ITipDialogListener listener) {
        mListener = listener;
    }

    public void setCheckTip(String text) {
        mTvCheckTip.setText(text);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_left:
                dismiss();
                if (null != mListener)
                    mListener.clickLeft();
                break;
            case R.id.dialog_right:
                dismiss();
                if (null != mListener)
                    mListener.clickRight();
                break;
            default:
                break;
        }
    }

    public void setLeftText(String text) {
        mTvLeft.setText(text);
    }

    public void setCenterPosition() {
        mTxtContent.setGravity(Gravity.CENTER);
    }

    public void setRightText(String text) {
        mTvRight.setText(text);
    }

    public void setRightButtonVisible(boolean isShow) {
        mTvLeft.setBackgroundResource(R.drawable.btn_radius_bottom_selector);
        mTvRight.setVisibility(isShow ? View.VISIBLE : View.GONE);
        mSLine.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}
