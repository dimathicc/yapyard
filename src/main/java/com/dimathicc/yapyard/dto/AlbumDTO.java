package com.dimathicc.yapyard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumDTO {
    private Long userId;
    private Long id;
    private String title;
}
