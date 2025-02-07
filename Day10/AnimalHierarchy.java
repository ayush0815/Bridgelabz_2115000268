class Animal {
    String name;
    int age;

    public Animal(String name, int age) { // Constructor
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Generic animal sound");
    }

    public String toString() {  // Overriding toString() for better output
        return "Name: " + name + ", Age: " + age;
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age); // Call the superclass constructor
    }

    @Override
    public void makeSound() {
        System.out.println("bark!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal myAnimal = new Animal("Generic", 5);
        Dog myDog = new Dog("Axel", 3);
        Cat myCat = new Cat("Kitty", 2);
        Bird myBird = new Bird("Tweety", 1);

        System.out.println(myAnimal); // Uses the overridden to toString()
        myAnimal.makeSound();

        System.out.println(myDog);
        myDog.makeSound();

        System.out.println(myCat);
        myCat.makeSound();

        System.out.println(myBird);
        myBird.makeSound();
    }
}