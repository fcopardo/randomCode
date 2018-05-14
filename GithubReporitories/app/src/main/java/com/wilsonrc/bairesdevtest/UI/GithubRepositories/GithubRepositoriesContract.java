package com.wilsonrc.bairesdevtest.UI.GithubRepositories;

import com.wilsonrc.bairesdevtest.Data.Models.Item;

import java.util.List;

/**
 * Created by W on 8/5/2018.
 */

public interface GithubRepositoriesContract {

    interface Presenter{

        void setView(View view);

        void loadGithubData();

    }

    interface View{

        void setPresenter(Presenter presenter);

        void showRepositories(List<Item> repositories);

        void showNoDataAvailable();

        void showError();

    }

}
