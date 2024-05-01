package com.ecommerce.swiftcart.dto;

public class ResponseDto {
    private String message;
    private String error;

    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto() {
    }

    public ResponseDto(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
