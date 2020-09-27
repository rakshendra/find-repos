package com.assignment.findrepos.service;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubAPIInterface {

    @GET("search/repositories")
    Call<JsonObject> searchRepos(@Query("q") String queryParams);

}
