package id.ac.umn.keburusarjanainc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ListFragment listFragment;

    public ViewPagerAdapter(FragmentManager fm, String param){
        super(fm);
        listFragment = new ListFragment(param);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
