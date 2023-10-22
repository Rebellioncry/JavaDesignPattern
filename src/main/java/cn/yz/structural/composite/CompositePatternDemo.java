package cn.yz.structural.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Component{
    protected String name;

    public Component(String name) {
        this.name = name;
    }
    //只有叶子节点会有实现
    public abstract void operation();
    //增加 只有非叶子节点会有实现
    public abstract void add(Component component);
    //获取所有叶子节点 只有非叶子节点会有实现
    public abstract List<Component> getChild();
    //删除 只有非叶子节点会有实现
    public abstract void delete(Component component);

}
//非叶子节点
class Composite extends Component{
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void operation() {

    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public List<Component> getChild() {
        return components;
    }

    @Override
    public void delete(Component component) {
        components.remove(component);
    }
}

//叶子节点
class Leaf extends Component{
    List<Component> components = new ArrayList<>();

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("叶子节点name:"+name+"的操作方法被调用");
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public List<Component> getChild() {
        return null;
    }

    @Override
    public void delete(Component component) {

    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        Composite root = new Composite("root");

        Leaf right = new Leaf("right");
        Leaf left = new Leaf("left");
        root.add(right);
        root.add(left);

        List<Component> child = root.getChild();
        for (Component c :child) {
            c.operation();
        }
    }
}
