package com.kingfeng.hystrix.reading.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description description
 * @author kingfeng
 * @date 2019年03月17日 11:19
 * @version 1.0
 */
@RestController
@RequestMapping("/read")
public class ReadController {

    @GetMapping(value = "/book-list")
    @HystrixCommand(fallbackMethod = "bookListFallback")
    public String bookList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8090/book/list", String.class);
    }

    public String bookListFallback() {
        return "调用 bookstore 失败，请稍后再试！";
    }



}
