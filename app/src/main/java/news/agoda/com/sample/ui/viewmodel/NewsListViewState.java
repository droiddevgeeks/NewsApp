package news.agoda.com.sample.ui.viewmodel;

import news.agoda.com.sample.api.model.NewsList;
import news.agoda.com.sample.base.BaseViewState;

public class NewsListViewState extends BaseViewState<NewsList> {
    private NewsListViewState(NewsList data, int currentState, Throwable error) {
        this.data = data;
        this.error = error;
        this.currentState = currentState;
    }

    public static NewsListViewState ERROR_STATE = new NewsListViewState(null, State.FAILED.value, new Throwable());
    public static NewsListViewState LOADING_STATE = new NewsListViewState(null, State.LOADING.value, null);
    public static NewsListViewState SUCCESS_STATE = new NewsListViewState(new NewsList(), State.SUCCESS.value, null);

}
