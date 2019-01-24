package news.agoda.com.sample.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import news.agoda.com.sample.api.ApiConstants;
import news.agoda.com.sample.api.ApiEndPoint;
import news.agoda.com.sample.api.model.MediaEntity;
import news.agoda.com.sample.di.scope.AppScope;
import news.agoda.com.sample.util.MediaDeserializer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @AppScope
    @Provides
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    Gson provideGson() {
        return new GsonBuilder().registerTypeAdapter(new TypeToken<List<MediaEntity>>(){}.getType(), new MediaDeserializer()).create();
    }


    @AppScope
    @Provides
    ApiEndPoint provideNewsApi(Retrofit retrofit) {
        return retrofit.create(ApiEndPoint.class);
    }
}
