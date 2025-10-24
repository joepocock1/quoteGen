package com.joe.quotegen.quote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StoicQuoteService {

    private final RestClient rest;
    private final String baseUrl;

    // Simple local fallback list so the site still works if the API is down
    private static final List<StoicQuote> FALLBACK = List.of(
            new StoicQuote("We suffer more often in imagination than in reality.", "Seneca"),
            new StoicQuote("The impediment to action advances action. What stands in the way becomes the way.", "Marcus Aurelius"),
            new StoicQuote("He who fears death will never do anything worth of a man who is alive.", "Seneca"),
            new StoicQuote("Wealth consists not in having great possessions, but in having few wants.", "Epictetus")
    );

    public StoicQuoteService(
            RestClient.Builder builder,
            @Value("${stoic.api.base-url:https://stoic-quotes.com/api}") String baseUrl
    ) {
        this.rest = builder.build();
        this.baseUrl = baseUrl;
    }

    public StoicQuote fetchRandom() {
        try {
            // Common public API shape: GET {base}/quote returns a single random quote
            StoicQuote q = rest.get()
                    .uri(baseUrl + "/quote")
                    .retrieve()
                    .onStatus(status -> status.isError(), (req, res) ->
                            new IllegalStateException("Stoic API error: " + res.getStatusCode()))
                    .body(StoicQuote.class);


            if (q == null || q.getText() == null || q.getText().isBlank()) {
                return pickFallback();
            }
            return q;
        } catch (RestClientException | IllegalStateException ex) {
            // Network error / parse error → fallback
            return pickFallback();
        }
    }

    private StoicQuote pickFallback() {
        int i = ThreadLocalRandom.current().nextInt(FALLBACK.size());
        return FALLBACK.get(i);
    }
}
