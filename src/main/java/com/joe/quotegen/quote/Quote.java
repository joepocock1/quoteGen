package com.joe.quotegen.quote;

public record Quote(String text, String author) {
    @Override public String toString() {
        return "\"" + text + "\" — " + (author == null ? "Unknown" : author);
    }
}