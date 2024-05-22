package com.example.masterpiece.model.daos;

import android.util.Log;

import com.example.masterpiece.model.connectiondb.ConnectionDB;
import com.example.masterpiece.model.entities.Artista;
import com.example.masterpiece.model.services.IArtistaService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDao implements IArtistaService {

    private static PreparedStatement pstm;

    private static ResultSet res;

    private static ConnectionDB con;

    private static final String TAG="Cliente_DAO";

    public  ArtistaDao(){
        con = ConnectionDB.getInstance();
    }
    @Override
    public Artista selectByName(String name) {
        Artista artista = null;
        final String SQL_SELECT_BY_NAME = "SELECT * FROM artistas WHERE nombre = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_NAME);
            pstm.setString(1, name);
            res = pstm.executeQuery();
            if (res.next()) {
                artista = new Artista.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .genero(res.getString("genero"))
                        .pais(res.getString("pais"))
                        .imagen(res.getString("imagen"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por nombre: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return artista;
    }

    @Override
    public Boolean insert(Artista artista) {
        Boolean result = false;
        final String SQL_INSERT = "INSERT INTO artistas (nombre, genero, pais, imagen) VALUES (?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, artista.getNombre());
            pstm.setString(2, artista.getGenero());
            pstm.setString(3, artista.getPais());
            pstm.setString(4, artista.getImagen());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al insertar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    @Override
    public Boolean update(Artista artista) {
        Boolean result = false;
        final String SQL_UPDATE = "UPDATE artistas SET nombre = ?, genero = ?, pais = ?, imagen = ? WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, artista.getNombre());
            pstm.setString(2, artista.getGenero());
            pstm.setString(3, artista.getPais());
            pstm.setString(4, artista.getImagen());
            pstm.setInt(5, artista.getId());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al actualizar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    @Override
    public List<Artista> list() {
        List<Artista> artistas = new ArrayList<>();
        final String SQL_LIST = "SELECT * FROM artistas";
        try {
            pstm = con.getConnection().prepareStatement(SQL_LIST);
            res = pstm.executeQuery();
            while (res.next()) {
                Artista artista = new Artista.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .genero(res.getString("genero"))
                        .pais(res.getString("pais"))
                        .imagen(res.getString("imagen"))
                        .build();
                artistas.add(artista);
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet y PreparedStatement
            try {
                if (res != null) {
                    res.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                Log.e(TAG, "Error al cerrar recursos: " + e.getMessage());
                e.printStackTrace();
            }
            // No cierres la conexión aquí
            // close();
        }
        return artistas;
    }


    @Override
    public Artista listById(Object id) {
        Artista artista = null;
        final String SQL_LIST_BY_ID = "SELECT * FROM artistas WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_LIST_BY_ID);
            pstm.setInt(1, (Integer) id);
            res = pstm.executeQuery();
            if (res.next()) {
                artista = new Artista.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .genero(res.getString("genero"))
                        .pais(res.getString("pais"))
                        .imagen(res.getString("imagen"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet y PreparedStatement
            try {
                if (res != null) {
                    res.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                Log.e(TAG, "Error al cerrar recursos: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return artista;
    }


    @Override
    public void delete(Object id) {
        final String SQL_DELETE = "DELETE FROM artistas WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_DELETE);
            pstm.setInt(1, (Integer) id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            Log.e(TAG, "Error al eliminar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void close(){
        try {
            if(res!=null)res.close();
            if(pstm!=null)pstm.close();
            if(con!=null)con.close();
        }catch (Exception e){
            Log.e(TAG,"Error :"+e.getMessage());
            e.printStackTrace();
        }

    }
}
