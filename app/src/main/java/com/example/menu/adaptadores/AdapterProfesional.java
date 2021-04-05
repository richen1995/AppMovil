package com.example.menu.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.entidades.Profesional;
;

import java.util.ArrayList;

public class AdapterProfesional extends RecyclerView.Adapter<AdapterProfesional.ViewHolder> implements View.OnClickListener {
    LayoutInflater inflater;
    ArrayList<Profesional> listProfesional;

    //listener
    private View.OnClickListener listener;

    public AdapterProfesional(Context context, ArrayList<Profesional> listProfesional){
        this.inflater = LayoutInflater.from(context);
        this.listProfesional = listProfesional;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_profesionales, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = listProfesional.get(position).getPerCedula().getPerNombre()
                        + " " + listProfesional.get(position).getPerCedula().getPerApellido();
        String profesion = listProfesional.get(position).getProfProfesion();
        holder.nombre.setText(nombre);
        holder.profesion.setText(profesion);


    }

    @Override
    public int getItemCount() {
        return listProfesional.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,profesion;
        //ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombreProfesional);
            profesion = itemView.findViewById(R.id.textViewProfeccion);
            //imagen = itemView.findViewById(R.id.imagenProfesional);
        }
    }
}

