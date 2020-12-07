package com.example.mascotasapplication.Modelo.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasapplication.Modelo.DataSet.ConstructorMascotas;
import com.example.mascotasapplication.Modelo.DataSet.Mascotas;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.MascotasPerfilViewHolder>  {

    ArrayList<Mascotas> listaperfilMascota;
    private Activity activity;


    public PerfilMascotaAdapter(ArrayList<Mascotas> listaperfilMascota, FragmentActivity activity) {
        this.activity = activity;
        this.listaperfilMascota = listaperfilMascota;
    }
    @NonNull
    @Override
    public MascotasPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_cardview_perfil, null, false);
        return new MascotasPerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasPerfilViewHolder holder, int position) {
        final Mascotas mascota = listaperfilMascota.get(position);
        holder.ImgFoto.setImageResource(mascota.getFoto());
        holder.tvhuesoP.setText(String.valueOf(mascota.getLikes()));
        holder.likeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Me gusta " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorPerfilMascotas = new ConstructorMascotas(activity);
                constructorPerfilMascotas.darLikeMascotas(mascota);
                holder.tvhuesoP.setText(String.valueOf(constructorPerfilMascotas.obtenerlikesMascotas(mascota)));

            }
        });

    }
    @Override
    public int getItemCount() {
        return listaperfilMascota.size();
    }

    public static class MascotasPerfilViewHolder extends RecyclerView.ViewHolder {
        CardView        mascotaCardViewPerfil;
        ImageView       ImgFoto;
        TextView        tvhuesoP;
        ImageView       likeP;

        public MascotasPerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            mascotaCardViewPerfil = itemView.findViewById(R.id.cardView);
            ImgFoto               = itemView.findViewById(R.id.imgPerfil);
            tvhuesoP              = itemView.findViewById(R.id.tvhuesoP);
            likeP                 = itemView.findViewById(R.id.huesoA);
        }
    }
}
