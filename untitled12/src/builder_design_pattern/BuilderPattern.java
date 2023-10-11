package builder_design_pattern;

// Class representing a Vehicle
class Vehicle {
    private String engine;  // Engine of the vehicle
    private int wheel;      // Number of wheels
    private int airbags;    // Number of airbags

    // Getter for engine
    public String getEngine() {
        return this.engine;
    }

    // Getter for wheel
    public int getWheel() {
        return this.wheel;
    }

    // Getter for airbags
    public int getAirbags() {
        return this.airbags;
    }

    // Private constructor that takes a VehicleBuilder object
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // Static inner class representing the Builder for Vehicle
    public static class VehicleBuilder {
        private String engine;  // Engine of the vehicle
        private int wheel;      // Number of wheels
        private int airbags;    // Number of airbags

        // Constructor for VehicleBuilder, requires engine and wheel
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        // Method to set the number of airbags (optional)
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        // Method to build the Vehicle object using the provided information
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

// Main class
public class BuilderPattern {
    public static void main(String[] args) {
        // Creating a car with 1500cc engine, 4 wheels, and 4 airbags
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        // Creating a bike with 250cc engine, 2 wheels (airbags not specified)
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        // Printing information about the car
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        // Printing information about the bike
        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags()); // Will print 0, as airbags were not specified
    }
}
