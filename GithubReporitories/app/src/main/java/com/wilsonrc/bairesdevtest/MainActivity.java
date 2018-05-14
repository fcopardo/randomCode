package com.wilsonrc.bairesdevtest;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.wilsonrc.bairesdevtest.Data.Models.Item;
import com.wilsonrc.bairesdevtest.UI.GithubRepositories.ItemFragment;
import com.wilsonrc.bairesdevtest.UI.TwoButtonsFragment;
import com.wilsonrc.bairesdevtest.UI.WebViewFragment;
import com.wilsonrc.bairesdevtest.Utils.ActivityUtils;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    FrameLayout mainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainContainer = findViewById(R.id.main_container);

        FragmentManager fragmentManager = getSupportFragmentManager();

//        TwoButtonsFragment twoButtonsFragment = TwoButtonsFragment.newInstance();
//        ActivityUtils.addFragmentToActivity(fragmentManager ,twoButtonsFragment,R.id.main_container);

//        WebViewFragment webViewFragment = WebViewFragment.newInstance("https://www.google.com.do/");
//        ActivityUtils.addFragmentToActivity(fragmentManager ,webViewFragment , R.id.main_container);

        ItemFragment itemFragment = ItemFragment.newInstance(1);
        ActivityUtils.addFragmentToActivity(fragmentManager, itemFragment, R.id.main_container);


    }

    @Override
    public void onListFragmentInteraction(Item item) {
        WebViewFragment webViewFragment = WebViewFragment.newInstance(item.getUrl());
        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(),webViewFragment , R.id.main_container);
    }


}
