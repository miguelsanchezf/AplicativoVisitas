package com.example.aplicativovisitas.modelo;

import java.util.ArrayList;

public class Premio {
    private String CODIGO;
    private String IDFORMATOTICKET;
    private String DESCRIPCION;
    private String MARCA;
    private String CANTIDAD;

    public static ArrayList<Premio> listaPremios = new ArrayList<>();

    public Premio(String CODIGO, String IDFORMATOTICKET, String DESCRIPCION, String MARCA, String CANTIDAD) {
        this.CODIGO = CODIGO;
        this.IDFORMATOTICKET = IDFORMATOTICKET;
        this.DESCRIPCION = DESCRIPCION;
        this.MARCA = MARCA;
        this.CANTIDAD = CANTIDAD;
    }

    public Premio() {
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getIDFORMATOTICKET() {
        return IDFORMATOTICKET;
    }

    public void setIDFORMATOTICKET(String IDFORMATOTICKET) {
        this.IDFORMATOTICKET = IDFORMATOTICKET;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }
}

