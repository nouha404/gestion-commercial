package com.ism.ismecom.data.repositories;

import com.ism.ismecom.data.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}