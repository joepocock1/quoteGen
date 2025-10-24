package com.joe.quotegen.quote;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quotes")
public class QuotePageController {

    private final QuoteService service;

    public QuotePageController(QuoteService service) {
        this.service = service;
    }

    // Handles browser routes like /quotes/local or /quotes/stoic
    @GetMapping("/{provider}")
    public String show(@PathVariable String provider, Model model) {
        Quote q = service.randomFrom(provider);
        model.addAttribute("quote", q.text());
        model.addAttribute("author", q.author());
        model.addAttribute("provider", provider);
        return "quote-by-provider"; // looks for templates/quote-by-provider.html
    }
}
