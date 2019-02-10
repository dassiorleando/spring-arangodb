package xyz.dassiorleando.arangodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.dassiorleando.arangodb.domain.Article;
import xyz.dassiorleando.arangodb.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

/**
 * Article service for basic CRUD operations
 * @author dassiorleando
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * To create an article
     * @param article
     * @return article
     */
    public Article save(Article article) {
        // Save the article
        return articleRepository.save(article);
    }

    /**
     * To update an article
     * @param article
     * @return boolean true if it was successfully updated
     */
    public Article update(Article article) {
        String articleId = article.getId();
        if (articleId == null || articleId.isEmpty()) return null;

        // Update the article
        return articleRepository.save(article);
    }

    /**
     * Find a single article by it's id
     * @param articleId
     * @return article
     */
    public Optional<Article> findOne(String articleId) {
        if (articleId == null || articleId.isEmpty()) return Optional.empty();
        return articleRepository.findById(articleId);
    }

    /**
     * Find all saved articles so far
     * @return
     */
    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    /**
     * Delete a single article by its id
     * @param articleId
     */
    public void delete(String articleId) {
        if (articleId == null || articleId.isEmpty()) return;
        articleRepository.deleteById(articleId);
    }
}
