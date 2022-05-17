package com.teigocoding.a99drivercontroller.Fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teigocoding.a99drivercontroller.Database.MyDatabaseHelper;
import com.teigocoding.a99drivercontroller.Models.RunsModel;
import com.teigocoding.a99drivercontroller.R;

import java.text.DecimalFormat;
import java.util.Calendar;


public class RunsRunsFragment extends Fragment {


    String TAG = "RunsRunsActivity";

    Button bt_add;
    EditText runs_data_add, runs_valor_add;
    Spinner _spinner_tipo;
    //DatePickerDialog.OnDateSetListener dateSetListener;
    DatePickerDialog datePickerDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_runs_runs, container, false);

        initDataPicker();

        runs_data_add = v.findViewById(R.id.txt_dateadd);
        runs_valor_add = v.findViewById(R.id.txt_valoradd);
        bt_add = v.findViewById(R.id.bt_addruns);
        _spinner_tipo = v.findViewById(R.id.spinner_tipo_add);
        
        runs_data_add.setText(getTodaysDate());


        runs_data_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker(view);
            }
        });

        //EditText datadaviagem = (EditText) v.findViewById(R.id.txt_dateadd);
        //EditText valorfinal = (EditText) v.findViewById(R.id.txt_valoradd);

        //valorfinal.addTextChangedListener(Format.mask(valorfinal, Format.FORMAT_DECIMAL));
        //datadaviagem.addTextChangedListener(Format.mask(datadaviagem, Format.FORMAT_DATE));


        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    DecimalFormat decimalFormat = new DecimalFormat("##.##");
                    decimalFormat.setMaximumFractionDigits(2);
                    Double valordouble = Double.parseDouble(runs_valor_add.getText().toString());
                    String string = decimalFormat.format(valordouble);
                    String stringformatted = string.replace(",", ".");
                    valordouble = Double.parseDouble(stringformatted);

                    Log.d(TAG, "O que que a cia faz pra prender o bandido? Ela erra.. É errando que a Cia aprende!!!!!");

                    String data = runs_data_add.getText().toString();
                    String tipo = _spinner_tipo.getSelectedItem().toString();


                    RunsModel runsModel = new RunsModel(-1, data, valordouble, tipo);

                    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getActivity());
                    myDatabaseHelper.addOne(runsModel);

                    Toast.makeText(getActivity(), "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();

                    runs_data_add.setText("");
                    runs_valor_add.setText("");

                }catch (Exception e){

                    Toast.makeText(getActivity(), "Erro ao salvar viagem.Verifique os dados e tente novamente.", Toast.LENGTH_SHORT).show();

            }

            }
        });

        return v;
    }

    private String getTodaysDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDataPicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;
                String date = makeDateString(day, month, year);
                runs_data_add.setText(date);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(getContext(), style, dateSetListener, year, month, day);


    }
    @SuppressLint("DefaultLocale")
    private String makeDateString(int day, int month, int year){
        //return day + " " + getMonthFormat(month) + " " + year;
        return String.format("%02d", day) + "/" + String.format("%02d", month)+ "/" + year;
    }
    private String getMonthFormat (int month){
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEV";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "ABR";
        if (month == 5)
            return "MAI";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AGO";
        if (month == 9)
            return "SET";
        if (month == 10)
            return "OUT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEZ";

        //Default should never happen
        return "DEF";
    }
    private void openDatePicker (View view){
        datePickerDialog.show();
    }
}