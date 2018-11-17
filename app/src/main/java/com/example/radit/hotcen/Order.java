package com.example.radit.hotcen;

public class Order {
    private String namarumahsakit, namapoli, jadwal, namadokter,url;

    public Order(String namarumahsakit, String namapoli, String jadwal, String namadokter, String url) {
        this.namarumahsakit = namarumahsakit;
        this.namapoli = namapoli;
        this.jadwal = jadwal;
        this.namadokter = namadokter;
        this.url = url;
    }

    public String getNamarumahsakit() {
        return namarumahsakit;
    }

    public void setNamarumahsakit(String namarumahsakit) {
        this.namarumahsakit = namarumahsakit;
    }

    public String getNamapoli() {
        return namapoli;
    }

    public void setNamapoli(String namapoli) {
        this.namapoli = namapoli;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getNamadokter() {
        return namadokter;
    }

    public void setNamadokter(String namadokter) {
        this.namadokter = namadokter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
