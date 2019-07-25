package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.models.Author;
import com.vastika.training.capstone.suchanaapi.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping("/author")
    public ResponseEntity<List<Author>> getAuthor() {
        List<Author> author = this.authorRepository.findAll();
        return new ResponseEntity<>(author, HttpStatus.OK); // 200
    }

    @RequestMapping("/author/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") int id) {
        Author author = this.authorRepository.getOne(id);
        log.info("Tag found with id: {}, {}", id, author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public ResponseEntity<Author> createTag(@RequestBody Author author) {
        log.info("CreateAuthor() -> {}", author);
        Author saved = this.authorRepository.save(author);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteTag(@PathVariable("id") int id) {
        log.info("DeleteAuthor() -> {}", id);
        boolean exists = this.authorRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.authorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }
    @RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> updateTag(@RequestBody Author author, @PathVariable("id") int id){
        log.info("updateAuthor()-> {}", id);
        boolean exists = this.authorRepository.existsById(id);
        if(!exists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.authorRepository.save(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

