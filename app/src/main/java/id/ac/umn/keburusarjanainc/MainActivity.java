package id.ac.umn.keburusarjanainc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbarTop = (Toolbar) findViewById(R.id.nav_view);
//        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.content_frame);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.ultimagz.com");
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
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
