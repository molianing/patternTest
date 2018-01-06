//Source file: D:\\WORKS\\Workspaces\\CommandTest\\src\\com\\builder\\Cook.java

package com.builder;


/**
 * "Director"
 */
class Cook 
{
   private PizzaBuilder pizzaBuilder;
   
   /**
    * @param pb
    * @roseuid 4D25B51A0207
    */
   public void setPizzaBuilder(PizzaBuilder pb) 
   {
		pizzaBuilder = pb;    
   }
   
   /**
    * @return com.builder.Pizza
    * @roseuid 4D25B51A0214
    */
   public Pizza getPizza() 
   {
		return pizzaBuilder.getPizza();    
   }
   
   /**
    * @roseuid 4D25B51A0242
    */
   public void constructPizza() 
   {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();    
   }
}
