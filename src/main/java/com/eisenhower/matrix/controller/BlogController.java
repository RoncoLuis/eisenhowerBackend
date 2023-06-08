package com.eisenhower.matrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @GetMapping("/eisenhower-article")
    public String eisenhowerArticle(){
        return "blog-articles/eisenhower-matrix-blog";
    }

}
