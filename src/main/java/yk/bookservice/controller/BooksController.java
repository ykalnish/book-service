package yk.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yk.bookservice.model.Book;
import yk.bookservice.service.BooksService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class BooksController {
    Logger logger = Logger.getLogger(BooksController.class.getName());

    @Autowired
    private Environment env;
    @Autowired
    private BooksService booksService;

    @RequestMapping("/")
    public String home() {
        String home = "Book-Service running at port: " + env.getProperty("local.server.port");
        logger.info(home);
        return home;
    }

    @GetMapping(path = "/show")
    public List<Book> getAllBooksList() {
        logger.info("Get data from database (Feign Client on client-service side)");
        return booksService.findAllBooks();
    }

    @GetMapping("/data")
    public List<Book> data() {
        logger.info("Get data from database (RestTemplate on client-service side)");
        return booksService.findAllBooks();
    }
}