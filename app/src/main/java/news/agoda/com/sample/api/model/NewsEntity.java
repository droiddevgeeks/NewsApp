package news.agoda.com.sample.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This represents a news item
 */
public class NewsEntity {


    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String summary;

    @SerializedName("url")
    private String articleUrl;

    @SerializedName("byline")
    private String byline;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("multimedia")
    private List<MediaEntity> mediaEntityList;

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public String getByline() {
        return byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<MediaEntity> getMediaEntityList() {
        return mediaEntityList;
    }
}
