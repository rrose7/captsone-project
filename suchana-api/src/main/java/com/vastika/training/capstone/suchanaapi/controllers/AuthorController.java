package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.exceptions.handler.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.models.dtos.CreateUserRequest;
import com.vastika.training.capstone.suchanaapi.models.types.RoleType;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import com.vastika.training.capstone.suchanaapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
public class AuthorController {
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/authors")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateAuthor(@RequestBody User user, @PathVariable("id") int id) {
        log.info("updateAuthor() -> {}", id);
        user.setId(id);
        return new ResponseEntity<>(this.userService.update(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<User> createAuthor(@Valid @RequestBody CreateUserRequest user,
                                             BindingResult result) {
        log.info("createAuthor() -> {}", user);
        if (result.hasErrors()) {
            throw new SuchanaDataException("Invalid Payload!", result.getFieldErrors());
        }

        User userToCreate = new User();
        userToCreate.setArticles(null);
        userToCreate.setFirstName(user.getFirstName());
        userToCreate.setLastName(user.getLastName());
        userToCreate.setUsername(user.getUsername());
        userToCreate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToCreate.setDateCreated(LocalDateTime.now());
        userToCreate.setRole(RoleType.ROLE_AUTHOR);
        userToCreate.setCategories(user.getCategories());

        return new ResponseEntity<>(this.userService.createAuthor(userToCreate), HttpStatus.CREATED);
    }

    // /api/v1/users/{id}/accounts
    @PostMapping("/authors/{id}/articles")
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article,
                                                 BindingResult result,
                                                 @PathVariable("id") int authorId) {
        log.info("createArticle() -> authorId: {}", authorId);

        if (result.hasErrors()) {
            throw new SuchanaDataException("Invalid Payload!", result.getFieldErrors());
        }

        article.setPublishDate(LocalDateTime.now());

        User user = this.userService.findById(authorId);

        article.setUser(user);
        Article saved = this.articleService.save(article);

        log.info("Article saved -> id: {}", saved.getId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/authors/{id}/articles")
    public ResponseEntity<List<Article>> getArticlesByAuthor(@PathVariable("id") int authorId) {
        return new ResponseEntity<>(this.articleService.findByAuthorId(authorId),
                HttpStatus.OK);
    }
}
