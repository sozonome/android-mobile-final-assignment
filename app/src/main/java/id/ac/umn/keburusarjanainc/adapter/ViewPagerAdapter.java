package id.ac.umn.keburusarjanainc.adapter;

import android.content.Context;
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
//        Log.d("ViewPagerAdapter", "Mulai Masuk : " + position + ", " + listFragment);
        Bundle bundle = new Bundle();

        switch (position){
            case 0:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", ""); //Recent / Home
                listFragment.setArguments(bundle);
                return listFragment;
            case 1:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=2125"); //Berita Kampus
                listFragment.setArguments(bundle);
                return listFragment;
            case 2:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=11"); //Opini
                listFragment.setArguments(bundle);
                return listFragment;
            case 3:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=6"); //Event
                listFragment.setArguments(bundle);
                return listFragment;
            case 4:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=9173"); //Hiburan
                listFragment.setArguments(bundle);
                return listFragment;
            case 5:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=9"); //Review
                listFragment.setArguments(bundle);
                return listFragment;
            case 6:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=45"); //Olahraga
                listFragment.setArguments(bundle);
                return listFragment;
            case 7:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=7"); //Otomotif
                listFragment.setArguments(bundle);
                return listFragment;
            case 8:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=5"); //Lifestyle
                listFragment.setArguments(bundle);
                return listFragment;
            case 9:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=3"); //Iptek
                listFragment.setArguments(bundle);
                return listFragment;
            case 10:
                Log.d("ViewPagerAdapter", "Masuk case " + position);
                bundle.putString("param", "?categories=12"); //Jalan-Jalan
                listFragment.setArguments(bundle);
                return listFragment;
        }

        Log.d("ViewPager", "End Null");
        return null;
    }

    @Override
    public int getCount() {
        //total pages
        return 11;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title;
        switch(position){
            case 0:
                title = "Recent";
                return title;
            case 1:
                title = "Berita Kampus";
                return title;
            case 2:
                title = "Opini";
                return title;
            case 3:
                title = "Event";
                return title;
            case 4:
                title = "Hiburan";
                return title;
            case 5:
                title = "Review";
                return title;
            case 6:
                title = "Olahraga";
                return title;
            case 7:
                title = "Otomotif";
                return title;
            case 8:
                title = "Lifestyle";
                return title;
            case 9:
                title = "Iptek";
                return title;
            case 10:
                title = "Jalan-Jalan";
                return title;
        }
        return null;
    }
}
