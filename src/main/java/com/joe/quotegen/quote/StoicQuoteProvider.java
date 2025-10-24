package com.joe.quotegen.quote;

import org.springframework.stereotype.Component;

@Component
public class StoicQuoteProvider implements QuoteProvider {

    private final StoicQuoteService api;

    public StoicQuoteProvider(StoicQuoteService api) {
        this.api = api;
    }

    @Override public String id() { return "stoic"; }

    @Override public String displayName() { return "Stoic Quotes"; }

    @Override public Quote random() {
        // Convert from StoicQuote to our unified Quote model
        var q = api.fetchRandom();
        return new Quote(q.getText(), q.getAuthor());
    }
}
