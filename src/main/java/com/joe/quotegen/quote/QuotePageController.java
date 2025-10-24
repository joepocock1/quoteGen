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

    @GetMapping("/quotes")               // /quotes → redirect to the only category we have
    public String quotesRoot() {
        return "redirect:/quotes/stoic";
    }

    @GetMapping("stoic")         // render the stoic page
    public String stoic(Model model) {
        Quote q = service.randomFrom("stoic");
        model.addAttribute("quote", q.text());
        model.addAttribute("author", q.author());
        return "stoic-quote";            // <-- matches templates/stoic-quote.html
    }
}
