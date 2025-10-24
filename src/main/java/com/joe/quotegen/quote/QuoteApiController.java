package com.joe.quotegen.quote;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteApiController {

    private final QuoteService service;

    public QuoteApiController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/providers")
    public List<String> providers() {
        return service.listProviders().stream().map(QuoteProvider::id).toList();
    }

    @GetMapping("/{provider}/random")
    public Quote random(@PathVariable String provider) {
        return service.randomFrom(provider);
    }
}
