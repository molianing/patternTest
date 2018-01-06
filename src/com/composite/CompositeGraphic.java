
package com.composite;
import java.util.List;
import java.util.ArrayList;

/** "Composite" */
class CompositeGraphic implements Graphic {
 
    //Collection of child graphics.<Graphic> <Graphic>
    private List mChildGraphics = new ArrayList();
 
    //Prints the graphic.
    public void print() {mChildGraphics.get(0);
//        for (Graphic graphic : mChildGraphics) {
//            graphic.print();
//        }
    }
 
    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        mChildGraphics.add(graphic);
    }
 
    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        mChildGraphics.remove(graphic);
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
