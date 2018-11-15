package com.example.radit.hotcen;

public class Profil {
    String nama, email, noId, password, nohp, tgl_lahir;

    public Profil(String nama, String email, String noId, String nohp, String tgl_lahir) {
        this.nama = nama;
        this.email = email;
        this.noId = noId;
        this.nohp = nohp;
        this.tgl_lahir = tgl_lahir;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
}


