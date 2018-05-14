package com.wilsonrc.bairesdevtest.UI.GithubRepositories;

import android.util.Log;

import com.wilsonrc.bairesdevtest.Data.Api.GithubService;
import com.wilsonrc.bairesdevtest.Data.Models.GithubResponse;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by W on 8/5/2018.
 */

public class GithubRepositoriesPresenter implements GithubRepositoriesContract.Presenter {

    GithubRepositoriesContract.View mView;

    private String TAG = GithubRepositoriesPresenter.class.getName();
    @Override
    public void setView(GithubRepositoriesContract.View view) {
        mView = view;
    }

    @Override
    public void loadGithubData() {
        GithubService githubService =  new GithubService();
        githubService.getApi()
                .getGithubRepositories("tetris+language:kotlin", "stars" , "desc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<GithubResponse>() {
                    @Override
                    public void onSuccess(GithubResponse githubResponse) {
                        if(githubResponse == null){
                            mView.showNoDataAvailable();
                        }else{
                            mView.showRepositories(githubResponse.getItems());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        mView.showError();
                    }
                });
    }
}
