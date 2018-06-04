package com.kpi.movies.adapters;

/**
 * Created by lex on 04.06.18.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kpi.movies.models.Movies;
import com.kpi.movies.R;

import java.util.List;

public class RVAdapterResults extends RecyclerView.Adapter<RVAdapterResults.ViewHolder> {

    private List<Movies> results;

    public RVAdapterResults(List<Movies> stocks) {
        this.results= results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        results = results.get(position);
        holder.tvName.setText("Название валюты: "+results.getName());
        holder.tvVolume.setText("Цена "+String.valueOf(results.getVolume()));
        holder.tvAmount.setText("Количество "+String.format("%.2f", results.getPrice().getAmount()));
    }

    @Override
    public int getItemCount() {
        if (results == null)
            return 0;
        return results.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAmount;
        TextView tvVolume;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName =  itemView.findViewById(R.id.tvName);
            tvAmount =  itemView.findViewById(R.id.tvAmount);
            tvVolume =  itemView.findViewById(R.id.tvVolume);
        }
    }
}
