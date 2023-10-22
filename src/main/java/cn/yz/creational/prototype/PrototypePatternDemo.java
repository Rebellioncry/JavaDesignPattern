package cn.yz.creational.prototype;

import java.io.*;

//浅克隆
class Wife implements Cloneable{
    private int age = 20;
    private int height = 165;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    protected Wife clone() throws CloneNotSupportedException {
        return (Wife)super.clone();
    }
}

//深克隆
class Clothes implements Serializable{
    private int size = 15;
    private int width = 20;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Clothes(int size, int width) {
        this.size = size;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "size=" + size +
                ", width=" + width +
                '}';
    }
}
class Wife2 implements Serializable,Cloneable{
    private Clothes clothes;

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Wife2(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "Wife2{" +
                "clothes=" + clothes +
                '}';
    }

    @Override
    protected Wife2 clone() throws CloneNotSupportedException {
        //重写克隆方法实现深克隆
        Wife2 clone = (Wife2)super.clone();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(clone);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream input = new ObjectInputStream(inputStream);
            Wife2 w = (Wife2) input.readObject();
            return w;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆输出
        Wife wife = new Wife();
        Wife clone = wife.clone();
        System.out.println(clone);

        //深克隆输出
        Wife2 wife2 = new Wife2(new Clothes(18,20));
        Wife2 clone2 = wife2.clone();
        System.out.println(clone2);
        Wife2 clone3 = wife2.clone();
        clone3.getClothes().setSize(33);
        System.out.println(clone3);
    }
}
