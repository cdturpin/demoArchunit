package com.keyholesoftware.demo.archunit.controller;

import java.time.LocalDateTime;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArchunitDemoController {

    @GetMapping("/")
    public String handler(Model model) {
        model.addAttribute("date", LocalDateTime.now());
        return "ArchunitDemoApplication is up and running!";
    }
}