package com.example.exweek4day5.Controller;

import com.example.exweek4day5.ApiResponse.ApiResponse;
import com.example.exweek4day5.Model.Book;
import com.example.exweek4day5.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService ;


    @GetMapping("/get")
    public ResponseEntity getAllBooks() {

        return ResponseEntity.status(200).body(bookService.getAllBook());
    }


    @PostMapping("/add")
    public ResponseEntity addBooks(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateBooks(@PathVariable Integer id, @RequestBody @Valid  Book book ){
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body(new ApiResponse("Book updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletebook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book deleted"));
    }

    @GetMapping("/getbycat/{cat}")
    public ResponseEntity getbycat(@PathVariable String cat){
        List<Book> books = bookService.getbycat(cat);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/getbynum")
    public ResponseEntity getbynum(){
        List<Book> books = bookService.getBook300();
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/getbyaut/{aut}")
    public ResponseEntity getbyaut(@PathVariable String aut){
        Book book = (Book) bookService.getbyauthor(aut);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/getbytit/{tit}")
    public ResponseEntity getbytit(@PathVariable String tit){
        Book book = (Book) bookService.SearchByTitle(tit);
        return ResponseEntity.status(200).body(book);
    }


}
