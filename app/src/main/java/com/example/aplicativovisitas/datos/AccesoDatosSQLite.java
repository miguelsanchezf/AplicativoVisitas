package com.example.aplicativovisitas.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccesoDatosSQLite extends SQLiteOpenHelper {
    private static String nombreBD = "bd_eventos_acp";
    private static int versionBD = 1;

    public static Context aplicacion;//Permite referenciar la aplicación donde se instalará la BD

    public static String tablaPersonalActivo = "CREATE TABLE PERSONALACTIVO(IDCODIGOGENERAL CHAR(8), NOMBRES VARCHAR(200), EMPRESA VARCHAR(50), FECHAINGRESO DATE, IDFORMATOTICKET VARCHAR(50))";
    public static String tablaPremios = "CREATE TABLE PREMIOS(CODIGO VARCHAR(20), IDFORMATOTICKET VARCHAR(50), DESCRIPCION VARCHAR(200), MARCA VARCHAR(100), PRECIO NUMERIC(14,2), CANTIDAD INTEGER, FECHAREGISTRO DATE)";
    public static String tablaPremiosAsignacion = "CREATE TABLE PERSONAL_PREMIOS(IDFORMATOTICKET VARCHAR(50), CODIGOPREMIO VARCHAR(20), IDCODIGOGENERAL CHAR(8), USUARIO VARCHAR(50), FECHAREGISTRO DATE, SINCRONIZADO CHAR(1) DEFAULT '0', ESTADO CHAR(1) DEFAULT '1')";


    public AccesoDatosSQLite() {
        super(aplicacion, nombreBD, null, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(tablaPersonalActivo);
        db.execSQL(tablaPremios);
        db.execSQL(tablaPremiosAsignacion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*switch (newVersion){
            case 2:
                db.execSQL(tablaHoraTareo);
                break;
            case 3:
                db.execSQL(eliminarTablaTareo);
                db.execSQL(tablaTareo);
                break;
        }*/
    }
}
