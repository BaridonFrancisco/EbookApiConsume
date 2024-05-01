package view;

import Service.BookService;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner;
    BookService bookService;

    public Menu() {
        this.bookService = new BookService();
        this.scanner=new Scanner(System.in);
    }

    public void menu() throws IOException {
        int op;
        String nameBook;
        int startYear,endYear;
        try {

            do {
                System.out.println("""
                    1.Buscar libro
                    2.Buscar los 10 libros mejor valorados
                    3.Buscar libros por anio
                    4.Cambiar de page
                    5.Salir""");
                switch (op=scanner.nextInt()){
                    case 1:
                        scanner.nextLine();
                        System.out.println("Ingrese el nombre del libro a buscar");
                        nameBook=scanner.next();
                        var result= bookService.searchBook(nameBook);
                        result.ifPresent(System.out::println);
                        break;
                    case 2:
                        System.out.println("Los 10 son libros mejor valorados en la pagina "+ bookService.getPage());
                        var topBook= bookService.top10Books();
                        topBook.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Ingrese el desde que anio desea buscar");
                        startYear= scanner.nextInt();
                        System.out.println("Ingrese hasta que anio desea buscar");
                        endYear=scanner.nextInt();
                        bookService.buscarLibrosAnios(LocalDate.of(startYear,1,1),LocalDate.of(endYear,1,1));
                        break;
                    case 4:
                        bookService.changePage();
                        System.out.println(bookService.getPage());
                        break;
                    case 5:
                        System.out.println("Saliendo....");
                        break;
                    default:
                        System.out.println("No ha seleccionado una opcion correcta");
                }
            }while(op!=5);
        }catch (InputMismatchException | DateTimeException e){
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Ha ocurrido una excepcion");
            e.printStackTrace();
        }
        scanner.close();

    }
}
