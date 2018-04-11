package com.baires.project.bairesdevproject.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baires.project.bairesdevproject.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndroidProjectsFragment extends Fragment {


    public AndroidProjectsFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android_projects, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    public static AndroidProjectsFragment getInstance(){
        return new AndroidProjectsFragment();
    }
}
