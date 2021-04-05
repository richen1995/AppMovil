package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profesional {

    @SerializedName("perCedula")
    @Expose
    private PerCedula perCedula;
    @SerializedName("profEstudios")
    @Expose
    private String profEstudios;
    @SerializedName("profId")
    @Expose
    private String profId;
    @SerializedName("profImagen")
    @Expose
    private String profImagen;
    @SerializedName("profProfesion")
    @Expose
    private String profProfesion;

    public PerCedula getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(PerCedula perCedula) {
        this.perCedula = perCedula;
    }

    public String getProfEstudios() {
        return profEstudios;
    }

    public void setProfEstudios(String profEstudios) {
        this.profEstudios = profEstudios;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getProfImagen() {
        return profImagen;
    }

    public void setProfImagen(String profImagen) {
        this.profImagen = profImagen;
    }

    public String getProfProfesion() {
        return profProfesion;
    }

    public void setProfProfesion(String profProfesion) {
        this.profProfesion = profProfesion;
    }

}
