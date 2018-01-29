package star.liuwen.com.le_shi.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import star.liuwen.com.le_shi.Adapter.AreaAdapter;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Base.Config;
import star.liuwen.com.le_shi.Dao.AssetsDatabaseManager;
import star.liuwen.com.le_shi.Model.AreaInfo;
import star.liuwen.com.le_shi.R;
import star.liuwen.com.le_shi.View.pinnedlistview.BladeView;
import star.liuwen.com.le_shi.View.pinnedlistview.PinnedHeaderListView;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/01/26 17:02
 * desc   :
 */
public class AreaSelectionActivity extends BaseActivity {

    private PinnedHeaderListView mListView;
    private AreaAdapter mAdapter;
    private BladeView mBladeView;
    private List<AreaInfo> mAreaList = new ArrayList<AreaInfo>();
    private boolean mIsEn = false;

    @Override
    protected int setLayoutRes() {
        return R.layout.activity_area_select;
    }

    @Override
    protected void initView() {
        setCenterText("选择国家/地区");
        showLeftView();
        mListView = getView(R.id.pd_listview);
        mBladeView = getView(R.id.letter_view);
    }

    @Override
    protected void initData() {
        AssetsDatabaseManager.initManager(getApplication());
        AssetsDatabaseManager mg = AssetsDatabaseManager.getManager();
        SQLiteDatabase db = mg.getDatabase("AreaCodeDB.db3");
        db.beginTransaction();
        try {
            Cursor c = db.rawQuery("select * from area_info", null);
            while (c.moveToNext()) {
                AreaInfo area = new AreaInfo();
                area.mId = c.getString(c.getColumnIndex("id"));
                area.mAreaCode = c.getString(c.getColumnIndex("code"));
                area.mNameCn = c.getString(c.getColumnIndex("name_cn"));
                area.mNameEn = c.getString(c.getColumnIndex("name_en"));
                area.mIndexCn = c.getString(c.getColumnIndex("index_cn"));
                area.mIndexEn = c.getString(c.getColumnIndex("index_en"));
                mAreaList.add(area);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        refreshListView();

    }

    private void refreshListView() {
        final String FORMAT = "^[a-z,A-Z].*$";
        List<String> leterList = new ArrayList<String>(); // 首字母集合
        Map<String, List<AreaInfo>> dataByLeterMap = new HashMap<String, List<AreaInfo>>();// 根据首字母存放的数据
        List<Integer> letterPositionList = new ArrayList<Integer>();// 首字母位置集
        final Map<String, Integer> indexerList = new HashMap<String, Integer>();// 首字母对应的位置

        for (int i = 0; i < mAreaList.size(); i++) {
            AreaInfo area = mAreaList.get(i);
            String firstName = (mIsEn ? area.mIndexEn : area.mIndexCn).toUpperCase();
            if (firstName.matches(FORMAT)) {
                if (leterList.contains(firstName)) {
                    dataByLeterMap.get(firstName).add(area);
                } else {
                    leterList.add(firstName);
                    List<AreaInfo> list = new ArrayList<AreaInfo>();
                    list.add(area);
                    dataByLeterMap.put(firstName, list);
                }
            } else {
                if (leterList.contains("#")) {
                    dataByLeterMap.get("#").add(area);
                } else {
                    leterList.add("#");
                    List<AreaInfo> list = new ArrayList<AreaInfo>();
                    list.add(area);
                    dataByLeterMap.put("#", list);
                }
            }
        }
        Collections.sort(mAreaList, new Comparator<AreaInfo>() {
            @Override
            public int compare(AreaInfo area1, AreaInfo area2) {
                // TODO Auto-generated method stub
                if (mIsEn)
                    return area1.mIndexEn.compareTo(area2.mIndexEn);
                else
                    return area1.mIndexCn.compareTo(area2.mIndexCn);
            }
        });
        Collections.sort(leterList);
        int position = 0;
        for (int i = 0; i < leterList.size(); i++) {
            indexerList.put(leterList.get(i), position);// 存入map中，key为首字母字符串，value为首字母在listview中位置
            letterPositionList.add(position);// 首字母在listview中位置，存入list中
            position += dataByLeterMap.get(leterList.get(i)).size();// 计算下一个首字母在listview的位置
        }

        // 初始化视图
        mBladeView.setOnItemTouchListener(new BladeView.OnItemTouchListener() {

            @Override
            public void onItemTouch(String s) {
                if (indexerList.get(s) != null) {
                    mListView.setSelection(indexerList.get(s));
                }
            }
        });

        if (mAdapter == null) {
            mAdapter = new AreaAdapter(this, mAreaList, leterList, letterPositionList, mIsEn);
            mListView.setAdapter(mAdapter);
            mListView.setOnScrollListener(mAdapter);
            mListView.setPinnedHeaderView(LayoutInflater.from(this).inflate(R.layout.area_listview_head, mListView, false));
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent();
                    intent.putExtra(Config.INTENT_AREA_CODE, mAreaList.get(position).mAreaCode);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void setListener() {

    }
}
