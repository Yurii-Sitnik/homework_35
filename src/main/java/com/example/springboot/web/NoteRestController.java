package com.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainRestController {

    @GetMapping
    // @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "INDEX";
    }
    @PostMapping
    // @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index1() {
        return "INDEX1";
    }
}
