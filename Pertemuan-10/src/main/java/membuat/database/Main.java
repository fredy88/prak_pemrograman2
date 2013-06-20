package com.p2.sesi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.util.Scanner;
import java.lang.String;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.lang.reflect.InvocationTargetException;

public class Main{
	public static void main(String[] args){
		Scanner data = new Scanner(System.in);
		int pilih = 0;
		int pilihSub = 0;
		
		while(pilih != 6){
			System.out.println("=================");
			System.out.println("MENU PILIHAN");
			System.out.println("1. Tampil daftar mahasiswa");
			System.out.println("2. Input mahasiswa");
			System.out.println("3. Pencarian mahasiswa");
			System.out.println("4. Tampil daftar mata kuliah");
			System.out.println("5. Tambah mata kuliah");
			System.out.println("6. Keluar");
			System.out.print("Masukan Pilihan Anda : ");
			
			pilih = data.nextInt();
			data.nextLine();
			if(pilih == 1){
				try{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2prak10","root","");
					String sql = "SELECT * FROM mahasiswa ";
					
					PreparedStatement psTampil = c.prepareStatement(sql);
					ResultSet rs = psTampil.executeQuery();
					
					while(rs.next()){
						System.out.println("------------------------------");
						System.out.println("NIM : " + rs.getInt("nim"));
						System.out.println("Nama : " + rs.getString("nama"));
						System.out.println("Alamat : " + rs.getString("alamat"));
						System.out.println("Semester : " + rs.getInt("semester"));
						System.out.println("------------------------------");
					}
					
					c.close();
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}	
			}
			else if(pilih == 2){
				System.out.println("--------------------------------");
				System.out.println("Input Data Mahasiswa");
				System.out.println("--------------------------------");
				
				System.out.println("Masukkan NIM : ");
				String nim = data.nextLine();
				System.out.println("Masukkan nama : ");
				String nama = data.nextLine();
				System.out.println("Masukkan alamat : ");
				String alamat = data.nextLine();
				System.out.println("Masukkan semester : ");
				int semester = data.nextInt();
				
				try{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2prak10","root","");
					String sql = "insert into mahasiswa (nim, nama, alamat, semester) values (?,?,?,?)";
					PreparedStatement ps = c.prepareStatement(sql);
					
					ps.setString(1, nim);
					ps.setString(2, nama);
					ps.setString(3, alamat);
					ps.setInt(4, semester);
					ps.executeUpdate();
					
					c.close();
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}
			}
			else if(pilih == 3){
				System.out.println("--------------------------------");
				System.out.println("Pencarian Data Mahasiswa");
				System.out.println("--------------------------------");
				
				System.out.println("Masukkan NIM mahasiswa : ");
				String nim = data.nextLine();
				try{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2prak10","root","");
					String sql = "SELECT * FROM mahasiswa";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, nim);
					ResultSet rs = ps.executeQuery();
					
					if(nim.equals(rs.getString()))
					
				}
				catch(SQLException SE){
					SE.printStackTrace();
				}
			}else if(pilih == 4){
			
			}else if(pilih == 5){
			
			}
		}
		System.out.println("Untuk keluar, tekan ENTER");
		data.nextLine();
	}
}