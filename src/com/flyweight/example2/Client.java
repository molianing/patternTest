package com.flyweight.example2;

public class Client
{
  private static FlavorFactory flavorFactory;
  private static int ordersMade = 0;

  public static void Main( String[] args )
  {
    flavorFactory = new FlavorFactory();

    TakeOrder("Black Coffee");
    TakeOrder("Capucino");
    TakeOrder("Espresso");
    TakeOrder("Capucino");
    TakeOrder("Espresso");
    TakeOrder("Black Coffee");
    TakeOrder("Espresso");
    TakeOrder("Espresso");
    TakeOrder("Black Coffee");
    TakeOrder("Capucino");
    TakeOrder("Capucino");
    TakeOrder("Black Coffee");

    System.out.println("\nTotal Orders made: " + ordersMade);
    System.out.println("\nTotal Flavor objects made: " + 
    	      flavorFactory.GetTotalFlavorsMade());
  }

  private static void TakeOrder(String aFlavor)
  {
    Order o = flavorFactory.GetOrder(aFlavor);
    
    // 将咖啡卖给客人
    o.Serve(new Table(++ordersMade));
  }
}
