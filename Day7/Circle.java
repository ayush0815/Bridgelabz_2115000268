class Circle{
    private double radius;
    Circle(){
        this(12);
        System.out.println("This is default constructor and radius is: " + radius);
    }

    Circle(double radius){
        System.out.println("This is parametarised construcor and radius is: " + radius);
    }

    public static void main(String[] args){
        Circle circle1 = new Circle();
    }

}
