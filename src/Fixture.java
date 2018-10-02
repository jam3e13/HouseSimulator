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
    static int acTempSetting, changeSettings, ceilingFanTempSetting, garageDoorSetting, sprinklerSetting;
    static String roomLocation, data, updatedList1, updatedList2, x1, x2, sprinklerMode;
    static String fixtureSwitch = "OFF";
    static double lightSettingOn, lightSettingOff;
    static ArrayList<String> list1;
    static ArrayList<String> list2;
    static String[] displayLine1, displayLine2, values, displayLine3;

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
                    System.out.println("\n1) MOTION SENSOR");
                    System.out.println("2) AIR CONDITIONER");
                    System.out.println("3) LIGHTS");
                    System.out.println("4) CEILING FAN");
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
                System.out.println("2) LIGHTS");
                System.out.println("3) GARAGE DOOR - Not done");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (0), (1), (2), (3) OR (4)");
                    System.out.println("\n1) MOTION SENSOR - Not done");
                    System.out.println("2) LIGHTS");
                    System.out.println("3) GARAGE DOOR - Not done");
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
                roomLocation = "GARDEN";
                System.out.println(roomLocation + " - Fixtures...");

                System.out.println("\n1) MOTION SENSOR");
                System.out.println("2) LIGHTS");
                System.out.println("3) SPRINKLERS");
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
        String fileName = "C:\\Users\\James\\Desktop\\airConConfig.txt";
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
                    //Location
                    list1.add(new House.airConditioner(House.getLocation()));
                    //Device
                    list1.add(new House.airConditioner("Air Conditioner"));
                    //Calibration
                    list1.add(new House.airConditioner("ON"));
                    //User Settings
                    list1.add(new House.airConditioner(String.valueOf(acTemp.getAcTemp())));
                    //Set list
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
                    //Location
                    list2.add(new House.airConditioner(House.getLocation()));
                    //Device
                    list2.add(new House.airConditioner("Air Conditioner"));
                    //Calibration
                    list2.add(new House.airConditioner("ON"));
                    //User Settings
                    list2.add(new House.airConditioner(String.valueOf(acTemp.getAcTemp())));
                    //Set list
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
                PrintWriter pw = new PrintWriter("C:\\Users\\James\\Desktop\\airConConfig.txt");
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
                    Files.write(Paths.get("C:\\Users\\James\\Desktop\\airConConfig.txt"), sb.toString().replace("[","").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
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

    private static void ceilingFan() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "C:\\Users\\James\\Desktop\\ceilingFanConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("LIVING ROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine3));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter a Temperature below, OR Enter 0 to EXIT.");
        System.out.println("Different weather conditions will effect the fan switch");
        System.out.println("Set Temperature for " + roomLocation + ": 22° - 30°");

        ceilingFanTempSetting = input.nextInt();

        //Exits if user chooses 0
        if (ceilingFanTempSetting == 0) {
            try {
                initialSetup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (ceilingFanTempSetting > 30) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: 22° - 30°");
            ceilingFanTempSetting = input.nextInt();
        }
        while (ceilingFanTempSetting < 22) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: 22° - 30°");
            ceilingFanTempSetting = input.nextInt();
        }

        //saves to user chosen room
        House ceilingFanTemp = new House();
        ceilingFanTemp.setCeilingFanTemp(ceilingFanTempSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                String ceilingFanDisplay = ("The " + roomLocation + " Garage Door has been set to: " + ceilingFanTemp.getCeilingFanTemp() + "°");
                System.out.println(ceilingFanDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("LIVING ROOM")) {
                    House location = new House();
                    location.setLocation(roomLocation);
                    House ceilingFanList = new House();
                    List<House.ceilingFan> list = new ArrayList<>();
                    //Location
                    list.add(new House.ceilingFan(House.getLocation()));
                    //Device
                    list.add(new House.ceilingFan("Ceiling Fan"));
                    //Calibration
                    list.add(new House.ceilingFan("ON"));
                    //User Settings
                    list.add(new House.ceilingFan(String.valueOf(ceilingFanTemp.getCeilingFanTemp())));
                    //Set list
                    ceilingFanList.setListCeilingFan(list);
                    updatedList2 = list.toString();
                    x2 = String.valueOf((updatedList2));

                    //Full list view of what is being saved
                    System.out.println("Ceiling Fan List: " + list);

                    //Shows what room the ac is in
                    System.out.println("ROOM: " + list.get(0));

                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("C:\\Users\\James\\Desktop\\ceilingFanConfig.txt");
                pw.close();


                System.out.println(x2);

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("C:\\Users\\James\\Desktop\\ceilingFanConfig.txt"), sb.toString().replace("[","").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Ceiling Fan List failed...");
                break;
        }


    }

    private static void garageDoor() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "C:\\Users\\James\\Desktop\\garageDoorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("GARAGE")) {
                System.out.println("Status: " + Arrays.toString(displayLine3));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter below, OR Enter 0 to EXIT.");
        System.out.println("Turn on Security Lock for " + roomLocation + ": 1 - Yes, 2 - No.");

        garageDoorSetting = input.nextInt();

        //Exits if user chooses 0
        if (garageDoorSetting == 0) {
            try {
                initialSetup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (garageDoorSetting > 2) {
            System.out.println("Wrong Input...");
            System.out.println("Please enter 1 to Turn ON, or 2 turn OFF.");
            garageDoorSetting = input.nextInt();
        }

        //saves to user chosen room
        House garageTemp = new House();
        garageTemp.setGarageTemp(garageDoorSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                String ceilingFanDisplay = ("The " + roomLocation + " Ceiling Fan has been set to: " + garageTemp.getGarageTemp() + "°");
                System.out.println(ceilingFanDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("GARAGE")) {
                    House location = new House();
                    location.setLocation(roomLocation);
                    House garageDoorList = new House();
                    List<House.garageDoor> list = new ArrayList<>();
                    //Location
                    list.add(new House.garageDoor(House.getLocation()));
                    //Device
                    list.add(new House.garageDoor("Garage Door"));
                    //Calibration
                    list.add(new House.garageDoor("ON"));
                    //User Settings
                    list.add(new House.garageDoor(String.valueOf(garageTemp.getGarageTemp())));
                    //Set list
                    garageDoorList.setListGarageDoor(list);
                    updatedList2 = list.toString();
                    x2 = String.valueOf((updatedList2));

                    //Full list view of what is being saved
                    System.out.println("Garage List: " + list);

                    //Shows what room the ac is in
                    System.out.println("ROOM: " + list.get(0));

                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("C:\\Users\\James\\Desktop\\garageDoorConfig.txt");
                pw.close();


                System.out.println(x2);

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("C:\\Users\\James\\Desktop\\garageDoorConfig.txt"), sb.toString().replace("[","").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Garage Door List failed...");
                break;
        }
    }

    private static void sprinklers() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "C:\\Users\\James\\Desktop\\sprinklerConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("GARDEN")) {
                System.out.println("Status: " + Arrays.toString(displayLine3));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter either; 1, 2 or 3 below, OR Enter 0 to EXIT.");
        System.out.println("\n1) Extreme Water Saver Mode - Waters Garden Once a Day");
        System.out.println("2) Water Saver Mode - Waters Garden Twice a Day");
        System.out.println("3) Full Flow Mode - Waters Garden Three times a Day");

        sprinklerSetting = input.nextInt();

        //Exits if user chooses 0
        if (sprinklerSetting == 0) {
            try {
                initialSetup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (sprinklerSetting > 3) {
            System.out.println("Wrong Input...");
            System.out.println("Please enter either 1, 2 or 3.");
            sprinklerSetting = input.nextInt();
        }

        if (sprinklerSetting == 1) {
            //1 Water - 6:00pm
            sprinklerMode = "Extreme Water Saver Mode";
        } else if (sprinklerSetting == 2) {
            //2 Water - 9:00am / 6:00pm
            sprinklerMode = "Water Saver Mode";
        } else if (sprinklerSetting == 3) {
            //3 Water - 9:00am / 6:00pm / 2:00am
            sprinklerMode = "Full Flow Mode";
        }

        //saves to user chosen room
        House sprinklerTemp = new House();
        sprinklerTemp.setSprinklerTemp(sprinklerSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                String sprinklerDisplay = ("The " + roomLocation + " Sprinklers has been set to: " + sprinklerMode);
                System.out.println(sprinklerDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("GARDEN")) {
                    House location = new House();
                    location.setLocation(roomLocation);
                    House gardenSprinkler = new House();
                    List<House.gardenSprinkler> list = new ArrayList<>();
                    //Location
                    list.add(new House.gardenSprinkler(House.getLocation()));
                    //Device
                    list.add(new House.gardenSprinkler("GARDEN"));
                    //Calibration
                    list.add(new House.gardenSprinkler("ON"));
                    //User Settings
                    list.add(new House.gardenSprinkler(String.valueOf(sprinklerTemp.getSprinklerTemp())));
                    //Set list
                    gardenSprinkler.setListGardenSprinkler(list);
                    updatedList2 = list.toString();
                    x2 = String.valueOf((updatedList2));

                    //Full list view of what is being saved
                    System.out.println("Garden List: " + list);

                    //Shows what room the ac is in
                    System.out.println("ROOM: " + list.get(0));

                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("C:\\Users\\James\\Desktop\\sprinklerConfig.txt");
                pw.close();


                System.out.println(x2);

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("C:\\Users\\James\\Desktop\\sprinklerConfig.txt"), sb.toString().replace("[","").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Garden Sprinkler List failed...");
                break;
        }
    }
}