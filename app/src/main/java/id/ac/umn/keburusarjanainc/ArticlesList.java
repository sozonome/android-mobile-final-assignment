package id.ac.umn.keburusarjanainc;

public class ArticlesList {
    private String article_title;
    private String article_image;
    private String article_content;

    public ArticlesList(String article_title, String article_image, String article_content) {
        this.article_title = article_title;
        this.article_image = article_image;
        this.article_content = article_content;
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
}
