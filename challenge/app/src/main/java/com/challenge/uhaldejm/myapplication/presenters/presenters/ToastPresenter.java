package com.challenge.uhaldejm.myapplication.presenters.presenters;

import android.view.View;

import com.challenge.uhaldejm.myapplication.presenters.contracts.ToastContract;

public class ToastPresenter implements ToastContract.Presenter {


    static private ToastPresenter instance;
    private ToastPresenter(){

    }
    public static ToastPresenter getInstance(){
        if (ToastPresenter.instance==null){
            ToastPresenter.instance= new ToastPresenter();
        }
        return ToastPresenter.instance;
    }

    ToastContract.ToastView view;

    @Override
    public void onTakeView(ToastContract.ToastView v) {
        this.view=v;
    }

    @Override
    public void onToastPressed() {
        this.view.showToast("Mensaje toast!");
    }

    @Override
    public void onAlertPressed() {
        this.view.showAlert("Titulo!", "This is an alert");
    }

}
