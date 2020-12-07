package com.example.mascotasapplication.Modelo.DataSet;

public final class ConstantesBD {

    //Nombre de la Base de datos.
    public static final String DATABASE_NAME                         = "mascotas";
    public static final int DATABASE_VERSION                         = 1;
    //Nombre de la tabla de mascotas
    public static final String TABLE_MASCOTAS                        ="mascota";
    public static final String TABLE_MASCOTAS_ID                     ="id";
    public static final String TABLE_MASCOTAS_NOMBRE                 ="Nombre";
    public static final String TABLE_MASCOTAS_DESCRIPCION            ="descripcion";
    public static final String TABLE_MASCOTAS_FECHA                  ="Fecha";
    public static final String TABLE_MASCOTAS_FOTO                   ="Foto";
    //Nombre de la tabla de Mascotas lIkes
    public static final String TABLE_LIKES_MASCOTAS                  ="mascota_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID               ="id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTAS      ="id_mascota";
    public static final String TABLE_LIKES_MASCOTAS_NUMERO_LIKES     ="numero_likes";

}
