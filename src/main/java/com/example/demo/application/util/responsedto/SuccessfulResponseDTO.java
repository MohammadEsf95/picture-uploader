package com.example.demo.application.util.responsedto;

public class SuccessfulResponseDTO {
    private String id;
    private String message;

    public SuccessfulResponseDTO(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public SuccessfulResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }
}
