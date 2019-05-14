package id.ac.umn.keburusarjanainc;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.ac.umn.keburusarjanainc.adapter.ArticlesAdapter;

public class ArticleActivity extends AppCompatActivity {

    //Activity yang menampilkan detail Artikel secara Individual

    String SHARE_URL ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        TextView articleTitle = findViewById(R.id.article_title);
        TextView articleDate = findViewById(R.id.article_date);
        ImageView articleImageView = findViewById(R.id.article_image);
        WebView articleContent = findViewById(R.id.article_content);
        WebSettings webSettings = articleContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        FloatingActionButton share_button = findViewById(R.id.share_button);

        Intent intent = getIntent();
        final String title = intent.getStringExtra(ArticlesAdapter.KEY_TITLE);
        final String date = intent.getStringExtra(ArticlesAdapter.KEY_DATE);
        String image = intent.getStringExtra(ArticlesAdapter.KEY_IMAGE);
        final String content = intent.getStringExtra(ArticlesAdapter.KEY_CONTENT);
        final String article_url = intent.getStringExtra(ArticlesAdapter.KEY_LINK);
        SHARE_URL = article_url;

        articleTitle.setText(title);
        articleDate.setText(date);
        Picasso.with(this)
                .load(image)
                .into(articleImageView);

        articleContent.loadData(content, "text/html", "utf-8");

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Ada artikel menarik dari Ultimagz nih!\nYuk di cek langsung : \n\n" + SHARE_URL;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Share this Article"));
            }
        });

    }
}
