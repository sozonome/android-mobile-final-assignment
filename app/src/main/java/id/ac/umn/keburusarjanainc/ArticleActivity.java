package id.ac.umn.keburusarjanainc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        TextView articleTitle = (TextView) findViewById(R.id.article_title);
        ImageView articleImageView = (ImageView) findViewById(R.id.article_image);
        TextView articleContent = (TextView) findViewById(R.id.article_content);

        Intent intent = getIntent();
        final String title = intent.getStringExtra(ArticlesAdapter.KEY_TITLE);
        String image = intent.getStringExtra(ArticlesAdapter.KEY_IMAGE);
        final String content = intent.getStringExtra(ArticlesAdapter.KEY_CONTENT);

        articleTitle.setText(title);
        Picasso.with(this)
                .load(image)
                .into(articleImageView);
        articleContent.setText(content);


    }
}
