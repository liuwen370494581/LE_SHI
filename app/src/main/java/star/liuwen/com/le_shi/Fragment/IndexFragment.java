package star.liuwen.com.le_shi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import star.liuwen.com.le_shi.Base.BaseFragment;
import star.liuwen.com.le_shi.ChildFragment.CaiJingFragment;
import star.liuwen.com.le_shi.ChildFragment.ChoiceFragment;
import star.liuwen.com.le_shi.ChildFragment.HotFragment;
import star.liuwen.com.le_shi.ChildFragment.MangaFragment;
import star.liuwen.com.le_shi.ChildFragment.MovieFragment;
import star.liuwen.com.le_shi.ChildFragment.MusicFragment;
import star.liuwen.com.le_shi.ChildFragment.ScienceFragment;
import star.liuwen.com.le_shi.ChildFragment.SportsFragment;
import star.liuwen.com.le_shi.ChildFragment.TvFragment;
import star.liuwen.com.le_shi.ChildFragment.VarietyFragment;
import star.liuwen.com.le_shi.ChildFragment.ZiZhiFragment;
import star.liuwen.com.le_shi.R;

/**
 * Created by liuwen on 2017/10/12.
 */
public class IndexFragment extends BaseFragment {


    private String[] mTabTitles = new String[]{};
    private BaseFragment[] fragments = {new HotFragment(), new ChoiceFragment(),
            new TvFragment(), new MovieFragment(), new VarietyFragment(), new ZiZhiFragment(), new MangaFragment(), new SportsFragment(), new MusicFragment(), new CaiJingFragment(), new ScienceFragment()};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mTabTitles = getResources().getStringArray(R.array.tab_titles);
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(fragments.length);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 方案二：页面选中时才去加载数据
                // BaseFragment fragment = fragments[position];
                // fragment.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class FragmentAdapter extends FragmentPagerAdapter {
        // FragmentPagerAdapter与FragmentStatePagerAdapter区别
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return mTabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (mTabTitles != null) {
                return mTabTitles[position];
            }
            return super.getPageTitle(position);
        }

    }

    @Override
    public void initData() {

    }
}
