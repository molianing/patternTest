//Source file: D:\\works\\Workspaces\\CommandTest\\src\\com\\command\\concreteCommand.java

package com.command;


public class ConcreteCommand implements Command
{
   private Receiver receiver;
   
   /**
    * @roseuid 4D1898F90169
    */
   public ConcreteCommand() 
   {
    
   }
   
   /**
    * @roseuid 4D1898390340
    */
   public void execute() 
   {
	   receiver.defaultAction() ;    
   }

public Receiver getReceiver() {
	return receiver;
}

public void setReceiver(Receiver receiver) {
	this.receiver = receiver;
}
}
//void ConcreteCommand.setReceiver(com.command.Receiver){
//	this.receiver = receiver;
//}
