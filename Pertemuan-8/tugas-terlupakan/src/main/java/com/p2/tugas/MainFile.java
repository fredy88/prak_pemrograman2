package com.p2.tugas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MainFile {
    public static void main(String[] args) throws ParseException, SQLException{
        FilmDao fd = new FilmDao();
        Integer pilih=0;
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do{
            try{
                System.out.println("\n\t==MENU==");
                System.out.println("1. Tampil");
                System.out.println("2. Input");
                System.out.println("3. Cari");
                System.out.println("4. Keluar");
                System.out.print("Masukkan pilihan anda :");
                pilih = Integer.parseInt(in.readLine());
                switch(pilih){
                    case 1 : 
                        System.out.println("--daftar film--\n");
                        List<Film> lf = fd.tampilFilm();
                        if(lf.isEmpty()){
                            System.out.println("kosong");
                            break;
                        }

                        for (Film f : lf) {
                            System.out.println("judul : "+f.getJudul());
                            System.out.println("tgl release : "+new SimpleDateFormat("EEE, dd-MM-yyyy").format(f.getTglRelease()));
                            System.out.println("rating : "+f.getRating());
                            System.out.println("harga : "+f.getHargaFilm());
                            System.out.println("-----------------------------------\n");
                        }
                        break;
                    case 2 : 
                        Film f = new Film();
                        System.out.println("--input film--");
                        System.out.print("judul :"); 
                        f.setJudul(in.readLine());

                        System.out.print("tgl release (dd-MM-yyyy) :"); 
                        f.setTglRelease(new SimpleDateFormat("dd-MM-yyyy").parse(in.readLine()));

                        System.out.print("rating (1-10) :"); 
                        f.setRating(Integer.parseInt(in.readLine()));

                        System.out.print("harga film :");    
                        f.setHargaFilm(new BigDecimal(in.readLine()));

                        fd.simpanFilm(f);
                        break;
					case 3 :
						System.out.println("Cari");
						System.out.print("masukkan judul:");						
						Film of = fd.cari(in.readLine());
						
						if(of==null){
							System.out.println("film tidak ditemukan");
							break;
						}
						
						System.out.println("judul : "+of.getJudul());
						System.out.println("tgl release : "+new SimpleDateFormat("EEE, dd-MM-yyyy").format(of.getTglRelease()));
						System.out.println("rating : "+of.getRating());
						System.out.println("harga : "+of.getHargaFilm());
						System.out.println("-----------------------------------\n");
							System.out.println("MENU");
							System.out.println("=================");
							System.out.println("1.edit");
							System.out.println("2.hapus");								
							System.out.println("=================");
							System.out.print("Pilih : ");
							Integer pilihsubmenu = Integer.parseInt(in.readLine());
							switch(pilihsubmenu){
								case 1:
									  Film f = new Film();
                        System.out.println("--edit film--");
                        System.out.print("judul :"); 
                        f.setJudul(in.readLine());

                        System.out.print("tgl release (dd-MM-yyyy) :"); 
                        f.setTglRelease(new SimpleDateFormat("dd-MM-yyyy").parse(in.readLine()));

                        System.out.print("rating (1-10) :"); 
                        f.setRating(Integer.parseInt(in.readLine()));

                        System.out.print("harga film :");    
                        f.setHargaFilm(new BigDecimal(in.readLine()));

                        fd.simpanFilm(f); 
									break;
									
								case 2: 
									System.out.println("Delete");
						System.out.print("masukkan id film yang akan dihapus:");						
						Film fi = fd.hapusFilm(Integer.parseInt(in.readLine()));
						if(fi==null){
							System.out.println("film tidak ditemukan");
							}
									break;
							
                        break;
					
                    case 4 : 
                        System.out.println("Terima Kasih Sudah Menggunakan Program Ini...");
                        break;
                    default:
                        System.out.println("Pilihan Anda Salah");
                }
            }}catch(ParseException pe){
                System.out.println("Penulisan Tanggal Salah");
            }catch(NumberFormatException nfe){
                System.out.println("Terjadi Kesalahan Pada Inputan! ");
                pilih=1;
            }catch(IOException ioe){
                
            }}
        while(pilih!=4);
}}
