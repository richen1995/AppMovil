package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("perCedula")
    @Expose
    private PerCedula perCedula;
    @SerializedName("pmId")
    @Expose
    private PmId pmId;
    @SerializedName("usEmail")
    @Expose
    private String usEmail;
    @SerializedName("usEstado")
    @Expose
    private Boolean usEstado;
    @SerializedName("usFechafinal")
    @Expose
    private String usFechafinal;
    @SerializedName("usFechainicial")
    @Expose
    private String usFechainicial;
    @SerializedName("usId")
    @Expose
    private Integer usId;
    @SerializedName("usPassword")
    @Expose
    private String usPassword;
    @SerializedName("usRol")
    @Expose
    private String usRol;

    public PerCedula getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(PerCedula perCedula) {
        this.perCedula = perCedula;
    }

    public PmId getPmId() {
        return pmId;
    }

    public void setPmId(PmId pmId) {
        this.pmId = pmId;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public Boolean getUsEstado() {
        return usEstado;
    }

    public void setUsEstado(Boolean usEstado) {
        this.usEstado = usEstado;
    }

    public String getUsFechafinal() {
        return usFechafinal;
    }

    public void setUsFechafinal(String usFechafinal) {
        this.usFechafinal = usFechafinal;
    }

    public String getUsFechainicial() {
        return usFechainicial;
    }

    public void setUsFechainicial(String usFechainicial) {
        this.usFechainicial = usFechainicial;
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsRol() {
        return usRol;
    }

    public void setUsRol(String usRol) {
        this.usRol = usRol;
    }

}
