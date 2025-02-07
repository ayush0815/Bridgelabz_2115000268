// Superclass
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}
// Interface Worker
interface Worker {
    void performDuties();
}
// Subclass Chef implementing Worker interface
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking delicious meals.");
    }
}
// Subclass Waiter implementing Worker interface
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}
class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Ranveer Brar", 101);
        Waiter waiter = new Waiter("Chotu", 202);

        chef.displayInfo();
        chef.performDuties();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
