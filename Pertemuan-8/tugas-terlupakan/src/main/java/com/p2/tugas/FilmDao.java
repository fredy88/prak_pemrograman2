package com.p2.tugas;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    
    public void simpanFilm(Film f) throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
        String sqlSimpan="INSERT INTO `film`(`judul`, `tglRelease`, `rating`, `hargaFilm`) VALUES "
                + "(?,?,?,?)";
        PreparedStatement psSimpan = c.prepareStatement(sqlSimpan);
        psSimpan.setString(1, f.getJudul());
        psSimpan.setDate(2,new java.sql.Date(f.getTglRelease().getTime()));
        psSimpan.setInt(3, f.getRating());
        psSimpan.setBigDecimal(4, f.getHargaFilm());
        
        psSimpan.executeUpdate();
        c.close();
    }
    
	public Film cari(String judul) throws SQLException{
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
		String sqlCari="select * from film where judul=?";
		PreparedStatement psCari = c.prepareStatement(sqlCari);
		psCari.setString(1,judul);
		ResultSet rs = psCari.executeQuery();
		if(!rs.next()){
			return null;
		}
		
		Film f = new Film();
		f.setId(rs.getInt("id"));
		f.setJudul(rs.getString("judul"));
		f.setTglRelease(rs.getDate("tglRelease"));
		f.setRating(rs.getInt("rating"));
		f.setHargaFilm(rs.getBigDecimal("hargaFilm"));
		
		c.close();
		return f;
	}  
	
    public List<Film> tampilFilm() throws SQLException{
        List<Film> lf = new ArrayList<Film>();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
        String sqlTampil = "SELECT * FROM film";
        PreparedStatement psTampil = c.prepareStatement(sqlTampil);
        ResultSet rs = psTampil.executeQuery();
        while(rs.next()){
            Film f = new Film();
            f.setId(rs.getInt("id"));
            f.setJudul(rs.getString("judul"));
            f.setTglRelease(rs.getDate("tglRelease"));
            f.setRating(rs.getInt("rating"));
            f.setHargaFilm(rs.getBigDecimal("hargaFilm"));
            
            lf.add(f);
        }
        c.close();
        return lf;
    }				
		public void hapusFilm(int id) throws SQLException{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
			String query = "DELETE FROM film WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			Film f = new Film();
			ps.setInt(f.getId());
			ps.executeUpdate();
		
	}
}