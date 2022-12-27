package yk.bookservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yk.bookservice.model.Book;

@Repository
public interface BooksRepository extends MongoRepository<Book, String> {
}