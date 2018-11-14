package com.example.radit.hotcen;

import java.util.ArrayList;

public class RumahSakit {
    private String url,nama,alamat,nohp;


    public RumahSakit(String url, String nama, String alamat, String nohp) {
        this.url = url;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
