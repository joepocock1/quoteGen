package com.joe.quotegen.quote;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoicQuotePageController {
    private final StoicQuoteService service;

    public StoicQuotePageController(StoicQuoteService service) {
        this.service = service;
    }

    @GetMapping("/quotes/stoic")
    public String showStoic(Model model) {
        StoicQuote q = service.fetchRandom();
        model.addAttribute("quote", q.getText());
        model.addAttribute("author", q.getAuthor());
        return "stoic-quote"; // <-- must match the template filename (without .html)
    }
}
