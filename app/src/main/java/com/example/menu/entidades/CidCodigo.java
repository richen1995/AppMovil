package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CidCodigo {

    @SerializedName("cidCodigo")
    @Expose
    private String cidCodigo;
    @SerializedName("cidEstado")
    @Expose
    private Boolean cidEstado;
    @SerializedName("cidNombre")
    @Expose
    private String cidNombre;
    @SerializedName("prvCodigo")
    @Expose
    private PrvCodigo prvCodigo;

    public String getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(String cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public Boolean getCidEstado() {
        return cidEstado;
    }

    public void setCidEstado(Boolean cidEstado) {
        this.cidEstado = cidEstado;
    }

    public String getCidNombre() {
        return cidNombre;
    }

    public void setCidNombre(String cidNombre) {
        this.cidNombre = cidNombre;
    }

    public PrvCodigo getPrvCodigo() {
        return prvCodigo;
    }

    public void setPrvCodigo(PrvCodigo prvCodigo) {
        this.prvCodigo = prvCodigo;
    }

}
