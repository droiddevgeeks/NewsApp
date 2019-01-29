package news.agoda.com.sample.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

import javax.inject.Inject;

import news.agoda.com.sample.R;
import news.agoda.com.sample.api.NewsViewModelFactory;
import news.agoda.com.sample.api.model.NewsEntity;
import news.agoda.com.sample.api.model.NewsList;
import news.agoda.com.sample.base.BaseActivity;
import news.agoda.com.sample.databinding.ActivityMainBinding;
import news.agoda.com.sample.ui.callback.IItemClick;
import news.agoda.com.sample.ui.viewmodel.NewsViewModel;
import news.agoda.com.sample.util.AppConstants;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IItemClick<NewsEntity> {
    private NewsAdapter newsAdapter;
    private NewsViewModel newsViewModel;

    @Inject
    NewsViewModelFactory newsViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        newsViewModel = ViewModelProviders.of(this, newsViewModelFactory).get(NewsViewModel.class);
        initNewsDataAdapter();
        observeDataChange();
        newsViewModel.fetchNews();
    }

    private void loadNewsData(NewsList data) {
        newsAdapter.addNewsList(data.getResults());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    private void initNewsDataAdapter() {
        newsAdapter = new NewsAdapter(this, new ArrayList<>());
        binding.rvNewsList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNewsList.setAdapter(newsAdapter);
        newsAdapter.addListener(this);
    }

    private void observeDataChange() {
        newsViewModel.getNewsListState().observe(this, newsListViewState -> {
            switch (newsListViewState.getCurrentState()) {
                case 0:
                    binding.setShowLoading(true);
                    break;
                case 1:
                    binding.setShowLoading(false);
                    loadNewsData(newsListViewState.getData());
                    break;
                case -1: // show error
                    binding.setShowLoading(false);
                    break;
            }
        });
    }

    @Override
    public void onItemClick(NewsEntity newsEntity) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.TITLE, newsEntity.getTitle());
        bundle.putString(AppConstants.URL, newsEntity.getArticleUrl());
        bundle.putString(AppConstants.SUMMARY, newsEntity.getSummary());
        if (!newsEntity.getMediaEntityList().isEmpty())
            bundle.putString(AppConstants.IMAGEURL, newsEntity.getMediaEntityList().get(0).getUrl());

        DetailViewActivity.openDetailViewActivity(this, bundle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (newsAdapter != null) {
            newsAdapter.removeListener();
        }
    }
}
