package com.franciscoBaridon.Ebook_Consumo_API;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import view.Menu;

@SpringBootApplication
public class EbookConsumoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(EbookConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		new Menu().menu();




	}
}
