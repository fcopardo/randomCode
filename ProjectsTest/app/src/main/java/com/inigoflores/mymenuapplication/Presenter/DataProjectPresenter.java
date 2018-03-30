package com.inigoflores.mymenuapplication.Presenter;

import com.inigoflores.mymenuapplication.IViewProject;
import com.inigoflores.mymenuapplication.Interactor.IProjectDataInteractor;
import com.inigoflores.mymenuapplication.Interactor.ProjectDataInteractor;

/**
 * Created by inigo on 27/03/18.
 */

public class DataProjectPresenter implements IDataProjectPresenter {

    IViewProject viewProject;
    IProjectDataInteractor projectDataInteractor;

    public DataProjectPresenter(IViewProject viewProject){
        this.viewProject = viewProject;
        projectDataInteractor = new ProjectDataInteractor(this);
    }

    @Override
    public void requestDataProject(String q, String sort, String order) {
        projectDataInteractor.requesDataInteractor(q,sort,order);
    }

    @Override
    public void responseDataProject(Object object) {
        viewProject.responseDataProjects(object);
    }
}
