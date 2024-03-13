package com.dimathicc.yapyard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    @JsonProperty("address")
    private AddressDTO addressDTO;
    private String phone;
    private String website;
    @JsonProperty("company")
    private CompanyDTO companyDTO;
}
