package com.joe.quotegen.quote;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoicQuote {
    // Some APIs use "quote", others use "text" – accept both.
    @JsonAlias({"quote", "text"})
    private String text;

    private String author;

    public StoicQuote() {}

    public StoicQuote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() { return text; }
    public String getAuthor() { return author; }

    @Override public String toString() {
        return "\"" + text + "\" — " + (author == null ? "Unknown" : author);
    }
}
