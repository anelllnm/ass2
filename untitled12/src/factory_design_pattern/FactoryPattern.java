package factory_design_pattern;

// Abstract class representing a vehicle
abstract class Vehicle {
    public abstract int getWheel(); // Abstract method to get the number of wheels

    // Override toString() to provide a meaningful string representation of the vehicle
    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

// Class representing a Car (sub-class of Vehicle)
class Car extends Vehicle {
    int wheel;

    // Constructor to initialize the number of wheels
    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

// Class representing a Bike (sub-class of Vehicle)
class Bike extends Vehicle {
    int wheel;

    // Constructor to initialize the number of wheels
    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

// Factory class for creating instances of vehicles
class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if (type.equals("car")) { // Use equals() for string comparison
            return new Car(wheel);
        } else if (type.equals("bike")) { // Use equals() for string comparison
            return new Bike(wheel);
        }
        return null; // Return null for unknown types
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        // Creating instances of vehicles using the factory
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}
