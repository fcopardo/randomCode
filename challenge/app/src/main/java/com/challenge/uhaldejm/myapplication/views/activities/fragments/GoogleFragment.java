package com.challenge.uhaldejm.myapplication.views.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.challenge.uhaldejm.myapplication.R;
import com.challenge.uhaldejm.myapplication.presenters.contracts.GoogleContract;
import com.challenge.uhaldejm.myapplication.presenters.presenters.GooglePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleFragment extends Fragment implements GoogleContract.GoogleView {


    @BindView(R.id.fragment_google_webview)
    WebView webview;

    GoogleContract.Presenter presenter;

    public GoogleFragment() {
        presenter= GooglePresenter.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_google, container, false);
        ButterKnife.bind(this,v);
        presenter.onTakeView(this);
        return v;
    }

    @Override
    public void showUrl(String url) {
        Log.e("MSJ" , "showing "+ url);
        this.webview.loadUrl(url);
    }
}
