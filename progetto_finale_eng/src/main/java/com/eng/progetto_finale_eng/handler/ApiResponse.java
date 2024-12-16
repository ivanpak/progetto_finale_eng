package com.eng.progetto_finale_eng.handler;

public class ApiResponse {
    private boolean success;
    private String message;

    // Costruttore
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getter e Setter
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
