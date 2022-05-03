package com.teigocoding.a99drivercontroller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.teigocoding.a99drivercontroller.R;
import com.teigocoding.a99drivercontroller.databinding.RunsItemBinding;


public class RunsBonusFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Spinner spinner_total;


    private String mParam1;
    private String mParam2;

    public RunsBonusFragment() {
        // Required empty public constructor
    }


    public static RunsBonusFragment newInstance(String param1, String param2) {
        RunsBonusFragment fragment = new RunsBonusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_runs_bonus, container, false);
    }
}