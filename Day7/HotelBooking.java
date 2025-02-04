class HotelBooking{
    private String name;
    private int id;
    private String address;

     HotelBooking(){
        name = "not specified";
        id = 0;
        address = "not specified";
    }

    HotelBooking(String name, int id, String address){
        this.name = name;
        this.id = id;
        this.address = address;
    }

    HotelBooking(HotelBooking previousBooking){
        this.name = previousBooking.name;
        this.id = previousBooking.id;
        this.address = previousBooking.address;
    }

    void show(){
        System.out.println("\nName: " + name);
        System.out.println("Id: " + id);
        System.out.println("address: " + address);

    }

    public static void main(String[] args){
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("karan seangar", 109, "B.Tech");
        HotelBooking booking3 = new HotelBooking(booking2);
        booking1.show();
        booking2.show();
        booking3.show();

   }
}

