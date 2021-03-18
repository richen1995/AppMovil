package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrvCodigo {

    @SerializedName("prvCodigo")
    @Expose
    private String prvCodigo;
    @SerializedName("prvEstado")
    @Expose
    private Boolean prvEstado;
    @SerializedName("prvNombre")
    @Expose
    private String prvNombre;

    public String getPrvCodigo() {
        return prvCodigo;
    }

    public void setPrvCodigo(String prvCodigo) {
        this.prvCodigo = prvCodigo;
    }

    public Boolean getPrvEstado() {
        return prvEstado;
    }

    public void setPrvEstado(Boolean prvEstado) {
        this.prvEstado = prvEstado;
    }

    public String getPrvNombre() {
        return prvNombre;
    }

    public void setPrvNombre(String prvNombre) {
        this.prvNombre = prvNombre;
    }

}
