package com.luismontero.listadetareas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.ViewHolder> implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;


    public TareaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflated = LayoutInflater.from(context);
        View view = inflated.inflate(R.layout.tarea_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String sTitulo = Store.lstTareas.get(position).getsTitulo();
        String sFecha = Store.lstTareas.get(position).getsFecha();
        String sHora = Store.lstTareas.get(position).getsHora();

        holder.lblTareaTitulo.setText(sTitulo);
        holder.lblFecha.setText(sFecha);
        holder.lblHora.setText(sHora);

        switch (Store.lstTareas.get(position).getiCategoria()){ //ESTO NO FUNCIONAAAAAAAA**************************
            case 0: holder.card.setCardBackgroundColor(R.color.clr_personal); break;
            case 1: holder.card.setCardBackgroundColor(R.color.clr_trabajo); break;
            case 2: holder.card.setCardBackgroundColor(R.color.clr_casa); break;
            case 3: holder.card.setCardBackgroundColor(R.color.clr_vacaciones); break;
        }

    }

    @Override
    public int getItemCount() { return Store.lstTareas.size(); }

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


        private TextView lblTareaTitulo;
        private TextView lblFecha;
        private TextView lblHora;
        private CardView card;
        private Resources res;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            res = itemView.getResources();
            lblTareaTitulo = itemView.findViewById(R.id.lblTareaTitulo);
            lblFecha = itemView.findViewById(R.id.lblFecha);
            lblHora = itemView.findViewById(R.id.lblHora);
            card = itemView.findViewById(R.id.cvGeneral);

        }
    }




}
