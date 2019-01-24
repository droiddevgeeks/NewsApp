package news.agoda.com.sample.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsList {

    @SerializedName("section")
    private String section;

    @SerializedName("num_results")
    private String totalResults;

    @SerializedName("results")
    private List<NewsEntity> results;


    public String getSection() {
        return section;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public List<NewsEntity> getResults() {
        return results;
    }
}
