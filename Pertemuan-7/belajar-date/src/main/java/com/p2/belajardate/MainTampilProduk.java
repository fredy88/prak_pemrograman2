package com.p2.belajar.jdbc;

import java.sql.SQLException;
import java.util.List;

public class MainTampilProduk {
    public static void main(String[] args) throws SQLException{
        ProdukDao pd = new ProdukDao();
        List<Produk> lp = pd.tampilProduk();
        
        for (Produk p : lp) {
            System.out.println("kode : "+p.getKodeProduk());
            System.out.println("jenis : "+p.getJp().getNamaJenis());
            System.out.println("nama : "+p.getNama());
            System.out.println("harga : "+p.getNama());
            System.out.println("waktu input : "+p.getWaktuInput());
            System.out.println("----------------");
        }
    }
}
