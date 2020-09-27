package com.assignmnet.findrepos.model;

import org.eclipse.egit.github.core.Repository;

import java.util.List;

public class GitHubSearchResults {

    private int total_count;
    private boolean incomplete_results;
    private List<MinimalRepo> items;

    public GitHubSearchResults() {
    }

    public GitHubSearchResults(int total_count, boolean incomplete_results, List<MinimalRepo> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<MinimalRepo> getItems() {
        return items;
    }

    public void setItems(List<MinimalRepo> items) {
        this.items = items;
    }
}
