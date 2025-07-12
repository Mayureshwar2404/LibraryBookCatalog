package com.mpp.LibraryBookCatalog.Controller;

import com.mpp.LibraryBookCatalog.Beans.Book;
import com.mpp.LibraryBookCatalog.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = service.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    // Add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        Book savedBook = service.addBook(book);
        URI location = URI.create("/books/" + savedBook.getId());
        return ResponseEntity.created(location).body(savedBook);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean deleted = service.deleteBook(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // Update availability
    @PatchMapping("/{id}/availability")
    public ResponseEntity<Book> updateAvailability(@PathVariable int id,
                                                   @RequestParam boolean available) {
        Book book = service.updateAvailability(id, available);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
}
