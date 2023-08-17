package com.example.exweek4day5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Librarian {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Integer id;


    @NotEmpty(message = "This fields is required")
    //@Size(min = 5 ,message = "name must be more that 4")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;


    @NotEmpty(message = "This fields is required")
    @Size(min = 5, message = "must be more that 4")
    @Column(unique = true)
    private String username;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,}$" , message = "the password must have at least 1 number, 1 letter (upper or lower case) and min 6 char")
    @NotEmpty(message = "This fields is required")
    private String password;

    @Email
    @NotEmpty(message = "The email must not be empty")
    private String email;

}
