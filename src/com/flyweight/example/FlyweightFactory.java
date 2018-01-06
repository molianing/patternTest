package com.flyweight.example;

import java.util.HashMap;   
import java.util.Map;   

public class FlyweightFactory {   


 private static FlyweightFactory S_INSTANCE = new FlyweightFactory();   

 private static Map flyweightsPool = new HashMap();   

 public static FlyweightFactory getInstance(){   
     return S_INSTANCE;   
 }   

 public Flyweight getFlyweight(String a, String b){   

     Flyweight flyweight = null;   

     if(flyweightsPool.get(a+b) == null){   
         flyweight = new Flyweight(a ,b);   
         flyweightsPool.put((a+b), flyweight);   
     }else{   
         flyweight = (Flyweight)flyweightsPool.get(a+b);   
     }   

     return flyweight;   

 }   

}  


//本文来自CSDN博客，转载请标明出处：http://blog.csdn.net/kingswood/archive/2009/02/02/3858512.aspx