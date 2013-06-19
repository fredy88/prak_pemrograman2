package com.p2.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexMain{
	public bolean valid(String regex, String input){
	pattern p= Pattern.compile(regex);
	Matcher m= p.matcher(input);
	return m.matches();
	}
}