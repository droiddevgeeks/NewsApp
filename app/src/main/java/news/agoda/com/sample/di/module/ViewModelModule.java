package news.agoda.com.sample.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import news.agoda.com.sample.api.NewsViewModelFactory;
import news.agoda.com.sample.di.scope.ViewModelKey;
import news.agoda.com.sample.ui.viewmodel.NewsViewModel;


@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel.class)
    abstract ViewModel bindNewsViewModel(NewsViewModel searchViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindNewsViewModelFactory(NewsViewModelFactory factory);
}
