package id.ac.umn.keburusarjanainc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbarTop = (Toolbar) findViewById(R.id.nav_view);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.content_frame);
        setContentView(R.layout.activity_main);
    }
}
