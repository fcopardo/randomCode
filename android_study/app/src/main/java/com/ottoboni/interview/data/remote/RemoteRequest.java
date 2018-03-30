package com.ottoboni.interview.data.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.ottoboni.interview.data.GitHubProject;
import com.ottoboni.interview.data.GitHubResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by caoj on 28/03/18.
 */

public class RemoteRequest {

    public void getRepositories(@NonNull final LoadRepositoriesCallback callback) {
        String query = "android+language:kotlin";
        String sort = "stars";
        String order = "desc";
        ApiClient.createRequests().getRepositories()
                .enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                callback.onRepositoriesLoaded(response.body());
            }

            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {
                Log.d("carlosottoboni", "RemoteBooksRepository - onFailure: ");

            }
        });
    }

    public interface LoadRepositoriesCallback {

        void onRepositoriesLoaded(GitHubResponse repositories);
    }
}
