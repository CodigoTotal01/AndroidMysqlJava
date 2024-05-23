package com.example.masterpiece.features.empleados.entities;

import java.math.BigDecimal;

public class Empleado {

    private int id;
    private String nombre;
    private String puesto;
    private BigDecimal salario;

    private Empleado(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.puesto = builder.puesto;
        this.salario = builder.salario;
    }

    public static class Builder {
        private int id;
        private String nombre;
        private String puesto;
        private BigDecimal salario;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder puesto(String puesto) {
            this.puesto = puesto;
            return this;
        }

        public Builder salario(BigDecimal salario) {
            this.salario = salario;
            return this;
        }

        public Empleado build() {
            return new Empleado(this);
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}