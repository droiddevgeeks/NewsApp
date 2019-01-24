package news.agoda.com.sample.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * This class represents a media item
 */
public class MediaEntity {

    public MediaEntity(String url, String format, int height, int width, String type, String subType, String caption, String copyright) {
        this.url = url;
        this.format = format;
        this.height = height;
        this.width = width;
        this.type = type;
        this.subType = subType;
        this.caption = caption;
        this.copyright = copyright;
    }

    @SerializedName("url")
    private String url;

    @SerializedName("format")
    private String format;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @SerializedName("type")
    private String type;

    @SerializedName("subtype")
    private String subType;

    @SerializedName("caption")
    private String caption;

    @SerializedName("copyright")
    private String copyright;

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getCaption() {
        return caption;
    }

    public String getCopyright() {
        return copyright;
    }
}
