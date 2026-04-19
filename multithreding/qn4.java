// Write a Java program which first generates a set of random numbers and then determines negative, positive even, positive odd numbers concurrently.

import java.util.Random;
// Step 1: Engine Interface
interface Engine {
    void start();
}

// Step 2: Petrol Engine
class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol Engine starting...");
    }
}

// Step 3: Diesel Engine
class DieselEngine implements Engine {
    public void start() {
        System.out.println("Diesel Engine starting...");
    }
}

// Step 4: Car class (Delegates work to Engine)
class Car {
    private Engine engine;

    // Constructor to inject engine
    public Car(Engine engine) {
        this.engine = engine;
    }

    // Delegation happens here
    public void startCar() {
        engine.start();  // delegating task
    }
}

// Step 5: Main Class
public class qn4 {
    public static void main(String[] args) {

        // Car with Petrol Engine
        Car petrolCar = new Car(new PetrolEngine());
        petrolCar.startCar();

        // Car with Diesel Engine
        Car dieselCar = new Car(new DieselEngine());
        dieselCar.startCar();
    }
}

