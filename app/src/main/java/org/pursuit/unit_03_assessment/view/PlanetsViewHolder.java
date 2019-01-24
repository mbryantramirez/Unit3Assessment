package org.pursuit.unit_03_assessment.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.PlanetObjects;

public class PlanetsViewHolder extends RecyclerView.ViewHolder {
    private TextView tile;
    private CardView cardView;

    public PlanetsViewHolder(@NonNull View itemView) {
        super(itemView);
        tile = itemView.findViewById(R.id.tile);
        cardView = itemView.findViewById(R.id.cardview);
    }

    public void onBind(final PlanetObjects objects){
        tile.setText(objects.getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);

                String name = objects.getName();
                int number = objects.getNumber();
                String image = objects.getImage();

                intent.putExtra(v.getResources().getString(R.string.name_key), name);
                intent.putExtra(v.getResources().getString(R.string.number_key), number);
                intent.putExtra(v.getResources().getString(R.string.image_key), image);

                v.getContext().startActivity(intent);
            }
        });
    }
}
