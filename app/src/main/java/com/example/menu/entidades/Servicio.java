package com.example.menu.entidades;

import com.google.gson.annotations.SerializedName;

public class Servicio {

    @SerializedName("srvEstado")

    private Boolean srvEstado;
    @SerializedName("srvId")

    private String srvId;
    @SerializedName("srvNombre")

    private String srvNombre;
    @SerializedName("srvTipo")

    private String srvTipo;

    public Servicio() {}

    public Servicio(Boolean srvEstado, String srvNombre, String srvTipo) {
        this.srvEstado = srvEstado;
        this.srvNombre = srvNombre;
        this.srvTipo = srvTipo;
    }

    public Boolean getSrvEstado() {
        return srvEstado;
    }

    public void setSrvEstado(Boolean srvEstado) {
        this.srvEstado = srvEstado;
    }

    public String getSrvId() {
        return srvId;
    }

    public void setSrvId(String srvId) {
        this.srvId = srvId;
    }

    public String getSrvNombre() {
        return srvNombre;
    }

    public void setSrvNombre(String srvNombre) {
        this.srvNombre = srvNombre;
    }

    public String getSrvTipo() {
        return srvTipo;
    }

    public void setSrvTipo(String srvTipo) {
        this.srvTipo = srvTipo;
    }

}

