package com.example.masterpiece.features.ventas.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venta {
    private int id;
    private int idUsuario;
    private int idProducto;
    private int cantidad;
    private BigDecimal total;

    private String nombreUsuario;

    private String nombreProducto;

    private Venta(Builder builder) {
        this.id = builder.id;
        this.idUsuario = builder.idUsuario;
        this.idProducto = builder.idProducto;
        this.cantidad = builder.cantidad;
        this.total = builder.total;
    }

    public static class Builder {
        private int id;
        private int idUsuario;
        private int idProducto;
        private int cantidad;
        private BigDecimal total;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder idUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder idProducto(int idProducto) {
            this.idProducto = idProducto;
            return this;
        }


        public Builder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public Venta build() {
            return new Venta(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }





    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}