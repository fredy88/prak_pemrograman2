package com.p2.hashset;

import java.util.Vector;

public class BelajarVector {
	public static void main(String[] args){
		Vector v = new Vector();
		
		v.add("Zak");
		v.add("Gordon");
		v.add(0,"Duke");
		v.add("Lara");
		v.add("Zak");
		v.add(1,"Fredy");
		System.out.println(v);
		
		String nama=(String) v.get(2);
		System.out.println(v);
	}
}