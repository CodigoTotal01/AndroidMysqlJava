package com.example.masterpiece.features.auth.entities;


public class Usuario {
    private Integer id;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }

    public static class Builder {
        private Integer id;
        private String usuario;
        private String password;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Usuario build() {
            return new Usuario(id, usuario, password);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
