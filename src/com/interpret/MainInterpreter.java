package com.interpret;

import java.util.ArrayList;
import java.util.Iterator;

public class MainInterpreter {
	/** * @param args */
	public static void main(String[] args) {
		String roman = "MCMXXVIII";
		Context context = new Context(roman);
		// Build the 'parse tree'

//		ArrayList<Expression> tree = new ArrayList<Expression>();。
		ArrayList tree = new ArrayList();
		tree.add(new ThousandExpression());
		tree.add(new HundredExpression());
		tree.add(new TenExpression());
		tree.add(new OneExpression());
		// Interpret
		for (Iterator it = tree.iterator(); it.hasNext();) {
			Expression exp = (Expression) it.next();
			exp.interpret(context);
		}
		System.out.println(roman + " = "+ Integer.toString(context.getOutput()));
	}
}
