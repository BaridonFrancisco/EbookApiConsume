package com.franciscoBaridon.Ebook_Consumo_API;


import Model.Book;
import Model.Result;
import Service.BookMenu;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;


@SpringBootApplication
public class EbookConsumoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(EbookConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BookMenu bookMenu=new BookMenu();
		//var resultado=bookMenu.searchBook("dickens");
		//System.out.println(resultado);
		//bookMenu.top10Books();
		bookMenu.searchBook("dickens great");




	}
}
