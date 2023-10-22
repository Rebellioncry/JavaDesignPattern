package cn.yz.behavioral.visitor;

abstract class ComputerPart {
    protected String name;
    protected  double price;

    public ComputerPart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double accept(Visitor visitor);
}

class Keyboard  extends ComputerPart {

    public Keyboard(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitKeyboard(this);
    }
}

class Mouse  extends ComputerPart {

    public Mouse(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitMouse(this);
    }
}

class Computer  {

    private  Keyboard keyboard;
    private Mouse mouse;

    public Computer(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public double getPrice(Visitor visitor){
        return visitor.visitMouse(mouse)+visitor.visitKeyboard(keyboard);
    }
}

interface Visitor {
    double visitMouse(Mouse mouse);
    double visitKeyboard(Keyboard keyboard);
}

class VIPVisitor implements Visitor{
    @Override
    public double visitMouse(Mouse mouse) {
        return mouse.price*0.8;
    }

    @Override
    public double visitKeyboard(Keyboard keyboard) {
        return keyboard.price*0.8;
    }
}

class CommonVisitor implements Visitor{
    @Override
    public double visitMouse(Mouse mouse) {
        return mouse.price*0.9;
    }

    @Override
    public double visitKeyboard(Keyboard keyboard) {
        return keyboard.price*0.9;
    }
}


public class VisitorPatternDemo {
    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard("樱桃", 100);
        Mouse mouse = new Mouse("罗技", 200);

        Computer computer = new Computer(keyboard, mouse);
        System.out.println(computer.getPrice(new CommonVisitor()));
    }
}
