package com.luismontero.gestiondearticulos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticulosAdapter extends RecyclerView.Adapter<ArticulosAdapter.ViewHolder> implements View.OnClickListener{

    private Context context;
    
    private View.OnClickListener listener;


    public ArticulosAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ArticulosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflated = LayoutInflater.from(context);
        View view = inflated.inflate(R.layout.articulos_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosAdapter.ViewHolder holder, int position) {

        String sNombreArticulo = Store.lstArticulos.get(position).getsNombre();
        String sPrecio = (Store.lstArticulos.get(position).getdPrecio()) + " €";
        String sStock = (Store.lstArticulos.get(position).getiStock()) + " Ud.";

        holder.lblNombre.setText(sNombreArticulo);
        holder.lblPrecio.setText(sPrecio);
        holder.lblStock.setText(sStock);
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

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView lblNombre;
        private TextView lblPrecio;
        private TextView lblStock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblPrecio = itemView.findViewById(R.id.lblPrecio);
            lblStock = itemView.findViewById(R.id.lblStock);
        }
    }

}
