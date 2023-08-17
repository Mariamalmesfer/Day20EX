package com.example.exweek4day5.Service;

import com.example.exweek4day5.ApiResponse.ApiException;
import com.example.exweek4day5.Model.Book;
import com.example.exweek4day5.Model.Librarian;
import com.example.exweek4day5.Repository.BookRepository;
import com.example.exweek4day5.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {


    private final LibrarianRepository librarianRepository ;

    public List<Librarian> getAllLibrarian(){

        return librarianRepository.findAll();
    }


    public void addLibrarian(Librarian librarian){

        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id,Librarian librarian) {
        Librarian OldLibrarian= librarianRepository.findLibrarianById(id);
        if (OldLibrarian==null){
            throw new ApiException("id not found");
        }
        OldLibrarian.setName(librarian.getName());
        OldLibrarian.setUsername(librarian.getUsername());
        OldLibrarian.setPassword(librarian.getPassword());
        OldLibrarian.setEmail(librarian.getEmail());
    }

    public void deleteLibrarian(Integer id) {
        Librarian OldLibrarian = librarianRepository.findLibrarianById(id);
        if (OldLibrarian == null) {
            throw new ApiException("id not found");
        }
        librarianRepository.delete(OldLibrarian);
    }

    public Librarian getbyid(Integer id){
        Librarian OldLibrarian = librarianRepository.findLibrarianById(id);
        if (OldLibrarian == null) {
            throw new ApiException("id not found");
        }
        return OldLibrarian;
    }

    public String checkUsernameandPassword(String username , String password){
        Librarian OldLibrarian = librarianRepository.findLibrarianByUsernameAndPassword(username,password);
        if (OldLibrarian == null) {
           return "Not found";
        }

        return "Found";
    }



    public Librarian getAccount(String email){
        Librarian OldLibrarian = librarianRepository.findLibrarianByEmail(email);
        if (OldLibrarian == null) {
            throw new ApiException("email not found");
        }
        return OldLibrarian;
    }













}
