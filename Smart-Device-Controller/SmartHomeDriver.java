// 1️⃣ SmartHome Device Controller
// Design classes for:
// •	Light
// •	Fan
// •	AC
// Each device should have:
// •	turnOn(), turnOff(), getStatus()
// •	AC should also have setTemperature()
// Create a Controller class that:
// •	Accepts any device
// •	Turns all devices ON or OFF using polymorphism
// Task: Write class structure + driver code to control all devices using only one reference type (like Device interface).


import java.util.*;

// Device Interface
interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
}

// Light Class
class Light implements Device {
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return isOn ? "Light is ON" : "Light is OFF";
    }
}

// Fan Class
class Fan implements Device {
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return isOn ? "Fan is ON" : "Fan is OFF";
    }
}

// AC Class
class AC implements Device {
    private boolean isOn;
    private int temperature;

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    public void setTemperature(int temp) {
        temperature = temp;
    }

    @Override
    public String getStatus() {
        if (isOn)
            return "AC is ON at temperature: " + temperature;
        else
            return "AC is OFF";
    }
}

// Controller Class


class Controller {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
    }

    public void turnAllOn() {
        for (Device d : devices) {
            d.turnOn();
        }
    }

    public void turnAllOff() {
        for (Device d : devices) {
            d.turnOff();
        }
    }

    public void showAllStatus() {
        for (Device d : devices) {
            System.out.println(d.getStatus());
        }
    }
}

// Main Driver
public class SmartHomeDriver {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();
        ac.setTemperature(24);

        Controller controller = new Controller();

        controller.addDevice(light);
        controller.addDevice(fan);
        controller.addDevice(ac);

        System.out.println("Turning all devices ON...");
        controller.turnAllOn();
        controller.showAllStatus();

        System.out.println("\nTurning all devices OFF...");
        controller.turnAllOff();
        controller.showAllStatus();
    }
}































