package star.liuwen.com.le_shi;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import star.liuwen.com.le_shi.Adapter.MainAdapter;
import star.liuwen.com.le_shi.Base.BaseActivity;
import star.liuwen.com.le_shi.Fragment.IndexFragment;
import star.liuwen.com.le_shi.Fragment.LiveFragment;
import star.liuwen.com.le_shi.Fragment.MyFragment;
import star.liuwen.com.le_shi.Fragment.UpgcFragment;
import star.liuwen.com.le_shi.Fragment.VipFragment;
import star.liuwen.com.le_shi.View.MyViewPager;
import star.liuwen.com.le_shi.View.NoPreloadViewPager;

public class MainActivity extends BaseActivity {

    private TabLayout mTableLayout;
    private MyViewPager mMyViewPager;
    private IndexFragment mIndexFragment;
    private UpgcFragment mUpgcFragment;
    private VipFragment mVipFragment;
    private LiveFragment mLiveFragment;
    private MyFragment mMyFragment;
    private String[] mTabTextArr;
    private final int[] mImgNormalResArr = {R.mipmap.main_bottom_nav_home_normal, R.mipmap.main_bottom_nav_upgc, R.mipmap.main_bottom_nav_vip_normal, R.mipmap.main_bottom_nav_live_normal, R.mipmap.main_bottom_nav_mine_normal};
    private final int[] mImgSelectedResArr = {R.mipmap.main_bottom_nav_home_click, R.mipmap.main_bottom_nav_upgc_select, R.mipmap.main_bottom_nav_vip_click, R.mipmap.main_bottom_nav_live_click, R.mipmap.main_bottom_nav_mine_click};


    @Override
    protected int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTabTextArr = getResources().getStringArray(R.array.tabs);
        mTableLayout = (TabLayout) findViewById(R.id.id_tab_layout);
        mMyViewPager = (MyViewPager) findViewById(R.id.id_viewpager);
        mIndexFragment = new IndexFragment();
        mUpgcFragment = new UpgcFragment();
        mVipFragment = new VipFragment();
        mLiveFragment = new LiveFragment();
        mMyFragment = new MyFragment();
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(mIndexFragment);
        fragmentList.add(mUpgcFragment);
        fragmentList.add(mVipFragment);
        fragmentList.add(mLiveFragment);
        fragmentList.add(mMyFragment);
        final MainAdapter mAdapter = new MainAdapter(fragmentList, getSupportFragmentManager());
        mMyViewPager.setAdapter(mAdapter);
        mMyViewPager.setOffscreenPageLimit(0);
        mMyViewPager.setSlipping(false);
        mTableLayout.setTabMode(TabLayout.MODE_FIXED);
        mTableLayout.addTab(mTableLayout.newTab().setCustomView(getTabView(0)));
        mTableLayout.addTab(mTableLayout.newTab().setCustomView(getTabView(1)));
        mTableLayout.addTab(mTableLayout.newTab().setCustomView(getTabView(2)));
        mTableLayout.addTab(mTableLayout.newTab().setCustomView(getTabView(3)));
        mTableLayout.addTab(mTableLayout.newTab().setCustomView(getTabView(4)));
        mTableLayout.getTabAt(0).getCustomView().findViewById(R.id.id_oval_red_img).setVisibility(View.VISIBLE);
        mTableLayout.getTabAt(3).getCustomView().findViewById(R.id.id_oval_red_img).setVisibility(View.VISIBLE);
        mTableLayout.getTabAt(4).getCustomView().findViewById(R.id.id_oval_red_img).setVisibility(View.VISIBLE);
        mMyViewPager.setOnPageChangeListener(new NoPreloadViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSelectedTabStyle(mTableLayout, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setSelectedTabStyle(mTableLayout, mTableLayout.getSelectedTabPosition());
                mMyViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setSelectedTabStyle(mTableLayout, mTableLayout.getSelectedTabPosition());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }


    private View getTabView(int position) {
        View view = View.inflate(this, R.layout.main_tab_layout, null);
        TextView tv = (TextView) view.findViewById(R.id.id_tab_tv);
        ImageView img = (ImageView) view.findViewById(R.id.id_tab_img);
        tv.setText(mTabTextArr[position]);
        img.setImageResource(mImgNormalResArr[position]);
        return view;
    }

    private void setSelectedTabStyle(TabLayout tabLayout, int position) {
        try {
            TextView tv = null;
            ImageView img = null;
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = tabLayout.getTabAt(i);
                tv = (TextView) tab.getCustomView().findViewById(R.id.id_tab_tv);
                tv.setTextColor(ContextCompat.getColor(this, R.color.gray2));
                img = (ImageView) tab.getCustomView().findViewById(R.id.id_tab_img);
                img.setImageResource(mImgNormalResArr[i]);
            }
            TabLayout.Tab selectedTab = tabLayout.getTabAt(position);
            tv = (TextView) selectedTab.getCustomView().findViewById(R.id.id_tab_tv);
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            img = (ImageView) selectedTab.getCustomView().findViewById(R.id.id_tab_img);
            img.setImageResource(mImgSelectedResArr[position]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
