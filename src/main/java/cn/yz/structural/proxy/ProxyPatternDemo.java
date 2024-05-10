package cn.yz.structural.proxy;

// 接口
interface Subject {
    void request();
}

// 目标对象（真实对象）
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject is performing the request.");
    }
}

// 代理类
class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        beforeRequest();
        subject.request();
        afterRequest();
    }

    private void beforeRequest() {
        System.out.println("ProxySubject: Before the request.");
    }

    private void afterRequest() {
        System.out.println("ProxySubject: After the request.");
    }
}

// 客户端代码
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject proxySubject = new ProxySubject(realSubject);
        proxySubject.request();
    }
}
