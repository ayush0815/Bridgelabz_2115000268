class Person{
    private String name;
    private int id;
    private String course;

     Person(){
        name = "not specified";
        id = 0;
        course = "not specified";
    }

    Person(String name, int id, String course){
        this.name = name;
        this.id = id;
        this.course = course;
    }

    Person(Person previousPerson){
        this.name = previousPerson.name;
        this.id = previousPerson.id;
        this.course = previousPerson.course;
    }

    void show(){
        System.out.println("\nName: " + name);
        System.out.println("Id: " + id);
        System.out.println("Course: " + course);

    }

    public static void main(String[] args){
        Person person1 = new Person();
        Person person2 = new Person("karan seangar", 109, "B.Tech");
        Person person3 = new Person(person2);
        person1.show();
        person2.show();
        person3.show();

   }
}

