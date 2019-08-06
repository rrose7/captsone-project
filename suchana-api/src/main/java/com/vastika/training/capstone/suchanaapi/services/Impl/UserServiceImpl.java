package com.vastika.training.capstone.suchanaapi.services.Impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.repositories.AuthorRepository;
import com.vastika.training.capstone.suchanaapi.repositories.CategoryRepository;
import com.vastika.training.capstone.suchanaapi.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<User> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public User update(User user) {
        boolean exists = this.authorRepository.existsById(user.getId());
        if (!exists) {
            throw new SuchanaApiException("No Author found with id:" + user.getId(), 404);
        }
        if (user.getCategories() == null) {
            user.setCategories(new HashSet<>());
        }
        if (user.getArticles() == null) {
            user.setArticles(new ArrayList<>());
        }
        return this.authorRepository.save(user);

    }
    @Override
    public User createAuthor(User user) {
        user.setArticles(new ArrayList<>());

        // if no categories are supplied, then set empty categories
        if (user.getCategories() == null) {
            user.setCategories(new HashSet<>());
        } else {
            // need to make sure that category exists
            List<Category> existingCategories = this.categoryRepository.findAll();

            for (Category upcoming: user.getCategories()) {
                if (!existingCategories.contains(upcoming)) {
                    throw new SuchanaApiException("No category exists with id: " + upcoming.getId() + ", name: " + upcoming.getName(), 400);
                }
            }
        }

        User userInDb = this.authorRepository.findByUsername(user.getUsername());

        if (userInDb != null) {
            throw new SuchanaApiException("Author exists with username: " + user.getUsername(), 409);
        }

        User created = this.authorRepository.save(user);

        log.info("Author created with id : {}", created.getId());

        return created;
    }
}