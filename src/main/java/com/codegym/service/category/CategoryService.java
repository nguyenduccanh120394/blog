package com.codegym.service.category;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements IGeneralService<Category> {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> fidById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findByName(String title) {
        return null;
    }
}
