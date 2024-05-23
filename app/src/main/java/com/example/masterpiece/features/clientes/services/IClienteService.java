package com.example.masterpiece.features.clientes.services;

import com.example.masterpiece.features.clientes.entities.Cliente;
import com.example.masterpiece.utils.services.ICRUD;

public interface IClienteService extends ICRUD<Cliente> {
    Cliente findByNombre(String nombre);
}
