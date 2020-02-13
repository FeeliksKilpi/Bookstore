package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
			
	}
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books"); //logger tuottaa lokia ohjelman toiminnasta
			repository.save(new Book("Buenas Migas 1", "Otava", "978-951-1-34784-2", 2014));
			repository.save(new Book("Star Trek - Nemesis", "Pocket Books", "0-7434-7866-5", 2002));
			repository.save(new Book("Paris Pop Up", "Editions Des Grandes Personnes", "978-2-36193-405-7", 2015));
			//repository.deleteAll(); //Poistaa kaikki kirjat mikäli niin halutaan
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
