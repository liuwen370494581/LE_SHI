package star.liuwen.com.le_shi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import star.liuwen.com.le_shi.Model.AreaInfo;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.View.pinnedlistview.PinnedHeaderListView;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/26 17:35
 * desc   :
 */
public class AreaAdapter extends BaseAdapter implements SectionIndexer, PinnedHeaderListView.PinnedHeaderAdapter, AbsListView.OnScrollListener {
    private boolean mIsEn = false;
    private int mLocationPosition = -1;
    private List<AreaInfo> mAreaList;
    // 首字母集
    private List<String> mLeterList;
    private List<Integer> mFriendsPositions;
    private LayoutInflater inflater;

    public AreaAdapter(Context context, List<AreaInfo> areaList, List<String> leterList, List<Integer> friendsPositions, boolean isEn) {
        // TODO Auto-generated constructor stub
        inflater = LayoutInflater.from(context);
        mAreaList = areaList;
        mLeterList = leterList;
        mFriendsPositions = friendsPositions;
        mIsEn = isEn;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mAreaList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mAreaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        int section = getSectionForPosition(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.area_listview_item, null);
        }
        LinearLayout mHeaderParent = (LinearLayout) convertView.findViewById(R.id.friends_item_header_parent);
        TextView mHeaderText = (TextView) convertView.findViewById(R.id.item_header_tv);
        if (getPositionForSection(section) == position) {
            mHeaderParent.setVisibility(View.VISIBLE);
            mHeaderText.setText(mLeterList.get(section));
        } else {
            mHeaderParent.setVisibility(View.GONE);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.item_content_tv);
        textView.setText(mIsEn ? mAreaList.get(position).mNameEn : mAreaList.get(position).mNameCn);
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        if (view instanceof PinnedHeaderListView) {
            ((PinnedHeaderListView) view).configureHeaderView(firstVisibleItem);
        }
    }

    @Override
    public int getPinnedHeaderState(int position) {
        int realPosition = position;
        if (realPosition < 0 || (mLocationPosition != -1 && mLocationPosition == realPosition)) {
            return PINNED_HEADER_GONE;
        }
        mLocationPosition = -1;
        int section = getSectionForPosition(realPosition);
        int nextSectionPosition = getPositionForSection(section + 1);
        if (nextSectionPosition != -1 && realPosition == nextSectionPosition - 1) {
            return PINNED_HEADER_PUSHED_UP;
        }
        return PINNED_HEADER_VISIBLE;
    }

    @Override
    public void configurePinnedHeader(View header, int position, int alpha) {
        // TODO Auto-generated method stub
        int realPosition = position;
        int section = getSectionForPosition(realPosition);
        String title = (String) getSections()[section];
        ((TextView) header.findViewById(R.id.head_tv)).setText(title);
    }

    @Override
    public Object[] getSections() {
        // TODO Auto-generated method stub
        return mLeterList.toArray();
    }

    @Override
    public int getPositionForSection(int section) {
        if (section < 0 || section >= mLeterList.size()) {
            return -1;
        }
        return mFriendsPositions.get(section);
    }

    @Override
    public int getSectionForPosition(int position) {
        // TODO Auto-generated method stub
        if (position < 0 || position >= getCount()) {
            return -1;
        }
        int index = Arrays.binarySearch(mFriendsPositions.toArray(), position);
        return index >= 0 ? index : -index - 2;
    }
}
