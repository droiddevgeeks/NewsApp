package news.agoda.com.sample.ui.viewmodel;

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
    private final RxSingleSchedulers rxSingleSchedulers;
    private final MutableLiveData<NewsListViewState> newsListState = new MutableLiveData<>();

    public MutableLiveData<NewsListViewState> getNewsListState() {
        return newsListState;
    }

    @Inject
    public NewsViewModel(NewsApiClient apiClient, RxSingleSchedulers rxSingleSchedulers) {
        this.apiClient = apiClient;
        this.rxSingleSchedulers = rxSingleSchedulers;
        disposable = new CompositeDisposable();
    }

    public void fetchNews() {
        disposable.add(apiClient.fetchNews()
                .doOnEvent((newsList, throwable) -> onLoading())
                .compose(rxSingleSchedulers.applySchedulers())
                .subscribe(this::onSuccess,
                        this::onError));
    }

    private void onSuccess(NewsList newsList) {
        NewsListViewState.SUCCESS_STATE.setData(newsList);
        newsListState.postValue(NewsListViewState.SUCCESS_STATE);
    }

    private void onError(Throwable error) {
        NewsListViewState.ERROR_STATE.setError(error);
        newsListState.postValue(NewsListViewState.ERROR_STATE);
    }

    private void onLoading() {
        newsListState.postValue(NewsListViewState.LOADING_STATE);
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
