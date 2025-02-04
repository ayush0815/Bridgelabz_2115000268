class Employee{
    static String companyName = "Capegemini";
    private String name;
    final private int id;
    private String designation;
    static int totalEmployee;

    Employee(String name,String designation){
        this.name = name;
        this.designation = designation;
        this.id = (int)(Math.random() * Math.pow(10,10));
        totalEmployee++;
    }

    void display(){
        System.out.println("\nName of employee: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Id: " + id);
        System.out.println("Company name: " + companyName);

    }

    static void displayTotalEmployee(){
        System.out.println("\nTotal employees: " + totalEmployee);
    }

    public static void main(String[] args){
        Employee employee1 = new Employee("Ayush Srivastav","Software Developer");
        if(employee1 instanceof Employee){
            System.out.println("\nemployee1 is instance of Employee class");
            employee1.display();
        }
        Employee.displayTotalEmployee();
    }
}
