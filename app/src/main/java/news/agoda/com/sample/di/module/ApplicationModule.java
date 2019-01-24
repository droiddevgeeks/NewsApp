package news.agoda.com.sample.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;


@Module(includes = ViewModelModule.class)
abstract public class ApplicationModule {

    @Binds
    abstract Context provideContext(Application application);

}
