package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.repositories.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleRepository articleRepository;


    @RequestMapping("/articles")
    public ResponseEntity<List<Article>> getArticle() {
        List<Article> articles = this.articleRepository.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK); // 200
    }

    @RequestMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable("id") int id) {
        Article article = this.articleRepository.getOne(id);
        log.info("article found with id: {}, {}", id, article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ResponseEntity<Article> createTag(@RequestBody Article article) {
        log.info("CreateArticle() -> {}", article);
        Article saved = this.articleRepository.save(article);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") int id) {
        log.info("DeleteArticle() -> {}", id);
        boolean exists = this.articleRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.articleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Article> updateArticle(@RequestBody Article article, @PathVariable("id") int id) {
        log.info("updateArticle()-> {}", id);
        boolean exists = this.articleRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.articleRepository.save(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

