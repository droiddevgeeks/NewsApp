package news.agoda.com.sample.ui;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;

import java.util.List;

import news.agoda.com.sample.R;
import news.agoda.com.sample.api.model.MediaEntity;
import news.agoda.com.sample.api.model.NewsEntity;
import news.agoda.com.sample.databinding.ListItemNewsBinding;
import news.agoda.com.sample.ui.callback.IItemClick;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsEntity> newsList;
    private LayoutInflater layoutInflater;
    private IItemClick listener;

    public NewsAdapter(Context context, List<NewsEntity> newsList) {
        this.newsList = newsList;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addListener(IItemClick itemClick) {
        this.listener = itemClick;
    }

    public void removeListener() {
        listener = null;
    }

    public void addNewsList(List<NewsEntity> newsList) {
        if (!this.newsList.isEmpty()) {
            this.newsList.clear();
        }
        this.newsList.addAll(newsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(ListItemNewsBinding.inflate(layoutInflater, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        NewsEntity newsEntity = newsList.get(i);
        viewHolder.binding.setNews(newsEntity);
        List<MediaEntity> mediaEntityList = newsEntity.getMediaEntityList();
        if (!mediaEntityList.isEmpty()) {
            MediaEntity mediaEntity = mediaEntityList.get(0);
            String thumbnailURL = mediaEntity.getUrl();

            DraweeController draweeController = Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequest.fromUri(Uri.parse(thumbnailURL))).setOldController(viewHolder.binding.newsItemImage.getController()).build();
            viewHolder.binding.newsItemImage.setController(draweeController);
        } else {
            viewHolder.binding.newsItemImage.setImageResource(R.mipmap.ic_launcher);
        }
        viewHolder.binding.setItemClickListener(click -> listener.onItemClick(viewHolder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemNewsBinding binding;

        public ViewHolder(ListItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

