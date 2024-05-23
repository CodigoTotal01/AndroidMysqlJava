package com.example.masterpiece.features.productos.services;

import com.example.masterpiece.features.productos.entities.Producto;
import com.example.masterpiece.utils.services.ICRUD;

public interface IProductoService extends ICRUD<Producto> {
    Producto findByNombre(String nombre);
}
