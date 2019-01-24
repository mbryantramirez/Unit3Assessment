package org.pursuit.unit_03_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.PlanetArray;
import org.pursuit.unit_03_assessment.model.PlanetObjects;
import org.pursuit.unit_03_assessment.view.PlanetsViewHolder;

import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsViewHolder> {
    List<PlanetObjects> planetObjectsList;

    public PlanetsAdapter(List<PlanetObjects> planetObjectsList) {
        this.planetObjectsList = planetObjectsList;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_content, viewGroup, false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder holder, int i) {
        holder.onBind(planetObjectsList.get(i));
    }

    @Override
    public int getItemCount() {
        return planetObjectsList.size();
    }
}
