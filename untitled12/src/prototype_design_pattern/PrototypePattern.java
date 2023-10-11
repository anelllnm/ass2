package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// The base class implementing Cloneable interface
class Vehicle implements Cloneable
{
    private List<String> vehicleList;

    // Constructor to initialize the vehicle list
    public Vehicle()
    {
        this.vehicleList = new ArrayList<String>();
    }

    // Constructor to initialize the vehicle list with provided list
    public Vehicle(List<String> list)
    {
        this.vehicleList = list;
    }

    // Method to insert sample vehicle data
    public void insertData()
    {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    // Method to get the list of vehicles
    public List<String> getVehicleList()
    {
        return this.vehicleList;
    }

    // Overriding the clone method
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        List<String> tempList = new ArrayList<String>();

        // Creating a deep copy of the vehicle list
        for(String s : this.getVehicleList())
        {
            tempList.add(s);
        }

        return new Vehicle(tempList); // Returning a new instance with the copied list
    }
}

public class PrototypePattern
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Vehicle a = new Vehicle(); // Creating an instance of Vehicle
        a.insertData(); // Inserting sample data into the vehicle list

        Vehicle b = (Vehicle) a.clone(); // Creating a clone of 'a' using clone() method
        List<String> list = b.getVehicleList(); // Getting the vehicle list from 'b'
        list.add("Honda new Amaze"); // Modifying the list in 'b'

        // Printing the vehicle lists from both 'a' and 'b'
        System.out.println(a.getVehicleList());
        System.out.println(list);

        // Removing an element from the list in 'b'
        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList()); // Printing the vehicle list from 'a' again
    }

}
