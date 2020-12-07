package com.example.mascotasapplication.VIsta.Principales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.VIsta.Menu.Acercade;
import com.example.mascotasapplication.VIsta.Menu.Contacto;
import com.example.mascotasapplication.VIsta.Menu.Favorito;
import com.example.mascotasapplication.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Detalle_Mascota extends AppCompatActivity  implements Serializable {
    TextView tvNombre,tvhueso, tvfecha, tvdescripcion;
    ImageView imgFoto,favoritostar;
    ArrayList<Mascotas>listaMascotas=new ArrayList<Mascotas>();
    Activity activity;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent favorito = new Intent(this, Favorito.class);
                startActivity(favorito);
                break;
            case R.id.Contacto:
                Intent Contacto = new Intent(this, Contacto.class);
                startActivity(Contacto);
                break;
            case R.id.Acercade:
                Intent Acerca = new Intent(this, Acercade.class);
                startActivity(Acerca);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__mascota);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);

        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Detalle Mascota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imgFoto         = findViewById(R.id.imgFotoD);
        tvNombre        = findViewById(R.id.tvNombreD);
        tvfecha          = findViewById(R.id.tvfechaD);
        tvdescripcion   = findViewById(R.id.tvdescripcionD);
        tvhueso         = findViewById(R.id.tvhuesoD);

        int imgf             = getIntent().getExtras().getInt("fotoD");
        String nombre        = getIntent().getStringExtra("nombre");
        String descripcion   = getIntent().getStringExtra("descripcion");
        String fecha          = getIntent().getStringExtra("fecha");
        int huesos           = getIntent().getExtras().getInt("likes");

        imgFoto.setImageResource(imgf);
        tvNombre.setText(nombre);
        tvdescripcion.setText(descripcion);
        tvfecha.setText(fecha);
        tvhueso.setText(String.valueOf(huesos));

    }

}