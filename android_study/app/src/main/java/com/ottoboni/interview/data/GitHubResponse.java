package com.ottoboni.interview.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by caoj on 28/03/18.
 */

public class GitHubResponse {
    @SerializedName("items")
    GitHubProject[] projects;

    public GitHubProject[] getProjects() {
        return projects;
    }

    public void setProjects(GitHubProject[] projects) {
        this.projects = projects;
    }
}
