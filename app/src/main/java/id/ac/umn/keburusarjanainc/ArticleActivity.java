package id.ac.umn.keburusarjanainc;

import android.content.Intent;
import android.graphics.Typeface;
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

        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        TextView articleTitle = findViewById(R.id.article_title);
        ImageView articleImageView = findViewById(R.id.article_image);
        WebView articleContent = findViewById(R.id.article_content);
        WebSettings webSettings = articleContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        Intent intent = getIntent();
        final String title = intent.getStringExtra(ArticlesAdapter.KEY_TITLE);
        String image = intent.getStringExtra(ArticlesAdapter.KEY_IMAGE);
        final String content = intent.getStringExtra(ArticlesAdapter.KEY_CONTENT);
        final String article_url = intent.getStringExtra(ArticlesAdapter.KEY_LINK);
        SHARE_URL = article_url;

        articleTitle.setText(title);
        Picasso.with(this)
                .load(image)
                .into(articleImageView);

        articleContent.loadData(content, "text/html", "utf-8");


    }

//    public void shareText(View view) {
//        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        String shareBodyText = "Your shearing message goes here";
//        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
//        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
//        startActivity(Intent.createChooser(intent, "Choose sharing method"));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.articleoptions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Ada artikel menarik dari Ultimagz nih!\nYuk di cek langsung : \n\n" + SHARE_URL;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Share this Article"));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
