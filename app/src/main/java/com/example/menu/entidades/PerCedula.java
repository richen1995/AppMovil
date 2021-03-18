package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PerCedula {

    @SerializedName("cidCodigo")
    @Expose
    private CidCodigo cidCodigo;
    @SerializedName("perApellido")
    @Expose
    private String perApellido;
    @SerializedName("perCedula")
    @Expose
    private String perCedula;
    @SerializedName("perCelular")
    @Expose
    private String perCelular;
    @SerializedName("perDireccion")
    @Expose
    private String perDireccion;
    @SerializedName("perFechanacimiento")
    @Expose
    private String perFechanacimiento;
    @SerializedName("perNombre")
    @Expose
    private String perNombre;
    @SerializedName("perRuc")
    @Expose
    private String perRuc;
    @SerializedName("perSexo")
    @Expose
    private String perSexo;
    @SerializedName("perTipo")
    @Expose
    private String perTipo;

    public CidCodigo getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(CidCodigo cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerCelular() {
        return perCelular;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerFechanacimiento() {
        return perFechanacimiento;
    }

    public void setPerFechanacimiento(String perFechanacimiento) {
        this.perFechanacimiento = perFechanacimiento;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerRuc() {
        return perRuc;
    }

    public void setPerRuc(String perRuc) {
        this.perRuc = perRuc;
    }

    public String getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }

    public String getPerTipo() {
        return perTipo;
    }

    public void setPerTipo(String perTipo) {
        this.perTipo = perTipo;
    }

}
