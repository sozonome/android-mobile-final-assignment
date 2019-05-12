package id.ac.umn.keburusarjanainc.model;

import android.text.Html;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticlesList {
    private String article_title;
    private String article_image;
    private String article_content;
    private String article_date;
    private String article_link;

    public ArticlesList(String article_title, String article_image, String article_content, String article_date, String article_link){
        this.article_title = String.valueOf(Html.fromHtml(article_title, Html.FROM_HTML_MODE_LEGACY));
        this.article_image = article_image;
        this.article_content = article_content;
//        this.article_date = article_date;
        this.article_date = parseDate(article_date);
        this.article_link = article_link;
    }

    public String parseDate(String date){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //Format untuk Input
            SimpleDateFormat output = new SimpleDateFormat("dd-MMMM-yyyy"); //Format untuk Output
            Date d = sdf.parse(date); //String tanggal dari JSON di format disini
            String formattedTime = output.format(d); //Men-format tanggal ke dalam String dengan format baru
            return formattedTime;
        }catch (Exception e){
            return null;
        }
    }

    public String getArticle_title() {
        return article_title;
    }

    public String getArticle_image() {
        return article_image;
    }

    public String getArticle_content() {
        return article_content;
    }

    public String getArticle_date() {
        return article_date;
    }

    public String getArticle_link() {
        return article_link;
    }

    public void setArticle_link(String article_link) {
        this.article_link = article_link;
    }

}
