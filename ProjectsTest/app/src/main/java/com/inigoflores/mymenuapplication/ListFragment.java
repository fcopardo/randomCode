package com.inigoflores.mymenuapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inigoflores.mymenuapplication.Presenter.DataProjectPresenter;
import com.inigoflores.mymenuapplication.Presenter.IDataProjectPresenter;
import com.inigoflores.mymenuapplication.Repository.MainObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements IViewProject {

    IDataProjectPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        presenter = new DataProjectPresenter(this);
        presenter.requestDataProject("android+language:kotlin","stars","desc");

        return view;
    }

    @Override
    public void responseDataProjects(Object object) {
        if(object != null){
            MainObject mainObject = (MainObject)object;
        }
    }
}
