package com.ottoboni.interview.data.remote;

import com.ottoboni.interview.data.GitHubResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by caoj on 28/03/18.
 */

public interface ApiRequest {

    @GET("/search/repositories?q=android+language:kotlin&sort=stars&order=desc")
    Call<GitHubResponse> getRepositories();
}
