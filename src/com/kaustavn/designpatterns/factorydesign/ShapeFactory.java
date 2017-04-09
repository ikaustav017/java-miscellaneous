package com.kaustavn.designpatterns.factorydesign;

public class ShapeFactory {

	public IShape getShape(String type) {

		if ("Circle".equalsIgnoreCase(type)) {
			return new Circle();
		}
		if ("Square".equalsIgnoreCase(type)) {
			return new Square();
		}
		if ("Triangle".equalsIgnoreCase(type)) {
			return new Triangle();
		}

		return null;
	}

}
