package com.example.masterpiece.features.empleados.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.R;
import com.example.masterpiece.features.clientes.adapter.ClienteAdapter;
import com.example.masterpiece.features.clientes.entities.Cliente;
import com.example.masterpiece.features.empleados.entities.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.ViewHolder> {
    private List<Empleado> empleados = new ArrayList<>();

    public EmpleadoAdapter(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @NonNull
    @Override
    public EmpleadoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.empleado_card_layout,null,false);

        return new EmpleadoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoAdapter.ViewHolder holder, int position) {
        Empleado empleado = empleados.get(position);
        holder.nombreTextView.setText(empleado.getNombre());
        holder.puestoTextView.setText(empleado.getPuesto());
        holder.salarioTextView.setText(empleado.getSalario().toString());
    }

    @Override
    public int getItemCount() {
        return empleados.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView;
        private TextView puestoTextView;
        private TextView salarioTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.tituloNombre);
            puestoTextView = itemView.findViewById(R.id.tituloPuesto);
            salarioTextView = itemView.findViewById(R.id.tituloSalario);

        }
    }
}
