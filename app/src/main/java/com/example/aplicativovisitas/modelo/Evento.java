package com.example.aplicativovisitas.modelo;

import java.util.ArrayList;

public class Evento {
    private String IDFORMATOTICKET;
    private String DESCRIPCION;
    private String FECHAREGISTRO;
    private String OBSERVACION;

    public static ArrayList<Evento> listaEventos = new ArrayList<>();

    public Evento(String IDFORMATOTICKET, String DESCRIPCION, String FECHAREGISTRO, String OBSERVACION) {
        this.IDFORMATOTICKET = IDFORMATOTICKET;
        this.DESCRIPCION = DESCRIPCION;
        this.FECHAREGISTRO = FECHAREGISTRO;
        this.OBSERVACION = OBSERVACION;
    }

    public Evento() {
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

    public String getFECHAREGISTRO() {
        return FECHAREGISTRO;
    }

    public void setFECHAREGISTRO(String FECHAREGISTRO) {
        this.FECHAREGISTRO = FECHAREGISTRO;
    }

    public String getOBSERVACION() {
        return OBSERVACION;
    }

    public void setOBSERVACION(String OBSERVACION) {
        this.OBSERVACION = OBSERVACION;
    }
}
