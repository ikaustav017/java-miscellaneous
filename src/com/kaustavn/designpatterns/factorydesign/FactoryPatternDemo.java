package com.kaustavn.designpatterns.factorydesign;

public class FactoryPatternDemo {
	public static void main(String args[]) {
		ShapeFactory shapeFactory = new ShapeFactory();
		IShape shape = shapeFactory.getShape("Circle");
		shape.draw();

		shape = shapeFactory.getShape("Triangle");
		shape.draw();

		shape = shapeFactory.getShape("Square");
		shape.draw();

	}

}
