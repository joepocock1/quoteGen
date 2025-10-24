package com.joe.quotegen.quote;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuoteService {

    private final Map<String, QuoteProvider> providers;

    public QuoteService(List<QuoteProvider> providerList) {
        // Spring injects ALL beans implementing QuoteProvider here
        Map<String, QuoteProvider> map = new LinkedHashMap<>();
        for (QuoteProvider p : providerList) {
            map.put(p.id(), p);
        }
        this.providers = Collections.unmodifiableMap(map);
    }

    public Set<String> providerIds() {
        return providers.keySet();
    }

    public List<QuoteProvider> listProviders() {
        return List.copyOf(providers.values());
    }

    public Quote randomFrom(String providerId) {
        QuoteProvider p = providers.get(providerId);
        if (p == null) throw new NoSuchElementException("Unknown provider: " + providerId);
        return p.random();
    }

    /** A default if you want one */
    public Quote randomDefault() {
        return providers.getOrDefault("local", providers.values().iterator().next()).random();
    }
}
