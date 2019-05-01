package id.ac.umn.keburusarjanainc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                ListFragment listFragment = new ListFragment();
//                Log.d("ViewPagerAdapter", "Isi : " + listFragment);
//                return listFragment;
//            case 1:
//                ListFragment2 listFragment2 = new ListFragment2();
//                Log.d("ViewPagerAdapter", "Isi : " + listFragment2);
//                return listFragment2;
//        }
//        return null;

        TestFragment testFragment = new TestFragment();
        position = position+1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment :"+position);
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Override
    public int getCount() {
        //total pages
        return 3;
    }
}
