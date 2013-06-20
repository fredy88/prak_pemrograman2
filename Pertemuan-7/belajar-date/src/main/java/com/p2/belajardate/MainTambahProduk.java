package com.p2.belajar.jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

public class MainTambahProduk {
    public static void main(String[] args) throws SQLException{
        JenisProduk jp = new JenisProduk();
        ProdukDao pd = new ProdukDao();
        
        //input produk pertama
        Produk p1 = new Produk();
        p1.setKodeProduk("p001");
        p1.setNama("susu bendera");
        p1.setHarga(new BigDecimal(1500));
        p1.setWaktuInput(new Date());
        
        //set objek jenis produk
        jp.setId(1);
        p1.setJp(jp);
        
        pd.simpanProduk(p1);
        
        //input produk ke 2
        
        //set objek jenis produk        
        Produk p2 = new Produk();
        
        jp.setId(3);
        p2.setJp(jp);
        
        p2.setKodeProduk("p002");
        p2.setNama("indomie kari ayam");
        p2.setHarga(new BigDecimal(1600));
        p2.setWaktuInput(new Date());
               
        pd.simpanProduk(p2);
    }
}
