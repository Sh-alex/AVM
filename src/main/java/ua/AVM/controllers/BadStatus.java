package ua.AVM.controllers;

public class BadStatus {
    private String error;

    public String getError() {
        return error;
    }

    public BadStatus(String error) {
        this.error = error;
    }
}
