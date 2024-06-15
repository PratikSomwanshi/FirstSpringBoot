package com.pratik.dto;


import java.util.List;

public class ErrorResponse {
    private boolean success;
    private String error;
    private Explaination explaination;
    private List<?> data;

    public ErrorResponse(boolean success, String error, Explaination explaination, List<?> data) {
        this.success = success;
        this.error = error;
        this.explaination = explaination;
        this.data = data;
    }

    // Getters and Setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Explaination getExplaination() {
        return explaination;
    }

    public void setExplaination(Explaination explaination) {
        this.explaination = explaination;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static class Explaination {
        private String message;

        public Explaination(String message) {
            this.message = message;
        }

        // Getters and Setters

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

