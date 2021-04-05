package com.example.menu.fragmento;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
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
 * create an instance of this  fragment.
 */
public class PrimerFragment extends Fragment {

    /*--- para uso de RecyclerView  https://www.youtube.com/watch?v=ndqsOLjjV7s---21:00------*/
    AdapterMaterial adapterMaterial;
    RecyclerView recyclerViewMateriales;
    ArrayList<Material> listaMateriales;
    /*-----------------------------------*/

    /*----------------------------------abrir fragment a partir de horiontal-menu-------------------------------------*/
    //FragmentManager fragmentManager;
    //FragmentTransaction fragmentTransaction;
    /*--------------------------------------------------------------------------------------------------------------*/

    ApiService apiService;
    //private String cedula;
    //TextView tvDatos;

    //Referencias PARA COMUNICAR FRAGMENTS DETALLE TUTO:  youtube.com/watch?v=vC8C89MsqlI
        Activity actividad;
        ComunicaFragDetalle comunicaFragDetalle;
    //--Instancias de los fragmnts q perteneces al menu Horizontal Scroll View
        //PrimerFragment primerFragment = new PrimerFragment();
        VideoVigilanciaFragment videoVigilanciaFragment = new VideoVigilanciaFragment();
        CableadoFragment cableadoFragment = new CableadoFragment();

        // esto es una prueba
        HorizontalScrollView horizontalScrollView;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Toast.makeText(getContext(), "El score es: "+ getArguments().getString("CEDULA"), Toast.LENGTH_SHORT).show();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primer, container, false);
        recyclerViewMateriales = view.findViewById(R.id.recyclerViewMaterial);
        listaMateriales = new ArrayList<>();
        //cargar lista
            cargarLista();
        //mostrar datos
            //mostrarDatos();

        //probando el click en el horizontal
        //Button btnTodos     = (Button) view.findViewById(R.id.btn_todos);
        //Button btnCamaras   = (Button) view.findViewById(R.id.btn_camaras);
        //Button btnCableado  = (Button) view.findViewById(R.id.btn_cableado);
        /*Button btnCercas    = view.findViewById(R.id.btn_cercas);
        Button btnAlarmas   = view.findViewById(R.id.btn_alarmas);
        Button btnIncendios = view.findViewById(R.id.btn_incendios);
        Button btnAcceso    = view.findViewById(R.id.btn_acceso);*/

        //btnTodos.setOnClickListener(this);
        //btnCamaras.setOnClickListener(this);
        //btnCableado.setOnClickListener(this);
        /*btnCercas.setOnClickListener(this);
        btnAlarmas.setOnClickListener(this);
        btnIncendios.setOnClickListener(this);
        btnAcceso.setOnClickListener(this);*/
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_drawer, new VideoVigilanciaFragment());
                fragmentTransaction.commit();
            }
        });*/


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
        adapterMaterial = new AdapterMaterial(getContext(),listaMaterial); //esta invocando a el adapter y enviando el objeto array vcon los datos para su representacion en el reycler
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

    //@Override
    //public void onClick(View v) {
    //    switch(v.getId()){
 /*           case R.id.btn_todos:
                loadFragment(primerFragment);
                break;*/
/*            case R.id.btn_camaras:
                loadFragment(videoVigilanciaFragment);
                //horizontalScrollView.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_cableado:
                loadFragment(cableadoFragment);
                //horizontalScrollView.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void loadFragment(Fragment fragment){
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_drawer, fragment);
        fragmentTransaction.commit();
    }*/
}