class CarRental{
    private String customerName;
    private String carModel;
    private int rentalDays;

    CarRental(){
        customerName = "Not available";
        carModel = "Not available";
        rentalDays = 0;
        CarRental obj = new CarRental(0);
    }

    CarRental(String customerName, String carModel, int rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        CarRental obj = new CarRental(rentalDays);
    }

    CarRental(int rentalDays){
        int perDayCost = 1000;
        if(rentalDays<0){
            System.out.println("Invalid! input");
        }
        System.out.println("The Total cost of rent is: " + perDayCost*rentalDays);
    }

    public static void main(String[] args){
        CarRental car1 = new CarRental();
        CarRental car2 = new CarRental("Ayush", "Tata Hexa", 7);
    }

}

