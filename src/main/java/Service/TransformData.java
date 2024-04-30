package Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TransformData implements IDeserialize {
    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public <T> T deserialize(String url, Class<T> classType) throws IOException {
        return objectMapper.readValue(new URL(url),classType);
    }
}
