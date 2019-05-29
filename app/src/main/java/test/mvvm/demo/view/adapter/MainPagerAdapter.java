package test.mvvm.demo.view.adapter;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import test.mvvm.demo.view.HomeFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private List<HomeFragment> list;

    public MainPagerAdapter(FragmentManager fm, List<HomeFragment> list) {
        super(fm);
        this.list = list;
    }

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }
}
