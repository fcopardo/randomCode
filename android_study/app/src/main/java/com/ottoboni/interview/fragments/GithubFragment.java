package com.ottoboni.interview.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ottoboni.interview.R;
import com.ottoboni.interview.adapters.GithubAdapter;
import com.ottoboni.interview.data.GitHubProject;
import com.ottoboni.interview.data.GitHubResponse;
import com.ottoboni.interview.data.remote.RemoteRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by caoj on 28/03/18.
 */

public class GithubFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private GithubAdapter mAdapter;

    private List<GitHubProject> mProjects = new ArrayList<>();

    public GithubFragment() {}

    public static GithubFragment newInstance() {
        GithubFragment fragment = new GithubFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RemoteRequest remoteRequest = new RemoteRequest();

        remoteRequest.getRepositories(new RemoteRequest.LoadRepositoriesCallback() {
            @Override
            public void onRepositoriesLoaded(GitHubResponse repositories) {
                Log.d("xablau", "this should work");
                updateItems(repositories.getProjects());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_github, container, false);

        initLayout(rootView);

        return rootView;
    }

    private void initLayout(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new GithubAdapter(mProjects, getContext(), new GithubAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(GitHubProject project) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(project.getProjectUrl()));
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }

    private void updateItems(GitHubProject[] projects) {
        mProjects.clear();
        mProjects.addAll(Arrays.asList(projects));
        mAdapter.notifyDataSetChanged();
    }

}
