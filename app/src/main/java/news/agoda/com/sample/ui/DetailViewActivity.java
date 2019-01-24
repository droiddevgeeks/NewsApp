package news.agoda.com.sample.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;

import news.agoda.com.sample.R;
import news.agoda.com.sample.base.BaseActivity;
import news.agoda.com.sample.databinding.ActivityDetailBinding;
import news.agoda.com.sample.util.AppConstants;
import news.agoda.com.sample.util.Utilities;

/**
 * News detail view
 */
public class DetailViewActivity extends BaseActivity<ActivityDetailBinding> {
    private String storyURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        storyURL = extras.getString(AppConstants.URL);
        String title = extras.getString(AppConstants.TITLE);
        String summary = extras.getString(AppConstants.SUMMARY);
        String imageURL = "";

        if (extras.containsKey(AppConstants.IMAGEURL))
            imageURL = extras.getString(AppConstants.IMAGEURL);

        binding.setTitle(title);
        binding.setSummary(summary);


        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(Uri.parse(imageURL)))
                .setOldController(binding.newsImage.getController()).build();
        binding.newsImage.setController(draweeController);

        binding.setStoryClick(click -> {
            if (Utilities.isNetworkConnected(this))
                openCompleteNews();
            else
                showToast(getString(R.string.internet_error));
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    private void openCompleteNews() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(storyURL));
        startActivity(intent);
    }
}
