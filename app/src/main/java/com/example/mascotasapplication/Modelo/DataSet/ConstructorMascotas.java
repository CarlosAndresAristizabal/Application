package com.example.mascotasapplication.Modelo.DataSet;

import android.content.ContentValues;
import android.content.Context;

import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private static Context context;

    public ConstructorMascotas(Context context){
        this.context=context;
    }


    public static ArrayList<Mascotas> obtenerDatos(){
        BD db = new BD(context);
        insertarTodasMascotas(db);
        return db.ObtenerTodasLasMascotas();
    }

    public static void insertarTodasMascotas(BD db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Luna");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.perro0);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Kira");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro1);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Thor");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Lola");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro3);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Firulay");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro4);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Rex");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro5);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Zeus");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro6);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Rocky");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro7);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Taison");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro8);
        db.insertarMascotas(contentValues);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE,"Rambo");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_DESCRIPCION,"El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FECHA,"2018/02/30");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro9);
        db.insertarMascotas(contentValues);


    }

    public void darLikeMascotas(Mascotas mascotas){
        BD db = new BD(context);
        ContentValues contentValues =new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTAS, mascotas.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascotas(contentValues);
    }

    public int obtenerlikesMascotas(Mascotas mascotas){
        BD db = new BD(context);
        return db.obtenerLikesMascotas(mascotas);
    }



}
