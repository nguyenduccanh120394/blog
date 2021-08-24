package com.codegym.service;

import com.codegym.model.Post;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);
    Iterable<T> findAll();
    Optional<T> fidById(Long id);
    void save(T t);
    void remove(Long id);
    Iterable<Post>findByName(String title);
}
