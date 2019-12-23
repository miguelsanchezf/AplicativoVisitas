package com.example.aplicativovisitas.modelo;

public class MiAplicacion {
    public static String URL_SERVICE = "http://190.223.54.4/EventosACP/controlador/";
    public static String URL_SERVICEWS = "https://inspira-digital.com/wsAplicativo/";
    public static String URL_SERVICEW = "https://inspira-digital.com/WSVisitas/controlador/";
    public static String URL_SERVICE_IMAGENES_HUELLA_FICHA = "https://inspira-digital.com/wsAplicativo/";
    public static String URL_SERVICE_IMAGENES_PREMIOS = "http://190.223.54.4/EventosACP/imagenes_premios/";
    public static String URL_SERVICE_FOTOS = "http://190.223.54.4/acp/fotosColaboradores/";
    //public static String URL_SERVICE_FOTOS_PDA = "http://190.223.54.4/PersonalACP/fotos_movil/";

    public static String IDCODIGOGENERAL;
    public static String NOMBRE;
    public static String IDFORMATOTICKET_EVENTO;
    public static String DESCRIPCION_EVENTO;

    public static boolean validarNumero(String cadena) {
        if (cadena.matches("[0-9]*")) {
            return true;
        } else {
            return false;
        }
    }
}
