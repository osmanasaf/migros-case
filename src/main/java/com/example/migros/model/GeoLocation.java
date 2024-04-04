package com.example.migros.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class GeoLocation implements Serializable {

    @JsonProperty("lat")
    @NotNull(message = "Latitude cannot be null")
    @Min(value = -90, message = "Latitude must be greater than or equal to -90")
    @Max(value = 90, message = "Latitude must be less than or equal to 90")
    private Double lat;

    @JsonProperty("lng")
    @NotNull(message = "Longitude cannot be null")
    @Min(value = -180, message = "Longitude must be greater than or equal to -180")
    @Max(value = 180, message = "Longitude must be less than or equal to 180")
    private Double lng;

    public GeoLocation(double v, double v1) {
        this.lat = v;
        this.lng = v1;
    }

    public GeoLocation() {
    }
}