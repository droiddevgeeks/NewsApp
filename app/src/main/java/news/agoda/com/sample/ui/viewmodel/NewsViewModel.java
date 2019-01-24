package news.agoda.com.sample.ui.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import news.agoda.com.sample.api.NewsApiClient;
import news.agoda.com.sample.api.RxSingleSchedulers;
import news.agoda.com.sample.api.model.NewsList;

public class NewsViewModel extends ViewModel {

    private CompositeDisposable disposable;
    private final NewsApiClient apiClient;


    private final MutableLiveData<NewsList> newsData = new MutableLiveData<>();
    private final MutableLiveData<Throwable> apiError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public NewsViewModel(NewsApiClient apiClient) {
        this.apiClient = apiClient;
        disposable = new CompositeDisposable();
    }

    public LiveData<NewsList> getNewsData() {
        return newsData;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public LiveData<Throwable> getApiError() {
        return apiError;
    }

    public void fetchNews() {
        loading.postValue(true);
        disposable.add(apiClient.fetchNews()
                .doOnEvent((used, not) -> loading.postValue(false))
                .compose(RxSingleSchedulers.DEFAULT.applySchedulers())
                .subscribe(
                        newsData::postValue,
                        apiError::postValue
                ));
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
