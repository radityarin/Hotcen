package com.example.radit.hotcen;

public class Dokter {
    private String namadokter, jadwaldokter;

    public Dokter(String namadokter, String jadwaldokter) {
        this.namadokter = namadokter;
        this.jadwaldokter = jadwaldokter;
    }

    public String getNamadokter() {
        return namadokter;
    }

    public void setNamadokter(String namadokter) {
        this.namadokter = namadokter;
    }

    public String getJadwaldokter() {
        return jadwaldokter;
    }

    public void setJadwaldokter(String jadwaldokter) {
        this.jadwaldokter = jadwaldokter;
    }
}
