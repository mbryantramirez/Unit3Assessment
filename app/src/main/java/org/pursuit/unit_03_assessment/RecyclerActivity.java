package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.controller.PlanetsAdapter;
import org.pursuit.unit_03_assessment.model.PlanetArray;
import org.pursuit.unit_03_assessment.model.PlanetObjects;
import org.pursuit.unit_03_assessment.network.PlanetsInterface;
import org.pursuit.unit_03_assessment.network.RetroFitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerActivity extends AppCompatActivity {
    private static final String LOGIDENTIFIER = "TAGTAGTAG";
    private RecyclerView recyclerView;
    private PlanetsAdapter adapter;
    private List<PlanetObjects> planetsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new PlanetsAdapter(planetsList);
        retroFitResponse();


        /*
        * TODO 5. Subclass a RecyclerView Adapter
        * TODO 6. Subclass a RecyclerView ViewHolder
        * TODO 7. Pass list to RecyclerView
        * TODO 8. Display planet name in a RecyclerView tile
        * TODO 9. Implement an OnClickListener for the itemview
        * TODO 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
        */

    }

    public void retroFitResponse(){
        /*
         * TODO: Add logic that will:
         * TODO 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
         * TODO 2. Make data model objects based on JSON
         * TODO 3. Make a service interface with method(s) to make a GET request
         * TODO 4. Make a request to the JSON endpoint using the Retrofit instance and the service
         */
        Retrofit retrofit = RetroFitSingleton.getInstance();
        retrofit.create(PlanetsInterface.class)
                .getPlanets()
                .enqueue(new Callback<PlanetArray>() {
                    @Override
                    public void onResponse(Call<PlanetArray> call, Response<PlanetArray> response) {
                        Log.d(LOGIDENTIFIER, "OnResponse: " + response.body().getPlanets().get(0).getName());
                        Log.d(LOGIDENTIFIER, "OnResponse: " + response.body().getPlanets().get(0).getNumber());
                        Log.d(LOGIDENTIFIER, "OnResponse: " + response.body().getPlanets().get(0).getImage());

                        for(int i = 0; i < response.body().getPlanets().size(); i++){
                            planetsList.add(response.body().getPlanets().get(i));
                        }
                        Log.d(LOGIDENTIFIER, "Size: " + planetsList.size());

                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }

                    @Override
                    public void onFailure(Call<PlanetArray> call, Throwable t) {
                        Log.d(LOGIDENTIFIER, "OnFailure: " + t.getMessage());
                    }
                });
    }
}
