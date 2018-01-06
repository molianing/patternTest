package com.observer2;

import java.util.Observable;
import java.util.Observer;

//观察者PriceObserver主要用来对产品价格(price)进行观察的
public class PriceObserver implements Observer {

	private float price = 0;

	public void update(Observable obj, Object arg) {

		if (arg instanceof Float) {

			price = ((Float) arg).floatValue();

			System.out.println("PriceObserver :price changet to " + price);

		}

	}

}
