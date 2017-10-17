package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import star.liuwen.com.le_shi.Model.CoverModel;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.Utils.GlideUtils;

/**
 * Created by liuwen on 2017/7/11.
 * 头部banner 适配器
 */
public class BannerAdapter extends PagerAdapter {

    private int mSize;
    private Context mActivity;
    private float mImageCorner = -1F;
    private List<CoverModel> mList;

    public BannerAdapter(Context activity, List<CoverModel> list) {
        mActivity = activity;
        mList = list;
    }

    public void updateList(List<CoverModel> list) {
        if (list.size() != 0) {
            mList = list;
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mActivity.getApplicationContext()).inflate(R.layout.recommend_page_item, container, false);
        if (mList.size() != 0) {
            CoverModel model = mList.get(position);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.image_desc);
            textView.setText(model.getCoverTitle());
            GlideUtils.loadImage(imageView, model.getCoverUrl(), R.mipmap.defalut_img, R.mipmap.defalut_img);
            Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            Bitmap newimage = getRoundCornerImage(image, 50);
            ImageView imageView2 = new ImageView(view.getContext());
            imageView2.setImageBitmap(newimage);
            container.addView(view);
            return view;
        }
        return view;
    }


    public Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundConcerImage);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }
}
