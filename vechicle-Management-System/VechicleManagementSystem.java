// 3️⃣ Vehicle Maintenance Manager
// Base class: Vehicle
// Properties:
// •	brand, model, kmDriven
// Subclasses:
// •	Car
// •	Bike
// •	Truck (extra: cargoCapacity)
// Create:
// •	calculateServiceCost() → different for each vehicle
// •	getNextServiceDue()
// Task: Given a list of vehicles, print their service cost using runtime polymorphism.

import java.lang.*;
import java.util.*;

class Vechicle{
    String brand;
    String model;
    int kmDriven;
    
    Vechicle(String brand, String model, int kmDriven){
        this.brand = brand;
        this.model = model;
        this.kmDriven = kmDriven;
    }
    
    void calculateServiceCost(){
        System.out.println("Genric Vechicle service");
    }
    void getNextServiceDue(){
        System.out.println("Next service details..");
    }
}

class Car extends Vechicle {
    Car (String brand, String model, int kmDriven){
        super(brand, model, kmDriven);
    }
    
    @Override
    void calculateServiceCost(){
        int cost = kmDriven * 2;
        System.out.println("Car Service Cost:"+cost);
    }
    @Override
    void getNextServiceDue(){
        System.out.println("Next Car Service is after 5000km");
    }
}

class Bike extends Vechicle {
    Bike(String brand, String model, int kmDriven){
        super(brand, model, kmDriven);
    }
    
    @Override
    void calculateServiceCost(){
        int cost = kmDriven * 1;
        System.out.println("Bike Sevice Cost:"+cost);
    }
    @Override
    void getNextServiceDue(){
        System.out.println("Next Bike Service is after 3000km");
    }
    
}

class Truck extends Vechicle {
    int cargoCapacity;
    
    Truck(String brand, String model, int kmDriven, int cargoCapacity){
        super(brand, model, kmDriven);
        this.cargoCapacity = cargoCapacity;
    }
    @Override
    void calculateServiceCost(){
        int cost = kmDriven * 3 + cargoCapacity * 10;
        System.out.println("Truck Service Cost:"+cost);
    }
    @Override
    void getNextServiceDue(){
        System.out.println("Next Truck Service is After 7000km");
    }
}

public class VechicleManagementSystem{
    public static void main (String[] args) {
        
        List<Vechicle> vechicles = new ArrayList<>();
        
        vechicles.add(new Car("Honda", "City", 5000));
        vechicles.add(new Bike("Yamaha", "FZ", 3000));
        vechicles.add(new Truck("Tata", "407", 8000, 2000));
        
        for(Vechicle v: vechicles){
            System.out.println("\nVechicle: " +v.brand+ " "+v.model);
            v.calculateServiceCost();
            v.getNextServiceDue();
        }
    }
}
