package thanhahvan.mydownloadzip.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    ArrayList <Fragment> list = new ArrayList<Fragment>();

    public PagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<Fragment> listFragment ) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.list = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}