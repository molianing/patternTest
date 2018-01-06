package com.flyweight.example2;

import java.util.Hashtable;

public class FlavorFactory
{
  private Hashtable flavors = new Hashtable();

  public Order GetOrder(String key)
  {
    if(! flavors.containsKey(key))
      flavors.put(key, new Flavor(key));
     return ((Order)flavors.get(key));
  }

  public int GetTotalFlavorsMade()
  {
    return flavors.size();
  }
}