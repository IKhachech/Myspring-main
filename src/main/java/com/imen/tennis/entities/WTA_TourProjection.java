package com.imen.tennis.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameTour", types = { WTA_Tour.class })
public interface WTA_TourProjection {
public String getNomProduit();
}