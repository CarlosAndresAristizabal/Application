package com.example.mascotasapplication.VIsta.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mascotasapplication.Interfaces.IVistas.Fragments.IPerfilFragmentView;
import com.example.mascotasapplication.Modelo.Adaptadores.PerfilMascotaAdapter;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.Interfaces.IPresentador.Fragments.IPerfilFragmentPresent;
import com.example.mascotasapplication.Presentador.PerfilFragmentPresent;
import com.example.mascotasapplication.R;

import java.util.ArrayList;


public class PerfilFragment extends Fragment implements IPerfilFragmentView {

    ArrayList<Mascotas> listaperfilratingMascota;
    ImageView imgPerfil;
    TextView NomPer;
    RecyclerView recyclerlista;
    private Object Mascotas;
    Mascotas mascotas;
    private IPerfilFragmentPresent lista;


    @Nullable
    @Override
    public View onCreateView( @Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View vista =inflater.inflate(R.layout.fragment_perfil, container, false);

        imgPerfil       = vista.findViewById(R.id.imgPerfil);
        NomPer          = vista.findViewById(R.id.NomPerfil);
        recyclerlista   = vista.findViewById(R.id.rvRatingFragment);

        lista           = new PerfilFragmentPresent(this,getContext());

//        llenarlistarating();
//        listaperfilratingMascota = new ArrayList<Mascotas>();
//        Bundle objetoMascota = getArguments();
//        if(objetoMascota !=null){
//            mascotas = (Mascotas) objetoMascota.getSerializable("objeto");
//            imgPerfil.setImageResource(mascotas.getFoto());
//            NomPer.setText(mascotas.getNombre());
//
//        }

        return vista;
    }

//    private void llenarlistarating(){
//
//          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), 3));
//          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), 4));
//          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), 2));
//          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), 5));
//          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), 9));
//
//
//}


    @Override
    public void generarGridLayout() {
        recyclerlista.setLayoutManager(new GridLayoutManager(getContext(),3));
    }

    @Override
    public PerfilMascotaAdapter crearAdaptador(ArrayList<Mascotas> mascota) {
        PerfilMascotaAdapter adaptador = new PerfilMascotaAdapter(mascota,getActivity());
        return adaptador;
    }

    @Override
    public void inicializadorPerfilAdaptadorRV(PerfilMascotaAdapter adaptador) {
        recyclerlista.setAdapter(adaptador);
    }
}