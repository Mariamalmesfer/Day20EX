package com.example.exweek4day5.Repository;

import com.example.exweek4day5.Model.Book;
import com.example.exweek4day5.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById (Integer id);

    Librarian findLibrarianByEmail(String email);

    Librarian findLibrarianByUsernameAndPassword(String username ,String password );
}
