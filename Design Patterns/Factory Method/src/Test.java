public class Test {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
        circle.draw();

        Shape triangle = ShapeFactory.getShape(ShapeType.TRIANGLE);
        triangle.draw();

        Shape rectangle = ShapeFactory.getShape(ShapeType.RECTANGLE);
        rectangle.draw();
    }
}
