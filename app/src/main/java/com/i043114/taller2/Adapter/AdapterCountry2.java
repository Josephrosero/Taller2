package com.i043114.taller2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.i043114.taller2.Models.Country2;
import com.i043114.taller2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 26/09/2017.
 */


    public class AdapterCountry2 extends RecyclerView.Adapter<AdapterCountry2.ViewHolder> {
        List<Country2> countryList = new ArrayList<>();
        Context context;

        // Constructor de la clase
        public AdapterCountry2(List<Country2> countryList, Context context) {
            this.countryList = countryList;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Configuracion del ViewAdapter
            // Obtener la vista (item.xml)
            View item2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
            // Pasar la vista (item.xml) al ViewHolder
            ViewHolder viewHolder = new ViewHolder(item2);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // Encargado de trabajar con el item.xml y sus componentes
            holder.textViewName.setText(countryList.get(position).getName());
            holder.textViewCapital.setText(countryList.get(position).getCapital());
            holder.textViewAlphs.setText(countryList.get(position).getAlphacode());
            holder.textViewRegion.setText(countryList.get(position).getRegion());
            holder.textViewPopulation.setText(countryList.get(position).getPopulation());
        }

        @Override
        public int getItemCount() {
            return countryList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textViewName;
            TextView textViewCapital;
            TextView textViewAlphs;
            TextView textViewRegion;
            TextView textViewPopulation;

            public ViewHolder(View item2) {
                super(item2);
                textViewName = (TextView) item2.findViewById(R.id.id_tv_item_email11);
                textViewCapital = (TextView) item2.findViewById(R.id.id_tv_item_email12);
                textViewAlphs = (TextView) item2.findViewById(R.id.id_tv_item_email13);
                textViewRegion = (TextView)item2.findViewById(R.id.id_tv_item_email14);
                textViewPopulation = (TextView)item2.findViewById(R.id.id_tv_item_email15);
            }
        }
    }

