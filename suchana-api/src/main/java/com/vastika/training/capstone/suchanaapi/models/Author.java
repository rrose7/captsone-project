package com.vastika.training.capstone.suchanaapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "articles"})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min =2, max =40)
    @Pattern(regexp = "[a-zA-Z]")
    private String firstName;
    @Size(min=2, max = 40)
    @Pattern(regexp = "[a-zA-Z}")
    private String lastName;
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "author")
    private List<Article> articles;

    @ManyToMany
    @JoinTable(
            name = "author_category",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")

    )

    private Set<Category> categories;



}
