package id.ac.umn.keburusarjanainc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import id.ac.umn.keburusarjanainc.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager; //isi page tiap tab
    private TabLayout tabLayout; //tab kategori

    //Adapter yang fungsinya untuk mengatur isi page sesuai tab atau page yang dipilih
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.qr_code_button:
                Intent intent  = new Intent(MainActivity.this, QRCodeScanner.class);
                startActivity(intent);
                break;

            case R.id.fetch_from_json_button:
                Intent intent2 = new Intent(MainActivity.this, FetchFromJSON.class);
                startActivity(intent2);
                break;

            case R.id.about_menu:
                aboutDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void aboutDialog(){
        AlertDialog.Builder about_dialog = new AlertDialog.Builder(this);
        about_dialog.setTitle("Ultimagz Mobile App");
        about_dialog.setMessage("Developed by :\n\n" +
                "Hanasya Shabrina - 00000014425\n" +
                "Agustinus Nathaniel - 00000014472\n" +
                "Robin Colinkang - 00000017937\n" +
                "Imam Wiratama - 18173\n\n" +
                "2019");
        about_dialog.setNegativeButton("Back", null);

        AlertDialog dialog = about_dialog.create();
        dialog.show();
    }
}
