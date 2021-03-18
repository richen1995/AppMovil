package com.example.menu.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.entidades.Material;

import java.util.ArrayList;

public class AdapterMaterial extends RecyclerView.Adapter<AdapterMaterial.ViewHolder> implements View.OnClickListener {
    LayoutInflater inflater;
    ArrayList<Material> listMaterial;

    //listener
    private View.OnClickListener listener;

    public AdapterMaterial(Context context, ArrayList<Material> listMaterial){
        this.inflater = LayoutInflater.from(context);
        this.listMaterial = listMaterial;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_materiales, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = listMaterial.get(position).getMatNombre();
        String marca = listMaterial.get(position).getMatMarca();
        holder.nombre.setText(nombre);
        holder.marca.setText(marca);


    }

    @Override
    public int getItemCount() {
        return listMaterial.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,marca;
        //ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombre);
            marca = itemView.findViewById(R.id.textViewMarca);
            //imagen = itemView.findViewById(R.id.imagenMaterial);
        }
    }
}
