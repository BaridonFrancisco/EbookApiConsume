package Service;

import Model.Authors;
import Model.Book;
import Model.Result;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class BookService {
     Scanner scanner=new Scanner(System.in);
     TransformData transformData=new TransformData();
     private final String URL_BASE="https://gutendex.com/books?";
     private int page=1;
    public Optional<Book> searchBook(String authorOrBookName) throws IOException {
        return transformData.deserialize(URL_BASE+"search=" +authorOrBookName.replace(" ", "%20"), Result.class).resultados()
                        .stream()
                        .max(Comparator.comparing(Book::numerosDescargas));
    }
    public List<String> top10Books() throws IOException {
        return transformData.deserialize(URL_BASE+"page="+page,Result.class)
                .resultados().stream()
                .sorted(Comparator.comparing(Book::numerosDescargas).reversed())
                .limit(10)
                .map(Book::titulo)
                .toList();
    }
    public void buscarLibrosAnios(LocalDate startDate, LocalDate endDate) throws IOException {
        String url=URL_BASE+"author_year_start="+startDate.getYear()+"&author_year_end="+endDate.getYear()+"&page="+page;
       var re= transformData.deserialize(url,Result.class)
                .resultados()
               .stream()
               .collect(Collectors.groupingBy(Book::titulo,
                       Collectors.mapping(book->book.listaAutores()
                               .stream()
                               .map(Authors::name)
                               .collect(Collectors.joining(",")),Collectors.toList())));
       re.forEach((k,v)-> System.out.println(k+" "+v));
    }

    public void changePage() {
        this.page++;
    }

    public int getPage() {
        return page;
    }
}
