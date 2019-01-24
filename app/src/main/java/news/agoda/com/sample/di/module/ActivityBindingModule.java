package news.agoda.com.sample.di.module;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import news.agoda.com.sample.ui.DetailViewActivity;
import news.agoda.com.sample.ui.MainActivity;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector()
    abstract DetailViewActivity bindDetailActivity();
}
