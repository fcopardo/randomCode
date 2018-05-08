package com.challenge.uhaldejm.myapplication.views.activities.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.challenge.uhaldejm.myapplication.R;
import com.challenge.uhaldejm.myapplication.presenters.contracts.ToastContract.ToastView;
import com.challenge.uhaldejm.myapplication.presenters.presenters.ToastPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToastFragment extends Fragment implements ToastView {

    ToastPresenter presenter;

    public ToastFragment() {
        this.presenter = ToastPresenter.getInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_toast, container, false);
        ButterKnife.bind(this,v);
        presenter.onTakeView(this);
        return v;
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlert(String title, String message) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        //TODO
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    @OnClick(R.id.fragment_toast_toast)
    public void onToastClicked(View view) {
        presenter.onToastPressed();
    }

    @OnClick(R.id.fragment_toast_alert)
    public void onAlertClicked(View view) {
        presenter.onAlertPressed();
    }

}
