package news.agoda.com.sample.ui.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;
import news.agoda.com.sample.api.ApiEndPoint;
import news.agoda.com.sample.api.NewsApiClient;
import news.agoda.com.sample.api.RxSingleSchedulers;
import news.agoda.com.sample.api.model.NewsList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class NewsViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    ApiEndPoint apiEndPoint;
    @Mock
    NewsApiClient apiClient;
    private NewsViewModel viewModel;
    @Mock
    Observer<NewsListViewState> observer;
    @Mock
    LifecycleOwner lifecycleOwner;
    Lifecycle lifecycle;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lifecycle = new LifecycleRegistry(lifecycleOwner);
        viewModel = new NewsViewModel(apiClient, RxSingleSchedulers.TEST_SCHEDULER);
        viewModel.getNewsListState().observeForever(observer);
    }

    @Test
    public void testNull() {
        when(apiClient.fetchNews()).thenReturn(null);
        assertNotNull(viewModel.getNewsListState());
        assertTrue(viewModel.getNewsListState().hasObservers());
    }

    @Test
    public void testApiFetchDataSuccess() {
        // Mock API response
        when(apiClient.fetchNews()).thenReturn(Single.just(new NewsList()));
        viewModel.fetchNews();
        verify(observer).onChanged(NewsListViewState.LOADING_STATE);
        verify(observer).onChanged(NewsListViewState.SUCCESS_STATE);
    }

    @Test
    public void testApiFetchDataError() {
        when(apiClient.fetchNews()).thenReturn(Single.error(new Throwable("Api error")));
        viewModel.fetchNews();
        verify(observer).onChanged(NewsListViewState.LOADING_STATE);
        verify(observer).onChanged(NewsListViewState.ERROR_STATE);
    }

    @After
    public void tearDown() throws Exception {
        apiClient = null;
        viewModel = null;
    }
}