package com.p2.regex;

import java.util.regex.*;

public class RegEmail{
	public static void main(String[] args){
		String text = "febry.cool77@yahoo.co.id";
		String regex = "\\w+\\.\\w+@\\w+\\.[a-zA-Z]{2,}\\.[a-zA-Z]{2,}";
		
		if(text.matches(regex)) {
			System.out.println("sesuai dengan regex");
		} else {
			System.out.println("tidak sesuai dengan regex");
		}			
	}	
}