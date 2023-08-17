package com.example.exweek4day5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Integer id;


    @NotEmpty(message = "This fields is required")
    //@Size(min = 5 ,message = "name must be more that 4")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;


    @NotEmpty(message = "This fields is required au")
    @Column(unique = true)
    private String author;

    @Pattern(regexp = "^(Academic|Mystery|Novel)$" , message = "must be  Novel or Mystery or Academic")
    private String category;


    @Min(1000)
    private Integer ISBN;

    @Min(50)
    private Integer numberOfPages;

}
