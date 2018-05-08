package com.challenge.uhaldejm.myapplication.presenters.contracts;

import android.view.View;

public class ToastContract {

    public interface ToastView{
        void showToast(String message);
        void showAlert(String title, String message);
    }

    public interface Presenter {
        void onTakeView(ToastView v);
        void onToastPressed();
        void onAlertPressed();
    }
}
