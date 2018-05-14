package com.challenge.uhaldejm.myapplication.presenters.contracts;

import android.view.View;

public class GithubContract {

    public interface GithubView{
        void showList(String projectName);
    }

    public interface Presenter {
        void onTakeView(GithubView v);
    }

}
