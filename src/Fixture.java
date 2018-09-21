//Fixtures to add:
//1. Motion Sensor
//2. Room Air con
//3. Room Lights
//4. Room Ceiling Fan
//5. Garage Door
//6. Sprinklers

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Fixture {

    private static int choice, fixtureChoice;
    static int acTempSetting, changeSettings;
    static String roomLocation, data, updatedList1, updatedList2, x1, x2;
    static String fixtureSwitch = "OFF";
    static double lightSettingOn, lightSettingOff;
    private static ArrayList<String> list1, list2;
    static String[] displayLine1, displayLine2, values;

    //Used at the very start of the program
    static void initialSetup() throws InterruptedException, FileNotFoundException {
        System.out.println("Please select a Room to set up...");
        roomDisplay();
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        do {
            if (choice == 1) {
                //LIVING ROOM
                roomLocation = "LIVING ROOM";
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR - Not done");
                System.out.println("2) AIR CONDITIONER");
                System.out.println("3) LIGHTS");
                System.out.println("4) CEILING FAN - Not done");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("2) AIR CONDITIONER");
                    System.out.println("3) LIGHTS");
                    System.out.println("4) CEILING FAN - Not done");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //MOTION SENSOR
                    motionSensor();

                } else if (fixtureChoice == 2) {
                    //AC
                    airCon();

                } else if (fixtureChoice == 3) {
                    //LIGHTS
                    lights();

                } else if (fixtureChoice == 4) {
                    //CEILING FAN
                    ceilingFan();

                } else if (fixtureChoice == 0) {
                    initialSetup();
                }

                //ADD APPLIANCES HERE

            } else if (choice == 2) {
                //MAIN BEDROOM
                roomLocation = "MAIN BEDROOM";
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR - Not done");
                System.out.println("2) AIR CONDITIONER");
                System.out.println("3) LIGHTS");
                System.out.println("4) CEILING FAN - Not done");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("2) AIR CONDITIONER");
                    System.out.println("3) LIGHTS");
                    System.out.println("4) CEILING FAN - Not done");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //MOTION SENSOR
                    motionSensor();

                } else if (fixtureChoice == 2) {
                    //AC
                    airCon();

                } else if (fixtureChoice == 3) {
                    //LIGHTS
                    lights();

                } else if (fixtureChoice == 4) {
                    //CEILING FAN
                    ceilingFan();

                } else if (fixtureChoice == 0) {
                    initialSetup();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 3) {
                //SECOND BEDROOM
                roomLocation = "SECOND BEDROOM";
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR - Not done");
                System.out.println("2) LIGHTS");
                System.out.println("3) CEILING FAN - Not done");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("2) LIGHTS");
                    System.out.println("3) CEILING FAN - Not done");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //MOTION SENSOR
                    motionSensor();
                } else if (fixtureChoice == 3) {
                    //LIGHTS
                    lights();
                } else if (fixtureChoice == 4) {
                    //CEILING FAN
                    ceilingFan();
                } else if (fixtureChoice == 0) {
                    initialSetup();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 4) {
                //KITCHEN
                roomLocation = "KITCHEN";
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR - Not done");
                System.out.println("2) LIGHTS");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("2) LIGHTS");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //MOTION SENSOR
                    motionSensor();

                } else if (fixtureChoice == 3) {
                    //LIGHTS
                    lights();

                } else if (fixtureChoice == 0) {
                    initialSetup();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 5) {
                //GARAGE
                roomLocation = "GARAGE";
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR - Not done");
                System.out.println("3) LIGHTS");
                System.out.println("5) GARAGE DOOR - Not done");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("3) LIGHTS");
                    System.out.println("5) GARAGE DOOR - Not done");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //MOTION SENSOR
                    motionSensor();

                } else if (fixtureChoice == 2) {
                    //LIGHTS
                    lights();

                } else if (fixtureChoice == 3) {
                    //GARAGE DOOR
                    garageDoor();

                } else if (fixtureChoice == 0) {
                    initialSetup();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 6) {
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR - Not done");
                System.out.println("2) LIGHTS");
                System.out.println("3) SPRINKLERS - Not done");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("2) LIGHTS");
                    System.out.println("3) SPRINKLERS - Not done");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }
                //GARDEN

                if (fixtureChoice == 1) {
                    //MOTION SENSOR
                    motionSensor();

                } else if (fixtureChoice == 2) {
                    //LIGHTS
                    lights();

                } else if (fixtureChoice == 3) {
                    //SPRINKLERS
                    sprinklers();
                } else if (fixtureChoice == 0) {
                    initialSetup();
                } else {
                    System.out.println("Wrong input...");
                }
            }

            //Displays menu
            Menu.menuDisplay();
            //User choice to run option
            Menu.initialChoice();
        } while (choice != 0);

    }

    private static void roomDisplay() {
        //Menu options
        System.out.println("\n0) Menu");
        System.out.println("1) LIVING ROOM");
        System.out.println("2) MAIN BEDROOM - Not done");
        System.out.println("3) SECOND BEDROOM - Not done");
        System.out.println("4) KITCHEN - Not done");
        System.out.println("5) GARAGE - Not done");
        System.out.println("6) GARDEN - Not done");
    }

    private static void motionSensor() {
        String itemName = "Motion Sensor";

        String room = "Living Room";

        ArrayList<String> motionSensorList = new ArrayList<>();
        motionSensorList.add(itemName);
        motionSensorList.add(String.valueOf(room));

        System.out.println(motionSensorList);
    }

    private static void airCon() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        //Checks to see if device already set up
        if (roomLocation.equals("MAIN BEDROOM") && acTempSetting > 0 && values[2].equals("ON")) {
            System.out.println("MAIN BEDROOM AC is already set up.");
            System.out.println("Edit MAIN BEDROOM settings?");
            changeSettings = input.nextInt();
            while (changeSettings > 1) {
                System.out.println("Wrong input...");
                System.out.println("Please enter only (0) - Exit, (1) - Change");
                changeSettings = input.nextInt();
            }
            if (changeSettings == 1) {
                System.out.println("Changing Settings");
            } else if (changeSettings == 0) {
                System.out.println("Returning to Rooms...");
                try {
                    initialSetup();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (roomLocation.equals("LIVING ROOM") && acTempSetting > 0 && values[2].equals("ON")) {
            System.out.println("LIVING ROOM AC is already set up.");
            System.out.println("Edit MAIN BEDROOM settings?");
            changeSettings = input.nextInt();
            while (changeSettings > 1) {
                System.out.println("Wrong input...");
                System.out.println("Please enter only (0) - Exit, (1) - Change");
                changeSettings = input.nextInt();
            }
            if (changeSettings == 1) {
                System.out.println("Changing Settings");
            } else if (changeSettings == 0) {
                System.out.println("Returning to Rooms...");
                try {
                    initialSetup();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //Display rooms status
        String fileName = "C:\\Users\\James\\Desktop\\input.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine2 = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("MAIN BEDROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine1));
            }
            if (roomLocation.equals("LIVING ROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine2));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter a Temperature below, OR Enter 0 to EXIT.");
        System.out.println("Set Temperature for " + roomLocation + ": 16° - 26°");

        acTempSetting = input.nextInt();

        //Exits if user chooses 0
        if (acTempSetting == 0) {
            try {
                initialSetup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (acTempSetting > 26) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: 16° - 26°");
            acTempSetting = input.nextInt();
        }
        while (acTempSetting < 16) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: 16° - 26°");
            acTempSetting = input.nextInt();
        }

        //saves to user chosen room
        House acTemp = new House();
        acTemp.setAcTemp(acTempSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                String acDisplay = ("The " + roomLocation + " Air Conditioner has been set to: " + acTemp.getAcTemp() + "°");
                System.out.println(acDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("MAIN BEDROOM")) {
                    House location = new House();
                    location.setLocation(roomLocation);

                    House acList = new House();
                    List<House.airConditioner> list1 = new ArrayList<>();
                    list1.add(new House.airConditioner(House.getLocation()));
                    list1.add(new House.airConditioner("Air Conditioner"));
                    list1.add(new House.airConditioner("OFF"));
                    list1.add(new House.airConditioner(String.valueOf(acTemp.getAcTemp())));
                    acList.setListAirCon(list1);

                    updatedList1 = list1.toString();
                    x1 = String.valueOf((updatedList1));

                    updatedList2 = Arrays.toString(displayLine2);
                    x2 = String.valueOf((updatedList2));

                    //Full list view of what is being saved
                    System.out.println("AC List: " + list1);

                    //Shows what room the ac is in
                    System.out.println("ROOM: " + list1.get(0));

                } else if (roomLocation.equals("LIVING ROOM")) {
                    House location = new House();
                    location.setLocation(roomLocation);
                    House acList = new House();
                    List<House.airConditioner> list2 = new ArrayList<>();
                    list2.add(new House.airConditioner(House.getLocation()));
                    list2.add(new House.airConditioner("Air Conditioner"));
                    list2.add(new House.airConditioner("OFF"));
                    list2.add(new House.airConditioner(String.valueOf(acTemp.getAcTemp())));
                    acList.setListAirCon(list2);

                    updatedList1 = Arrays.toString(displayLine1);
                    x1 = String.valueOf((updatedList1));

                    updatedList2 = list2.toString();
                    x2 = String.valueOf((updatedList2));

                    //Full list view of what is being saved
                    System.out.println("AC List: " + list2);

                    //Shows what room the ac is in
                    System.out.println("ROOM: " + list2.get(0));

                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("C:\\Users\\James\\Desktop\\input.txt");
                pw.close();


                System.out.println(x1);
                System.out.println(x2);

                StringBuilder sb = new StringBuilder();
                //x1 = insert full updated list here
                sb.append(x1).append("\n");
                sb.append(System.lineSeparator());
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("C:\\Users\\James\\Desktop\\input.txt"), sb.toString().replace("[","").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("AC List failed...");
                break;
        }
    }

    private static void lights() {
        System.out.println("Lights config file loading...");
        System.out.println("Set when the lights switch on for the " + roomLocation + " Example: 18.00, 23.00");
        System.out.println("Enter Turn ON time: ");
        Scanner input = new Scanner(System.in);
        lightSettingOn = input.nextDouble();

        //Makes sure use inputs 0, 1, 2 or 3 only
        while (lightSettingOn >= 24 && lightSettingOn <= 5) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: 5.00 and 24.00.");
            lightSettingOn = input.nextDouble();
        }

        System.out.println("Enter Turn OFF time: ");
        lightSettingOff = input.nextDouble();

        //Makes sure use inputs 0, 1, 2 or 3 only
        while (lightSettingOff >= lightSettingOn && lightSettingOff <= 5) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: " + lightSettingOn + " and 24.00.");
            lightSettingOff = input.nextDouble();
        }

        String itemName = "Ceiling Lights";

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                ArrayList<String> lightList = new ArrayList<>();
                lightList.add("Fixture: " + itemName);
                lightList.add(String.valueOf("Lights will turn on at: " + lightSettingOn));
                lightList.add(String.valueOf("Lights will turn off at: " + lightSettingOff));
                lightList.add(String.valueOf("Room: " + roomLocation));

                System.out.println(lightList);
                break;
            default:
                System.out.println("Light List failed...");
                break;
        }

    }

    private static void ceilingFan() {
    }

    private static void garageDoor() {
    }

    private static void sprinklers() {
    }
}