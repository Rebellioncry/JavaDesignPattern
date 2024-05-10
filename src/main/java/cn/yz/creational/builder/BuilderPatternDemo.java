package cn.yz.creational.builder;
class Director{
    public Product builder(Builder builder){
        builder.buildA();
        builder.buildB();
        return builder.getProduct();
    }
}

interface Builder{
    void buildA();
    void buildB();
    Product getProduct();
}

class ConcreteBuilder1 implements Builder{
    private  Product product = new Product();
    @Override
    public void buildA() {
        product.setPartA("碳纤维做的A");
    }

    @Override
    public void buildB() {
        product.setPartB("碳纤维做的B");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

class ConcreteBuilder2 implements Builder{
    private  Product product = new Product();
    @Override
    public void buildA() {
        product.setPartA("金子做的A");
    }

    @Override
    public void buildB() {
        product.setPartB("金子做的B");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

class Product{
    private String partA;
    private String partB;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void show(){
        System.out.println("我的组成部件:partA"+partA+",partB"+partB);
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Product product =director.builder(builder1);
        product.show();
    }
}
