package star.liuwen.com.le_shi.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by liuwen on 2017/9/20.
 */
public class MyViewPager extends ViewPager {


    private boolean isSlipping = true;// 可滑动标志位

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!isSlipping) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!isSlipping) {
            return false;
        }
        return super.onTouchEvent(ev);
    }


    /**
     * 设置它是否滑动
     *
     * @param isSlipping
     */
    public void setSlipping(boolean isSlipping) {
        this.isSlipping = isSlipping;
    }
}
