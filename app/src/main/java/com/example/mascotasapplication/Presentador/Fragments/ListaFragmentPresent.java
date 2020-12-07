package com.example.mascotasapplication.Presentador.Fragments;

import android.content.Context;

import com.example.mascotasapplication.Interfaces.IPresentador.Fragments.IListaFragmentPresent;
import com.example.mascotasapplication.Modelo.DataSet.ConstructorMascotas;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.Interfaces.IVistas.Fragments.IListaFragmentView;

import java.util.ArrayList;

public class ListaFragmentPresent implements IListaFragmentPresent {

    private IListaFragmentView iListaFragmentView;
    private Context context;
    private ArrayList<Mascotas> mascotas;

    public ListaFragmentPresent(IListaFragmentView iListaFragmentView, Context context) {
        this.iListaFragmentView = iListaFragmentView;
        this.context =context;
        ObtenerDatosBD();
    }
    @Override
    public void ObtenerDatosBD() {
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }
    @Override
    public void mostrarMascotasRV() {
        iListaFragmentView.MostrarAdaptadorRV(iListaFragmentView.crearAdaptador(mascotas));
        iListaFragmentView.generarLinearLayoutVertical();
    }


}
