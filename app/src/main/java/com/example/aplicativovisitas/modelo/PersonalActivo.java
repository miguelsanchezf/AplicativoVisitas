package com.example.aplicativovisitas.modelo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.aplicativovisitas.datos.AccesoDatosSQLite;

import java.util.ArrayList;


public class PersonalActivo extends AccesoDatosSQLite {
    private String IDCODIGOGENERAL;
    private String NOMBRES;
    private String EMPRESA;
    private String FECHAINGRESO;
    private String IDFORMATOTICKET;

    public static ArrayList<PersonalActivo> listaPersonalActivo = new ArrayList<>();
    public static ArrayList<PersonalActivo> datosPersonalEncontrado = new ArrayList<>();

    public PersonalActivo(String IDCODIGOGENERAL, String NOMBRES, String EMPRESA, String FECHAINGRESO, String IDFORMATOTICKET) {
        this.IDCODIGOGENERAL = IDCODIGOGENERAL;
        this.NOMBRES = NOMBRES;
        this.EMPRESA = EMPRESA;
        this.FECHAINGRESO = FECHAINGRESO;
        this.IDFORMATOTICKET = IDFORMATOTICKET;
    }

    public PersonalActivo() {
    }

    public String getIDFORMATOTICKET() {
        return IDFORMATOTICKET;
    }

    public void setIDFORMATOTICKET(String IDFORMATOTICKET) {
        this.IDFORMATOTICKET = IDFORMATOTICKET;
    }

    public String getIDCODIGOGENERAL() {
        return IDCODIGOGENERAL;
    }

    public void setIDCODIGOGENERAL(String IDCODIGOGENERAL) {
        this.IDCODIGOGENERAL = IDCODIGOGENERAL;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getEMPRESA() {
        return EMPRESA;
    }

    public void setEMPRESA(String EMPRESA) {
        this.EMPRESA = EMPRESA;
    }

    public String getFECHAINGRESO() {
        return FECHAINGRESO;
    }

    public void setFECHAINGRESO(String FECHAINGRESO) {
        this.FECHAINGRESO = FECHAINGRESO;
    }

    public void agregar_personal(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for(PersonalActivo personalActivo : listaPersonalActivo){
                values.put("IDCODIGOGENERAL", personalActivo.IDCODIGOGENERAL);
                values.put("NOMBRES", personalActivo.NOMBRES);
                values.put("EMPRESA", personalActivo.EMPRESA);
                values.put("FECHAINGRESO", personalActivo.FECHAINGRESO);
                values.put("IDFORMATOTICKET", personalActivo.IDFORMATOTICKET);
                db.insert("PERSONALACTIVO", null, values);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    public void cargarListaUsuariosLog(){ //BD SQLITE
        SQLiteDatabase bd = this.getReadableDatabase();
        String sql = "select * from PERSONALACTIVO order by 1";
        Cursor resultado = bd.rawQuery(sql, null);
        while (resultado.moveToNext()){
            Log.i("PERSONAL", resultado.getString(1));
        }
        bd.close();
    }

    public boolean verificarPersonal(String IDCODIGOGENERAL, String IDFORMATOTICKET){ //BD SQLITE
        SQLiteDatabase bd = this.getReadableDatabase();
        String sql = "select IDCODIGOGENERAL, NOMBRES, EMPRESA, FECHAINGRESO, IDFORMATOTICKET from PERSONALACTIVO WHERE IDFORMATOTICKET= '"+IDFORMATOTICKET.trim()+"' AND IDCODIGOGENERAL = '"+IDCODIGOGENERAL+"' order by 1";
        datosPersonalEncontrado.clear();
        Cursor resultado = bd.rawQuery(sql, null);
        while (resultado.moveToNext()){
            datosPersonalEncontrado.add(new PersonalActivo(
                    resultado.getString(0),
                    resultado.getString(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4)
            ));
            Log.i("PERSONAL", resultado.getString(1)+"|"+resultado.getString(4));
        }
        bd.close();

        if(datosPersonalEncontrado.size()!= 0){
            return true;
        }else{
            return false;
        }
    }

    public long limpiarTablaPersonalActivo(){
        SQLiteDatabase bd = this.getReadableDatabase();
        bd.delete("PERSONALACTIVO", null, null);
        return 1;
    }
}
