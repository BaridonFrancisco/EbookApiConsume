package com.franciscoBaridon.Ebook_Consumo_API;


import Model.Author;
import Model.Book;
import Model.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class EbookConsumoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(EbookConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		var re=mapper.readValue(new URL("https://gutendex.com/books?ids=1"),Result.class);
		System.out.println(re);


	}
}
