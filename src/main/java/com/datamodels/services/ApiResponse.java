package com.datamodels.services;

public class ApiResponse {
    private int code;
    private String type;
    private String message;

    public ApiResponse(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiResponse)) return false;

        ApiResponse that = (ApiResponse) o;

        if (code != that.code) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
