package com.dimathicc.yapyard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoDTO {
    private Double lat;
    private Double lng;
}
