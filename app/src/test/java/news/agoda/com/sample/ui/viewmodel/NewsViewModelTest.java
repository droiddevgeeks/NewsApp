package news.agoda.com.sample.ui.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;
import news.agoda.com.sample.api.ApiEndPoint;
import news.agoda.com.sample.api.NewsApiClient;
import news.agoda.com.sample.api.model.NewsList;

import static io.reactivex.Single.never;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(JUnit4.class)
public class NewsViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    ApiEndPoint apiEndPoint;
    private NewsApiClient apiClient;
    private NewsViewModel viewModel;

    private NewsList newsList = Mockito.mock(NewsList.class);


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        apiClient = new NewsApiClient(apiEndPoint);
        viewModel = new NewsViewModel(apiClient);

    }

    @Test
    public void testNull() {
        assertThat(viewModel.getNewsData(), notNullValue());
        Observer observer = Mockito.mock(Observer.class);
        Mockito.verify(observer, Mockito.never()).onChanged(Mockito.any());

    }

    @Test
    public void testApiFetchDataSuccess() {
        // Mock API response
        LiveData<NewsList> newsListLiveData = new MutableLiveData<>();
        Observer observer = Mockito.mock(Observer.class);
        Mockito.when(apiClient.fetchNews()).thenReturn(newsListLiveData);
        viewModel.getNewsData().observeForever(observer);
        viewModel.fetchNews();
        Mockito.verify(observer, Mockito.never()).onChanged(Mockito.any());
    }

    @Test
    public void testApiFetchDataError() {
        Mockito.when(apiClient.fetchNews()).thenReturn(Single.error(new Throwable("Api error")));
        viewModel.fetchNews();
        Assert.assertEquals("Api error", apiClient.fetchNews());
    }

    @After
    public void tearDown() throws Exception {
        apiClient = null;
        viewModel = null;
    }
}