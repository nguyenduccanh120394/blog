package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("category")Category category,Model model){
        categoryService.save(category);
        model.addAttribute("category",new Category());
        return "redirect:list";
    }
    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(size = 3)Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories",categoryService.findAll(pageable));
        return modelAndView;
    }
}
