package news.agoda.com.sample.di.component;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import news.agoda.com.sample.NewsApp;
import news.agoda.com.sample.di.module.ActivityBindingModule;
import news.agoda.com.sample.di.module.ApiModule;
import news.agoda.com.sample.di.module.ApplicationModule;
import news.agoda.com.sample.di.module.RxModule;
import news.agoda.com.sample.di.scope.AppScope;

@AppScope
@Component(modules = {ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ApiModule.class, RxModule.class})
public interface ApplicationComponent extends AndroidInjector<NewsApp> {

    void inject(NewsApp application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(NewsApp application);
        ApplicationComponent build();
    }
}