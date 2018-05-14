package com.wilsonrc.bairesdevtest.Data.Api;

import com.wilsonrc.bairesdevtest.Data.Models.GithubResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by W on 8/5/2018.
 */

public class GithubService extends BaseService {

    public interface GithubAPI{

        @GET("search/repositories")
        Single<GithubResponse> getGithubRepositories(@Query("q") String query,@Query("sort") String sort, @Query("order") String order);


    }

    public GithubAPI getApi(){
        return retrofit.create(GithubAPI.class);
    }

}
