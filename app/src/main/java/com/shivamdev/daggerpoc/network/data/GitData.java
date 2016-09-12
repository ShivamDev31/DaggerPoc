package com.shivamdev.daggerpoc.network.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shivam on 11/9/16.
 */

public class GitData {
    @SerializedName("name")
    public String repoName;

    @SerializedName("description")
    public String repoDesc;

    @SerializedName("html_url")
    public String htmlUrl;

    @Override
    public String toString() {
        return "Repo Name : " + repoName + " \n" +
                "Repo Desc : " + repoDesc + " \n" +
                "Repo Url : " + htmlUrl + " \n\n";
    }
}
