package com.example.masterpiece.features.productos.daos;

import android.util.Log;

import com.example.masterpiece.features.productos.entities.Producto;
import com.example.masterpiece.features.productos.services.IProductoService;
import com.example.masterpiece.utils.connectiondb.ConnectionDB;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements IProductoService {

    private static PreparedStatement pstm;

    private static ResultSet res;

    private static ConnectionDB con;

    private static final String TAG = "Producto_DAO";

    public ProductoDAO() {
        con = ConnectionDB.getInstance();
    }
    @Override
    public Producto findByNombre(String nombre) {
        Producto producto = null;
        final String SQL_FIND_BY_NOMBRE = "SELECT * FROM productos WHERE nombre = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_FIND_BY_NOMBRE);
            pstm.setString(1, nombre);
            res = pstm.executeQuery();
            if (res.next()) {
                producto = new Producto.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .tipo(res.getString("tipo"))
                        .urlImagen(res.getString("url_imagen"))
                        .precio(new BigDecimal(res.getString("precio")))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al buscar por nombre: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return producto;
    }

    @Override
    public Boolean insert(Producto producto) {
        Boolean isInserted = false;
        final String SQL_INSERT = "INSERT INTO productos (nombre, tipo, precio, url_imagen) VALUES (?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);
            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getTipo());
            pstm.setBigDecimal(3, producto.getPrecio());
            pstm.setString(4, producto.getUrlImagen());
            int affectedRows = pstm.executeUpdate();
            isInserted = affectedRows > 0;
        } catch (SQLException e) {
            Log.e(TAG, "Error al insertar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
         return  true;//forzado
    }

    @Override
    public Boolean update(Producto producto) {
        Boolean isUpdated = false;
        final String SQL_UPDATE = "UPDATE productos SET nombre = ?, tipo = ?, precio = ?, url_imagen = ? WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getTipo());
            pstm.setBigDecimal(3, producto.getPrecio());
            pstm.setString(4, producto.getUrlImagen());
            pstm.setInt(5, producto.getId());
            int affectedRows = pstm.executeUpdate();
            isUpdated = affectedRows > 0;
        } catch (SQLException e) {
            Log.e(TAG, "Error al actualizar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return isUpdated;
    }
    @Override
    public List<Producto> list() {
        List<Producto> productos = new ArrayList<>();
        final String SQL_SELECT = "SELECT * FROM productos";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            res = pstm.executeQuery();
            while (res.next()) {
                Producto producto = new Producto.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .tipo(res.getString("tipo"))
                        .precio(new BigDecimal(res.getString("precio")))
                        .urlImagen(res.getString("url_imagen"))
                        .build();
                productos.add(producto);
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return productos;
    }

    @Override
    public Producto listById(Object id) {
        Producto producto = null;
        final String SQL_SELECT_BY_ID = "SELECT * FROM productos WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
            pstm.setInt(1, (Integer) id);
            res = pstm.executeQuery();
            if (res.next()) {
                producto = new Producto.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .tipo(res.getString("tipo"))
                        .precio(new BigDecimal(res.getString("precio")))
                        .urlImagen(res.getString("url_imagen"))
                        .build();
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar por ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return producto;
    }

    @Override
    public void delete(Object id) {
        final String SQL_DELETE = "DELETE FROM productos WHERE id = ?";
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
