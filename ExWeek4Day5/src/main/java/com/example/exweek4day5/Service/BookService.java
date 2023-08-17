package com.example.exweek4day5.Service;


import com.example.exweek4day5.ApiResponse.ApiException;
import com.example.exweek4day5.Model.Book;
import com.example.exweek4day5.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBook(){

        return bookRepository.findAll();
    }


    public void addBook(Book book){

        bookRepository.save(book);
    }

    public void updateBook(Integer id,Book book) {
        Book OldBook= bookRepository.findBookById(id);
        if (OldBook==null){
            throw new ApiException("id not found");
        }
        OldBook.setTitle(book.getTitle());
        OldBook.setAuthor(book.getAuthor());
        OldBook.setCategory(book.getCategory());
        OldBook.setISBN(book.getISBN());
        OldBook.setNumberOfPages(book.getNumberOfPages());

    }

    public void deleteBook(Integer id) {
        Book OldBook = bookRepository.findBookById(id);
        if (OldBook == null) {
            throw new ApiException("id not found");
        }
        bookRepository.delete(OldBook);
    }


    public List<Book> getbycat(String cat){
        List<Book> coff= bookRepository.findBookByCategory(cat);
        if (coff.isEmpty()){
            throw new ApiException("cat not found");
        }
        return coff;
    }

    public List<Book> getBook300(){
        List<Book> books= bookRepository.findBooksWithMoreThan300Pages();
        if (books.isEmpty()){
            throw new ApiException("cat not found");
        }
        return books;
    }


    public Book getbyauthor(String author){
        Book OldBook = bookRepository.findBookByAuthor(author);
        if (OldBook == null) {
            throw new ApiException("author not found");
        }
       return OldBook;
    }


    public Book SearchByTitle(String title){
        Book OldBook = bookRepository.findBookByTitle(title);
        if (OldBook == null) {
            throw new ApiException("title not found");
        }
        return OldBook;
    }









}
