package star.liuwen.com.le_shi.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/02/05 16:26
 * desc   :
 */
public class LoadingDialog extends Dialog {
    private TextView tv_text;

    public LoadingDialog(Context context) {
        super(context);
        /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.login_loading);
        tv_text = (TextView) findViewById(R.id.tv_text);
        setCanceledOnTouchOutside(false);
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    public void setMessage(String message) {
        if (tv_text != null) {
            tv_text.setText(message);
        }
    }
}
