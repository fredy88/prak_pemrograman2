package com.p2.jdbc.latihan;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
import javax.swing.*;

public class Update 
{
    public static void main( String[] args )
    {
		try{
			//paramenter yang dikirim adalah host,port , nama database ,user,password
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2","root","");
			
			Statement atm = conn.createStatement();
			String query = "UPDATE produk set nama='dipsi' ,harga='4500' WHERE nama='lala'";
			
			int hasil = atm.executeUpdate(query);
			
			if(hasil == 1){
				JOptionPane.showMessageDialog(null,"berhasil update");
			}
			else{
				JOptionPane.showMessageDialog(null,"gagal update");
			}
		}catch(SQLException se){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,se);
		}
    }
}
