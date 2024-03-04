package com.ism.ismecom.services.impl;

import com.ism.ismecom.data.entities.Article;
import com.ism.ismecom.data.repositories.ArticleRepository;
import com.ism.ismecom.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//injection de dependance
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    @Override
    public List<Article> getArticlesFormCommande() {
        return articleRepository.findAllByActiveTrue();
    }
}
