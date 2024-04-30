package Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(

        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        List<Authors>listaAutores,
        @JsonAlias("languages")
        String[]lenguajes,
        @JsonAlias("download_count")
        Long numerosDescargas


) {


    @Override
    public String toString() {
        return "Libro:" + "titulo=" + titulo +
                "listaAutores: " + listaAutores +
                "lenguajes: " + Arrays.toString(lenguajes) +
                "numerosDescargas: " + numerosDescargas+" \n";
    }
}
