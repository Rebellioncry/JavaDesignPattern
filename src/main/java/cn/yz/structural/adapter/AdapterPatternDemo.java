package cn.yz.structural.adapter;
//适配器模式
class Voltage220V {
    //输出220V的电压
    public int output220V(){
        int src = 220;
        System.out.println("电压为"+src+"伏");
        return src;
    }
}

interface IVoltage5V {
    public int output5V();
}
class VoltageAdapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        //调用Voltage220V里的方法得到220V
        int srcV = output220V();
        //把220V转换成5V并输出
        int dstV =srcV / 44 ;
        return dstV;
    }
}

class Phone {
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5){
            System.out.println("适配后的电压5V，可以充电");
        }else {
            System.out.println("适配后的电压异常，不能充电");
        }
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        System.out.println("测试类适配器模式：");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
