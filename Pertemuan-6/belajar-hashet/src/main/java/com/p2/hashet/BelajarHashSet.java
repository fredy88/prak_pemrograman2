package com.p2.hashset;

import java.util.*;

public class BelajarHashSet {   
    public static void main( String[] args ){
        Set set= new HashSet();
        
        set.add("satu");
        set.add("dua");
        set.add(new Integer(4));
        set.add(new Float(3.0f));
        set.add("dua");
        set.add(new Integer(4));
        
        System.out.println(set);
    }
}
