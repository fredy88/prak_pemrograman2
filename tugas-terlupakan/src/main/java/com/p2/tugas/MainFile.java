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
    
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws ParseException, SQLException{
        FilmDao fd = new FilmDao();        
        Integer pilih=0;
        Integer subMenuCari=0;
        Film film = new Film();
        
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
                        film = new Film();
                        System.out.println("--input film--");
                        film = inputFilm(film);

                        fd.simpanFilm(film);
                        break;
                    case 3 : 
                        System.out.println("--Cari Film--");
                        System.out.print("masukkan nama film :");
                        String judul = in.readLine();                        
                        film = new Film();
                        film = fd.cariFilmByJudul(judul);
                        if(film != null){
                            System.out.println("judul : "+film.getJudul());
                            System.out.println("tgl release : "+new SimpleDateFormat("EEE, dd-MM-yyyy").format(film.getTglRelease()));
                            System.out.println("rating : "+film.getRating());
                            System.out.println("harga : "+film.getHargaFilm());
                            System.out.println("-----------------------------------\n");
                            System.out.println("1. Edit");
                            System.out.println("2. Hapus");
                            System.out.print("masukkan pilihan anda :");
                            subMenuCari = Integer.parseInt(in.readLine());
                            switch(subMenuCari){
                                case 1:
                                    System.out.println("--edit film--");
                                    film = inputFilm(film);
                                    fd.simpanFilm(film);
                                    System.out.println("berhasil edit");
                                    break;
                                case 2:
                                    fd.hapusFilmById(film.getId());
                                    System.out.println("berhasil hapus");
                                    break;
                                default:
                                    System.out.println("pilihan anda salah");
                                    break;
                            }
                            
                        }else{
                            System.out.println("Film Tidak ditemukan !");
                        }
                        break;
                        
                    case 4 : 
                        System.out.println("Terima Kasih");
                        break;
                    default:
                        System.out.println("Pilihan anda Salah");
                }
            }catch(ParseException pe){
                System.out.println("penulisan tanggal salah");
            }catch(NumberFormatException nfe){
                System.out.println("terjadi kesalahan pada inputan! ");
                pilih=1;
            }catch(IOException ioe){
                
            }
        }while(pilih!=4);
    }
    
    private static Film inputFilm(Film film) throws IOException, ParseException{
        System.out.print("judul :"); 
        film.setJudul(in.readLine());

        System.out.print("tgl release (dd-MM-yyyy) :"); 
        film.setTglRelease(new SimpleDateFormat("dd-MM-yyyy").parse(in.readLine()));

        System.out.print("rating (1-10) :"); 
        film.setRating(Integer.parseInt(in.readLine()));

        System.out.print("harga film :");    
        film.setHargaFilm(new BigDecimal(in.readLine()));
        
        return film;
    } 
}
