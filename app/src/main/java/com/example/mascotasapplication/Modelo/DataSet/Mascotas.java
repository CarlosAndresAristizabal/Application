package com.example.mascotasapplication.Modelo.DataSet;

import java.io.Serializable;

public class Mascotas implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private int foto;
    private int likes =0;
    private boolean favorito;

    public Mascotas(){

    }

    public Mascotas(String nombre,  String descripcion, String fecha,int foto,int likes ) {

        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.fecha       = fecha;
        this.foto        = foto;
        this.likes       = likes;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }





}
