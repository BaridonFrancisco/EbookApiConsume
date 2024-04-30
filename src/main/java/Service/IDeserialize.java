package Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IDeserialize {

    // deserializa una respuesta json -> a un Objeto java
    <T> T deserialize(String json,Class<T>classType) throws IOException;
}
