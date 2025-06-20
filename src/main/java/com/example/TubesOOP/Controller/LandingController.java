package com.example.TubesOOP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/")
    public String redirectToLanding() {
        return "redirect:/landing";
    }

    @GetMapping("/landing")
    public String landingPage() {
        return "landingpage";
    }
}
