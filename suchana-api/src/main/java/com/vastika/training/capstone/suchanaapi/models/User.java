package com.vastika.training.capstone.suchanaapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vastika.training.capstone.suchanaapi.models.types.RoleType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "articles","password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min =2, max =40)
    @Pattern(regexp = "[a-zA-Z]+")
    private String firstName;
    @NotBlank
    @Size(min=2, max = 40)
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9]+") //to give username as roshan123 but not like roshan.1234
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min=3, max = 500)
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleType role;

    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "user")
    private List<Article> articles;

    @Valid
    @NotNull
    @ManyToMany
    @JoinTable(
            name = "author_category",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")

    )

    private Set<Category> categories;



}
