package star.liuwen.com.le_shi.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by liuwen on 2017/9/27.
 */
public class MainAdapter extends PagerAdapter {

    List<Fragment> fragmentList;
    private FragmentManager mFragmentManager;


    public MainAdapter(List<Fragment> fragmentList, FragmentManager fragmentManager) {
        this.fragmentList = fragmentList;
        mFragmentManager = fragmentManager;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragmentList.get(position);
        if (!fragment.isAdded()) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.add(fragment, fragment.getClass().getSimpleName());
            ft.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
        }

        if (fragment.getView().getParent() == null) {
            container.addView(fragment.getView());
        }
        return fragment.getView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragmentList.get(position).getView());
    }
}
