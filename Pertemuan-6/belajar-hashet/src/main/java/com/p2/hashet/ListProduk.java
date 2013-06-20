package com.p2.hashset;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class ListProduk {
	public static void main(String[] args){
		List<Produk> lp = new ArrayList<Produk>();
		
		Produk p = new Produk();
		Produk p2 = new Produk();
		
		p.setId(1);
		p.setNama("sedap");
		p.setHarga(new BigDecimal(1100));
		
		lp.add(p);
		lp.add(p2);
		
		for (Produk pr : lp) {
			System.out.println("Id Produk : "+pr.getId());
			System.out.println("Nama Produk : "+pr.getNama());
			System.out.println("Harga Produk : "+pr.getHarga());
			System.out.println("-----------------------------");
			}
		}
	}