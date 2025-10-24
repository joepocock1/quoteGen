package com.joe.quotegen.quote;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    private final QuoteService quoteService;

    // Constructor injection: Spring provides the QuoteService here
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes/random")
    public String random(Model model) {
        // Put data in the model so the view can read it
        model.addAttribute("quote", quoteService.randomQuote());
        return "quote"; // looks for templates/quote.html
    }
}
