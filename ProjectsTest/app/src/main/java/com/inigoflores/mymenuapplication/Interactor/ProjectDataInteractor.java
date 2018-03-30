package com.inigoflores.mymenuapplication.Interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inigoflores.mymenuapplication.Presenter.IDataProjectPresenter;
import com.inigoflores.mymenuapplication.Repository.IProjectDataProvider;
import com.inigoflores.mymenuapplication.Repository.MainObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by inigo on 27/03/18.
 */

public class ProjectDataInteractor implements IProjectDataInteractor {

    public String baseUrl = "https://api.github.com/search/";
    IDataProjectPresenter presenter;

    public ProjectDataInteractor(IDataProjectPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void requesDataInteractor(String q, String sort, String order) {
        OkHttpClient client = new OkHttpClient();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IProjectDataProvider service = retrofit.create(IProjectDataProvider.class);

        Call<MainObject> messagesCall = service.getProjects(q, sort, order);

        if(messagesCall != null){
            messagesCall.enqueue(new Callback<MainObject>() {
                @Override
                public void onResponse(Call<MainObject> call, Response<MainObject> response) {
                    presenter.responseDataProject(response.body());
                }

                @Override
                public void onFailure(Call<MainObject> call, Throwable t) {

                }
            });
        }
    }
}
