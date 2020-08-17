package improve;

/**
 * @author: pbb
 * @date: 2020/8/17 15:00
 */
public class Demo2 {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.drawShape(new Rectangle());
        ge.drawShape(new Circle());
        ge.drawShape(new Triangle());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
       s.draw();
    }
}

abstract class Shape {
    int type;
    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.type = 1;
    }

    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}

class Circle extends Shape {
    Circle() {
        super.type = 2;
    }

    @Override
    public void draw() {
        System.out.println("circle");
    }
}

class Triangle extends Shape {
    Triangle() {
        super.type = 3;
    }

    @Override
    public void draw() {
        System.out.println("triangle");
    }
}
