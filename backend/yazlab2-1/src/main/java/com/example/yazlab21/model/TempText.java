package com.example.yazlab21.model;

public class TempText {
    private final String text;
    private final long elapsedTime;

    public TempText(String text, long elapsedTime) {
        this.text = text;
        this.elapsedTime = elapsedTime;
    }

    public String getText() {
        return text;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}
