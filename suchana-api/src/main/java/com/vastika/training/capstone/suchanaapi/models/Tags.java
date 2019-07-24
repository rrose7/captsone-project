package com.vastika.training.capstone.suchanaapi.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;
    private String name;
}
