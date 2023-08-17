package com.example.exweek4day5.Controller;

import com.example.exweek4day5.ApiResponse.ApiResponse;
import com.example.exweek4day5.Model.Book;
import com.example.exweek4day5.Model.Librarian;
import com.example.exweek4day5.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/librarian")
public class LibrarianController {

    private final LibrarianService librarianService  ;


    @GetMapping("/get")
    public ResponseEntity getAllLibrarians() {

        return ResponseEntity.status(200).body(librarianService.getAllLibrarian());
    }


    @PostMapping("/add")
    public ResponseEntity addLibrarian(@RequestBody @Valid Librarian librarian) {
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @RequestBody @Valid Librarian librarian ){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian deleted"));
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity getbycat(@PathVariable Integer id){
        Librarian librarian = librarianService.getbyid(id);
        return ResponseEntity.status(200).body(librarian);
    }


    @GetMapping("/check/{un}/{pa}")
    public ResponseEntity getbycat(@PathVariable String un , @PathVariable String pa){
        String res = librarianService.checkUsernameandPassword(un, pa);
        return ResponseEntity.status(200).body(res);
    }


    @GetMapping("/getbyem/{em}")
    public ResponseEntity getbycat(@PathVariable String em){
        Librarian librarian = librarianService.getAccount(em);
        return ResponseEntity.status(200).body(librarian);
    }

}
