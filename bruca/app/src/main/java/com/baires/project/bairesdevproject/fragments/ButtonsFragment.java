package com.baires.project.bairesdevproject.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.baires.project.bairesdevproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtonsFragment extends Fragment {


    public ButtonsFragment() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_toast)
    public void showToast(View v){
        Toast.makeText(getActivity(), R.string.msg_toast, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_alert)
    public void showAlert(View v){
        new AlertDialog.Builder(getActivity())
                .setMessage(R.string.msg_alert)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    public static ButtonsFragment getInstance(){
        return new ButtonsFragment();
    }
}
