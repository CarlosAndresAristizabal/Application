package com.example.mascotasapplication.Presentador;

import android.content.Context;

import com.example.mascotasapplication.Interfaces.IPresentador.Fragments.IPerfilFragmentPresent;
import com.example.mascotasapplication.Modelo.DataSet.ConstructorMascotas;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.Interfaces.IVistas.Fragments.IPerfilFragmentView;

import java.util.ArrayList;

public class PerfilFragmentPresent implements IPerfilFragmentPresent {

    private IPerfilFragmentView iPerfilFragmentView;
    private  Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public PerfilFragmentPresent(IPerfilFragmentView iPerfilFragmentVIew, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentVIew;
        this.context = context;
        ObtenerDatosBD();
    }
    @Override
    public void ObtenerDatosBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = ConstructorMascotas.obtenerDatos();
        mostrarPerfilMascotasRV();
    }
    @Override
    public void mostrarPerfilMascotasRV() {
        iPerfilFragmentView.inicializadorPerfilAdaptadorRV(iPerfilFragmentView.crearAdaptador(mascotas));
        iPerfilFragmentView.generarGridLayout();

    }
}
