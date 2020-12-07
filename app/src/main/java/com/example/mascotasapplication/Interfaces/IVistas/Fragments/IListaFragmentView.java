package com.example.mascotasapplication.Interfaces.IVistas.Fragments;

import com.example.mascotasapplication.Modelo.Adaptadores.MascotaAdaptador;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;

import java.util.ArrayList;

public interface IListaFragmentView {

     void generarLinearLayoutVertical();

     MascotaAdaptador crearAdaptador ( ArrayList<Mascotas> mascota);

     void MostrarAdaptadorRV(MascotaAdaptador adaptador);

}
