package com.example.masterpiece.features.auth.daos;

import android.util.Log;

import com.example.masterpiece.features.auth.entities.Usuario;
import com.example.masterpiece.features.auth.services.IUsuarioService;
import com.example.masterpiece.utils.connectiondb.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;


public class UsuarioDAO implements IUsuarioService {

    private static PreparedStatement pstm;

    private static ResultSet res;

    private static ConnectionDB con;

    private static final String TAG = "Usuario_DAO";

    public UsuarioDAO() {
        con = ConnectionDB.getInstance();
    }

    @Override
    public Usuario findByNombre(String nombre) {
        Usuario usuario = null;
        final String SQL_FIND_BY_NOMBRE = "SELECT * FROM usuarios WHERE usuario = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_BY_NOMBRE);
            pstm.setString(1, nombre);
            res = pstm.executeQuery();
            if (res.next()) {
                usuario = new Usuario.Builder()
                        .id(res.getInt("id"))
                        .usuario(res.getString("usuario"))
                        .password(res.getString("password"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por nombre: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return usuario;
    }

    @Override
    public Boolean insert(Usuario usuario) {
        Boolean result = false;
        final String SQL_INSERT = "INSERT INTO usuarios (usuario, password) VALUES (?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getPassword());
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
    public Boolean update(Usuario usuario) {
        Boolean result = false;
        final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?, password = ? WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getPassword());
            pstm.setInt(3, usuario.getId());
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
    public List<Usuario> list() {
        List<Usuario> usuarios = new ArrayList<>();
        final String SQL_LIST = "SELECT * FROM usuarios";
        try {
            pstm = con.getConnection().prepareStatement(SQL_LIST);
            res = pstm.executeQuery();
            while (res.next()) {
                Usuario usuario = new Usuario.Builder()
                        .id(res.getInt("id"))
                        .usuario(res.getString("usuario"))
                        .password(res.getString("password"))
                        .build();
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return usuarios;
    }

    @Override
    public Usuario listById(Object id) {
        Usuario usuario = null;
        final String SQL_LIST_BY_ID = "SELECT * FROM usuarios WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_LIST_BY_ID);
            pstm.setInt(1, (Integer) id);
            res = pstm.executeQuery();
            if (res.next()) {
                usuario = new Usuario.Builder()
                        .id(res.getInt("id"))
                        .usuario(res.getString("usuario"))
                        .password(res.getString("password"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return usuario;
    }

    @Override
    public void delete(Object id) {
        final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";
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

    public void close() {
        try {
            if (res != null) res.close();
            if (pstm != null) pstm.close();
            if (con != null) con.close();
        } catch (Exception e) {
            Log.e(TAG, "Error :" + e.getMessage());
            e.printStackTrace();
        }

    }
}
