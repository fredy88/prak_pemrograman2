package com.p2.hashset;

import java.util.List;
import java.util.ArrayList;

public class BelajarList{
	public static void main ( String[] args ){
		List Is = new ArrayList() ;
		Is.add("satu");
		Is.add("dua");
		Is.add(new Integer(4));
		Is.add(new Float(3.0f));
		Is.add("dua");
		Is.add(new Integer(4));
		
		System.out.println(Is);
	}
}