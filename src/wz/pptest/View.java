//Source file: D:\\WORKS\\Workspaces\\CommandTest\\src\\wz\\pptest\\View.java

package wz.pptest;

import java.util.Observable;
import javax.swing.JFrame;
import java.util.Observer;

public class View extends javax.swing.JFrame implements java.util.Observer 
{
   public Controller controller;
   public Model model;
   
   /**
    * @roseuid 4D29E4DD01C5
    */
   public View() 
   {
    
   }
   
   /**
    * @Override
    * @param o
    * @param arg
    * @roseuid 4D2AF60A00AB
    */
   public void update(Observable o, Object arg) 
   {
	// TODO Auto-generated method stub    
   }
}
