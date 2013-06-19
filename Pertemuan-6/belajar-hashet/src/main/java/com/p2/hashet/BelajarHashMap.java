package com.p2.hashset;

import java.util.HashMap;

public class BelajarHashMap {
   public static void main(String[] args){
        HashMap hm=new HashMap();
        
        hm.put("Game1","Hearts");
        hm.put("game5","sweeper");
        hm.put("game3","Checker");
        hm.put("game3","Whist");
        hm.put(null,"Chess");
        hm.put("game4","Chess");
        System.out.println(hm);
    }
}
