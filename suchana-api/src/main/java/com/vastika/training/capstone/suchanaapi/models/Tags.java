package com.vastika.training.capstone.suchanaapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tags")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;
    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 40)
    private String name;
}
