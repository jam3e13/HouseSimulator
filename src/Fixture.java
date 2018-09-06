//Fixtures to add:
//1. Motion Sensor
//2. Room Air con
//3. Room Lights
//4. Room Ceiling Fan
//5. Garage Door
//6. Sprinklers

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fixture {
    public String itemName;
    public int number;
    public boolean fixtureSwitch;
    public int roomNumber;

    public static void main(String args[]) {

    }

    static void fixtureFlow() {
        livingRoom();
        mainBedroom();
        secondBedroom();
        kitchen();
        garage();
        garden();
    }


    //Used at the very start of the program
    static void initialSetup() {
        System.out.println("Fixtures: ");
    }

    //Used to edit fixtures
    private static void livingRoom() {
        //Living Room Fixtures
        //1. Motion Sensor
        //2. Room Air con
        //3. Room Lights
        //4. Room Ceiling Fan

        System.out.println("Edit Fixtures for Living Room?");
        Scanner input = new Scanner(System.in);
        String editLivingRoom = input.toString();

        //Edit elements in array lists
        if (editLivingRoom.equals("Y")) {
            System.out.println("Loading Main Bedroom Fixtures...");
            System.out.println("Please fill in the required fields...");
            System.out.println("Living Room Fixtures: ");
        } else {
            System.out.println("Main Bedroom Fixtures NOT Changed");
        }
        System.out.println("Loading Main Bedroom Fixtures...");
    }

    private static void mainBedroom() {
        //Living Room Fixtures
        //1. Motion Sensor
        //2. Room Air con
        //3. Room Lights
        //4. Room Ceiling Fan

        System.out.println("Edit Fixtures for Main Bedroom");
        Scanner input = new Scanner(System.in);
        String editLivingRoom = input.toString();

        //Edit elements in array lists
        if (editLivingRoom.equals("Y")) {
            System.out.println("Loading Main Bedroom Fixtures...");
            System.out.println("Please fill in the required fields...");
            System.out.println("Main Bedroom Fixtures: ");
        } else {
            System.out.println("Main Bedroom Fixtures NOT Changed");
        }
        System.out.println("Loading Main Bedroom Fixtures...");
    }

    private static void secondBedroom() {
        //Living Room Fixtures
        //1. Motion Sensor
        //2. Room Air con
        //3. Room Lights
        //4. Room Ceiling Fan

        System.out.println("Edit Fixtures for Main Bedroom");
        Scanner input = new Scanner(System.in);
        String editLivingRoom = input.toString();

        //Edit elements in array lists
        if (editLivingRoom.equals("Y")) {
            System.out.println("Loading Main Bedroom Fixtures...");
            System.out.println("Please fill in the required fields...");
            System.out.println("Main Bedroom Fixtures: ");
        } else {
            System.out.println("Main Bedroom Fixtures NOT Changed");
        }
        System.out.println("Loading Main Bedroom Fixtures...");
    }

    private static void kitchen() {
        //Living Room Fixtures
        //1. Motion Sensor
        //2. Room Air con
        //3. Room Lights
        //4. Room Ceiling Fan

        System.out.println("Edit Fixtures for Main Bedroom");
        Scanner input = new Scanner(System.in);
        String editLivingRoom = input.toString();

        //Edit elements in array lists
        if (editLivingRoom.equals("Y")) {
            System.out.println("Loading Main Bedroom Fixtures...");
            System.out.println("Please fill in the required fields...");
            System.out.println("Main Bedroom Fixtures: ");
        } else {
            System.out.println("Main Bedroom Fixtures NOT Changed");
        }
        System.out.println("Loading Main Bedroom Fixtures...");
    }

    private static void garage() {
        //Living Room Fixtures
        //1. Motion Sensor
        //2. Room Air con
        //3. Room Lights
        //4. Room Ceiling Fan

        System.out.println("Edit Fixtures for Main Bedroom");
        Scanner input = new Scanner(System.in);
        String editLivingRoom = input.toString();

        //Edit elements in array lists
        if (editLivingRoom.equals("Y")) {
            System.out.println("Loading Main Bedroom Fixtures...");
            System.out.println("Please fill in the required fields...");
            System.out.println("Main Bedroom Fixtures: ");
        } else {
            System.out.println("Main Bedroom Fixtures NOT Changed");
        }
        System.out.println("Loading Main Bedroom Fixtures...");
    }

    private static void garden() {
        //Living Room Fixtures
        //1. Motion Sensor
        //2. Room Lights
        //3. Sprinklers

        System.out.println("Edit Fixtures for Garden");
        Scanner input = new Scanner(System.in);
        String editLivingRoom = input.toString();

        //Edit elements in array lists
        if (editLivingRoom.equals("Y")) {
            System.out.println("Loading Garden Fixtures...");
            System.out.println("Please fill in the required fields...");
            System.out.println("Garden Fixtures: ");
        } else {
            System.out.println("Garden Fixtures NOT Changed");
        }
        System.out.println("Loading Living Room Appliances...");
    }


}
