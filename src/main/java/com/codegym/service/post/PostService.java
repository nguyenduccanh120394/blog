package com.codegym.service.post;

import com.codegym.model.Post;
import com.codegym.repository.IPostRepository;
import com.codegym.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IGeneralService<Post> {
    @Autowired
    private IPostRepository postRepository;
    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> fidById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findByName(String title) {
        return postRepository.findByName(title);
    }
}
