package cn.yz.structural.decorator;

// 基础接口
interface Drink {
    double getPrice();
    String getDescription();
}

// 具体饮料
class SimpleCoffee implements Drink {
    @Override
    public double getPrice() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

// 装饰器接口
interface DrinkDecorator extends Drink {
    Drink getDecoratedDrink();
}

// 装饰器类，增加价格
class WithMilk implements DrinkDecorator {
    private Drink decoratedDrink;

    public WithMilk(Drink drink) {
        this.decoratedDrink = drink;
    }

    @Override
    public double getPrice() {
        return decoratedDrink.getPrice() + 1.0;
    }

    @Override
    public String getDescription() {
        return decoratedDrink.getDescription() + ", with milk";
    }

    @Override
    public Drink getDecoratedDrink() {
        return decoratedDrink;
    }
}

// 装饰器类，改变特性
class Decaf implements DrinkDecorator {
    private Drink decoratedDrink;

    public Decaf(Drink drink) {
        this.decoratedDrink = drink;
    }

    @Override
    public double getPrice() {
        return decoratedDrink.getPrice();
    }

    @Override
    public String getDescription() {
        return decoratedDrink.getDescription() + ", decaf";
    }

    @Override
    public Drink getDecoratedDrink() {
        return decoratedDrink;
    }
}

// 客户端代码
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Drink simpleCoffee = new SimpleCoffee();
        Drink coffeeWithMilk = new WithMilk(simpleCoffee);
        Drink decafCoffee = new Decaf(coffeeWithMilk);

        System.out.println("Price: " + decafCoffee.getPrice());
        System.out.println("Description: " + decafCoffee.getDescription());
    }
}
