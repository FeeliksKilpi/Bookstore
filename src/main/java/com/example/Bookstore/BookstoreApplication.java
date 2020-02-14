package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
			
	}
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Spanish"));
			crepository.save(new Category("Culture"));
			crepository.save(new Category("Sci-fi"));
			
			log.info("save a couple of books"); //logger tuottaa lokia ohjelman toiminnasta
			brepository.save(new Book("Buenas Migas 1", "Otava", "978-951-1-34784-2", 2014, crepository.findByName("Spanish").get(0)));
			brepository.save(new Book("La Comida Española", "FoodieBooks", "22-434-2-11232", 2001, crepository.findByName("Spanish").get(0)));
			brepository.save(new Book("Star Trek - Nemesis", "Pocket Books", "0-7434-7866-5", 2002, crepository.findByName("Sci-fi").get(0)));
			brepository.save(new Book("Paris Pop Up", "Editions Des Grandes Personnes", "978-2-36193-405-7", 2015, crepository.findByName("Culture").get(0)));
			brepository.save(new Book("WTF - Welcome to Finland", "FinnLit", "19-999-0-222", 2018, crepository.findByName("Culture").get(0)));
			brepository.save(new Book("Moon mission", "Storyland", "245-0-1-123-321", 1975, crepository.findByName("Sci-fi").get(0)));
			//repository.deleteAll(); //Poistaa kaikki kirjat mikäli niin halutaan
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
