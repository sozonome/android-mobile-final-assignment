package id.ac.umn.keburusarjanainc.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import id.ac.umn.keburusarjanainc.fragment.ListFragment;

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

        ListFragment listFragment= new ListFragment();
        position = position+1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment :"+position);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    @Override
    public int getCount() {
        //total pages
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position +1;
        return "Fragment " + position;
    }
}
