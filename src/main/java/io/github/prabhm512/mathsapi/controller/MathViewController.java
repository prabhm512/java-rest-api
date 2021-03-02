package io.github.prabhm512.mathsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MathViewController {

    @GetMapping("/") 
    public String getTemplate() {
        return "index";
    }

}