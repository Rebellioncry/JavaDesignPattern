package cn.yz.creational.singleton;
//饿汉式
class SingletonHunger{
    private static SingletonHunger instance = new SingletonHunger();

    private SingletonHunger(){}

    public static SingletonHunger getInstance(){
        return instance;
    }
}
//懒汉式
class SingletonLazy{
    private static SingletonLazy instance ;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if (instance==null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
//懒汉式-线程安全-同步方法
class SingletonLazySafeAsync{
    private static SingletonLazySafeAsync instance ;

    private SingletonLazySafeAsync(){}

    public synchronized  static SingletonLazySafeAsync getInstance(){
        if (instance==null){
            instance = new SingletonLazySafeAsync();
        }
        return instance;
    }
}
//懒汉式-线程安全-双重检查锁定
class SingletonLazySafeDCL{
    private volatile static SingletonLazySafeDCL instance ;

    private SingletonLazySafeDCL(){}

    public static SingletonLazySafeDCL getInstance(){
        if (instance==null){
            synchronized (SingletonLazySafeDCL.class){
                if (instance==null){
                    instance = new SingletonLazySafeDCL();
                }
            }
        }
        return instance;
    }
}
public class SingletonPatternDemo {
}
