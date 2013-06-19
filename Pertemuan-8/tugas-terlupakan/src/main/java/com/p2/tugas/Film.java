package com.p2.tugas;

import java.math.BigDecimal;
import java.util.Date;

public class Film {
    private Integer id;
    private String judul;
    private Date tglRelease;
    private Integer rating;
    private BigDecimal hargaFilm;

    public BigDecimal getHargaFilm() {
        return hargaFilm;
    }

    public void setHargaFilm(BigDecimal hargaFilm) {
        this.hargaFilm = hargaFilm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getTglRelease() {
        return tglRelease;
    }

    public void setTglRelease(Date tglRelease) {
        this.tglRelease = tglRelease;
    }
}
