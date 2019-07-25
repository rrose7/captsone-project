package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.models.Tags;
import com.vastika.training.capstone.suchanaapi.repositories.TagsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {
    private static final Logger log = LoggerFactory.getLogger(TagController.class);
    @Autowired
    private TagsRepository tagsRepository;


    @RequestMapping("/tags")
    public ResponseEntity<List<Tags>> getTags() {
        List<Tags> tags = this.tagsRepository.findAll();
        return new ResponseEntity<>(tags, HttpStatus.OK); // 200
    }

    @RequestMapping("/tags/{id}")
    public ResponseEntity<Tags> getTag(@PathVariable("id") int id) {
        Tags tags = this.tagsRepository.getOne(id);
        log.info("Tag found with id: {}, {}", id, tags);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public ResponseEntity<Tags> createTag(@RequestBody Tags tags) {
        log.info("CreateTag() -> {}", tags);
        Tags saved = this.tagsRepository.save(tags);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteTag(@PathVariable("id") int id) {
        log.info("DeleteTag() -> {}", id);
        boolean exists = this.tagsRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.tagsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tags> updateTag(@RequestBody Tags tags, @PathVariable("id") int id) {
        log.info("updateTag()-> {}", id);
        boolean exists = this.tagsRepository.existsById(id);
        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.tagsRepository.save(tags);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
