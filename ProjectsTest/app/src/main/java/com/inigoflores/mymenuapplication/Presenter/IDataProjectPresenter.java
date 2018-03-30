package com.inigoflores.mymenuapplication.Presenter;

/**
 * Created by inigo on 27/03/18.
 */

public interface IDataProjectPresenter {
    void requestDataProject(String q, String sort, String order);
    void responseDataProject(Object object);
}
