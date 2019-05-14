package id.ac.umn.keburusarjanainc;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import id.ac.umn.keburusarjanainc.adapter.ArticlesAdapter;

public class FokusWebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_scan);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent intent = getIntent();
        final String URL = intent.getStringExtra(QRCodeScanner.KEY_URL);
//        Log.d("URL CodeScanned, Masuk FokusWebActivity", "URL yang akan ditarik : " + URL);

        WebView myWebView2 = findViewById(R.id.webView2);
        WebSettings webSettings = myWebView2.getSettings();
            webSettings.setJavaScriptEnabled(true);
            String UA = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Safari/537.36";
            webSettings.setUserAgentString(UA);
        myWebView2.setWebViewClient(new WebViewClient());

        myWebView2.loadUrl(URL);
    }


}
