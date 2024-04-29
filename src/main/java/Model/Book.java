package Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(

        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        List<Autores> listaAutores,
        @JsonAlias("download_count")
        Long numerosDescargas
) {


}
/*  @JsonAlias("count")
    private Integer count;
    @JsonAlias("next")
    private String next;
    @JsonAlias("previous")
    private String previous;
    @JsonAlias("results")
    private Results[] results;

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public Results[] getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Book{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + Arrays.toString(results) +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Results {
        private int id;
        private String title;
        private String[] authors;



        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Results{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", authors=" + Arrays.toString(authors) +
                    '}';
        }
    }*/

