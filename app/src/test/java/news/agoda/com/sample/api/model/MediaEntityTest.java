package news.agoda.com.sample.api.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MediaEntityTest {

    private final String url = "www.test.com";
    private final String format = "testing format";
    private int height = 2;
    private int width = 1;
    private final String type = "testing type";
    private final String subType = "testing subtype";
    private final String caption = "testing caption";
    private final String copyright = "testing copyright";

    @Mock
    MediaEntity mediaEntity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mediaEntity.getUrl()).thenReturn(url);
        Mockito.when(mediaEntity.getFormat()).thenReturn(format);
        Mockito.when(mediaEntity.getHeight()).thenReturn(height);
        Mockito.when(mediaEntity.getWidth()).thenReturn(width);
        Mockito.when(mediaEntity.getType()).thenReturn(type);
        Mockito.when(mediaEntity.getSubType()).thenReturn(subType);
        Mockito.when(mediaEntity.getCaption()).thenReturn(caption);
        Mockito.when(mediaEntity.getCaption()).thenReturn(copyright);
    }

    @Test
    public void testMediaUrl() {
        Mockito.when(mediaEntity.getUrl()).thenReturn(url);
        Assert.assertEquals("www.test.com", mediaEntity.getUrl());
    }

    @Test
    public void testMediaFormat() {
        Mockito.when(mediaEntity.getFormat()).thenReturn(format);
        Assert.assertEquals("testing format", mediaEntity.getFormat());
    }

    @Test
    public void testMediaHeight() {
        Mockito.when(mediaEntity.getHeight()).thenReturn(height);
        Assert.assertEquals(2, mediaEntity.getHeight());
    }

    @Test
    public void testMediaWidth() {
        Mockito.when(mediaEntity.getWidth()).thenReturn(width);
        Assert.assertEquals(1, mediaEntity.getWidth());
    }

    @Test
    public void testMediaType() {
        Mockito.when(mediaEntity.getType()).thenReturn(type);
        Assert.assertEquals("testing type", mediaEntity.getType());
    }

    @Test
    public void testMediaSubType() {
        Mockito.when(mediaEntity.getSubType()).thenReturn(subType);
        Assert.assertEquals("testing subtype", mediaEntity.getSubType());
    }

    @Test
    public void testMediaCaption() {
        Mockito.when(mediaEntity.getCaption()).thenReturn(caption);
        Assert.assertEquals("testing caption", mediaEntity.getCaption());
    }

    @Test
    public void testMediaCopyright() {
        Mockito.when(mediaEntity.getCopyright()).thenReturn(copyright);
        Assert.assertEquals("testing copyright", mediaEntity.getCopyright());
    }


    @Test
    public void testMediaUrlIncorrect() {
        Mockito.when(mediaEntity.getUrl()).thenReturn(url);
        Assert.assertNotEquals(" testing www.test.com", mediaEntity.getUrl());
    }

    @Test
    public void testMediaFormatIncorrect() {
        Mockito.when(mediaEntity.getFormat()).thenReturn(format);
        Assert.assertNotEquals("format", mediaEntity.getFormat());
    }

    @Test
    public void testMediaHeightIncorrect() {
        Mockito.when(mediaEntity.getHeight()).thenReturn(height);
        Assert.assertNotEquals(12, mediaEntity.getHeight());
    }

    @Test
    public void testMediaWidthIncorrect() {
        Mockito.when(mediaEntity.getWidth()).thenReturn(width);
        Assert.assertNotEquals(11, mediaEntity.getWidth());
    }

    @Test
    public void testMediaTypeIncorrect() {
        Mockito.when(mediaEntity.getType()).thenReturn(type);
        Assert.assertNotEquals("type", mediaEntity.getType());
    }

    @Test
    public void testMediaSubTypeIncorrect() {
        Mockito.when(mediaEntity.getSubType()).thenReturn(subType);
        Assert.assertNotEquals("subtype", mediaEntity.getSubType());
    }

    @Test
    public void testMediaCaptionIncorrect() {
        Mockito.when(mediaEntity.getCaption()).thenReturn(caption);
        Assert.assertNotEquals("caption", mediaEntity.getCaption());
    }

    @Test
    public void testMediaCopyrightIncorrect() {
        Mockito.when(mediaEntity.getCopyright()).thenReturn(copyright);
        Assert.assertNotEquals("copyright", mediaEntity.getCopyright());
    }



    @After
    public void tearDown() throws Exception {
        mediaEntity = null;
    }
}