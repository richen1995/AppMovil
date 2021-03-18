package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CatId implements Serializable {

    @SerializedName("catCodigo")
    @Expose
    private String catCodigo;
    @SerializedName("catEstado")
    @Expose
    private Boolean catEstado;
    @SerializedName("catId")
    @Expose
    private Integer catId;
    @SerializedName("catNombre")
    @Expose
    private String catNombre;

    public String getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(String catCodigo) {
        this.catCodigo = catCodigo;
    }

    public Boolean getCatEstado() {
        return catEstado;
    }

    public void setCatEstado(Boolean catEstado) {
        this.catEstado = catEstado;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

}
