package com.challenge.uhaldejm.myapplication.presenters.presenters;

import android.util.Log;
import android.view.View;

import com.challenge.uhaldejm.myapplication.presenters.contracts.GoogleContract;

public class GooglePresenter implements GoogleContract.Presenter {


    static private GooglePresenter instance;
    private GooglePresenter(){

    }
    public static GooglePresenter getInstance(){
        if (GooglePresenter.instance==null){
            GooglePresenter.instance= new GooglePresenter();
        }
        return GooglePresenter.instance;
    }

    GoogleContract.GoogleView view;

    @Override
    public void onTakeView(GoogleContract.GoogleView v) {
Log.e("MSJ", "OnTake");
        this.view = v;
        this.init();
    }

    private void init(){
        view.showUrl("www.google.com");
    }
}
