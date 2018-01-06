package com.bridge;

class Abstraction
{
  // Fields
  protected Implementor implementor;

  // Properties

  // Methods
//  @virtual
  public void Operation()
  {
    implementor.Operation();
  }

public Implementor getImplementor() {
	return implementor;
}

public void setImplementor(Implementor implementor) {
	this.implementor = implementor;
}
}

