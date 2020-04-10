package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;
/*
    @Test
    public void findByNameShouldReturnBook() {
        List<Book> books = brepository.findByName("Buenas Migas 1");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getName()).isEqualTo("Buenas Migas 1");
    }
    */
   /*
    @Test
    public void createNewBook() {
    	Book book = new Book("Testi", "TestiAuthor", "1919191919-1919", 2000,  new Category("Testauskirjat"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void CreateAndDeleteBookTest() {
    	Book book = new Book("Testi2", "TestiAuthor2", "1919191919-19192", 2000,  new Category("Testauskirjat"));
    	brepository.save(book);
    	brepository.delete(book);
    }
    
    
    */
    

}