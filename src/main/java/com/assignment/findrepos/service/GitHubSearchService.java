package com.assignment.findrepos.service;

import com.assignment.findrepos.model.MinimalRepo;
import com.assignment.findrepos.model.GitHubSearchResults;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GitHubSearchService {

    private static final String BASE_URL = "https://api.github.com/";
    private static final String Q_CONNECTOR = ":";
    private GitHubAPIInterface apiInterface;
    @Autowired
    private InputValidator inputValidator;

    public GitHubSearchService(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        apiInterface = retrofit.create(GitHubAPIInterface.class);
    }

    public ResponseEntity<List<MinimalRepo>> getReposByLanguage(String language){
        if(!inputValidator.isValidLanguage(language)){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

        String queryParams = SearchQualifiers.LANGUAGE.getName()+ Q_CONNECTOR + language;
        Call<JsonObject> call = apiInterface.searchRepos(queryParams);
        Response<JsonObject> response;
        try {
            response = call.execute();
        } catch (IOException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(response.isSuccessful()){
            return ResponseEntity
                    .of(Optional
                            .of(new Gson().fromJson(response.body(), GitHubSearchResults.class).getItems()));
        }else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.valueOf(response.code()));
        }
    }

}
