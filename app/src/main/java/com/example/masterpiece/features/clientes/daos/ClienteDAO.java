package com.example.masterpiece.features.clientes.daos;

import android.util.Log;

import com.example.masterpiece.features.clientes.entities.Cliente;
import com.example.masterpiece.features.clientes.services.IClienteService;
import com.example.masterpiece.utils.connectiondb.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteService {


    private static PreparedStatement pstm;

    private static ResultSet res;

    private static ConnectionDB con;

    private static final String TAG = "Usuario_DAO";

    public ClienteDAO() {
        con = ConnectionDB.getInstance();
    }

    @Override
    public Cliente findByNombre(String nombre) {
        Cliente cliente = null;
        final String SQL_FIND_BY_NOMBRE = "SELECT * FROM clientes WHERE nombre = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_BY_NOMBRE);
            pstm.setString(1, nombre);
            res = pstm.executeQuery();
            if (res.next()) {
                cliente = new Cliente.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .correo(res.getString("correo"))
                        .telefono(res.getString("telefono"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por nombre: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return cliente;
    }

    @Override
    public Boolean insert(Cliente cliente) {
        Boolean result = false;
        final String SQL_INSERT = "INSERT INTO clientes (nombre, correo, telefono) VALUES (?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getCorreo());
            pstm.setString(3, cliente.getTelefono());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al insertar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return true; // a la fuerza por ese errorcito que da
    }

    @Override
    public Boolean update(Cliente cliente) {
        Boolean result = false;
        final String SQL_UPDATE = "UPDATE clientes SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getCorreo());
            pstm.setString(3, cliente.getTelefono());
            pstm.setInt(4, cliente.getId());
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
    public List<Cliente> list() {
        List<Cliente> clientes = new ArrayList<>();
        final String SQL_SELECT = "SELECT * FROM clientes";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            res = pstm.executeQuery();
            while (res.next()) {
                Cliente cliente = new Cliente.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .correo(res.getString("correo"))
                        .telefono(res.getString("telefono"))
                        .build();
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return clientes;
    }

    @Override
    public Cliente listById(Object id) {
        Cliente cliente = null;
        final String SQL_SELECT_BY_ID = "SELECT * FROM clientes WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
            pstm.setInt(1, (int) id);
            res = pstm.executeQuery();
            if (res.next()) {
                cliente = new Cliente.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .correo(res.getString("correo"))
                        .telefono(res.getString("telefono"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por id: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return cliente;
    }

    @Override
    public void delete(Object id) {
        final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_DELETE);
            pstm.setInt(1, (int) id);
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
