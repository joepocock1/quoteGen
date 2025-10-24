package com.joe.quotegen.quote;

public interface QuoteProvider {
    /** A short stable id used in URLs, e.g., "local", "stoic" */
    String id();

    /** Human-friendly name, e.g., "Local Sample Quotes", "Stoic Quotes" */
    String displayName();

    /** Return one random quote */
    Quote random();
}
