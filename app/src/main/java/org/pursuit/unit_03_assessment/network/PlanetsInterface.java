package org.pursuit.unit_03_assessment.network;

import org.pursuit.unit_03_assessment.model.PlanetArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetsInterface {
    @GET("/JDVila/storybook/master/planets.json")
    Call<PlanetArray> getPlanets();
}
