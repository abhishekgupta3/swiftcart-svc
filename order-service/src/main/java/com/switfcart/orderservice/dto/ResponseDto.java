package com.switfcart.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String message;
    private String error;

    public ResponseDto(String msg) {
        this.message = msg;
    }
}
