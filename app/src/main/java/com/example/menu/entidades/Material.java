package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Material implements Serializable {

    @SerializedName("catId")
    @Expose
    private CatId catId;
    @SerializedName("matColor")
    @Expose
    private String matColor;
    @SerializedName("matCompatibilidad")
    @Expose
    private String matCompatibilidad;
    @SerializedName("matCorriente")
    @Expose
    private Double matCorriente;
    @SerializedName("matDescripcion")
    @Expose
    private String matDescripcion;
    @SerializedName("matId")
    @Expose
    private String matId;
    @SerializedName("matMarca")
    @Expose
    private String matMarca;
    @SerializedName("matNombre")
    @Expose
    private String matNombre;
    @SerializedName("matPotencia")
    @Expose
    private Double matPotencia;
    @SerializedName("matStock")
    @Expose
    private Integer matStock;
    @SerializedName("matTipoconexion")
    @Expose
    private String matTipoconexion;
    @SerializedName("matVoltaje")
    @Expose
    private Double matVoltaje;

    public Material(){}

    /*public Material(CatId catId, String matColor, String matCompatibilidad, Double matCorriente, String matDescripcion, String matId, String matMarca, String matNombre, Double matPotencia, Integer matStock, String matTipoconexion, Double matVoltaje) {
        this.catId = catId;
        this.matColor = matColor;
        this.matCompatibilidad = matCompatibilidad;
        this.matCorriente = matCorriente;
        this.matDescripcion = matDescripcion;
        this.matId = matId;
        this.matMarca = matMarca;
        this.matNombre = matNombre;
        this.matPotencia = matPotencia;
        this.matStock = matStock;
        this.matTipoconexion = matTipoconexion;
        this.matVoltaje = matVoltaje;
    }*/

    public Material(String matDescripcion, String matNombre) {
        this.matDescripcion = matDescripcion;
        this.matNombre = matNombre;
    }

    public CatId getCatId() {
        return catId;
    }

    public void setCatId(CatId catId) {
        this.catId = catId;
    }

    public String getMatColor() {
        return matColor;
    }

    public void setMatColor(String matColor) {
        this.matColor = matColor;
    }

    public String getMatCompatibilidad() {
        return matCompatibilidad;
    }

    public void setMatCompatibilidad(String matCompatibilidad) {
        this.matCompatibilidad = matCompatibilidad;
    }

    public Double getMatCorriente() {
        return matCorriente;
    }

    public void setMatCorriente(Double matCorriente) {
        this.matCorriente = matCorriente;
    }

    public String getMatDescripcion() {
        return matDescripcion;
    }

    public void setMatDescripcion(String matDescripcion) {
        this.matDescripcion = matDescripcion;
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId;
    }

    public String getMatMarca() {
        return matMarca;
    }

    public void setMatMarca(String matMarca) {
        this.matMarca = matMarca;
    }

    public String getMatNombre() {
        return matNombre;
    }

    public void setMatNombre(String matNombre) {
        this.matNombre = matNombre;
    }

    public Double getMatPotencia() {
        return matPotencia;
    }

    public void setMatPotencia(Double matPotencia) {
        this.matPotencia = matPotencia;
    }

    public Integer getMatStock() {
        return matStock;
    }

    public void setMatStock(Integer matStock) {
        this.matStock = matStock;
    }

    public String getMatTipoconexion() {
        return matTipoconexion;
    }

    public void setMatTipoconexion(String matTipoconexion) {
        this.matTipoconexion = matTipoconexion;
    }

    public Double getMatVoltaje() {
        return matVoltaje;
    }

    public void setMatVoltaje(Double matVoltaje) {
        this.matVoltaje = matVoltaje;
    }

}
