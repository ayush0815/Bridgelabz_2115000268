class Product {

    private String productName;
    private float price;
    private static int totalProduct = 0;

    Product(String productName, float price){
        this.productName = productName;
        this.price = price;
        totalProduct++;
    }

    void displayProductDetails(){
        System.out.println("\nProduct name is: " + productName);
        System.out.println("Price of the product is: " + price);
    }

    static void displayTotalProduct(){
        System.out.println("\nTotal products are: " + totalProduct);
    }

    public static void main(String[] args){
        Product product1 = new Product("Kurkure", 20);
        Product product2 = new Product("Coke", 20);

        product1.displayProductDetails();
        product2.displayProductDetails();

        Product.displayTotalProduct();
    }


}

