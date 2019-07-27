package com.vastika.training.capstone.suchanaapi.controllers;


import com.vastika.training.capstone.suchanaapi.models.Tags;
import com.vastika.training.capstone.suchanaapi.services.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TagsController {
    @Autowired
    private TagsService tagsService;


    @RequestMapping("/tags")
    public ResponseEntity<List<Tags>> getTags() {
        List<Tags> tags = this.tagsService.findAll();
        return new ResponseEntity<>(tags, HttpStatus.OK); // 200
    }

    @RequestMapping("/tags/{id}")
    public ResponseEntity<Tags> getTag(@PathVariable("id") int id) {
        Tags tags = this.tagsService.findById(id);
        log.info("Tag found with id: {}, {}", id, tags);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public ResponseEntity<Tags> createTag(@RequestBody Tags tags) {
        log.info("CreateTag() -> {}", tags);
        Tags saved = this.tagsService.CreateTag(tags);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteTag(@PathVariable("id") int id) {
        log.info("DeleteTag() -> {}", id);
        this.tagsService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tags> updateTag(@RequestBody Tags tags, @PathVariable("id") int id) {
        log.info("updateTag()-> {}", id);
        tags.setTagId(id);
        Tags updated = this.tagsService.updateTag(tags);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
