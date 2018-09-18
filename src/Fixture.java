//Fixtures to add:
//1. Motion Sensor
//2. Room Air con
//3. Room Lights
//4. Room Ceiling Fan
//5. Garage Door
//6. Sprinklers

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Fixture {

    private static int choice, fixtureChoice;
    static int acTempSetting;
    static String roomLocation;
    static String fixtureSwitch = "OFF";
    static double lightSettingOn, lightSettingOff;
    static ArrayList<String> list1, acList;

    //Used at the very start of the program
    static void initialSetup() throws InterruptedException {
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

        ArrayList<String> motionSensorList = new ArrayList<String>();
        motionSensorList.add(itemName);
        motionSensorList.add(String.valueOf(room));

        System.out.println(motionSensorList);
    }

    private static void airCon() {
        System.out.println("AC config file loading...");
        System.out.println("Set Temperature for " + roomLocation + ": 16° - 26°");
        Scanner input = new Scanner(System.in);
        acTempSetting = input.nextInt();

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
        House deviceID = new House();
        deviceID.setDeviceID("Air Conditioner");
        House location = new House();
        location.setLocation(roomLocation);
        House powerSwitch = new House();
        powerSwitch.setPowerSwitch("OFF");
        House acTemp = new House();
        acTemp.setAcTemp(acTempSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                powerSwitch.setPowerSwitch("ON");
                String acDisplay = ("The " + House.getLocation() +
                        " " + deviceID.getDeviceID() + " has been set to: " +
                        "" + acTemp.getAcTemp() + "°");
                System.out.println(acDisplay);

                //Add to a list to be called in sim
                House acList = new House();
                List<House.airConditioner> list1 = new ArrayList<House.airConditioner>();
                list1.add(new House.airConditioner(House.getLocation()));
                list1.add(new House.airConditioner(deviceID.getDeviceID()));
                list1.add(new House.airConditioner(String.valueOf(acTemp.getAcTemp())));
                list1.add(new House.airConditioner(powerSwitch.setPowerSwitch()));
                acList.setListAirCon(list1);

                //Full list view of what is being saved
                System.out.println("AC List: " + list1);

                //Shows what room the ac is in
                System.out.println("ROOM: " + list1.get(0));

                //Updates any new AC fixtures into one list
                try {
                    updateAcList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("AC List failed...");
                break;
        }
    }

    private static void updateAcList() throws IOException {

        //Get files to save


        File newFile = new File("C:\\Users\\James\\IdeaProjects\\HouseSimulator\\acList.txt");
        if (newFile.exists()){
            System.out.println("File Already Exists!");
        } else {
            try {
                newFile.createNewFile();
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                FileWriter fileW = new FileWriter(newFile);
                BufferedWriter buffW = new BufferedWriter(fileW);
                buffW.write(String.valueOf(list1));
                System.out.println(list1);
                System.out.println("File Written!");

            }catch (Exception e) {
                e.printStackTrace();
            }
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
                ArrayList<String> lightList = new ArrayList<String>();
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