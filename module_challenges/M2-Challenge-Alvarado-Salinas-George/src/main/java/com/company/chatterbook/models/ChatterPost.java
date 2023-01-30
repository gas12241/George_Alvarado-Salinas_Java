package com.company.chatterbook.models;

/**
 * ChatterPost class that will b
 */
public class ChatterPost {
    private String text;

    /**
     * Constructor for a ChatterPost object. Takes a String for the text.
     * @param text text that will be included in a ChatterPost object.
     */
    public ChatterPost(String text) {
        this.text = text;
    }

    /**
     * Gets the text of a ChatterPost object.
     * @return Returns the text of a ChatterPost Object.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text for a ChatterPost
     * @param text text that will be included in a ChatterPost object.
     */
    public void setText(String text) {
        this.text = text;
    }
}
