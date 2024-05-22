package com.example.masterpiece.model.entities;

public class Artista {
    private Integer id;
    private String nombre;
    private String genero;
    private String pais;
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Artista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public static class Builder{

        private Artista artista;

        public Builder(){
            this.artista = new Artista();
        }
        public Builder id(Integer id){
            this.artista.id = id;
            return this;
        }
        public Builder nombre(String nombre){
            this.artista.nombre = nombre;
            return this;
        }
        public Builder genero(String genero){
            this.artista.genero = genero;
            return this;
        }
        public  Builder pais(String pais){
            this.artista.pais=pais;
            return this;
        }
        public  Builder imagen(String imagen){
            this.artista.imagen=imagen;
            return this;
        }
        public Artista build(){
            return  this.artista;
        }


    }
}
