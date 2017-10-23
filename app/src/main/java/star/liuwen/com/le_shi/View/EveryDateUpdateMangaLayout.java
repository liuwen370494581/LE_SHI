package star.liuwen.com.le_shi.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by liuwen on 2017/10/23.
 */
public class EveryDateUpdateMangaLayout extends FrameLayout {
    private Context mContext;


    public EveryDateUpdateMangaLayout(Context context) {
        super(context);
        init(context);
    }


    public EveryDateUpdateMangaLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        mContext = context;
    }
}
