package org.architectsforcharity.architectsback.services;

public class PasswordTokenDto {
    private String token;
    private String password;

    public PasswordTokenDto(String token, String password) {
        this.token = token;
        this.password = password;
    }

    public PasswordTokenDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
