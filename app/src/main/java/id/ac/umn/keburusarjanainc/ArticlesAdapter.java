package id.ac.umn.keburusarjanainc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    public static final String KEY_TITLE = "title";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_CONTENT = "content";

    private List<ArticlesList> articlesLists;
    private Context context;

    public ArticlesAdapter(List<ArticlesList> articlesLists, Context context){
        this.articlesLists = articlesLists;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ArticlesList articlesList = articlesLists.get(position);
        holder.title.setText(articlesList.getArticle_title());

        Picasso.with(context)
                .load(articlesList.getArticle_image())
                .into(holder.image);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticlesList articlesList1 = articlesLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), ArticleActivity.class);
                skipIntent.putExtra(KEY_TITLE, articlesList1.getArticle_title());
                skipIntent.putExtra(KEY_IMAGE, articlesList1.getArticle_image());
                skipIntent.putExtra(KEY_CONTENT, articlesList1.getArticle_content());
                v.getContext().startActivity(skipIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView image;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.article_title);
            image = itemView.findViewById(R.id.article_image);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
