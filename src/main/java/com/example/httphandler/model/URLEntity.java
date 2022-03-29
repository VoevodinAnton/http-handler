package com.example.httphandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class URLEntity {
    private final String name;

    public URLEntity(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
