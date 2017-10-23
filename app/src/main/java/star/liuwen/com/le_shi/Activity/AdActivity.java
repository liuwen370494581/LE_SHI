package star.liuwen.com.le_shi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.MainActivity;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/9/21.
 * 启动页面
 */
public class AdActivity extends BaseActivity {

    private TextView tvName;
    private Timer mTimer;
    private int count = 5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //  GlideUtils.loadImage((ImageView) findViewById(R.id.id_ad_img), Config.AdUrl, R.mipmap.icon_net_work, R.mipmap.icon_net_work);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_add;
    }

    @Override
    protected void initView() {
        tvName = getView(R.id.id_count_tv);
    }

    @Override
    protected void initData() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        tvName.setText(count + "s");
                        break;

                    case 1:
                        startActivity(new Intent(AdActivity.this, MainActivity.class));
                        finish();
                        break;
                }
            }
        };

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                count--;
                if (count < 1) {
                    mTimer.cancel();
                    handler.sendEmptyMessage(1);
                }
            }
        }, 0, 1000);
    }

    @Override
    protected void setListener() {

    }

    public void clickPass(View view) {
        startActivity(new Intent(AdActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mTimer) {
            mTimer.cancel();
        }
    }
}
