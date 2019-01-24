package news.agoda.com.sample.api;

import io.reactivex.Single;
import news.agoda.com.sample.api.model.NewsList;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET(ApiConstants.NEWS_URL)
    Single<NewsList> fetchNewsList();
}
