package com.challenge.uhaldejm.myapplication.views.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge.uhaldejm.myapplication.R;
import com.challenge.uhaldejm.myapplication.presenters.contracts.GithubContract;
import com.challenge.uhaldejm.myapplication.presenters.presenters.GithubPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GithubFragment extends Fragment implements GithubContract.GithubView {


    @BindView(R.id.fragment_github_list)
    RecyclerView list;

    GithubContract.Presenter presenter;

    public GithubFragment() {
        presenter = GithubPresenter.getInstance();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_github, container, false);
        ButterKnife.bind(this,v);
        presenter.onTakeView(this);
        return v;
    }

    @Override
    public void showList(String projectName) {
//TODO
    }
}
