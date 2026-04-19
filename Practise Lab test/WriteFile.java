class Product {
    int productID;
    String productName;
    int quantity;
    double price;

    public Product(int productID, String productName, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void display() {
        System.out.println(productID + " | " + productName + " | " + quantity + " | " + price);
    }
}