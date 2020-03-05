package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;



@Controller
public class BookstoreController {
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value= {"/", "/bookstore"})
    public String studentList(Model model) {	
        model.addAttribute("books", brepository.findAll());
        return "bookstore";
    }
	// Kaikki kirjat listattuna REST-rajapinnan avulla
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {	
        return (List<Book>) brepository.findAll();
    }
    // Kirja ID:n mukaan REST-rajapinnan avulla
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    	return brepository.findById(bookId);
    }  
    
	@RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    } 
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:bookstore";
        // Ohjaa tallennuksen jälkeen bookstore pääsivu endpointtiin
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.deleteById(bookId);
    	//.. tarkoittaa että mennään polussa ylöspäin
        return "redirect:../bookstore";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	//Haetaan tietokannasta SQL-lauseella kirja, jolla on tämä id
    	//ja lisätään modeliin
    	model.addAttribute("book", brepository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }  
}
