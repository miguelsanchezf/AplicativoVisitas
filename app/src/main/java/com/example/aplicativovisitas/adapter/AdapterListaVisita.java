package com.example.aplicativovisitas.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aplicativovisitas.R;
import com.example.aplicativovisitas.modelo.MiAplicacion;
import com.example.aplicativovisitas.modelo.Visita;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import static android.widget.Toast.*;


public class AdapterListaVisita extends ArrayAdapter<Visita> {
    private Activity contexto;

    public AdapterListaVisita(Activity context){
        super(context, R.layout.item_visita, Visita.listaVisita);
        this.contexto = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        item = this.contexto.getLayoutInflater().inflate(R.layout.item_visita, null);
        final Visita obj = Visita.listaVisita.get(position);

        TextView item_codigo = (TextView)item.findViewById(R.id.item_codigo);
        TextView item_titulo = (TextView)item.findViewById(R.id.item_titulo);
        TextView item_descripcion = (TextView)item.findViewById(R.id.item_descripcion);
        LinearLayout ly_visita = (LinearLayout)item.findViewById(R.id.ly_visita);
        ImageView item_img = (ImageView)item.findViewById(R.id.item_img);

        item_codigo.setText(obj.getCODIGO());
        item_titulo.setText(obj.getTITULO());
        item_descripcion.setText(obj.getDESCRIPCION());

        Picasso.get().load(""+ MiAplicacion.URL_SERVICE_IMAGENES_HUELLA_FICHA+obj.getRUTAIMAGEN()).memoryPolicy(MemoryPolicy.NO_CACHE).into(item_img);

        ly_visita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CODIGO", obj.getCODIGO());

                /*String uri = "geo:<" +obj.getLATITUD()+ ">,<" + obj.getLONGIUTD()+ ">?q=<" + obj.getLATITUD()+ ">,<" + obj.getLONGIUTD()+ ">(" + obj.getTITULO() + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                contexto.startActivity(intent);*/

                Uri gmmIntentUri = Uri.parse("google.navigation:q="+obj.getLATITUD()+","+obj.getLONGIUTD()+"&mode=d");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                contexto.startActivity(mapIntent);
                //contexto.startActivity(new Intent(contexto, MenuPrincipal.class));
            }
        });

        return item;
    }



    private void buscarImg(final String titulo) {
       Log.i("Codigo: ", titulo);
    }

    public void guardar_preferencias_evento(String IDFORMATOTICKET, String DESCRIPCION){
        SharedPreferences prefs = contexto.getSharedPreferences("PreferenciasEventosACP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("IDFORMATOTICKET_EVENTO", IDFORMATOTICKET);
        editor.putString("DESCRIPCION_EVENTO", DESCRIPCION);
        editor.commit();
    }
}
