package com.pratik.dto;

import java.util.ArrayList;
import java.util.List;

public class SuccessResponse<T> {
    private boolean success;
    private String message;
    private List<T> data;

    public SuccessResponse(boolean success, String message, T d) {
        this.success = success;
        this.message = message;
        this.data = new ArrayList<>();
        this.data.add(d);
    }

    public SuccessResponse(boolean success, String message, List<T> data) {
        this.success = success;
        this.message = message;
        this.data = data != null ? new ArrayList<>(data) : new ArrayList<>();
    }

    // Getters and Setters

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

    public List<T> getData() {
        return this.data;
    }

    public void setData(T d) {
        this.data.add(d);
    }
}

