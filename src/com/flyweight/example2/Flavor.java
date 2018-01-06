package com.flyweight.example2;

public class Flavor extends Order
{
  private String flavor;

  // 构造函数，内蕴状态以参数方式传入
  public Flavor(String flavor)
  {
    this.flavor = flavor;
  }   
  // 返回咖啡的名字
  @Override
  public  String GetFlavor()
  {
    return this.flavor;
  }

  // 将咖啡卖给客人
  @Override
  public void Serve(Table table)
  {
//	  System.out.println("Serving table {0} with flavor {1}", table.getNumber(), flavor);
	  System.out.println("Serving table "+table.getNumber()+" with flavor "+flavor+"" );
  }  }