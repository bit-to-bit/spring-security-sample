package org.java.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AfterLogin {
    @GetMapping("/")
    public String getStart() {
            return "redirect:/login";
        }
}
