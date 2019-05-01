package id.ac.umn.keburusarjanainc.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import id.ac.umn.keburusarjanainc.fragment.ListFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        ListFragment listFragment = new ListFragment();
        Log.d("ViewPagerAdapter", "Mulai Masuk : " + position + " " + listFragment);
        Bundle bundle = new Bundle();

        switch (position){
            case 0:
                bundle.putString("param", "");
                listFragment.setArguments(bundle);
                return listFragment;
            case 1:
                bundle.putString("param", "?categories?name=berita-kampus");
                listFragment.setArguments(bundle);
                return listFragment;
            default:
        }

        Log.d("ViewPager", "End");
        return null;
    }

    @Override
    public int getCount() {
        //total pages
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                String title1 = "Recent";
                return title1;
            case 1:
                String title2 = "Berita Kampus";
                return title2;
        }
        return null;
    }
}
