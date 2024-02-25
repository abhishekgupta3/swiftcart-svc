package com.ecommerce.swiftcart.dto;

public class AuthResponseDto {
    private String jwtToken;
    private String message;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthResponseDto(String jwtToken, String message) {
        this.jwtToken = jwtToken;
        this.message = message;
    }

    public AuthResponseDto() {
    }
}
