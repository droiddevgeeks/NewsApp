package news.agoda.com.sample.api.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class NewsEntityTest {


    private final String title = "Testing Title";
    private final String summary = "Testing summary";
    private final String articleUrl = "www.google.com/image";
    private final String byline = "Testing byline";
    private final String publishedDate = "29-01-2019";
    private final List<MediaEntity> mediaEntityList = new ArrayList<>();

    @Mock
    NewsEntity newsEntity;
    @Mock
    List<MediaEntity> mediaList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(newsEntity.getTitle()).thenReturn(title);
        Mockito.when(newsEntity.getSummary()).thenReturn(summary);
        Mockito.when(newsEntity.getArticleUrl()).thenReturn(articleUrl);
        Mockito.when(newsEntity.getByline()).thenReturn(byline);
        Mockito.when(newsEntity.getPublishedDate()).thenReturn(publishedDate);
        Mockito.when(newsEntity.getMediaEntityList()).thenReturn(mediaEntityList);
    }

    @Test
    public void testNewsTitle(){
        Mockito.when(newsEntity.getTitle()).thenReturn(title);
        Assert.assertEquals("Testing Title",newsEntity.getTitle());
    }

    @Test
    public void testNewsSummary(){
        Mockito.when(newsEntity.getSummary()).thenReturn(summary);
        Assert.assertEquals("Testing summary",newsEntity.getSummary());
    }

    @Test
    public void testNewsArticleUrl(){
        Mockito.when(newsEntity.getArticleUrl()).thenReturn(articleUrl);
        Assert.assertEquals("www.google.com/image",newsEntity.getArticleUrl());
    }

    @Test
    public void testNewsByline(){
        Mockito.when(newsEntity.getByline()).thenReturn(byline);
        Assert.assertEquals("Testing byline",newsEntity.getByline());
    }

    @Test
    public void testNewsDate(){
        Mockito.when(newsEntity.getPublishedDate()).thenReturn(publishedDate);
        Assert.assertEquals("29-01-2019",newsEntity.getPublishedDate());
    }


    @Test
    public void testNewsMediaEntitiy(){
        Mockito.when(newsEntity.getMediaEntityList()).thenReturn(mediaEntityList);
        Assert.assertEquals(new ArrayList<>(),newsEntity.getMediaEntityList());
    }



    @Test
    public void testNewsTitleIncorrect(){
        Mockito.when(newsEntity.getTitle()).thenReturn(title);
        Assert.assertNotEquals("Title",newsEntity.getTitle());
    }

    @Test
    public void testNewsSummaryIncorrect(){
        Mockito.when(newsEntity.getSummary()).thenReturn(summary);
        Assert.assertNotEquals("summary",newsEntity.getSummary());
    }

    @Test
    public void testNewsArticleUrlIncorrect(){
        Mockito.when(newsEntity.getArticleUrl()).thenReturn(articleUrl);
        Assert.assertNotEquals("www.google.com",newsEntity.getArticleUrl());
    }

    @Test
    public void testNewsBylineIncorrect(){
        Mockito.when(newsEntity.getByline()).thenReturn(byline);
        Assert.assertNotEquals("byline",newsEntity.getByline());
    }

    @Test
    public void testNewsDateIncorrect(){
        Mockito.when(newsEntity.getPublishedDate()).thenReturn(publishedDate);
        Assert.assertNotEquals("29-02-2019",newsEntity.getPublishedDate());
    }


    @Test
    public void testNewsMediaEntitiyIncorrect(){
        Mockito.when(newsEntity.getMediaEntityList()).thenReturn(mediaEntityList);
        Assert.assertNotEquals("",newsEntity.getMediaEntityList());
    }


    @After
    public void tearDown() throws Exception {
        newsEntity =null;
        mediaList = null;
    }
}