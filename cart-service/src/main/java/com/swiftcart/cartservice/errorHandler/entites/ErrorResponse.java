package com.swiftcart.cartservice.errorHandler.entites;

public class ErrorResponse {
    private String message;
    private long timestamp;
    private int status;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ErrorResponse(String message, long timestamp, int status) {
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }

    public ErrorResponse() {
    }
}
