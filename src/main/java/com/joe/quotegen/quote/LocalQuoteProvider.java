package com.joe.quotegen.quote;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class LocalQuoteProvider implements QuoteProvider {

    private final List<Quote> quotes = List.of(
            new Quote("Simplicity is the soul of efficiency.", "Austin Freeman"),
            new Quote("Programs must be written for people to read.", "Harold Abelson"),
            new Quote("Make it work, make it right, make it fast.", "Kent Beck"),
            new Quote("Talk is cheap. Show me the code.", "Linus Torvalds"),
            new Quote("The only way to learn a new programming language is by writing programs in it.", "Dennis Ritchie")
    );

    @Override public String id() { return "local"; }

    @Override public String displayName() { return "Local Sample Quotes"; }

    @Override public Quote random() {
        int i = ThreadLocalRandom.current().nextInt(quotes.size());
        return quotes.get(i);
    }
}
