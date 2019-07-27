package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Tags;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TagsService {
    List<Tags> findAll();
    Tags findById( int id);
    Tags CreateTag(Tags tags);
    void deleteTag(int id);
    Tags updateTag(Tags tags);
}
