package com.example.aplicativovisitas.modelo;

import java.util.ArrayList;

public class Visita {

    private String CODIGO;
    private String TITULO;
    private String DESCRIPCION;
    private String LATITUD;
    private String LONGIUTD;
    private String RUTAIMAGEN;

    public static ArrayList<Visita> listaVisita = new ArrayList<>();

    public Visita(String CODIGO, String TITULO, String DESCRIPCION, String LATITUD, String LONGIUTD, String RUTAIMAGEN) {
        this.CODIGO = CODIGO;
        this.TITULO = TITULO;
        this.DESCRIPCION = DESCRIPCION;
        this.LATITUD = LATITUD;
        this.LONGIUTD = LONGIUTD;
        this.RUTAIMAGEN = RUTAIMAGEN;
    }

    public Visita() {
    }

    public String getRUTAIMAGEN() {
        return RUTAIMAGEN;
    }

    public void setRUTAIMAGEN(String RUTAIMAGEN) {
        this.RUTAIMAGEN = RUTAIMAGEN;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getLATITUD() {
        return LATITUD;
    }

    public void setLATITUD(String LATITUD) {
        this.LATITUD = LATITUD;
    }

    public String getLONGIUTD() {
        return LONGIUTD;
    }

    public void setLONGIUTD(String LONGIUTD) {
        this.LONGIUTD = LONGIUTD;
    }
}
