package com.stardust.android.qro.model;

public class User {

    private int userId;
    private String username;
    private String lastname;
    private String phone;
    private String email;
    private String balance;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.lastname = builder.lastname;
        this.phone = builder.phone;
        this.balance = builder.balance;
        this.email = builder.email;

    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return username;
    }

    public String getLastName() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBalance() {
        return balance;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public static class Builder {
        private int userId;
        private String username;
        private String lastname;
        private String phone;
        private String email;
        private String balance;

        public Builder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String username) {
            this.username = username;
            return this;
        }

        public Builder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder balance(String balance) {
            this.balance = balance;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
