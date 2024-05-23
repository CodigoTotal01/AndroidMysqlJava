package com.example.masterpiece.features.empleados.daos;

import android.util.Log;

import com.example.masterpiece.features.empleados.entities.Empleado;
import com.example.masterpiece.features.empleados.services.IEmpleadoService;
import com.example.masterpiece.utils.connectiondb.ConnectionDB;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EmpleadoDAO implements IEmpleadoService {
    private static PreparedStatement pstm;

    private static ResultSet res;

    private static ConnectionDB con;

    private static final String TAG = "Usuario_DAO";

    public EmpleadoDAO() {
        con = ConnectionDB.getInstance();
    }


    @Override
    public Boolean insert(Empleado empleado) {
        return null;
    }

    @Override
    public Boolean update(Empleado empleado) {
        return null;
    }

    @Override
    public List<Empleado> list() {
        List<Empleado> empleados = new ArrayList<>();
        final String SQL_SELECT = "SELECT * FROM empleados";
        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            res = pstm.executeQuery();
            while (res.next()) {
                Empleado empleado = new Empleado.Builder()
                        .id(res.getInt("id"))
                        .nombre(res.getString("nombre"))
                        .puesto(res.getString("puesto"))
                        .salario(res.getBigDecimal("salario"))
                        .build();
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            Log.e(TAG, "Error al listar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            close();
        }

        return empleados;
    }

    @Override
    public Empleado listById(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

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
