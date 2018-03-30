package com.ottoboni.interview.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by caoj on 28/03/18.
 */

public class GitHubProject {

    @SerializedName("name")
    private String projectName;

    @SerializedName("html_url")
    private String projectUrl;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
}
