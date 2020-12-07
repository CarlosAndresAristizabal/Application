package com.example.mascotasapplication.VIsta.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotasapplication.Interfaces.IVistas.Fragments.IListaFragmentView;
import com.example.mascotasapplication.Modelo.Adaptadores.MascotaAdaptador;
import com.example.mascotasapplication.Interfaces.IModelo.Comunica;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.Interfaces.IPresentador.Fragments.IListaFragmentPresent;
import com.example.mascotasapplication.Presentador.Fragments.ListaFragmentPresent;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class ListaFragment extends Fragment implements IListaFragmentView, Comunica {

    ArrayList<Mascotas> listaMascotas;
    private RecyclerView recyclerlista;
    private Activity actividad;
    Comunica comunica;
    private IListaFragmentPresent lista;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_lista, container, false);

        recyclerlista   = vista.findViewById(R.id.rvMascotasFragment);
        lista           = new ListaFragmentPresent(this,getContext());

//      adaptador.setOnClikListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "selecciono a:  " + listaMascotas.get(recyclerlista.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_LONG).show();
//                comunica.enviarDatos(listaMascotas.get(recyclerlista.getChildAdapterPosition(v)));
//
//            }
//        } );
        return vista;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerlista.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascota) {
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascota,actividad);
        return adaptador;
    }

    @Override
    public void MostrarAdaptadorRV(MascotaAdaptador adaptador) {
        recyclerlista.setAdapter(adaptador);
    }

    @Override
    public void enviarDatos(Mascotas mascotas) {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.actividad= (Activity) context;
            comunica= (Comunica) this.actividad;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}