package com.example.TubesOOP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // about.html di folder templates
    }
}

