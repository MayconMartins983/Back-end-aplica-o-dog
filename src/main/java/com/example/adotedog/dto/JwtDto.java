package com.example.adotedog.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtDto {

    @NonNull
    private String token;
    private String type = "Bearer";
}
