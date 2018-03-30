package com.ottoboni.interview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ottoboni.interview.R;


public class GoogleFragment extends Fragment {

    private WebView mWebView;

    public GoogleFragment() {
        // Required empty public constructor
    }


    public static GoogleFragment newInstance() {
        GoogleFragment fragment = new GoogleFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_google, container, false);
        initLayout(rootView);

        return rootView;
    }

    private void initLayout(View view) {
        mWebView = (WebView) view.findViewById(R.id.web_view);

        mWebView.loadUrl("https://www.google.com");

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

}
