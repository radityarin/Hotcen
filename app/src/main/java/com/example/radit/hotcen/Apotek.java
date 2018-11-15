package com.example.radit.hotcen;

public class Apotek {

    private String nama,url;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Apotek(String nama, String url) {
        this.nama = nama;
        this.url = url;
    }
}
