package com.assignmnet.findrepos.service;

import org.springframework.stereotype.Service;

@Service
public class InputValidator {
    public boolean isValidLanguage(String language){
        return language != null && language.trim().length() != 0;
    }

}
