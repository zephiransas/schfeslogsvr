package io.github.zephiransas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping
    public String index() {

        return "index";
    }
}
