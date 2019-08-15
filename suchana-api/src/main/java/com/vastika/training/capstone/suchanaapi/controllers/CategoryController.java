package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.exceptions.handler.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value ="/categories")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK); // 200
    }

    @RequestMapping(value = "/categories/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") int id) {
        Category category = this.categoryService.findById(id);
        log.info("Tag found with id: {}, {}", id, category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category, BindingResult result) {
        if(result.hasErrors()){
            throw new SuchanaDataException("Invalid Payload", result.getFieldErrors());
        }
        return new ResponseEntity<>(this.categoryService.createCategory(category), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
        log.info("DeleteCategory() -> {}", id);
        this.categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("id") int id) {
        log.info("updatecategory()-> {}", id);
        category.setId(id);
        return new ResponseEntity<>(this.categoryService.update(category),HttpStatus.OK);
    }
}
