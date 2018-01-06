package com.flyweight.example;

import junit.framework.TestCase;   
public class Client extends TestCase {   

 public void testMethod(){   

     FlyweightFactory factory = FlyweightFactory.getInstance();   

     Flyweight f1 = factory.getFlyweight("aaa", "bbb");   
     Flyweight f2 = factory.getFlyweight("aaa", "bbb");   

     assertSame(f1, f2);   
 }   
}  
