//Source file: D:\\WORKS\\Workspaces\\CommandTest\\src\\com\\composite\\Graphic.java


package com.composite;


public interface Graphic 
{
   
   /**
    * @roseuid 4D246EB10251
    */
   public abstract void defaultMethod();
   
   /**
    * @return com.composite.Graphic
    * @roseuid 4D246EB10261
    */
   public Graphic getChild();
   
   /**
    * @param component
    * @roseuid 4D246EB10271
    */
   public void addComponent(Graphic component);
   
   /**
    * @param component
    * @roseuid 4D246EB10281
    */
   public void removeComponent(Graphic component);

public abstract void print();
}
//Graphic.print()
