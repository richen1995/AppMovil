package com.example.menu.fragmento;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.R;
import com.example.menu.RestEngine;
import com.example.menu.adaptadores.AdapterMaterial;
import com.example.menu.entidades.ApiService;
import com.example.menu.entidades.ComunicaFragDetalle;
import com.example.menu.entidades.Material;
import com.example.menu.entidades.PerCedula;
import com.example.menu.entidades.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PrimerFragment extends Fragment {

    /*--- para uso de RecyclerView  https://www.youtube.com/watch?v=ndqsOLjjV7s---21:00------*/
    AdapterMaterial adapterMaterial;
    RecyclerView recyclerViewMateriales;
    ArrayList<Material> listaMateriales;
    /*-----------------------------------*/

    ApiService apiService;
    //private String cedula;
    //TextView tvDatos;

    //Referencias PARA COMUNICAR FRAGMENTS DETALLE TUTO:  youtube.com/watch?v=vC8C89MsqlI
        Activity actividad;
        ComunicaFragDetalle comunicaFragDetalle;

    public PrimerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //cedula = getArguments().getString("CEDULA");
        }
        //recibirDatos();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Toast.makeText(getContext(), "El score es: "+ getArguments().getString("CEDULA"), Toast.LENGTH_SHORT).show();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primer, container, false);
        recyclerViewMateriales = view.findViewById(R.id.recyclerViewMaterial);
        listaMateriales = new ArrayList<>();
        //cargar lista
            cargarLista();
        //mostrar datos
            //mostrarDatos();


        return view;
        //recibirDatos();
    }

    public void cargarLista() {
        /*listaMateriales.add(new Material("Camara grande", "camara 1"));
        listaMateriales.add(new Material("Camara grande", "camara 2"));
        listaMateriales.add(new Material("Camara grande", "camara 3"));
        listaMateriales.add(new Material("Camara grande", "camara 4"));
        listaMateriales.add(new Material("Camara grande", "camara 5"));
        listaMateriales.add(new Material("Camara grande", "camara 6"));*/

        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<ArrayList<Material>> call = apiService.getMateriales();
        call.enqueue(new Callback<ArrayList<Material>>() {
            @Override
            public void onResponse(Call<ArrayList<Material>> call, Response<ArrayList<Material>> response) {
                if(response.isSuccessful()) {
                    ArrayList<Material> listaMaterial = response.body();
                    mostrarDatos(listaMaterial);
                    Toast.makeText(getContext(), "Correcta extraccion de array Material", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Material>> call, Throwable t) {
                Toast.makeText(getContext(), "Fallo la extraccion de array Material", Toast.LENGTH_SHORT).show();
            }
        });
    }


    // private void mostrarDatos() {
    private void mostrarDatos(ArrayList<Material> listaMaterial) {
        recyclerViewMateriales.setLayoutManager(new LinearLayoutManager(getContext()));
        //adapterMaterial = new AdapterMaterial(getContext(),listaMateriales);
        adapterMaterial = new AdapterMaterial(getContext(),listaMaterial);
        recyclerViewMateriales.setAdapter(adapterMaterial);

        //mostrar mensaje luego de dar click en un item
            adapterMaterial.setOnclickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String nom = listaMateriales.get(recyclerViewMateriales.getChildAdapterPosition(v)).getMatNombre();
                    String nom = listaMaterial.get(recyclerViewMateriales.getChildAdapterPosition(v)).getMatNombre();
                    Toast.makeText(getContext(),"Selecciono "+ nom, Toast.LENGTH_SHORT).show();
                    comunicaFragDetalle.enviarOBJMaterial(listaMaterial.get(recyclerViewMateriales.getChildAdapterPosition(v)));
                }
            });

        listaMateriales =  listaMaterial; //esto es una prueba para ver si se almacena un objSON

    }

    /*2 metodo para llamer a fragmrnt detalle de Material*/
        @Override
        public void onAttach(@NonNull Context context) { //metodo pra establecer cominicacion entre frag Material y FragDetalleMaterial
            super.onAttach(context);                     //comunicacion fragmento actividad usando un interfaz ComunicaFragDetalle como puente
            if(context instanceof Activity){
                this.actividad = (Activity) context;
                comunicaFragDetalle = (ComunicaFragDetalle) this.actividad;
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
        }

    public void recibirDatos(){
        /*Bundle extras = getIntent().getExtras();
        String cedula = extras.getString("CEDULA");
        String email = extras.getString("EMAIL");
        String password = extras.getString("PASSWORD");

        tvDatos = findViewById(R.id.tvDatos);
        tvDatos.setText("" + cedula + " " + email + " " + password);*/
    }
}