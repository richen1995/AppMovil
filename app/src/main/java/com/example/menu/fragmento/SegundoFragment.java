package com.example.menu.fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.menu.R;
import com.example.menu.RestEngine;
import com.example.menu.adaptadores.AdapterProfesional;
import com.example.menu.entidades.ApiService;
import com.example.menu.entidades.Profesional;

import java.sql.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SegundoFragment extends Fragment {

    AdapterProfesional adapterProfesional;
    RecyclerView recyclerviewProfecionales;
    ArrayList<Profesional> listaProfecionales;

    ApiService apiService;

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);
        recyclerviewProfecionales = view.findViewById(R.id.recyclerViewPofesionales);
        listaProfecionales = new ArrayList<>();
        //return inflater.inflate(R.layout.fragment_segundo, container, false);

        cargarLista();
        return view;
    }

    public void cargarLista(){
        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<ArrayList<Profesional>> call = apiService.getProfesionales();
        call.enqueue(new Callback<ArrayList<Profesional>>() {
            @Override
            public void onResponse(Call<ArrayList<Profesional>> call, Response<ArrayList<Profesional>> response) {
                if(response.isSuccessful()){
                    ArrayList<Profesional> listaProfesional = response.body();
                    mostrarDatos(listaProfesional);
                    Toast.makeText(getContext(),"Coorrecta xtraccion del Array Profecional",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Profesional>> call, Throwable t) {
                Toast.makeText(getContext(), "Fallo la extraccion de array Profeccional", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDatos(ArrayList<Profesional> listaProfecional){
        recyclerviewProfecionales.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterProfesional = new AdapterProfesional(getContext(),listaProfecional);
        recyclerviewProfecionales.setAdapter(adapterProfesional);
    }
}