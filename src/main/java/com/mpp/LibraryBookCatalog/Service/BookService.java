package com.mpp.LibraryBookCatalog.Service;

import com.mpp.LibraryBookCatalog.Beans.Book;
import com.mpp.LibraryBookCatalog.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public boolean deleteBook(int id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    public Book updateAvailability(int id, boolean available) {
        Book book = getBookById(id);
        if (book == null) return null;
        book.setAvailable(available);
        return repository.save(book);
    }
}
