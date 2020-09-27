package com.assignment.findrepos.controller;

import com.assignment.findrepos.model.MinimalRepo;
import com.assignment.findrepos.service.GitHubSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github/repos/")
public class SearchController {

    @Autowired
    private GitHubSearchService searchService;

    @GetMapping(path = "/search/{language}")
    public ResponseEntity<List<MinimalRepo>> searchRepositories(@NonNull @PathVariable String language){
        return searchService.getReposByLanguage(language);
    }

}
