
package com.composite;
/** "Leaf" */
class Ellipse implements Graphic {
 
    //Prints the graphic.
    public void print() {
        System.out.println("Ellipse");
    }

	@Override
	public void addComponent(Graphic component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defaultMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Graphic getChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeComponent(Graphic component) {
		// TODO Auto-generated method stub
		
	}
}
