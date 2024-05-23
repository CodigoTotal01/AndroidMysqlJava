package com.example.masterpiece.features.productos.entities;

import java.math.BigDecimal;

public class Producto {

    private int id;
    private String nombre;
    private String tipo;
    private BigDecimal precio;
    private String urlImagen;

    public Producto(int id, String nombre, String tipo, BigDecimal precio, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.urlImagen = urlImagen;
    }

    // ... tus métodos getter y setter ...

    public static class Builder {
        private int id;
        private String nombre;
        private String tipo;
        private BigDecimal precio;
        private String urlImagen;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder precio(BigDecimal precio) {
            this.precio = precio;
            return this;
        }

        public Builder urlImagen(String urlImagen) {
            this.urlImagen = urlImagen;
            return this;
        }

        public Producto build() {
            return new Producto(id, nombre, tipo, precio, urlImagen);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}