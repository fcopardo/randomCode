package com.challenge.uhaldejm.myapplication.presenters.contracts;

import android.view.View;

public class GoogleContract {

    public interface GoogleView{
        void showUrl(String url);
    }

    public interface Presenter {
        void onTakeView(GoogleView v);
    }

}
