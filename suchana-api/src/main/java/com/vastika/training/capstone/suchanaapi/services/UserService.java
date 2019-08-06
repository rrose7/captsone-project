package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.User;

import java.util.List;

public interface AuthorService {
    List<User> findAll();
    User findById(int id);
    User update(User user);
    User createAuthor(User user);
}
