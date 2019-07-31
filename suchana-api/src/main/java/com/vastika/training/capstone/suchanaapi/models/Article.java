package com.vastika.training.capstone.suchanaapi.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 10, max = 500)
    @Column(unique = true)
    private String title;
    @Size(min = 10, max = 1000)
    @NotBlank
    private String content;
    private LocalDate publishDate;
    @Min(0)
    private long noOfViews;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "article_tag",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tags> tags;

    @Valid
    @OneToOne
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
