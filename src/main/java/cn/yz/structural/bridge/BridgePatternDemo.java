package cn.yz.structural.bridge;

abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }
    public abstract void  SetShape();
}

class Circle extends Shape{

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void SetShape() {
        System.out.println("设为圆形");
        color.showColor();
    }
}

class Square extends Shape{

    public Square(Color color) {
        super(color);

    }

    @Override
    public void SetShape() {
        System.out.println("设为方形");
        color.showColor();
    }
}

interface Color{
    void showColor();
}

class Red implements Color{
    @Override
    public void showColor() {
        System.out.println("red");
    }
}

class Blue implements Color{
    @Override
    public void showColor() {
        System.out.println("blue");
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        redCircle.SetShape();
        Shape blueSquare = new Square(new Blue());
        blueSquare.SetShape();
    }
}
