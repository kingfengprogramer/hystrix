package com.kingfeng.hystrix.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kingfeng
 * @date 2019年03月16日 22:19
 * description
 */
@Controller
@RequestMapping("/book")
public class BookController {


    @GetMapping("/list")
    public String list(Model model) {
        List<String> bookList = new ArrayList<>();
        bookList.add("红楼梦");
        bookList.add("西游记");
        bookList.add("水浒传");
        bookList.add("三国演义");
        model.addAttribute("bookList",  bookList);
        return "book/list";
    }
}
