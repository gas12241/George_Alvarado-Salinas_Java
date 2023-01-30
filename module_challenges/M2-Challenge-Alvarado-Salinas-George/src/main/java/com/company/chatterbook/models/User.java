package com.company.chatterbook.models;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * User class that will be used in a Chatterbook Application.
 */
public class User {
    private String name;
    private List<ChatterPost> chatterPosts = new ArrayList<>();

    /**
     * Constructor for a User object.
     * @param name name that will be given
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the User Object.
     * @return Returns a String of the User object's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the User object.
     * @param name name that will set for the User object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the List of ChatterPosts for a User object.
     * @return Returns a list of ChatterPosts for the User object.
     */
    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    /**
     * Set's the chatterPosts for the User object.
     * @param chatterPosts List of chatterPosts that will be set to a user.
     */
    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }
}
