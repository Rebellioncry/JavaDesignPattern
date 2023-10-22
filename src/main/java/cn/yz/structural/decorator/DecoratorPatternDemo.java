package cn.yz.structural.decorator;

interface Shape {
    void draw();
}
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

abstract class ShapeDecorator {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public abstract void draw();
}

class RedColorDecorator extends ShapeDecorator {

    public RedColorDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setColor("red");
    }

    private void setColor(String color){
        System.out.println("Border Color: Red");
    }
}
class BlueColorDecorator extends ShapeDecorator {

    public BlueColorDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setColor("blue");
    }

    private void setColor(String color){
        System.out.println("Border Color: blue");
    }
}


public class DecoratorPatternDemo {
    public static void main(String[] args) {
        RedColorDecorator redCircle = new RedColorDecorator(new Circle());
        redCircle.draw();
    }
}
