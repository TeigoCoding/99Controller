package com.teigocoding.a99drivercontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.teigocoding.a99drivercontroller.Adapters.RunsAdapter;
import com.teigocoding.a99drivercontroller.Database.MyDatabaseHelper;

import java.util.ArrayList;

public class ListRunsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView _txt_empty;
    //ArrayList<> arrayList = new ArrayList();
    ArrayList<String> runsid, runsdate, runsvalue, runsbonus;
    RunsAdapter runsAdapter;
    //boolean isSelectedMode = false;
    //ArrayList<> selectedItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_runs);

        recyclerView = findViewById(R.id.recyclerview_list);
        _txt_empty = findViewById(R.id.txt_empty);

        runsid = new ArrayList<>();
        runsdate = new ArrayList<>();
        runsvalue = new ArrayList<>();
        runsbonus = new ArrayList<>();

        GetData();

        runsAdapter = new RunsAdapter(this, runsid, runsdate, runsvalue, runsbonus);
        recyclerView.setAdapter(runsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void GetData() {

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        Cursor cursor = myDatabaseHelper.runsList();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, R.string.msgquantcorridas, Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                runsid.add(cursor.getString(0));
                runsdate.add(cursor.getString(1));
                runsvalue.add(cursor.getString(2));
                runsbonus.add(cursor.getString(3));
            }
        }
    }
}