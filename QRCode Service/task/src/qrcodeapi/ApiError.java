package qrcodeapi;

public class ApiError {
    String error;

    public ApiError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
