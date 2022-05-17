package com.teigocoding.a99drivercontroller.Adapters;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teigocoding.a99drivercontroller.R;

import java.util.ArrayList;

public class RunsAdapter extends RecyclerView.Adapter<RunsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList runs_id, runs_date, runs_valor, runs_tipo;



    public RunsAdapter(Context context, ArrayList runs_id, ArrayList runs_date, ArrayList runs_valor, ArrayList runs_tipo){

        this.context = context;
        this.runs_id = runs_id;
        this.runs_date = runs_date;
        this.runs_valor = runs_valor;
        this.runs_tipo = runs_tipo;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.runs_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id_runs_txt.setText(String.valueOf(runs_id.get(position)));
        holder.date_runs_txt.setText(String.valueOf(runs_date.get(position)));
        holder.valor_runs_txt.setText(String.valueOf(runs_valor.get(position)));
        holder.bonus_runs_txt.setText(String.valueOf(runs_tipo.get(position)));

    }

    @Override
    public int getItemCount() {
        return runs_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_runs_txt, date_runs_txt, valor_runs_txt, bonus_runs_txt;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        id_runs_txt = itemView.findViewById(R.id.txt_id);
        date_runs_txt = itemView.findViewById(R.id.txt_date);
        valor_runs_txt = itemView.findViewById(R.id.txt_value);
        bonus_runs_txt = itemView.findViewById(R.id.txt_bonus);

    }

    }
    private static ShapeDrawable oval (@ColorInt int color, View view){
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(view.getHeight());
        shapeDrawable.setIntrinsicWidth(view.getWidth());
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

}
