package star.liuwen.com.le_shi.Activity;

import android.view.View;

import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.R;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/31 13:56
 * desc   :  分享页面
 */
public class ShareActivity extends BaseActivity implements View.OnClickListener {

//    private TextView mTxtQQFriend, mTxtSina, mTxtWXFriend, mTxtWXLock;
//    private OnekeyShare mOks;
//    private String mFilePath;
//    private String mDownLoadUrl;
//    private String mShareAppName;
//    private String mShareContent;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_share;
    }

    @Override
    protected void initView() {
        showLeftView();
        setCenterText("分享");
//        mTxtQQFriend = (TextView) findViewById(R.id.share_to_qq_friend);
//        mTxtSina = (TextView) findViewById(R.id.share_to_sina);
//        mTxtWXFriend = (TextView) findViewById(R.id.share_to_weixin_friend);
//        mTxtWXLock = (TextView) findViewById(R.id.share_to_friendlock);


    }

    @Override
    protected void initData() {
//        mDownLoadUrl = "http://sap.dyajb.com/jiaju_share.html";
//        mShareAppName = getString(R.string.app_name);
//        mShareContent = "乐视 一款你看电影不需看广告的产品";
//        mFilePath = Config.SHARE_LOGO;
//        mTxtQQFriend.setOnClickListener(this);
//        mTxtSina.setOnClickListener(this);
//        mTxtWXFriend.setOnClickListener(this);
//        mTxtWXLock.setOnClickListener(this);

        copyShareImgToSD();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share_to_qq_friend:
                shareMethod(0);
                break;
            case R.id.share_to_sina:
                shareMethod(1);
                break;
            case R.id.share_to_weixin_friend:
                shareMethod(2);
                break;
            case R.id.share_to_friendlock:
                shareMethod(3);
                break;
            default:
                break;
        }
    }

    private void shareMethod(int type) {
//        try {
//            if ((type == 2 || type == 3) && !ApkInfoUtil.isAppInstalled(this, "com.tencent.mm")) {
//                UIUtils.showToast("请安装微信客户端");
//                return;
//            }
//            mOks = new OnekeyShare();
//            mOks.setAddress("");
//            mOks.setTitleUrl(mDownLoadUrl);
//            mOks.setUrl(mDownLoadUrl);
//            mOks.setSilent(true);// 设置成直接分享
//            switch (type) {
//                case 0:
//                    mOks.setTitle(mShareAppName);
//                    mOks.setImagePath(mFilePath + "logo_asset.png");
//                    mOks.setText(mShareContent);
//                    mOks.setPlatform("QQ");
//                    mOks.show(this);
//                    break;
//                case 1:
//                    mOks.disableSSOWhenAuthorize();
//                    mOks.setTitle(mShareAppName);
//                    mOks.setImagePath(mFilePath + "logo_asset.png");
//                    mOks.setText(mShareContent + "下载地址:" + mDownLoadUrl);
//                    mOks.setPlatform("SinaWeibo");
//                    mOks.show(this);
//                    break;
//                case 2:
//                    mOks.setTitle(mShareAppName);
//                    mOks.setImagePath(mFilePath + "logo_asset.png");
//                    mOks.setText(mShareContent);
//                    mOks.setPlatform("Wechat");
//                    mOks.show(this);
//
//                    break;
//                case 3:
//                    mOks.setTitle(mShareContent);
//                    mOks.setImagePath(mFilePath + "logo_asset.png");
//                    mOks.setText(mShareContent);
//                    mOks.setPlatform("WechatMoments");
//                    mOks.show(this);
//                    break;
//                default:
//                    break;
//            }
//        } catch (Exception e) {
//            UIUtils.showToast("分享失败");
//        }
    }

    private void copyShareImgToSD() {
//        String fileName = "logo_asset.png";
//
//        try {
//            File file = new File(mFilePath);
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//            file = new File(mFilePath + fileName);
//            if (!file.exists()) {
//                // 本地不存在才copy至sdcard，由于copy文件较大 使用线程来进行
//                file.createNewFile();
//                new Thread(runnableCopyFile).start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

//    Runnable runnableCopyFile = new Runnable() {
//
//        @Override
//        public void run() {
//            try {
//                AssetManager am = getAssets();
//                String fileName = "logo_asset.png";
//                InputStream is = is = am.open(fileName);
//                Bitmap bitmap = BitmapFactory.decodeStream(is);
//                File file = new File(mFilePath + fileName);
//                FileOutputStream fos = new FileOutputStream(file);
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
//                fos.flush();
//                fos.close();
//            } catch (Exception e) {
//
//            }
//        }
//    };

}
