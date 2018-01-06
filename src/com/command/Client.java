//Source file: D:\\works\\Workspaces\\CommandTest\\src\\com\\command\\Client.java

package com.command;


public class Client 
{
   private Receiver theReceiver;
   private Invoker theInvoker;
   
   /**
    * @roseuid 4D1898F900BD
    */
   public Client() 
   {
    
   }

public  static void main(String [] a){
	


//命令模式涉及到五个角色，它们分别是：
//
//    客户（Client）角色：创建了一个具体命令(ConcreteCommand)对象并确定其接收者。
//    命令（Command）角色：声明了一个给所有具体命令类的抽象接口。这是一个抽象角色。
//    具体命令（ConcreteCommand）角色：定义一个接受者和行为之间的弱耦合；实现Execute()方法，负责调用接收考的相应操作。Execute()方法通常叫做执方法。
//    请求者（Invoker）角色：负责调用命令对象执行请求，相关的方法叫做行动方法。
//    接收者（Receiver）角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。 
	
	   Client client = new Client();
	   client.theReceiver = new Receiver();
	   client.theInvoker = new Invoker() ;
	   
	   ConcreteCommand concreteCommand = new ConcreteCommand() ;
	   
	   concreteCommand.setReceiver(client.theReceiver);// 实际上还是找的这个  Receiver的方法  
	   
	   client.theInvoker.setTheCommand(concreteCommand);
	   
	   client.theInvoker.getTheCommand().execute() ;
	
}
}
//void Client.main(java.lang.String[]){
//	   Client client = new Client();
//	   client.theReceiver = new Receiver();
//	   client.theInvoker = new Invoker() ;
//	   
//	   ConcreteCommand concreteCommand = new ConcreteCommand() ;
//	   
//	   concreteCommand.setReceiver(client.theReceiver);
//	   
//	   client.theInvoker.setTheCommand(concreteCommand);
//	   
//	   client.theInvoker.getTheCommand().execute() ;
//}
