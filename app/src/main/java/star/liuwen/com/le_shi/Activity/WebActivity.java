package star.liuwen.com.le_shi.Activity;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/11/7.
 */
public class WebActivity extends BaseActivity {
    ProgressBar mPbLoading;
    WebView mWvContent;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("暴风bbs");
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        mWvContent = (WebView) findViewById(R.id.wv_content);

    }

    @Override
    protected void initData() {
        String url = getIntent().getStringExtra(Config.INTENT_BBS_URL);
        mWvContent.loadUrl(url);

    }

    @Override
    protected void setListener() {
        WebSettings settings = mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);

        mWvContent.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mPbLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mPbLoading.setVisibility(View.GONE);
            }
        });

        mWvContent.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mPbLoading.setProgress(newProgress);
            }
        });

        mWvContent.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWvContent.canGoBack()) {  //表示按返回键
                        mWvContent.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
    }
}
