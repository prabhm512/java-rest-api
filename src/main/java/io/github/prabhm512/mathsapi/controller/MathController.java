package io.github.prabhm512.mathsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.prabhm512.mathsapi.model.Math;

@RestController
public class MathController {

    @GetMapping("/api/maths")
    public Math math() {
        return new Math(1, 2, "plus");
    }
}