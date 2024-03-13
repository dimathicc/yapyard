package com.dimathicc.yapyard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private String street;
    private String suite;
    private String city;
    @JsonProperty("zipcode")
    private String zipCode;
    @JsonProperty("geo")
    private GeoDTO geoDTO;
}