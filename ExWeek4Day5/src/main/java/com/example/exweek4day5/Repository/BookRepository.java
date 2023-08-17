package com.example.exweek4day5.Repository;

import com.example.exweek4day5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById (Integer id);

    List<Book> findBookByCategory(String category);


    Book findBookByAuthor(String author);


    Book findBookByTitle (String title);

    @Query("SELECT b FROM Book b WHERE b.numberOfPages > 300")
    List<Book> findBooksWithMoreThan300Pages();
}
