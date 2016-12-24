package io.github.zephiransas.controller;

import io.github.zephiransas.repository.LiveResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    LiveResultRepository repository;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("results", repository.findAllByOrderByCreatedAtDesc());
        return "index";
    }
}
