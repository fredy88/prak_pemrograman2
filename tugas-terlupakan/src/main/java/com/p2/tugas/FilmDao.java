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
        String sqlUpdate="UPDATE `film` SET `judul`=?,`tglRelease`=?,`rating`=?,`hargaFilm`=? WHERE id=?";
        
        if(f.getId()==null){
            PreparedStatement psSimpan = c.prepareStatement(sqlSimpan);
            psSimpan.setString(1, f.getJudul());
            psSimpan.setDate(2,new java.sql.Date(f.getTglRelease().getTime()));
            psSimpan.setInt(3, f.getRating());
            psSimpan.setBigDecimal(4, f.getHargaFilm());

            psSimpan.executeUpdate();
        }else{
            //update
            PreparedStatement psUpdate = c.prepareStatement(sqlUpdate);
            psUpdate.setString(1, f.getJudul());
            psUpdate.setDate(2,new java.sql.Date(f.getTglRelease().getTime()));
            psUpdate.setInt(3, f.getRating());
            psUpdate.setBigDecimal(4, f.getHargaFilm());
            psUpdate.setInt(5, f.getId());

            psUpdate.executeUpdate();
        }
        c.close();
    }
    
    public List<Film> tampilFilm() throws SQLException{
        List<Film> lf = new ArrayList<Film>();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
        String sqlTampil = "SELECT * FROM film";
        PreparedStatement psTampil = c.prepareStatement(sqlTampil);
        ResultSet rs = psTampil.executeQuery();
        while(rs.next()){
            Film f = rsToFilm(rs);
            lf.add(f);
        }
        c.close();
        return lf;
    }

    private Film rsToFilm(ResultSet rs) throws SQLException {
        Film f = new Film();
        f.setId(rs.getInt("id"));
        f.setJudul(rs.getString("judul"));
        f.setTglRelease(rs.getDate("tglRelease"));
        f.setRating(rs.getInt("rating"));
        f.setHargaFilm(rs.getBigDecimal("hargaFilm"));
        return f;
    }
    
    public Film cariFilmByJudul(String judul) throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
        String sqlCariFilmByJudul="SELECT * from film where judul=?";
        PreparedStatement psCariFilmByJudul = c.prepareStatement(sqlCariFilmByJudul);
        psCariFilmByJudul.setString(1, judul);
        ResultSet rs = psCariFilmByJudul.executeQuery();
        if(!rs.next()){
            return null;
        }
        Film f = rsToFilm(rs);
        c.close();
        return f;
    }
    
    public void hapusFilmById(Integer id) throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_terlupakan","root","");
        String sqlHapusFilmById="DELETE from film where id=?";
        PreparedStatement psHapusFilmById = c.prepareStatement(sqlHapusFilmById);
        psHapusFilmById.setInt(1, id);
        psHapusFilmById.executeUpdate();
        c.close();
    }
}