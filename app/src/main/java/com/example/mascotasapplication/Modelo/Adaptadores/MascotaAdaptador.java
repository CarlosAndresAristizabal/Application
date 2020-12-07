package com.example.mascotasapplication.Modelo.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasapplication.Interfaces.IModelo.Comunica;
import com.example.mascotasapplication.Modelo.DataSet.ConstructorMascotas;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.VIsta.Principales.Detalle_Mascota;
import com.example.mascotasapplication.VIsta.Menu.Favorito;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class MascotaAdaptador  extends  RecyclerView.Adapter<MascotaAdaptador.MascotasViewHolder>  implements View.OnClickListener{

    ArrayList<Mascotas> listaMascota;
    private Activity activity;
    private Context context;
    Comunica comunica;


    public MascotaAdaptador(ArrayList<Mascotas> listaMascota,  Context context) {
        this.listaMascota = listaMascota;
        this.context = context;
            }
    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_cardview, null, false);
        context = parent.getContext();
        view.setOnClickListener(this);
        return new MascotasViewHolder(view);
    }

    //asocia cada elemento
    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        final Mascotas mascota = listaMascota.get(position);
        holder.ImgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvhuesoCV.setText(String.valueOf(mascota.getLikes()));
        holder.detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Detalle de "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent Siguiente = new Intent(context, Detalle_Mascota.class);
                Siguiente.putExtra("fotoD", mascota.getFoto());
                Siguiente.putExtra("nombre", mascota.getNombre());
                Siguiente.putExtra("fecha", mascota.getFecha());
                Siguiente.putExtra("descripcion", mascota.getDescripcion());
                Siguiente.putExtra("likes", mascota.getLikes());
                context.startActivity(Siguiente);
            }
        });
        holder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(context, "Añadido a Favorito", Toast.LENGTH_LONG).show();
                Intent Siguiente = new Intent(context, Favorito.class);

//                context.startActivity(Siguiente);

            }
        });

        holder.Like.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Toast.makeText(context, "Me gusta " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
                constructorMascotas.darLikeMascotas(mascota);
                holder.tvhuesoCV.setText(String.valueOf(constructorMascotas.obtenerlikesMascotas(mascota)));

            }
        });
        holder.mascotaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Perfil de "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();


            }
        } );
    }




    @Override
    public int getItemCount() {
        return listaMascota.size();
    }

    @Override
    public void onClick(View v) {

    }


    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
        CardView    mascotaCardView;
        ImageView   ImgFoto;
        TextView    tvNombreCV;
        TextView    tvhuesoCV;
        ImageView   star;
        ImageView   detalle;
        ImageView   Like ;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            mascotaCardView = itemView.findViewById(R.id.cardView);
            ImgFoto         = itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = itemView.findViewById(R.id.tvNombreCV);
            tvhuesoCV       = itemView.findViewById(R.id.tvhuesoCV);
            star            = itemView.findViewById(R.id.star);
            detalle         = itemView.findViewById(R.id.iconodetalle);
            Like            = itemView.findViewById(R.id.huesoA);
        }

    }
}