package id.ac.umn.keburusarjanainc;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity_Build extends AppCompatActivity {
    private static ViewPager viewPager;
    private static TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_build);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Indepth"));
//        tabLayout.addTab(tabLayout.newTab().setText("Info Kampus"));
//        tabLayout.addTab(tabLayout.newTab().setText("Opini"));
//        tabLayout.addTab(tabLayout.newTab().setText("Event"));
//        tabLayout.addTab(tabLayout.newTab().setText("Film"));
//        tabLayout.addTab(tabLayout.newTab().setText("Literatur"));
//        tabLayout.addTab(tabLayout.newTab().setText("Mode"));
//        tabLayout.addTab(tabLayout.newTab().setText("Musik"));
//        tabLayout.addTab(tabLayout.newTab().setText("Review"));
//        tabLayout.addTab(tabLayout.newTab().setText("Olahraga"));
//        tabLayout.addTab(tabLayout.newTab().setText("Otomotif"));
//        tabLayout.addTab(tabLayout.newTab().setText("Lifestyle"));
//        tabLayout.addTab(tabLayout.newTab().setText("Iptek"));
//        tabLayout.addTab(tabLayout.newTab().setText("Jalan-Jalan"));

        viewPager = findViewById(R.id.viewPager);
//        tabLayout.setupWithViewPager(viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
//        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), "");
//        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }
}
