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
import com.example.Bookstore.domain.UserCred;
import com.example.Bookstore.domain.UserCredRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
			
	}
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository, UserCredRepository urepository) {
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
			
			// Create users: admin/admin user/user
			UserCred user1 = new UserCred("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			UserCred user2 = new UserCred("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			// Luo user käyttäjä käyttäen bcrypt kryptausjuttua
			UserCred user3 = new UserCred("felix", "$2a$09$5I3aVz.7cAf/I5KKq9to.OkEb3haIiZQDXieNXv.C0qgnTveZ0kWi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
