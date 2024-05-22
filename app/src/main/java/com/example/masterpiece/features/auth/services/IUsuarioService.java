package com.example.masterpiece.features.auth.services;

import com.example.masterpiece.features.auth.entities.Usuario;
import com.example.masterpiece.utils.services.ICRUD;

public interface IUsuarioService extends ICRUD<Usuario> {
    Usuario findByNombre(String nombre);
}
