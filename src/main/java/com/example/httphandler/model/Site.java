package com.example.httphandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Site {
    private final URLEntity urlEntity;
    private final String serverInformation;
    private final List<String> linkTree;

    public Site(@JsonProperty("url") URLEntity urlEntity,
                @JsonProperty("serverInformation") String serverInformation,
                @JsonProperty("linkTree") List<String> linkTree) {
        this.urlEntity = urlEntity;
        this.serverInformation = serverInformation;
        this.linkTree = linkTree;
    }

    public URLEntity getUrl() {
        return urlEntity;
    }

    public String getServerInformation() {
        return serverInformation;
    }

    public List<String> getLinkTree() {
        return linkTree;
    }
}
