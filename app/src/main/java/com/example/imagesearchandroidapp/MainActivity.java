package com.example.imagesearchandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /* -----------------------------------------------------------------------------------------
            Function: Initialise View models + Elements
            Author: Ryan + Parakram
     ---------------------------------------------------------------------------------------- */
    FragmentManager fm = getSupportFragmentManager();
    NavBarFragment navBarFragment = new NavBarFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadNavBar();
    }

    /* -----------------------------------------------------------------------------------------
            Function: loadSearchFragment()
            Author: Ryan
            Description: Determines if body fragment is currently full, if so replace with search
                otherwise add search fragment
     ---------------------------------------------------------------------------------------- */
    private void loadSearchFragment() {
        // Defines other fragments
        SearchFragment searchFragment = new SearchFragment();
        Fragment mainContainer = fm.findFragmentById(R.id.body_container);

        //If currently active, removes boardFragment
        if (mainContainer != null) {
            fm.beginTransaction().replace(R.id.body_container, searchFragment, "searchFragment").commit();
        }
        else {
            fm.beginTransaction().add(R.id.body_container, searchFragment, "searchFragment").commit();
        }

    }

    /* -----------------------------------------------------------------------------------------
            Function: loadDisplayFragment()
            Author: Ryan
            Description: Determines if body fragment is currently full, if so replace with display
                otherwise add display fragment
     ---------------------------------------------------------------------------------------- */
    private void loadDisplayFragment() {
        // Defines other fragments
        DisplayFragment displayFragment = new DisplayFragment();
        Fragment mainContainer = fm.findFragmentById(R.id.body_container);


        //If currently active, removes boardFragment
        if (mainContainer != null) {
            fm.beginTransaction().replace(R.id.body_container, displayFragment, "displayFragment").commit();
        }
        else {
            fm.beginTransaction().add(R.id.body_container, displayFragment, "displayFragment").commit();
        }

    }

    /* -----------------------------------------------------------------------------------------
            Function: loadUploadFragment()
            Author: Ryan
            Description: Determines if body fragment is currently full, if so replace with upload
                otherwise add upload fragment
     ---------------------------------------------------------------------------------------- */
    private void loadUploadFragment() {
        // Defines  fragments
        UploadFragment uploadFragment = new UploadFragment();
        Fragment bodyContainer = fm.findFragmentById(R.id.body_container);

        //replaces or adds fragment according to if there is already a fragment
        if (bodyContainer != null) {
            fm.beginTransaction().replace(R.id.body_container, uploadFragment, "uploadFragment").commit();
        }
        else {
            fm.beginTransaction().add(R.id.body_container, uploadFragment, "uploadFragment").commit();
        }
    }

    /* -----------------------------------------------------------------------------------------
            Function: loadNavBar()
            Author: Ryan
            Description: Determines if navBar fragment is currently full, if so replace with
                navBar otherwise add navBar fragment
     ---------------------------------------------------------------------------------------- */
    private void loadNavBar() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.navBar_container);
        if (frag!= null) {
            fm.beginTransaction().replace(R.id.navBar_container, navBarFragment, "navBarFragment").commit();
        }
        else {
            fm.beginTransaction().add(R.id.navBar_container, navBarFragment, "navBarFragment").commit();
        }
    }
}