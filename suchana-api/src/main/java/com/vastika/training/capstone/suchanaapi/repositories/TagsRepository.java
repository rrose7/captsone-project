package com.vastika.training.capstone.suchanaapi.repositories;


import com.vastika.training.capstone.suchanaapi.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {
}
