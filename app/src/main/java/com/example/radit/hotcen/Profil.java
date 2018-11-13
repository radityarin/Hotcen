package com.example.radit.hotcen;

public class Profil {
    String nama, email, noId, password;

    public Profil(String nama, String email, String noId) {
        this.nama = nama;
        this.email = email;
        this.noId = noId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoId() {
        return noId;
    }

    public void setNoId(String noId) {
        this.noId = noId;
    }

    public String getPassword() {
        return password;
    }
}


