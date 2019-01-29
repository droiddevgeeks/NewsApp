package news.agoda.com.sample.di.module;

import dagger.Module;
import dagger.Provides;
import news.agoda.com.sample.api.RxSingleSchedulers;
import news.agoda.com.sample.di.scope.AppScope;

@Module
public class RxModule {
    @AppScope
    @Provides
    public RxSingleSchedulers providesScheduler() {
        return RxSingleSchedulers.DEFAULT;
    }
}
