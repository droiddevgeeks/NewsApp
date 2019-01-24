package news.agoda.com.sample.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import news.agoda.com.sample.api.model.MediaEntity;

public class MediaDeserializer extends TypeAdapter<List<MediaEntity>> {

    @Override
    public void write(JsonWriter out, List<MediaEntity> value) throws IOException {

    }

    @Override
    public List<MediaEntity> read(JsonReader reader) throws IOException {
        List<MediaEntity> mediaEntities = new ArrayList<>();
        try {
            if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                reader.beginArray();
                while (reader.hasNext()) {
                    mediaEntities.add(readMessage(reader));
                }
                reader.endArray();
            } else {
                reader.skipValue();
                return mediaEntities;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mediaEntities;
    }


    private MediaEntity readMessage(JsonReader reader) throws IOException {

        String url = null;
        String format = null;
        int height = 0;
        int width = 0;
        String type = null;
        String subType = null;
        String caption = null;
        String copyright = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "url":
                    url = reader.nextString();
                    break;
                case "format":
                    format = reader.nextString();
                    break;
                case "height":
                    height = reader.nextInt();
                    break;
                case "width":
                    width = reader.nextInt();
                    break;
                case "type":
                    type = reader.nextString();
                    break;
                case "subtype":
                    subType = reader.nextString();
                    break;
                case "caption":
                    caption = reader.nextString();
                    break;
                case "copyright":
                    copyright = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }

        }
        reader.endObject();
        return new MediaEntity(url, format, height, width, type, subType, caption, copyright);
    }
}
