package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.databasedemo.domain.BookRepository;

@Controller
public class DatabasedemoController {
	@Autowired
	private BookRepository repository;
	
	
}
