//Source file: D:\\WORKS\\Workspaces\\CommandTest\\src\\wz\\testextends\\Father.java

package wz.testextends;


public class Father 
{
	   private String name="Fathername";
   
   /**
    * @roseuid 4D31041C0290
    */
   public Father() 
   {
    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 4D3100D401F4
    */
   public String getName() 
   {
    return this.name;
   }
   
   /**
    * @param args
    * @roseuid 4D31037A032C
    */
   public static void main(String[] args) 
   {
	    Father f = new Father();
	    System.out.println(f.getName());
	    Ch1 c1 = new Ch1();
	    System.out.println(c1.getName());
	    Ch2 c2 = new Ch2();
	    System.out.println(c2.getName());

   }
}
