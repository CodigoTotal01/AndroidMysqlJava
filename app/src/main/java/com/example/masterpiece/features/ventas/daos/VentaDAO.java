package com.example.masterpiece.features.ventas.daos;

import android.util.Log;

import com.example.masterpiece.features.ventas.entities.Venta;
import com.example.masterpiece.features.ventas.services.IVentaService;
import com.example.masterpiece.utils.connectiondb.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO implements IVentaService {

    private static PreparedStatement pstm;

    private static ResultSet res;

    private static ConnectionDB con;

    private static final String TAG = "Venta_DAO";


    public VentaDAO() {
        con = ConnectionDB.getInstance();
    }


    @Override
    public Boolean insert(Venta venta) {

        String sql = "INSERT INTO ventas (id_usuario, id_producto, cantidad, total) VALUES (?, ?, ?, ?)";
        try {
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setInt(1, venta.getIdUsuario());
            pstm.setInt(2, venta.getIdProducto());
            pstm.setInt(3, venta.getCantidad());
            pstm.setBigDecimal(4, venta.getTotal());
            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
          close();
        }
    }

    @Override
    public Boolean update(Venta venta) {
        return null;
    }

    @Override
    public List<Venta> list() {
        List<Venta> ventas = new ArrayList<>();
        final String SQL_SELECT_ALL = "SELECT v.id, u.usuario as nombre_usuario, p.nombre as nombre_producto, v.cantidad, v.total " +
                "FROM ventas v " +
                "JOIN usuarios u ON v.id_usuario = u.id " +
                "JOIN productos p ON v.id_producto = p.id";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT_ALL);
            res = pstm.executeQuery();
            while (res.next()) {
                Venta venta = new Venta.Builder()
                        .id(res.getInt("id"))
                        .cantidad(res.getInt("cantidad"))
                        .total(res.getBigDecimal("total"))
                        .build();

                venta.setNombreUsuario(res.getString("nombre_usuario"));
                venta.setNombreProducto(res.getString("nombre_producto"));

                ventas.add(venta);
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }
        return ventas;
    }

    @Override
    public Venta listById(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {
        String sql = "DELETE FROM ventas WHERE id = ?";
        try {
            pstm = con.getConnection().prepareStatement(sql);
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
