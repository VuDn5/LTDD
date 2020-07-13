package com.example.hw04.Data;

public class User {
    private String name;
    private String phone;

    public User() {
    }

    public User(String _name, String _phone){
        this.name = _name;
        this.phone = _phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
