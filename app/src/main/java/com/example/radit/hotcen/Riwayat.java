package com.example.radit.hotcen;

public class Riwayat {
    private String namarumahsakit, namaklinik, tanggalkunjungan;

    public Riwayat(String namarumahsakit, String namaklinik, String tanggalkunjungan) {
        this.namarumahsakit = namarumahsakit;
        this.namaklinik = namaklinik;
        this.tanggalkunjungan = tanggalkunjungan;
    }

    public String getNamarumahsakit() {
        return namarumahsakit;
    }

    public void setNamarumahsakit(String namarumahsakit) {
        this.namarumahsakit = namarumahsakit;
    }

    public String getNamaklinik() {
        return namaklinik;
    }

    public void setNamaklinik(String namaklinik) {
        this.namaklinik = namaklinik;
    }

    public String getTanggalkunjungan() {
        return tanggalkunjungan;
    }

    public void setTanggalkunjungan(String tanggalkunjungan) {
        this.tanggalkunjungan = tanggalkunjungan;
    }
}
