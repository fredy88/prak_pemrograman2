package com.p2.regex;
import java.util.regex.*;

public class Cari{
	public static void main(String[] args){
		String text1 = "Nama saya Dono ini email saya Dono@yahoo.com";		
		cekRegex("[A-Za-z]{2,20}\\s",text1);
	}
	
	public static void cekRegex(String regexp,String kata){
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(kata);
		
		while(m.find()){
			if(m.group().length()!=0){
				System.out.println(m.group().trim());
			}
			System.out.println("indeks awal : "+m.start());
			System.out.println("indeks akhir : "+m.end());
		}
	}
}