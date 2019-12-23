package com.example.aplicativovisitas.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aplicativovisitas.R;
import com.example.aplicativovisitas.modelo.Evento;


public class AdapterListaEventos extends ArrayAdapter<Evento> {
    private Activity contexto;

    public AdapterListaEventos(Activity context){
        super(context, R.layout.item_evento, Evento.listaEventos);
        this.contexto = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        item = this.contexto.getLayoutInflater().inflate(R.layout.item_evento, null);
        final Evento obj = Evento.listaEventos.get(position);

        TextView item_id_evento = (TextView)item.findViewById(R.id.item_id_evento);
        TextView item_descripcion_evento = (TextView)item.findViewById(R.id.item_descripcion_evento);
        TextView item_observacion = (TextView)item.findViewById(R.id.item_observacion);
        TextView item_fecha_registro = (TextView)item.findViewById(R.id.item_fecha_registro);
        LinearLayout ly_evento = (LinearLayout)item.findViewById(R.id.ly_evento);

        item_id_evento.setText(obj.getIDFORMATOTICKET());
        item_descripcion_evento.setText(obj.getDESCRIPCION());
        item_observacion.setText(obj.getOBSERVACION());
        item_fecha_registro.setText(obj.getFECHAREGISTRO());

        ly_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("IDFORMATO", obj.getIDFORMATOTICKET().trim());
                guardar_preferencias_evento(obj.getIDFORMATOTICKET().trim(), obj.getDESCRIPCION());
                //contexto.startActivity(new Intent(contexto, MenuPrincipal.class));
            }
        });

        return item;
    }

    public void guardar_preferencias_evento(String IDFORMATOTICKET, String DESCRIPCION){
        SharedPreferences prefs = contexto.getSharedPreferences("PreferenciasEventosACP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("IDFORMATOTICKET_EVENTO", IDFORMATOTICKET);
        editor.putString("DESCRIPCION_EVENTO", DESCRIPCION);
        editor.commit();
    }
}
