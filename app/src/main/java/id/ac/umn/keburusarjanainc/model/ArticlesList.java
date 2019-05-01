package id.ac.umn.keburusarjanainc;

public class ArticlesList {
    private String article_title;
    private String article_image;
    private String article_content;
    private String article_date;

    public ArticlesList(String article_title, String article_image, String article_content, String article_date) {
        this.article_title = article_title;
        this.article_image = article_image;
        this.article_content = article_content;
        this.article_date = article_date;
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


}
