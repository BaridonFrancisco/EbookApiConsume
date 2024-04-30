package Service;

import Model.Book;
import Model.Result;
import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;


public class BookMenu {
     Scanner scanner=new Scanner(System.in);
     TransformData transformData=new TransformData();


    public Optional<Book> searchBook(String author) throws IOException {
        return transformData.deserialize("https://gutendex.com/books?search=" + author.replace(" ", "%20"), Result.class).resultados()
                        .stream()
                        .max(Comparator.comparing(Book::numerosDescargas));
    }
    public void top10Books() throws IOException {
        var re=transformData.deserialize("https://gutendex.com/books/?page=1",Result.class)
                .resultados().stream()
                .sorted(Comparator.comparing(Book::numerosDescargas).reversed())
                .limit(10)
                .map(Book::titulo)
                .toList();
        re.forEach(System.out::println);
    }
    public void buscarLibrosPor(String bookName,String language){

    }

}
