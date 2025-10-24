package com.joe.quotegen.quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoicQuoteApiController {

    private final StoicQuoteService service;

    public StoicQuoteApiController(StoicQuoteService service) {
        this.service = service;
    }

    @GetMapping("/api/quotes/stoic")
    public StoicQuote getStoicQuote() {
        return service.fetchRandom();
    }
}
