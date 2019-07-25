package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryRepository categoryRepository;


    @RequestMapping("/category")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK); // 200
    }

    @RequestMapping("/category/{id}")
    public ResponseEntity<Category> getTag(@PathVariable("id") int id) {
        Category category = this.categoryRepository.getOne(id);
        log.info("Tag found with id: {}, {}", id, category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Category> createTag(@RequestBody Category category) {
        log.info("Createcategory() -> {}", category);
        Category saved = this.categoryRepository.save(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
        log.info("DeleteCategory() -> {}", id);
        boolean exists = this.categoryRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.categoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateTag(@RequestBody Category category, @PathVariable("id") int id) {
        log.info("updatecategory()-> {}", id);
        boolean exists = this.categoryRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
