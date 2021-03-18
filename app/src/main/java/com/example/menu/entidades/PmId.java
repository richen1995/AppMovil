package com.example.menu.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PmId {

    @SerializedName("pmCodigo")
    @Expose
    private String pmCodigo;
    @SerializedName("pmId")
    @Expose
    private Integer pmId;
    @SerializedName("pmNombre")
    @Expose
    private String pmNombre;

    public String getPmCodigo() {
        return pmCodigo;
    }

    public void setPmCodigo(String pmCodigo) {
        this.pmCodigo = pmCodigo;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getPmNombre() {
        return pmNombre;
    }

    public void setPmNombre(String pmNombre) {
        this.pmNombre = pmNombre;
    }

}
