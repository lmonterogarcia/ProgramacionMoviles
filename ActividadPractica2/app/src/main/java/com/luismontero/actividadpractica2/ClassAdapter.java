package com.luismontero.actividadpractica2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> implements View.OnClickListener{

    private Context context;

    private View.OnClickListener listener;


    public ClassAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflated = LayoutInflater.from(context);
        View view = inflated.inflate(R.layout.class_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*
        String sCalle = Inmobiliaria.lstCasas.get(position).getsCalle();
        Integer iNumero = (Inmobiliaria.lstCasas.get(position).getiNumero());
        Double dSuperficie = (Inmobiliaria.lstCasas.get(position).getdSuperficie());

        holder.lblCalleNum.setText(sCalle + ", " + iNumero);
        holder.lblSuperficie.setText(Double.toString(dSuperficie) + " m2");
        */
    }

    @Override
    public int getItemCount() {
        //return Inmobiliaria.lstCasas.size();
        return 0;
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

        private TextView lblCalleNum;
        private TextView lblSuperficie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*
            lblCalleNum = itemView.findViewById(R.id.lblCalleNum);
            lblSuperficie = itemView.findViewById(R.id.lblSuperficie);
             */
        }
    }




}
