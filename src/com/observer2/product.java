package com.observer2;

import java.util.Observable;
//我们注意到,在product类中 的setXXX方法中,我们设置了 notify(通知)方法, 当Jsp表单调用setXXX(如何调用见我的另外一篇文章),实际上就触发了notisfyObservers方法,这将通知相应观察者应该采取行动了.

/**产品类 可供Jsp直接使用UseBean调用 该类主要执行产品数据库插入 更新*/
public class product extends Observable{ 
 private String name;
 private float price;

 public String getName(){ return name;}
 public void setName(String name){
  this.name=name;
 //设置变化点 
  setChanged();
  notifyObservers(name);

 } 

 public float getPrice(){ return price;}
 public void setPrice(float price){
  this.price=price;
 //设置变化点
  setChanged();
  notifyObservers(new Float(price)); 

 }

 //以下可以是数据库更新 插入命令.
 public void saveToDb(){
	 //.....................


 }
}
