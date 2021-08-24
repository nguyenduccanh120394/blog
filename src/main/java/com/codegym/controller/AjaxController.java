package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.category.CategoryService;
import com.codegym.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AjaxController {
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;

@GetMapping("/posts")
    public ResponseEntity<Iterable<Post>> listPost(){
    Iterable<Post>posts=postService.findAll();
    return new ResponseEntity<>(posts, HttpStatus.OK);
}
@GetMapping("/title/{key}")
    public ResponseEntity<Iterable<Post>> findByTitle(@PathVariable("key")String key){
        Iterable<Post> posts=postService.findByName("%"+key+"%");
        if (posts==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(posts,HttpStatus.OK);
}
@GetMapping("/posts/{id}")
public ResponseEntity<Post> deleteSmartphone(@PathVariable Long id) {
        Optional<Post> post = postService.fidById(id);
        if (!post.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(post.get(), HttpStatus.NO_CONTENT);
    }
//@GetMapping("/{id}")
//    public ResponseEntity<Post> findById(@PathVariable Long id){
//        Optional<Post> post = postService.fidById(id);
//        if (!post.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(post.get(),HttpStatus.OK);
//}
}
