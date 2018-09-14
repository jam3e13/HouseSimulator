//Fixtures to add:
//1. Motion Sensor
//2. Room Air con
//3. Room Lights
//4. Room Ceiling Fan
//5. Garage Door
//6. Sprinklers

import java.util.ArrayList;
import java.util.Scanner;

public class Fixture {

    private static int choice, fixtureChoice;
    static String roomLocation, exit;
    static String fixtureSwitch = "OFF";
    static double acTempSetting, lightSettingOn, lightSettingOff;
    static boolean leaveLivingRoom;

    public static void main(String[] args) {

    }

    //Used at the very start of the program
    static void initialSetup() {
        System.out.println("Please select a Room to set up...");
        roomDisplay();
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        do {
            if (choice == 1) {
                //LIVING ROOM
                roomLocation = "LIVING ROOM";
                System.out.println(roomLocation + " - Fixtures...");
                fixtureDisplay();
                fixtureChoice = input.nextInt();
                leaveLivingRoom = false;

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

                } else if (fixtureChoice == 5) {
                    //GARAGE DOOR
                    garageDoor();

                } else if (fixtureChoice == 6) {
                    //SPRINKLERS
                    sprinklers();
                } else if (fixtureChoice == 0) {
                    fixtureChoice = 11;
                    System.out.println(fixtureChoice);
                }


            } else if (choice == 2) {
                //MAIN BEDROOM
                roomLocation = "MAIN BEDROOM";
                System.out.println(roomLocation + " - Fixtures...");
                fixtureDisplay();
                fixtureChoice = input.nextInt();
                do {
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

                    } else if (fixtureChoice == 5) {
                        //GARAGE DOOR
                        garageDoor();

                    } else if (fixtureChoice == 6) {
                        //SPRINKLERS
                        sprinklers();
                    }
                } while (fixtureChoice == 0);
            } else if (choice == 3) {
                //SECOND BEDROOM
                roomLocation = "SECOND BEDROOM";
                System.out.println(roomLocation + " - Fixtures...");
                fixtureDisplay();
                fixtureChoice = input.nextInt();
                do {
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

                    } else if (fixtureChoice == 5) {
                        //GARAGE DOOR
                        garageDoor();

                    } else if (fixtureChoice == 6) {
                        //SPRINKLERS
                        sprinklers();
                    }
                } while (fixtureChoice == 0);
            } else if (choice == 4) {
                //KITCHEN
                roomLocation = "KITCHEN";
                System.out.println(roomLocation + " - Fixtures...");
                fixtureDisplay();
                fixtureChoice = input.nextInt();
                do {
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

                    } else if (fixtureChoice == 5) {
                        //GARAGE DOOR
                        garageDoor();

                    } else if (fixtureChoice == 6) {
                        //SPRINKLERS
                        sprinklers();
                    }
                } while (fixtureChoice == 0);
            } else if (choice == 5) {
                //GARAGE
                roomLocation = "GARAGE";
                System.out.println(roomLocation + " - Fixtures...");
                fixtureDisplay();
                fixtureChoice = input.nextInt();
                do {
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

                    } else if (fixtureChoice == 5) {
                        //GARAGE DOOR
                        garageDoor();

                    } else if (fixtureChoice == 6) {
                        //SPRINKLERS
                        sprinklers();
                    }
                } while (fixtureChoice == 0);
            } else if (choice == 6) {
                System.out.println(roomLocation + " - Fixtures...");
                fixtureDisplay();
                fixtureChoice = input.nextInt();
                //GARDEN
                do {
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

                    } else if (fixtureChoice == 5) {
                        //GARAGE DOOR
                        garageDoor();

                    } else if (fixtureChoice == 6) {
                        //SPRINKLERS
                        sprinklers();
                    }
                } while (fixtureChoice == 0);
            }
            System.out.println("Please select a Room to set up...");
            roomDisplay();
            choice = input.nextInt();
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

    private static void fixtureDisplay() {
        //Menu options
        System.out.println("\n1) MOTION SENSOR - Not done");
        System.out.println("2) AIR CONDITIONER");
        System.out.println("3) LIGHTS");
        System.out.println("4) CEILING FAN - Not done");
        System.out.println("5) GARAGE DOOR - Not done");
        System.out.println("6) SPRINKLERS - Not done");
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
        System.out.println("Set temperature for " + roomLocation + " 16 Degrees - 26 Degrees.");
        Scanner input = new Scanner(System.in);
        acTempSetting = input.nextDouble();

        //Makes sure use inputs 0, 1, 2 or 3 only
        while (acTempSetting >= 26) {
            System.out.println("Wrong input...");
            System.out.println("Please enter between: 16 Degrees - 26 Degrees.");
            acTempSetting = input.nextDouble();
        }

        String itemName = "Air Conditioner";

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                ArrayList<String> airConList = new ArrayList<String>();
                airConList.add("Fixture: " + itemName);
                airConList.add(String.valueOf("AC set Temperature: " + acTempSetting));
                airConList.add(String.valueOf("Room: " + roomLocation));

                System.out.println(airConList);
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


/*

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

            String itemName = "Motion Sensor";



            String room = "Living Room";

            ArrayList<String> motionSensorList = new ArrayList<String>();
            motionSensorList.add(itemName);
            motionSensorList.add(String.valueOf(fixtureSwitch));
            motionSensorList.add(String.valueOf(room));

            System.out.println("Living Room Fixtures: ");
            System.out.println(motionSensorList);

            //Add in loop to run through each living room fixture and break when user says not to edit
            System.out.println("Please fill in the required fields...");
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
*/

}
