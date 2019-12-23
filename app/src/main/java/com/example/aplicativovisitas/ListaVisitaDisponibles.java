package com.example.aplicativovisitas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplicativovisitas.adapter.AdapterListaEventos;
import com.example.aplicativovisitas.adapter.AdapterListaVisita;
import com.example.aplicativovisitas.modelo.Evento;
import com.example.aplicativovisitas.modelo.MiAplicacion;
import com.example.aplicativovisitas.modelo.Visita;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class ListaVisitaDisponibles extends AppCompatActivity {
    private ListView lv_visita;
    private SwipeRefreshLayout swipeActualizarLista;
    int ACTUALIZARLISTA = 0;
    private AdapterListaVisita adapter;
    private RequestQueue request;

    private ImageView mImageViewFingerprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_visita_disponibles);

        lv_visita = (ListView) findViewById(R.id.lv_visita);
        swipeActualizarLista = (SwipeRefreshLayout) findViewById(R.id.swipeActualizarLista);

        adapter = new AdapterListaVisita(this);
        lv_visita.setAdapter(adapter);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Sitios");

        /*if(!cargar_preferencias()){
            finish();
        }*/

        swipeActualizarLista.setRefreshing(true);
        refreshItems();

        swipeActualizarLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });
    }



    void refreshItems() {
        ACTUALIZARLISTA = 1;
        getListaEventos();
    }

    void onItemsLoadComplete() {
        ACTUALIZARLISTA = 0;
        swipeActualizarLista.setRefreshing(false);
    }

    private void getListaEventos(){
        request = Volley.newRequestQueue(this);
        String url = MiAplicacion.URL_SERVICEW + "datos.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                if(ACTUALIZARLISTA == 1){
                    onItemsLoadComplete();
                }
                try {
                    Visita.listaVisita.clear();

                    JSONObject json = new JSONObject(response);
                    JSONArray jsonArray = json.getJSONArray("resultado");

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonData = jsonArray.getJSONObject(i);
                        Visita.listaVisita.add(new Visita(
                                jsonData.getString("codigo"),
                                jsonData.getString("titulo"),
                                jsonData.getString("descripcion"),
                                jsonData.getString("latitud"),
                                jsonData.getString("longitud"),
                                jsonData.getString("ruta_imagen")
                        ));
                    }
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(ACTUALIZARLISTA == 1){
                            onItemsLoadComplete();
                        }
                        Log.i("ERROR", "Error");
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("accion", "getAplicativo");
                return params;
            }
        };
        request.add(postRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                dialogAdvertenciaSalir();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        dialogAdvertenciaSalir();
    }

    public void dialogAdvertenciaSalir(){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(ListaVisitaDisponibles.this);
        builder.setTitle("¿Salir?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                limpiarPreferencias();
                finish();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        android.support.v7.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void limpiarPreferencias(){
        SharedPreferences prefs = getSharedPreferences("PreferenciasEventosACP", Context.MODE_PRIVATE);
        prefs.edit().remove("FECHAULTIMA_LOGIN").commit();
        prefs.edit().remove("IDCODIGOGENERAL").commit();
        prefs.edit().remove("NOMBRE").commit();
        prefs.edit().remove("IDFORMATOTICKET").commit();
    }
}
