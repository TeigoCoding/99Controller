package com.teigocoding.a99drivercontroller.Fragments;

import android.database.Cursor;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.teigocoding.a99drivercontroller.Adapters.RunsAdapter;
import com.teigocoding.a99drivercontroller.Database.MyDatabaseHelper;
import com.teigocoding.a99drivercontroller.R;

import java.util.ArrayList;


public class RunsListFragment extends Fragment {



    RecyclerView recyclerView;
    ArrayList<String> runsid, runsdate, runsvalue, runstipo;
    RunsAdapter runsAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView txt_total;
    Double somatotal;
    String TAG = "RunsListFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_runs_list, container, false);

        somatotal = 0.00;
        recyclerView = v.findViewById(R.id.runs_recyclerview);
        runsid = new ArrayList<>();
        runsdate = new ArrayList<>();
        runsvalue = new ArrayList<>();
        runstipo = new ArrayList<>();
        txt_total = v.findViewById(R.id.txt_total);
        swipeRefreshLayout = v.findViewById(R.id.swipe_runs);

        GetData();

        runsAdapter = new RunsAdapter(getContext(), runsid, runsdate, runsvalue, runstipo);
        recyclerView.setAdapter(runsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Sumtotal();
        Update();

        return v;
    }

    public void Sumtotal (){

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getActivity());
        Cursor cursor = myDatabaseHelper.runsList();

        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), R.string.msgquantcorridas, Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {

                runsvalue.add(cursor.getString(2));
                String string = runsvalue.get(cursor.getPosition());
                somatotal += Double.parseDouble(string);

                txt_total.setText("R$ " + somatotal.toString());
                Log.d(TAG, "Sucessow");
            }
        }
    }


    public void GetData() {

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getActivity());
                Cursor cursor = myDatabaseHelper.runsList();

        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), R.string.msgquantcorridas, Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                runsid.add(cursor.getString(0));
                runsdate.add(cursor.getString(1));
                runsvalue.add(cursor.getString(2));
                runstipo.add(cursor.getString(3));
            }
        }
    }


    public void Update(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}