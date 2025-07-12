package com.mpp.LibraryBookCatalog.Repository;

import com.mpp.LibraryBookCatalog.Beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
