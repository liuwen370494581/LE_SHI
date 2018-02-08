package star.liuwen.com.le_shi.Activity;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import star.liuwen.com.le_shi.Base.App;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Dao.DaoCoverQuery;
import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.DateTimeUtils;
import star.liuwen.com.le_shi.Utils.UIUtils;

/**
 * Created by liuwen on 2017/11/7.
 */
public class WebActivity extends BaseActivity {
    private ProgressBar mPbLoading;
    private WebView mWvContent;
    private SpringView mSpringView;
    private String url;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        showLeftView();
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        mWvContent = (WebView) findViewById(R.id.wv_content);
        mSpringView = (SpringView) findViewById(R.id.web_view_spring_view);

    }

    @Override
    protected void initData() {
        CoverModel model = (CoverModel) getIntent().getSerializableExtra(Config.INTENT_COMM_MODEL);
        url = getIntent().getStringExtra(Config.INTENT_BBS_URL);
        if (model != null) {
            setCenterText(model.getCoverTitle());
            //保存历史播放记录
            saveWatchHistory(model);
        } else {
            setCenterText(UIUtils.getString(R.string.bbs));
        }
        mWvContent.loadUrl(url);
    }

    private void saveWatchHistory(CoverModel model) {
        CoverModel insertModel = new CoverModel(DaoCoverQuery.getCount(),
                App.getUserInfoTel(),
                model.getCoverVideoUrl()
                , model.getCoverDesc() != null ? model.getCoverDesc() : ""
                , model.getCoverTitle(), model.getCoverUrl(), model.getCoverPage() != null ?
                model.getCoverPage() : "", DateTimeUtils.getTodayDate(), DateTimeUtils.getCurrentTime_Y_M_D_H_M_S());
        DaoCoverQuery.insert(insertModel);

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

        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mWvContent.loadUrl(url);
                mSpringView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                mSpringView.onFinishFreshAndLoad();
                UIUtils.showToast(UIUtils.getString(R.string.no_more_data));
            }
        });
        mSpringView.setHeader(new DefaultHeader(this));
        mSpringView.setFooter(new DefaultFooter(this));
    }

}
