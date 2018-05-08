package com.challenge.uhaldejm.myapplication.presenters.presenters;

import android.view.View;

import com.challenge.uhaldejm.myapplication.presenters.contracts.GithubContract;

public class GithubPresenter implements GithubContract.Presenter {


    static private GithubPresenter instance;
    private GithubPresenter(){

    }
    public static GithubPresenter getInstance(){
        if (GithubPresenter.instance==null){
            GithubPresenter.instance= new GithubPresenter();
        }
        return GithubPresenter.instance;
    }

    //----------------------------------------------------------------


    GithubContract.GithubView view;

    @Override
    public void onTakeView(GithubContract.GithubView v) {
        this.view=v;
        //TODO
    }
}
