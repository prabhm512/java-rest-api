package io.github.prabhm512.mathsapi.controller;

// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;

// import io.github.prabhm512.mathsapi.model.Math;

@Controller
public class MathViewController {

    // @RequestMapping(value = "/")
    // public String getTemplate() {
    //     return "index";
    // }

    @GetMapping("/") 
    public String getTemplate() {
        // model.addAttribute("math", new Math(1, 1, "plus"));
        return "index";
    }

}