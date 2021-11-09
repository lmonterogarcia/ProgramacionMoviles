package com.luismontero.gestiondearticulos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ArticulosAdapter extends RecyclerView.Adapter<ArticulosAdapter.ViewHolder> implements View.OnClickListener{

    private Context context;
    LayoutInflater inflated;
    
    private View.OnClickListener listener;


    public ArticulosAdapter(Context context) {
        inflated = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ArticulosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflated.inflate(R.layout.articulos_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosAdapter.ViewHolder holder, int position) {

        String sNombreArticulo = Store.lstArticulos.get(position).getsNombre();
        String sNombrePrecio = Double.toString(Store.lstArticulos.get(position).getdPrecio()) + " €";
        String sNombreStock = Integer.toString(Store.lstArticulos.get(position).getiStock()) + " Ud.";

        holder.lblNombre.setText(sNombreArticulo);
        holder.lblPrecio.setText(sNombrePrecio);
        holder.lblStock.setText(sNombreStock);
    }

    @Override
    public int getItemCount() {
        return Store.lstArticulos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView lblNombre;
        TextView lblPrecio;
        TextView lblStock;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblPrecio = itemView.findViewById(R.id.lblPrecio);
            lblStock = itemView.findViewById(R.id.lblStock);
        }
    }
    
    public void onClick(View.OnClickListener listener){
        this.listener = listener;

    }}
