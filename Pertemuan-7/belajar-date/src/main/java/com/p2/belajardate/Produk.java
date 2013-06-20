package com.p2.belajar.jdbc;

import java.math.BigDecimal;
import java.util.Date;

public class Produk {
    private Integer id;
    private String kodeProduk;
    private String nama;
    private BigDecimal harga;
    private Date waktuInput;
    private JenisProduk jp;

    public JenisProduk getJp() {
        return jp;
    }

    public void setJp(JenisProduk jp) {
        this.jp = jp;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getWaktuInput() {
        return waktuInput;
    }

    public void setWaktuInput(Date waktuInput) {
        this.waktuInput = waktuInput;
    }
    
}
