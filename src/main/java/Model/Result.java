package Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Result(
        @JsonAlias("count")
        Integer cantidad,
        @JsonAlias("results")
        List<Book>resultados




) {


        @Override
        public String toString() {
                return "cantidad=" + cantidad +" "+ resultados.toString();

        }
}
