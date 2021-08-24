package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.category.CategoryService;
import com.codegym.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/create")
    public String showFormCreate(Model model,Pageable pageable){
        model.addAttribute("post",new Post());
        model.addAttribute("categories",categoryService.findAll(pageable));
        return "/post/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Post post,Model model){
        postService.save(post);
        model.addAttribute("post",new Post());
        return "redirect:list";
    }
    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(size = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts",postService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/api")
    public String list(){
        return "/ajax/list";
    }
}
