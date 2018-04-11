package com.baires.project.bairesdevproject.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.baires.project.bairesdevproject.R;
import com.baires.project.bairesdevproject.fragments.AndroidProjectsFragment;
import com.baires.project.bairesdevproject.fragments.ButtonsFragment;
import com.baires.project.bairesdevproject.fragments.GoogleSiteFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.container)
    FrameLayout frameLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    Fragment currentFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);

                        if(menuItem.getItemId() == R.id.sidebar_opt1){
                            currentFragment = GoogleSiteFragment.getInstance();
                        }else  if(menuItem.getItemId() == R.id.sidebar_opt2){
                            currentFragment = ButtonsFragment.getInstance();
                        } else  if(menuItem.getItemId() == R.id.sidebar_opt3){
                            currentFragment = AndroidProjectsFragment.getInstance();
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, currentFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });

        currentFragment = GoogleSiteFragment.getInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, currentFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
