package cn.yz.creational.abstractfactory;


// 抽象产品：按钮接口
interface Button {
    void paint();
}

// 抽象产品：文本框接口
interface TextBox {
    void render();
}

// 具体产品：Windows风格的按钮
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows Button.");
    }
}

// 具体产品：Windows风格的文本框
class WindowsTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows TextBox.");
    }
}

// 具体产品：Mac风格的按钮
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Mac Button.");
    }
}

// 具体产品：Mac风格的文本框
class MacTextBox implements TextBox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac TextBox.");
    }
}

// 抽象工厂
interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
}

// 具体工厂：Windows风格组件工厂
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}

// 具体工厂：Mac风格组件工厂
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacTextBox();
    }
}


public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // 根据操作系统类型选择工厂
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory factory;

        if (osName.contains("windows")) {
            factory = new WindowsFactory();
        } else if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported OS");
        }

        // 创建组件
        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        // 使用组件
        button.paint();
        textBox.render();
    }
}
