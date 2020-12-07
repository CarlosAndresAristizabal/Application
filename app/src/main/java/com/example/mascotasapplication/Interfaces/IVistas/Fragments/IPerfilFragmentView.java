package com.example.mascotasapplication.Interfaces.IVistas.Fragments;

import com.example.mascotasapplication.Modelo.Adaptadores.PerfilMascotaAdapter;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;

import java.util.ArrayList;

public interface IPerfilFragmentView {

    public void generarGridLayout();

   public PerfilMascotaAdapter crearAdaptador(ArrayList<Mascotas> mascota);

    public void inicializadorPerfilAdaptadorRV(PerfilMascotaAdapter adaptador);
}
