package id.ac.umn.keburusarjanainc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ListFragment listFragment;

    public ViewPagerAdapter(FragmentManager fm /*, String param*/){
        super(fm);
//        listFragment = new ListFragment(param);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ListFragment listFragment = new ListFragment();
                return listFragment;
            case 1:
                ListFragment2 listFragment2 = new ListFragment2();
                return listFragment2;
        }
        return null;
    }

    @Override
    public int getCount() {
        //total pages
        return 2;
    }
}
