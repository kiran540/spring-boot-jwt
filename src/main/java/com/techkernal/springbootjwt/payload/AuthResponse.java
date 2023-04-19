package com.techkernal.springbootjwt.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String bearer = "Bearer";

    public AuthResponse(String token) {
        this.token = token;
    }
}
