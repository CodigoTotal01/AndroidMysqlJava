package com.example.masterpiece.model.services;

import com.example.masterpiece.model.entities.Artista;

public interface IArtistaService extends ICRUD<Artista>{

    Artista selectByName(String name);
}
