package com.example.friendfinderapp.Model;

import java.util.List;

public class ResponseModel {
    public List<User_Model> dataUser;
    public  String pesan, fullname;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }


    public List<User_Model> getDataUser() {
        return dataUser;
    }
    public void setDataUser(List<User_Model> dataUser) {
        this.dataUser = dataUser;
    }
}