package com.teigocoding.a99drivercontroller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.teigocoding.a99drivercontroller.R;


public class RunsBonusFragment extends Fragment {


    Spinner spinner_total;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_runs_bonus, container, false);
    }
}