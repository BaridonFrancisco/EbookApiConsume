package Service;

import Model.Book;
import Model.Elements;
import Model.Result;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookMenu {
     Scanner scanner=new Scanner(System.in);
     TransformData transformData=new TransformData();


    public List<Book> searchBook(String author) throws IOException {
            return transformData.deserialize("https://gutendex.com/books?search="+author.replace(" ","%20")
                    ,Result.class).resultados();

    }
    public void top10Books() throws IOException {
        var re=transformData.deserialize("https://gutendex.com/books/?page=1",Result.class)
                .resultados().stream()
                .sorted(Comparator.comparing(Book::numerosDescargas).reversed())
                .limit(10)
                .collect(Collectors.groupingBy(Book::titulo,Collectors.toList()));
        re.forEach((k,v)-> System.out.println("key "+k+" value "+v));

    }

}
