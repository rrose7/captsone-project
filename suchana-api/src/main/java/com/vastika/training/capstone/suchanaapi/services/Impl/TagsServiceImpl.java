package com.vastika.training.capstone.suchanaapi.services.Impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.Tags;
import com.vastika.training.capstone.suchanaapi.repositories.TagsRepository;
import com.vastika.training.capstone.suchanaapi.services.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public List<Tags> findAll() {
        return this.tagsRepository.findAll();
    }

    @Override
    public Tags findById(int id) {
        return this.tagsRepository.getOne(id);
    }

    @Override
    public Tags CreateTag(Tags tags) {
        Tags created = this.tagsRepository.save(tags);
        log.info("Tag Created with Id",tags.getTagId());
        return created;
    }

    @Override
    public void deleteTag(int id) {
        Tags tags = new Tags();
        boolean exists = this.tagsRepository.existsById(id);
        if(!exists){
            throw new SuchanaApiException("No Tag found with id:"+ tags.getTagId(), 404);
        }
        this.tagsRepository.deleteById(id);
    }

    @Override
    public Tags updateTag(Tags tags) {
        boolean exists = this.tagsRepository.existsById(tags.getTagId());
        if (!exists) {
            throw new SuchanaApiException("No Tag found with id:" + tags.getTagId(), 404);
        }
         return this.tagsRepository.save(tags);


    }
}