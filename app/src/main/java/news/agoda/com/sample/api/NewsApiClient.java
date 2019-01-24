package news.agoda.com.sample.api;


import javax.inject.Inject;

import io.reactivex.Single;
import news.agoda.com.sample.api.model.NewsList;

public class NewsApiClient {

    private final ApiEndPoint api;

    @Inject
    public NewsApiClient(ApiEndPoint api) {
        this.api = api;
    }

    public Single<NewsList> fetchNews() {
        return api.fetchNewsList();
    }

}
