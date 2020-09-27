package com.assignmnet.findrepos.service;

public enum SearchQualifiers {
    LANGUAGE("language");

    private String name;

    SearchQualifiers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
