package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Interface for the Subject (Observable)
interface Subject {
    void register(Observer obj);    // Method to register an observer
    void unregister(Observer obj);  // Method to unregister an observer
    void notifyObservers();         // Method to notify all observers
}

// Class representing the DeliveryData (Concrete Subject)
class DeliveryData implements Subject {
    private List<Observer> observers; // List of observers
    private String location;          // Current location information

    // Constructor to initialize the list of observers
    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj); // Add observer to the list
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj); // Remove observer from the list
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location); // Notify each observer
        }
    }

    public void locationChanged() {
        this.location = getLocation(); // Update the location
        notifyObservers(); // Notify observers of the change
    }

    public String getLocation() {
        return "YPlace"; // Placeholder method to get the location
    }
}

// Interface for the Observer
interface Observer {
    void update(String location); // Method to update the observer with location information
}

// Class representing a Seller (Concrete Observer)
class Seller implements Observer {
    private String location; // Location information of the seller

    @Override
    public void update(String location) {
        this.location = location; // Update location
        showLocation(); // Display the location
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Class representing a User (Concrete Observer)
class User implements Observer {
    private String location; // Location information of the user

    @Override
    public void update(String location) {
        this.location = location; // Update location
        showLocation(); // Display the location
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Class representing a DeliveryWarehouseCenter (Concrete Observer)
class DeliveryWarehouseCenter implements Observer {
    private String location; // Location information of the warehouse center

    @Override
    public void update(String location) {
        this.location = location; // Update location
        showLocation(); // Display the location
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData(); // Create a subject

        Observer obj1 = new Seller(); // Create observers
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        topic.register(obj1); // Register observers with the subject
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged(); // Trigger a location change event
        topic.unregister(obj3); // Unregister an observer

        System.out.println();
        topic.locationChanged(); // Trigger another location change event
    }
}
