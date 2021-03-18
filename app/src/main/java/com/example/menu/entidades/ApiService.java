package com.example.menu.entidades;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface  ApiService {
    //@GET("funcion")
    //Call<ArrayList<Funcion>> getFunciones();

    @GET("servicio")
    Call<ArrayList<Servicio>> getServicios();

    @GET("material")
    Call<ArrayList<Material>> getMateriales();

    @GET("ciudad/{codigo}")
    Call<CidCodigo> getCiudad(@NonNull @Path("codigo") String codigo);

    @POST("servicio")
    Call<Servicio> setServicio (@Body Servicio servicio);

    @POST("persona")
    Call<PerCedula> setPersona (@Body PerCedula persona);

    @POST("usuario")
    Call<Usuario> setUsuario (@Body Usuario usuario);



    //--------------GET - PERSONALIZADOS------------------
    @GET("sessionusuario/{email}/{password}")
    Call<Usuario> getUsuarioEmailPassword(@NonNull @Path("email") String email, @Path("password") String password);
}
