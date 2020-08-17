package base;

/**
 * @author: pbb
 * @date: 2020/8/17 15:00
 */
public class Demo1 {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        ge.drawShape(rectangle);
        ge.drawCircle(circle);


    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        if (s.type == 1) {
            drawRectangle(s);
        } else if (s.type == 2) {
            drawCircle(s);
        }
    }

    public void drawRectangle(Shape s) {
        System.out.println("rectangle");
    }

    public void drawCircle(Shape s) {
        System.out.println("circle");
    }

    public void drawTriangle(Shape s){
        System.out.println("triangle");
    }
}

class Shape {
    int type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.type = 2;
    }
}

class Triangle extends Shape {
    Triangle() {
        super.type = 3;
    }
}
