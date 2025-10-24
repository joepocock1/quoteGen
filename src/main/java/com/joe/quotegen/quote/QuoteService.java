package com.joe.quotegen.quote;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuoteService {

    private final List<String> quotes = List.of(
            "Simplicity is the soul of efficiency. — Austin Freeman",
            "Programs must be written for people to read. — Harold Abelson",
            "Make it work, make it right, make it fast. — Kent Beck",
            "Talk is cheap. Show me the code. — Linus Torvalds",
            "The only way to learn a new programming language is by writing programs in it. — Dennis Ritchie"
    );

    public String randomQuote() {
        int i = ThreadLocalRandom.current().nextInt(quotes.size());
        return quotes.get(i);
    }
}
