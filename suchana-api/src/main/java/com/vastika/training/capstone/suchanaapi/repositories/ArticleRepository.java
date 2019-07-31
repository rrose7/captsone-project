package com.vastika.training.capstone.suchanaapi.repositories;


import com.vastika.training.capstone.suchanaapi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("from Article a where a.author.id=?1")
    List<Article> findAllByAuthor(Integer authorId);
    @Query("from Article a where a.category.name=?1")
    List<Article> findAllByCategory(String category);
    @Query(value = "select * from article where id in (select article_id from article_tag where tag_id = (select tagId from tags where name = ?1))", nativeQuery = true)
    List<Article> findAllByTag(String tags);

    Article findByTitle(String title);
}
