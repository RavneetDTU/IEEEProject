package com.example.ravneet.ieeedtu.fragments;

import android.app.Fragment;
import android.os.Bundle;

import com.example.ravneet.ieeedtu.infrasturcture.IEEEApplication;

/**
 * Created by ravneet on 17/6/17.
 */

public abstract class Basefragment extends Fragment {

    protected IEEEApplication application;

    public void onCreate(Bundle savedState){
        super.onCreate(savedState);

        application = (IEEEApplication) getActivity().getApplication();

    }
}
