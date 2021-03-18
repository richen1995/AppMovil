package com.example.menu.fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menu.R;
import com.example.menu.entidades.Material;


public class FragDetalleMaterial extends Fragment {
    TextView nombre, marca, detalle;
    ImageView imagen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_detalle_material, container, false);
        nombre =   view.findViewById(R.id.tvnombreMaterial);
        marca =    view.findViewById(R.id.tvmarcaMaterial);
        detalle =  view.findViewById(R.id.tvdetalleMaterial);
        //imagen =   view.findViewById(R.id.imagenMaterial);
        //Crear objeto bundle para recibir el objeto con sus parametros seleccionado desde l flame general pasando por la PrinipalActivity
        Bundle objMaterial = getArguments();
        Material material = null;
        //validar para saver si Existen Argumetos
        if(objMaterial != null){
            material =  (Material) objMaterial.getSerializable("objetoMaterial");
            //establecer los datos en las vistas
            nombre.setText(material.getMatNombre());
            marca.setText(material.getMatMarca());
            detalle.setText(material.getMatDescripcion());


        }
        return view;
    }
}