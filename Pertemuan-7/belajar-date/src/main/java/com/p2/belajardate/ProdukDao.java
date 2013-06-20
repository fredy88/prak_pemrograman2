package com.p2.belajar.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdukDao {
    
    public void simpanProduk(Produk p) throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2","root","");
        String sqlSimpan = "INSERT INTO `produk`(`kodeProduk`, `idJenis`, `nama`, `harga`, `waktuInput`) VALUES (?,?,?,?,?)";
        PreparedStatement psSimpan = c.prepareStatement(sqlSimpan);
        psSimpan.setString(1, p.getKodeProduk());
        psSimpan.setInt(2, p.getJp().getId());
        psSimpan.setString(3, p.getNama());
        psSimpan.setBigDecimal(4, p.getHarga());
        psSimpan.setDate(5, new java.sql.Date(p.getWaktuInput().getTime()));
        
        psSimpan.executeUpdate();
        c.close();
    }
    
    public List<Produk> tampilProduk() throws SQLException{
        List<Produk> lp = new ArrayList<Produk>();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2","root","");
        String sqlTampil = "SELECT * FROM produk ";
        PreparedStatement psTampil = c.prepareStatement(sqlTampil);
        ResultSet rs = psTampil.executeQuery();
        while(rs.next()){
            Produk p = new Produk();
            p.setId(rs.getInt("id"));
            p.setKodeProduk(rs.getString("kodeProduk"));
            p.setNama(rs.getString("nama"));
            p.setWaktuInput(rs.getDate("waktuInput"));
            
            JenisProduk jp = jpByid(rs.getInt("idJenis"));
            p.setJp(jp);
            
            lp.add(p);
        }
        c.close();
        return lp;
    }
    
    public JenisProduk jpByid(Integer id) throws SQLException{
        JenisProduk jp = new JenisProduk();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2","root","");
        
        String sqlTampilJenis = "SELECT * FROM jenis WHERE id=?";
        PreparedStatement psTampilJenis = c.prepareStatement(sqlTampilJenis);
        psTampilJenis.setInt(1, id);
        ResultSet rs = psTampilJenis.executeQuery();
        if(!rs.next()){
            return null;
        }
        jp.setId(rs.getInt("id"));
        jp.setNamaJenis(rs.getString("namaJenis"));
        
        c.close();
        return jp;
    }
}
