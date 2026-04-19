import java.io.*;
import java.util.*;

class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

class Product {
    private int productID;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productID, String productName, int quantity, double price) throws InvalidProductException {
        if (quantity < 0 || price <= 0) {
            throw new InvalidProductException("Invalid quantity or price");
        }
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public int getProductID() { return productID; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) throws InvalidProductException {
        if (quantity < 0) {
            throw new InvalidProductException("Invalid quantity");
        }
        this.quantity = quantity;
    }

    public void setPrice(double price) throws InvalidProductException {
        if (price <= 0) {
            throw new InvalidProductException("Invalid price");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productID + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class InventoryManager<T extends Product> {
    private LinkedList<T> products;
    private Stack<String> operations;
    private Stack<Object> backups;

    public InventoryManager() {
        products = new LinkedList<>();
        operations = new Stack<>();
        backups = new Stack<>();
        loadFromFile();
    }

    public void addProduct(T product) {
        products.add(product);
        operations.push("ADD");
        backups.push(product);
    }

    public boolean removeProduct(int productID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                T removed = products.remove(i);
                operations.push("REMOVE");
                backups.push(removed);
                return true;
            }
        }
        return false;
    }

    public boolean updateQuantity(int productID, int newQuantity) {
        for (T product : products) {
            if (product.getProductID() == productID) {
                try {
                    int oldQuantity = product.getQuantity();
                    product.setQuantity(newQuantity);
                    operations.push("UPDATE");
                    backups.push(productID);
                    backups.push(oldQuantity);
                    return true;
                } catch (InvalidProductException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    public T searchProduct(int productID) {
        for (T product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (T product : products) {
                System.out.println(product);
            }
        }
    }

    public void undoLastOperation() {
        if (operations.isEmpty()) {
            System.out.println("No operations to undo.");
            return;
        }
        String lastOp = operations.pop();
        switch (lastOp) {
            case "ADD":
                products.remove((T) backups.pop());
                break;
            case "REMOVE":
                products.add((T) backups.pop());
                break;
            case "UPDATE":
                int oldQuantity = (Integer) backups.pop();
                int productID = (Integer) backups.pop();
                for (T product : products) {
                    if (product.getProductID() == productID) {
                        try {
                            product.setQuantity(oldQuantity);
                        } catch (InvalidProductException e) {
                            System.out.println("Error updating product quantity: " + e.getMessage());
                        }
                        break;
                    }
                }
                break;
        }
    }

    private void loadFromFile() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("product.dat"))) {
            while (dis.available() > 0) {
                int id = dis.readInt();
                String name = dis.readUTF();
                int qty = dis.readInt();
                double price = dis.readDouble();
                try {
                    T product = (T) new Product(id, name, qty, price);
                    products.add(product);
                } catch (InvalidProductException e) {
                    System.out.println("Invalid product in file: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Product file not found. Starting with empty inventory.");
        } catch (IOException e) {
            System.out.println("Error reading product file: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("product.dat"))) {
            for (T product : products) {
                dos.writeInt(product.getProductID());
                dos.writeUTF(product.getProductName());
                dos.writeInt(product.getQuantity());
                dos.writeDouble(product.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public static void writeInitialData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("product.dat"))) {
            dos.writeInt(1);
            dos.writeUTF("Laptop");
            dos.writeInt(10);
            dos.writeDouble(999.99);

            dos.writeInt(2);
            dos.writeUTF("Mouse");
            dos.writeInt(50);
            dos.writeDouble(19.99);

            dos.writeInt(3);
            dos.writeUTF("Keyboard");
            dos.writeInt(30);
            dos.writeDouble(49.99);
        } catch (IOException e) {
            System.out.println("Error writing initial data: " + e.getMessage());
        }
    }
}

public class MainApp {
    public static void main(String[] args) {
        InventoryManager<Product> manager = new InventoryManager<>();
        Scanner scanner = new Scanner(System.in);

        File file = new File("product.dat");
        if (!file.exists()) {
            InventoryManager.writeInitialData();
            System.out.println("Initial data written to file.");
        }

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Product");
            System.out.println("5. Display All");
            System.out.println("6. Undo Last Operation");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    try {
                        Product p = new Product(id, name, qty, price);
                        manager.addProduct(p);
                        System.out.println("Product added.");
                    } catch (InvalidProductException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    if (manager.removeProduct(removeId)) {
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQty = scanner.nextInt();
                    if (manager.updateQuantity(updateId, newQty)) {
                        System.out.println("Quantity updated.");
                    } else {
                        System.out.println("Product not found or invalid quantity.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID to search: ");
                    int searchId = scanner.nextInt();
                    Product found = manager.searchProduct(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    manager.displayAllProducts();
                    break;
                case 6:
                    manager.undoLastOperation();
                    break;
                case 7:
                    manager.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}