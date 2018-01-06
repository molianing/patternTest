package com.bridge;
public class Client
{
	public static void main(String[] args) {

	    Abstraction abstraction = new RefinedAbstraction();

	    // Set implementation and call
	    abstraction.implementor = new ConcreteImplementorA();
	    abstraction.Operation();

	    // Change implemention and call
	    abstraction.implementor = new ConcreteImplementorB();
	    abstraction.Operation();
	  
	}
}