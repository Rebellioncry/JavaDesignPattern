package cn.yz.creational.factorymathod;

interface Shape {

    void draw();
}
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}

interface ShapeFactory {

    //使用 getShape 方法获取形状类型的对象

    Shape getShape();
}

class RectangleFactory implements ShapeFactory{

    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}

class SquareFactory implements ShapeFactory{

    @Override
    public Shape getShape() {
        return new Square();
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory rectangle = new RectangleFactory();

        //获取 rectangle 的对象，并调用它的 draw 方法
        Shape shape1 = rectangle.getShape();

        //调用 rectangle 的 draw 方法
        shape1.draw();

        ShapeFactory square = new SquareFactory();

        //获取 square 的对象，并调用它的 draw 方法
        Shape shape2 = square.getShape();

        //调用 square 的 draw 方法
        shape2.draw();
    }
}




