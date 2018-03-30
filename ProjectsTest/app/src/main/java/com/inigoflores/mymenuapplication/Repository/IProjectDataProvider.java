package com.inigoflores.mymenuapplication.Repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by inigo on 27/03/18.
 */

public interface IProjectDataProvider {
    @GET("repositories")
    Call<MainObject> getProjects(@Query("q") String language, @Query("sort") String sort, @Query("order") String order);
}
