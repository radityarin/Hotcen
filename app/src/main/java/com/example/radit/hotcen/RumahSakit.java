package com.example.radit.hotcen;

import java.util.ArrayList;

public class RumahSakit {
    private String alamat, nama, nohp, url;

    public RumahSakit() {

    }

    public RumahSakit(String alamat, String nama, String nohp, String url) {
        this.alamat = alamat;
        this.nama = nama;
        this.nohp = nohp;
        this.url = url;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
