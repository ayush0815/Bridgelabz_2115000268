class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    public void displayResults() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        c1.displayResults();
    }
}
