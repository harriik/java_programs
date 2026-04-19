import java.util.*;

class InventoryManager<T extends Product> {
    LinkedList<T> list = new LinkedList<>();
    Stack<String> operationHistory = new Stack<>();

    // For undo support
    T lastRemoved = null;
    int lastQuantity = -1;
        public void add(T product) {
        list.add(product);
        operationHistory.push("ADD");
    }
        public void remove(int id) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T p = it.next();
            if (p.productID == id) {
                lastRemoved = p;
                it.remove();
                operationHistory.push("REMOVE");
                return;
            }
        }
        System.out.println("Product not found");
    }
        public void update(int id, int newQty) throws InvalidProductException {
        if (newQty < 0)
            throw new InvalidProductException("Quantity cannot be negative");

        for (T p : list) {
            if (p.productID == id) {
                lastQuantity = p.quantity;
                p.quantity = newQty;
                operationHistory.push("UPDATE");
                return;
            }
        }
        System.out.println("Product not found");
    }
        public void search(int id) {
        for (T p : list) {
            if (p.productID == id) {
                p.display();
                return;
            }
        }
        System.out.println("Not found");
    }    public void displayAll() {
        for (T p : list) {
            p.display();
        }
    }
        public void undoLastOperation() {
        if (operationHistory.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        String lastOp = operationHistory.pop();

        switch (lastOp) {
            case "ADD":
                list.removeLast();
                System.out.println("Undo ADD done");
                break;

            case "REMOVE":
                if (lastRemoved != null) {
                    list.add(lastRemoved);
                    System.out.println("Undo REMOVE done");
                }
                break;

            case "UPDATE":
                if (lastQuantity != -1) {
                    list.getLast().quantity = lastQuantity;
                    System.out.println("Undo UPDATE done");
                }
                break;
        }
    }
}