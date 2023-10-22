package cn.yz.creational.singleton;

class Single{
    private static Single instance = new Single();

    private Single(){}

    public static Single getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 Single() 是不可见的
        //Single object = new Single();

        //获取唯一可用的对象
        Single object = Single.getInstance();

        //显示消息
        object.showMessage();
    }
}
