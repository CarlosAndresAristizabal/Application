package com.example.mascotasapplication.Modelo.DataSet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BD extends SQLiteOpenHelper {

    private Context context;

    public BD(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTablaMascotas = "CREATE TABLE "      + ConstantesBD.TABLE_MASCOTAS + "(" +
                ConstantesBD.TABLE_MASCOTAS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_MASCOTAS_NOMBRE       + " TEXT, " +
                ConstantesBD.TABLE_MASCOTAS_DESCRIPCION  + " TEXT, " +
                ConstantesBD.TABLE_MASCOTAS_FECHA        + " TEXT, " +
                ConstantesBD.TABLE_MASCOTAS_FOTO         + " INTEGER " +
               ")";

        String crearTablaMascotasLikes = "CREATE TABLE "          + ConstantesBD.TABLE_LIKES_MASCOTAS + "(" +
                ConstantesBD.TABLE_LIKES_MASCOTAS_ID              + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTAS     + " INTEGER," +
                ConstantesBD.TABLE_LIKES_MASCOTAS_NUMERO_LIKES    + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + ")" +
                "REFERENCES " + ConstantesBD.TABLE_MASCOTAS + "( "+ ConstantesBD.TABLE_MASCOTAS_ID + " )" +
                ")";

        db.execSQL(crearTablaMascotas);
        db.execSQL(crearTablaMascotasLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTAS);
        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBD.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascotas> ObtenerTodasLasMascotas(){
        ArrayList<Mascotas>  mascotas = new ArrayList<Mascotas>();

        String query = "SELECT * FROM "  + ConstantesBD.TABLE_MASCOTAS; // Selección de la tabla
        SQLiteDatabase db = this.getWritableDatabase(); //Consultar la tabla
        Cursor registros =  db.rawQuery(query,null);// Moverse en la tabla

        while(registros.moveToNext()){              //Mientras se mueve ir registrando la base de datos con el Dataset
            Mascotas mascotasActual = new Mascotas(); // Del dataset se coloca la infomracion de la BD
            mascotasActual.setId(registros.getInt(0));
            mascotasActual.setNombre(registros.getString(1));
            mascotasActual.setDescripcion(registros.getString(2));
            mascotasActual.setFecha(registros.getString(3));
            mascotasActual.setFoto(registros.getInt(4));
            //Seleccionamos y contamos los likes de la tabla de likes mascotas de la BD y con paramos con el id para poder colocar los like en pantalla.
            String queryLikes = "SELECT COUNT( " + ConstantesBD.TABLE_LIKES_MASCOTAS_NUMERO_LIKES + ") AS LIKE" +
                                " FROM "+ ConstantesBD.TABLE_LIKES_MASCOTAS +
                                " WHERE " + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + "=" + mascotasActual.getId();
            //Se hace un recorrido para colocar dicha conuslta en pantalla
            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotasActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotasActual.setLikes(0);
            }

            mascotas.add(mascotasActual);
        }
        db.close();// cerramos la BD depues de la consultta y registro
        return mascotas;
    }
    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }

    public void insertarLikeMascotas (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES_MASCOTAS, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascotas(Mascotas mascotas){
        int likes = 0;
        String query = " SELECT COUNT( " + ConstantesBD.TABLE_LIKES_MASCOTAS_NUMERO_LIKES+ ")" +
                     " FROM "+ ConstantesBD.TABLE_LIKES_MASCOTAS +
                     " WHERE " + ConstantesBD.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + " = " + mascotas.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery(query, null);

        if (registro.moveToNext()){
            likes = registro.getInt(0);
        }
        db.close();
        return likes;
    }

}
