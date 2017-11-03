package star.liuwen.com.le_shi.View;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/27.
 */
public class LoadingFlashView extends FrameLayout {
    private ImageView imgShow;
    private TextView tvName;

    public LoadingFlashView(Context context) {
        super(context);
        init(context);
    }

    public LoadingFlashView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_loading, null);
        imgShow = (ImageView) view.findViewById(R.id.img_show);
        tvName = (TextView) view.findViewById(R.id.txt);
        imgShow.setBackgroundResource(R.drawable.load_animal);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgShow.getBackground();
        animationDrawable.start();
        addView(view);
    }

    public void setShowMsg(String msg) {
        if (tvName != null) {
            return;
        }
        tvName.setText(msg.isEmpty() ? "" : msg);
        tvName.setVisibility(msg.isEmpty() ? GONE : VISIBLE);
    }
}
