import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;


class Simulator extends JFrame {
    private static final LocalTime SIM_START_TIME = LocalTime.parse("05:00");
    public static LocalTime time = SIM_START_TIME;
    static double inDoorTempSetter;
    public static double temperature, inDoorTemp, lightOn, lightOn2, sunLight, sunLightValue, livingRTemp;
    private static double mainRTemp, morningTotal, lunchTotal, dinnerTotal;
    private static double secondRTemp;
    private static double kitchenTemp;
    private static double garageTemp;
    static double gardenTemp, fullClock = time.getHour() + time.getMinute();
    public static String data, morningMode, lunchMode, dinnerMode, ovenDisplay, tvDisplay, coffeeDisplay, kettleDisplay, carDisplay, alarmDisplay, sprinklerDisplay, garageDoorDisplay, acDisplay, lightDisplay, fanDisplay;
    private static boolean tvON, kettleBoiled, behaviour1, behaviour2, behaviour3, mainRoomAC, livingRoomAc, livingRoomCeilingFan, carRunning, morningBoolean, lunchBoolean, dinnerBoolean, alarmSound, makeMainBedroomCoffee, makeSecondBedroomCoffee, alarmCoffee;
    private static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5;
    private static int ceilingFanSpeed, x, garageDoorCloseSequence = 0;
    private static int morningChoice, lunchChoice, dinnerChoice;
    static String travelTo = "";
    private static SimGUI gui = new SimGUI();


    public static void main(String weatherType) {
        //TODO make GUI appear same time as Sim is run to update GUI
        gui.setVisible(true);
        runSimulator(Menu.weatherType);
    }


    public static void runSimulator(String weatherType) {
        do {
            //Clock starts at 05:00AM
            time = time.plusMinutes(1);

            //Gets the morning weather type
            temperature = Weather.getTemperature();

            //Adds Temperature value every minute
            temperature += Weather.dynamicIncrease();

            //Sets the Light value for weather every hour
            sunLight = Sun.getSunLight();

            //TODO add water and energy functions for simulator

            //TODO make the sun light increase and decrease show right values
            //Before 12:00 Increase Light | After 12:00 Decrease Light
            if (time.getHour() < 12) {
                //am
                sunLight += Sun.sunLightIncrease();
            } else if (time.getHour() > 12) {
                //pm
                sunLight += Sun.sunLightDecrease();
            }


            //Sets temperature for each room
            livingRTemp = Devices.livingRoomTemp();
            mainRTemp = Devices.roomTemp();
            secondRTemp = Devices.roomTemp();
            kitchenTemp = Devices.livingRoomTemp();
            garageTemp = Devices.garageTemp();
            gardenTemp = Devices.gardenTemps();


            //Gets the Weather for sim
            Menu.weatherType = dynamicWeather();
            //Finds where the Person is for sim
            travelTo = dynamicMotionSensors();
            //Turns on lights for user inputs/sensors
            lightDisplay = dynamicLights();
            //Turns on AC for user inputs/sensors
            acDisplay = dynamicAC();
            //Turns on Ceiling Fan for user inputs/sensors
            fanDisplay = dynamicCeilingFan();
            //Turns on Garage for user inputs/sensors
            garageDoorDisplay = dynamicGarageDoor();
            //Turns on Sprinklers for user inputs/sensors
            sprinklerDisplay = dynamicSprinkler();

            //Behaviour change for Alarm Clock
            acDisplay = dynamicAlarm();
            //Behaviour change for Car
            carDisplay = dynamicCar();
            //Behaviour change for Oven
            ovenDisplay = dynamicOven();
            //Behaviour change for Tv
            tvDisplay = dynamicTv();
            //Behaviour change for Kettle
            kettleDisplay = dynamicKettle();
            //Behaviour change for Coffee Machine
            coffeeDisplay = dynamicCoffeeMachine();
            //Updates string to say what room person is in and change location
            travelTo = dynamicTravel();
            //Updates GUI
            gui.updateDisplays(time, temperature, sunLight, Menu.weatherType, travelTo, lightDisplay, acDisplay, fanDisplay, garageDoorDisplay, sprinklerDisplay, acDisplay, carDisplay, ovenDisplay, tvDisplay, kettleDisplay, coffeeDisplay);
            //Display for System.out()
            halfHourlyDisplay();

            //Loop finish once 24 Hours has passed.
        } while (!(time == SIM_START_TIME));
    }

    private static void halfHourlyDisplay() {
        if (time.getHour() < 12) {
            System.out.println(time + " am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLight);
            System.out.print("%");
        } else if (time.getHour() > 12) {
            System.out.println(time + " pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLight);
            System.out.print("%\n");
        }
    }

    private static String dynamicAC() {
        inDoorTempSetter = temperature;
        DecimalFormat decimalFormat = new DecimalFormat("#");

        //Change file name to be more specific for method
        String fileName = "ConfigFiles\\airConConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");

                //MAIN BEDROOM - ON
                double acTemp;
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    acTemp = Double.parseDouble(values[3]);
                    //Display when device switches on and off
                    if (acTemp < inDoorTemp && !mainRoomAC) {
                        acDisplay = "Main Room AC has switched ON! \nIn-door Temp set to: " + decimalFormat.format(inDoorTemp) + " °";
                        mainRoomAC = true;
                    }

                    if (acTemp > inDoorTemp && mainRoomAC) {
                        acDisplay = "Main Room AC has switched OFF!";
                        mainRoomAC = false;
                    }


                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    acTemp = 0;
                    values[3] = String.valueOf(acTemp);
                    //Re-format user inputs to act as a refresher
                }

                //LIVING ROOM - ON
                double acTemp2;
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.livingRoomTemp();
                    displayLine2 = data.split(", ");
                    acTemp2 = Double.parseDouble(values[3]);

                    //Display when device switches on and off
                    if (acTemp2 < inDoorTemp && !livingRoomAc) {
                        acDisplay = "Living Room AC has switched ON! \nIn-door Temp set to: " + decimalFormat.format(inDoorTemp) + " °";
                        livingRoomAc = true;
                    }

                    if (acTemp2 > inDoorTemp && livingRoomAc) {
                        acDisplay = "Living Room AC has switched OFF!";
                        livingRoomAc = false;
                    }

                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                    acTemp2 = 0;
                    values[3] = String.valueOf(acTemp2);
                    //Re-format user inputs to act as a refresher
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return acDisplay;
    }

    static String dynamicWeather() {


        Random rand = new Random();
        //1 : 150 chance for weather to change every minute
        int n = rand.nextInt(150) + 1;

        String oldWeather = Menu.weatherType;

        if (n == 1) {
            String weatherChange = Menu.getWeatherType();

            if (!weatherChange.equals(oldWeather)) {
                Menu.weatherType = weatherChange;
            }
        }
        return Menu.weatherType;
    }

    private static String dynamicMotionSensors() {
        if (time.getHour() > 21) {
            travelTo = "MAIN BEDROOM";
        } else {
            Random rand = new Random();
            //5% chance for Person to enter a new Room every minute
            int n = rand.nextInt(100) + 1;

            if (n > 95) {
                //1 : 6 chance for Room to enter a different room
                x = rand.nextInt(6) + 1;
            } else if (n < 5) {
                x = 0;
                //Main Bedroom is the main Starting and ending room for the simulation.
                travelTo = "MAIN BEDROOM";
            }

            if (x == 1) {
                //Person enters Main Bedroom
                travelTo = "MAIN BEDROOM";

            } else if (x == 2) {
                //Person enters Living Room
                travelTo = "LIVING ROOM";

            } else if (x == 3) {
                //Person enters Second Bedroom
                travelTo = "SECOND BEDROOM";

            } else if (x == 4) {
                //Person enters Kitchen
                travelTo = "KITCHEN";

            } else if (x == 5) {
                //Person enters Garage
                travelTo = "GARAGE";

            } else if (x == 6) {
                //Person enters Garden
                travelTo = "GARDEN";
            }
        }
        return travelTo;
    }

    private static String dynamicTravel() {
        //Add in possibility for people to leave property and appliances switch off automatically.
        String oldRoom;
        String changeRoom;
        switch (travelTo) {
            case "MAIN BEDROOM":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                }
                break;
            case "LIVING ROOM":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                }
                break;
            case "SECOND BEDROOM":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                }
                break;
            case "KITCHEN":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                }
                break;
            case "GARAGE":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                }
                break;
            case "GARDEN":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                }
                break;
        }
        return travelTo;
    }

    private static String dynamicLights() {
        //Change file name to be more specific for method
        String fileName = "ConfigFiles\\lightConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");

                //MAIN BEDROOM - ON
                double lightTemp;
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    lightTemp = Double.parseDouble(values[3]);

                    switch (values[3]) {
                        case "1":
                            //Economy Mode - Lights only turn on after 6pm and sunlight under 10%
                            lightOn = 10; //%
                            lightOn2 = 18; //Time
                            break;
                        case "2":
                            //Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.
                            lightOn = 25;
                            break;
                        case "3":
                            //Entertainment Mode - Lights always turn on.
                            lightOn = 75;
                            break;
                    }

                    //Display when device switches on and off
                    if (lightOn > sunLightValue && !mainRoomAC && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Main Room Lights have switched OFF!";
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        lightDisplay = "Main Room Lights have switched OFF!";
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Main Room Lights have switched OFF!";
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        lightDisplay = "Main Room Lights have switched OFF!";
                        mainRoomAC = false;
                    }


                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    //Re-format user inputs to act as a refresher
                }

                //LIVING ROOM - ON
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    lightTemp = Double.parseDouble(values[3]);

                    switch (values[3]) {
                        case "1":
                            //Economy Mode - Lights only turn on after 6pm and sunlight under 10%
                            lightOn = 10; //%
                            lightOn2 = 18; //Time
                            break;
                        case "2":
                            //Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.
                            lightOn = 25;
                            break;
                        case "3":
                            //Entertainment Mode - Lights always turn on.
                            lightOn = 75;
                            break;
                    }

                    //Display when device switches on and off
                    if (lightOn > sunLightValue && !mainRoomAC && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Living Room Lights have switched ON!";
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        lightDisplay = "Living Room Lights have switched ON!";
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Living Room Lights have switched OFF!";
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        lightDisplay = "Living Room Lights have switched OFF!";
                        mainRoomAC = false;
                    }


                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    //Re-format user inputs to act as a refresher
                }
                //SECOND BEDROOM - ON
                if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    lightTemp = Double.parseDouble(values[3]);

                    switch (values[3]) {
                        case "1":
                            //Economy Mode - Lights only turn on after 6pm and sunlight under 10%
                            lightOn = 10; //%
                            lightOn2 = 18; //Time
                            break;
                        case "2":
                            //Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.
                            lightOn = 25;
                            break;
                        case "3":
                            //Entertainment Mode - Lights always turn on.
                            lightOn = 75;
                            break;
                    }

                    //Display when device switches on and off
                    if (lightOn > sunLightValue && !mainRoomAC && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Second Bedroom Lights have switched ON!";
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        lightDisplay = "Second Bedroom Lights have switched ON!";
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Second Bedroom Lights have switched OFF!";
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        lightDisplay = "Second Bedroom Lights have switched OFF!";
                        mainRoomAC = false;
                    }


                    //SECOND BEDROOM - OFF
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    //Re-format user inputs to act as a refresher
                }
                //KITCHEN - ON
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    lightTemp = Double.parseDouble(values[3]);

                    switch (values[3]) {
                        case "1":
                            //Economy Mode - Lights only turn on after 6pm and sunlight under 10%
                            lightOn = 10; //%
                            lightOn2 = 18; //Time
                            break;
                        case "2":
                            //Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.
                            lightOn = 25;
                            break;
                        case "3":
                            //Entertainment Mode - Lights always turn on.
                            lightOn = 75;
                            break;
                    }

                    //Display when device switches on and off
                    if (lightOn > sunLightValue && !mainRoomAC && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Kitchen Lights have switched ON!";
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        lightDisplay = "Kitchen Lights have switched ON!";
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Kitchen Lights have switched OFF!";
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        lightDisplay = "Kitchen Lights have switched OFF!";
                        mainRoomAC = false;
                    }


                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    //Re-format user inputs to act as a refresher
                }
                //GARAGE - ON
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    lightTemp = Double.parseDouble(values[3]);

                    switch (values[3]) {
                        case "1":
                            //Economy Mode - Lights only turn on after 6pm and sunlight under 10%
                            lightOn = 10; //%
                            lightOn2 = 18; //Time
                            break;
                        case "2":
                            //Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.
                            lightOn = 25;
                            break;
                        case "3":
                            //Entertainment Mode - Lights always turn on.
                            lightOn = 75;
                            break;
                    }

                    //Display when device switches on and off
                    if (lightOn > sunLightValue && !mainRoomAC && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Garage Lights have switched ON!";
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        lightDisplay = "Garage Lights have switched ON!";
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Garage Lights have switched OFF!";
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        lightDisplay = "Garage Lights have switched OFF!";
                        mainRoomAC = false;
                    }


                    //GARAGE - OFF
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    //Re-format user inputs to act as a refresher
                }
                //GARDEN - ON
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    inDoorTemp = Devices.roomTemp();
                    displayLine1 = data.split(", ");
                    lightTemp = Double.parseDouble(values[3]);

                    switch (values[3]) {
                        case "1":
                            //Economy Mode - Lights only turn on after 6pm and sunlight under 10%
                            lightOn = 10; //%
                            lightOn2 = 18; //Time
                            break;
                        case "2":
                            //Neutral Mode - Lights turn on when sunlight drops below 25% or person enters room.
                            lightOn = 25;
                            break;
                        case "3":
                            //Entertainment Mode - Lights always turn on.
                            lightOn = 75;
                            break;
                    }

                    //Display when device switches on and off
                    if (lightOn > sunLightValue && !mainRoomAC && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Garden Lights have switched ON!";
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        lightDisplay = "Garden Lights have switched ON!";
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Garden Lights have switched OFF!";
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        lightDisplay = "Garden Lights have switched OFF!";
                        mainRoomAC = false;
                    }


                    //GARDEN - OFF
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    //Re-format user inputs to act as a refresher
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lightDisplay;
    }

    private static String dynamicCeilingFan() {
        DecimalFormat decimalFormat = new DecimalFormat("#");

        //Users Set temp they want room to stay at

        String fileName = "ConfigFiles\\ceilingFanConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                double ceilingFanTemp = Devices.livingRoomTemp();
                values = data.split(",");
                //LIVING ROOM - ON
                double ceilingFanListTemp;
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.livingRoomTemp();
                    displayLine1 = data.split(", ");
                    ceilingFanListTemp = Double.parseDouble(values[3]);
                    switch (Menu.weatherType) {
                        // 30 - 1
                        case "SUNNY":
                            if (ceilingFanTemp < 28 && ceilingFanTemp > 26) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if (ceilingFanTemp < 26 && ceilingFanTemp > 24) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if (ceilingFanTemp < 24 && ceilingFanTemp > 22) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 29 && inDoorTemp >= 29) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                        // 28 - 1
                        case "CLOUDY":
                            if ((ceilingFanTemp < 26 && ceilingFanTemp > 24) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if ((ceilingFanTemp < 24 && ceilingFanTemp > 22) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if ((ceilingFanTemp < 22 && ceilingFanTemp > 20) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 27 && inDoorTemp >= 27) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                        // 26
                        case "RAINY":
                            if ((ceilingFanTemp < 25 && ceilingFanTemp > 23) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if ((ceilingFanTemp < 23 && ceilingFanTemp > 21) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if ((ceilingFanTemp < 21 && ceilingFanTemp > 19) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 26 && inDoorTemp >= 26) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                    }

                    //Display when device switches on and off
                    if (ceilingFanListTemp < inDoorTemp && !livingRoomCeilingFan) {
                        fanDisplay = ("Living Room Ceiling Fan has switched ON! Fan Speed: " + ceilingFanSpeed);
                        livingRoomCeilingFan = true;
                    }

                    if (ceilingFanListTemp > inDoorTemp && livingRoomCeilingFan) {
                        fanDisplay = ("Living Room Ceiling Fan has switched OFF! ");
                        livingRoomCeilingFan = false;
                    }
                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    //Re-format user inputs to act as a refresher
                }

                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.livingRoomTemp();
                    displayLine2 = data.split(", ");
                    ceilingFanListTemp = Double.parseDouble(values[3]);
                    switch (Menu.weatherType) {
                        // 30 - 1
                        case "SUNNY":
                            if (ceilingFanTemp < 28 && ceilingFanTemp > 26) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if (ceilingFanTemp < 26 && ceilingFanTemp > 24) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if (ceilingFanTemp < 24 && ceilingFanTemp > 22) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 29 && inDoorTemp >= 29) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                        // 28 - 1
                        case "CLOUDY":
                            if ((ceilingFanTemp < 26 && ceilingFanTemp > 24) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if ((ceilingFanTemp < 24 && ceilingFanTemp > 22) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if ((ceilingFanTemp < 22 && ceilingFanTemp > 20) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 27 && inDoorTemp >= 27) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                        // 26
                        case "RAINY":
                            if ((ceilingFanTemp < 25 && ceilingFanTemp > 23) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if ((ceilingFanTemp < 23 && ceilingFanTemp > 21) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if ((ceilingFanTemp < 21 && ceilingFanTemp > 19) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 26 && inDoorTemp >= 26) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                    }

                    //Display when device switches on and off
                    if (ceilingFanListTemp < inDoorTemp && !livingRoomCeilingFan) {
                        fanDisplay = ("Main Bedroom Ceiling Fan has switched ON! Fan Speed: " + ceilingFanSpeed);
                        livingRoomCeilingFan = true;
                    }

                    if (ceilingFanListTemp > inDoorTemp && livingRoomCeilingFan) {
                        fanDisplay = ("Main Bedroom Ceiling Fan has switched OFF! ");
                        livingRoomCeilingFan = false;
                    }
                    //LIVING ROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    //Re-format user inputs to act as a refresher
                }

                if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    inDoorTemp = Devices.livingRoomTemp();
                    displayLine3 = data.split(", ");
                    ceilingFanListTemp = Double.parseDouble(values[3]);
                    switch (Menu.weatherType) {
                        // 30 - 1
                        case "SUNNY":
                            if (ceilingFanTemp < 28 && ceilingFanTemp > 26) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if (ceilingFanTemp < 26 && ceilingFanTemp > 24) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if (ceilingFanTemp < 24 && ceilingFanTemp > 22) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 29 && inDoorTemp >= 29) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                        // 28 - 1
                        case "CLOUDY":
                            if ((ceilingFanTemp < 26 && ceilingFanTemp > 24) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if ((ceilingFanTemp < 24 && ceilingFanTemp > 22) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if ((ceilingFanTemp < 22 && ceilingFanTemp > 20) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 27 && inDoorTemp >= 27) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                        // 26
                        case "RAINY":
                            if ((ceilingFanTemp < 25 && ceilingFanTemp > 23) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                            } else if ((ceilingFanTemp < 23 && ceilingFanTemp > 21) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                            } else if ((ceilingFanTemp < 21 && ceilingFanTemp > 19) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                            } else if (ceilingFanTemp >= 26 && inDoorTemp >= 26) {
                                ceilingFanSpeed = 0;
                            }
                            break;
                    }

                    //Display when device switches on and off
                    if (ceilingFanListTemp < inDoorTemp && !livingRoomCeilingFan) {
                        fanDisplay = ("Second Bedroom Ceiling Fan has switched ON! Fan Speed: " + ceilingFanSpeed);
                        livingRoomCeilingFan = true;
                    }

                    if (ceilingFanListTemp > inDoorTemp && livingRoomCeilingFan) {
                        fanDisplay = ("Second Bedroom Ceiling Fan has switched OFF! ");
                        livingRoomCeilingFan = false;
                    }
                    //LIVING ROOM - OFF
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    //Re-format user inputs to act as a refresher
                }

            }

        } catch (FileNotFoundException | NumberFormatException ignored) {

        }
        return fanDisplay;
    }

    private static String dynamicGarageDoor() {
        String fileName = "ConfigFiles\\garageDoorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                //GARAGE - ON
                double garageDoorList;

                LocalTime a = LocalTime.parse("07:30");
                LocalTime b = LocalTime.parse("12:30");
                LocalTime c = LocalTime.parse("17:30");

                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                    garageDoorList = Double.parseDouble(values[3]);


                    Random rand = new Random();
                    //1 : 4 chance for Garage Door display chance
                    int randomX = rand.nextInt(4) + 1;

                    if ((randomX == 1) && (time.equals(a))) {
                        garageDoorDisplay = "Garage Door is opening Now!";
                        garageDoorCloseSequence = 1;
                    } else if ((randomX == 4) && (time.equals(a))) {
                        garageDoorDisplay = "Garage Door accessed via Secure Mobile!";
                        garageDoorCloseSequence = 1;
                    } else if ((randomX < 4 && randomX > 1) && (time.equals(a))) {
                        garageDoorDisplay = "Garage Door accessed remotely! Please Inspect!!";
                        garageDoorCloseSequence = 1;
                    }

                    if ((time.equals(b)) && (randomX == 1)) {
                        garageDoorDisplay = "Garage Door is opening Now!";
                        garageDoorCloseSequence = 1;
                    } else if ((time.equals(b)) && (randomX == 4)) {
                        garageDoorDisplay = "Garage Door accessed via Secure Mobile!";
                        garageDoorCloseSequence = 1;
                    } else if ((time.equals(b)) && (randomX < 4 && randomX > 1)) {
                        garageDoorDisplay = "Garage Door accessed remotely! Please Inspect!!";
                        garageDoorCloseSequence = 1;
                    }

                    if ((time.equals(c)) && (randomX == 1)) {
                        garageDoorDisplay = "Garage Door is opening Now!";
                        garageDoorCloseSequence = 1;
                    } else if ((time.equals(c)) && (randomX == 4)) {
                        garageDoorDisplay = "Garage Door accessed via Secure Mobile!";
                        garageDoorCloseSequence = 1;
                    } else if ((time.equals(c)) && (randomX < 4 && randomX > 1)) {
                        garageDoorDisplay = "Garage Door accessed remotely! Please Inspect!!";
                        garageDoorCloseSequence = 1;
                    }

                    //Display when device switches on and off
                    if (garageDoorList == 1 && garageDoorCloseSequence == 1) {
                        System.out.println("Garage Door is Closing Now!");
                        garageDoorCloseSequence = 0;
                    }

                    //GARAGE - OFF
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                    garageDoorList = 0;
                    values[3] = String.valueOf(garageDoorList);
                }

            }

        } catch (Exception ignored) {

        }
        return garageDoorDisplay;
    }

    private static String dynamicSprinkler() {
        //Users Set temp they want room to stay at
        String fileName = "ConfigFiles\\sprinklerConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                //GARDEN - ON
                double sprinklerListTemp;
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                    sprinklerListTemp = Double.parseDouble(values[3]);

                    double gardenTemp;
                    String sprinklerMode;
                    switch (Menu.weatherType) {
                        case "SUNNY":
                            if (sprinklerListTemp == 1) {

                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 27;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //3 Water - 9:00am / 6:00pm / 2:00am
                                sprinklerMode = "Full Flow Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 27;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 2) {
                                    //2:00am
                                    gardenTemp = 17;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                        case "CLOUDY":
                            // NO FULL FLOW ON CLOUDY DAYS
                            if (sprinklerListTemp == 1) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 25;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 25;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                        case "RAINY":
                            // NO FULL FLOW OR WATER SAVER ON RAINY DAYS
                            if (sprinklerListTemp == 1) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                    }

                    //GARDEN - OFF
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                    sprinklerListTemp = 0;
                    values[3] = String.valueOf(sprinklerListTemp);
                    //Re-format user inputs to act as a refresher
                }

            }

        } catch (FileNotFoundException | NumberFormatException ignored) {

        }
        return sprinklerDisplay;
    }

    private static String dynamicAlarm() {
        String fileName = "ConfigFiles\\alarmClockConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");

                //MAIN BEDROOM - ON
                double alarmTime;
                String alarmBehaviour;
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                    alarmTime = Double.parseDouble(values[3]);
                    alarmBehaviour = values[4];

                    if (alarmTime < fullClock && !alarmSound) {
                        alarmDisplay = "Alarm has Turned ON!";
                        alarmSound = true;
                    } else if (time.getHour() == 4) {
                        alarmSound = false;
                    }

                    if (alarmBehaviour.equals("1")) {
                        //Morning Coffee always
                        makeMainBedroomCoffee = true;
                    } else if (alarmBehaviour.equals("2")) {
                        //Morning Coffee never
                        makeMainBedroomCoffee = false;
                    }


                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");

                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                    alarmTime = Double.parseDouble(values[3]);
                    alarmBehaviour = values[4];

                    if (alarmTime < fullClock && !alarmSound) {
                        alarmDisplay = "Alarm has Turned ON!";
                        alarmSound = true;
                    } else if (time.getHour() == 4) {
                        alarmSound = false;
                    }

                    if (alarmBehaviour.equals("1")) {
                        //Morning Coffee always
                        makeSecondBedroomCoffee = true;
                    } else if (alarmBehaviour.equals("2")) {
                        //Morning Coffee never
                        makeSecondBedroomCoffee = false;
                    }

                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }
            }

        } catch (Exception ignored) {

        }
        return alarmDisplay;
    }

    private static String dynamicCar() {
        //Users Set temp they want room to stay at
        String fileName = "ConfigFiles\\carConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                //GARAGE - ON
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");

                    switch (values[3]) {
                        case "1":
                            String carMode = "Auto Start";
                            if (travelTo.equals("GARAGE") && !carRunning) {
                                carDisplay = ("Car Status: " + carMode + ", Turning Engine ON once in Car...");
                                carRunning = true;
                            }

                            if (!travelTo.equals("GARAGE") && carRunning) {
                                carDisplay = "Car Status: Returned, Engine OFF...";
                                carRunning = false;
                            } else if (!travelTo.equals("GARAGE")) {
                                carRunning = false;
                            }
                            break;
                        case "2":
                            carMode = "Economy Start";
                            if (travelTo.equals("GARAGE") && !carRunning) {
                                carDisplay = ("Car Status: " + carMode + ", Turning Engine ON once in Car...");
                            }

                            if (!travelTo.equals("GARAGE") && carRunning) {
                                carDisplay = "Car Status: Returned, Engine OFF...";
                                carRunning = false;
                            } else if (!travelTo.equals("GARAGE")) {
                                carRunning = false;
                            }
                            break;
                        case "3":
                            carMode = "Manual Start";
                            if (travelTo.equals("GARAGE") && !carRunning) {
                                carDisplay = ("Car Status: " + carMode + ", Turning Engine ON once in Car...");
                            }

                            if (!travelTo.equals("GARAGE") && carRunning) {
                                carDisplay = "Car Status: Returned, Engine OFF...";
                                carRunning = false;
                            } else if (!travelTo.equals("GARAGE")) {
                                carRunning = false;
                            }
                            break;
                    }

                    //GARAGE - OFF
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                    //Re-format user inputs to act as a refresher
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return carDisplay;
    }

    private static String dynamicCoffeeMachine() {
        //Users Set temp they want room to stay at
        String fileName = "ConfigFiles\\coffeeMachineConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays  status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                String coffeeBehaviour;
                //KITCHEN - ON
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");

                    if (makeMainBedroomCoffee && makeSecondBedroomCoffee && !alarmCoffee) {
                        coffeeDisplay = "Morning Coffee Boiling!";
                        alarmCoffee = true;
                    } else if (makeMainBedroomCoffee && !alarmCoffee) {
                        coffeeDisplay = "Morning Coffee Boiling!";
                        alarmCoffee = true;
                    } else if (makeSecondBedroomCoffee && !alarmCoffee) {
                        coffeeDisplay = "Morning Coffee Boiling!";
                        alarmCoffee = true;
                    } else if (time.getHour() == 4 && alarmCoffee) {
                        alarmCoffee = false;
                    }
                    coffeeBehaviour = values[3];

                    if (coffeeBehaviour.equals("1") && !alarmCoffee) {
                        //Coffee Addiction
                        if (time.getHour() < 7 && !behaviour1) {
                            behaviour1 = true;
                            coffeeDisplay = "Morning Coffee Boiling!";
                        } else if (time.getHour() == 4 && behaviour1) {
                            behaviour1 = false;
                        }
                    } else if (coffeeBehaviour.equals("2")) {
                        //All day Coffee
                        if (time.getHour() < 7 && !behaviour2) {
                            coffeeDisplay = "All Day Coffee Boiling!";
                            behaviour2 = true;
                        } else if (time.getHour() < 12 && !behaviour2) {
                            coffeeDisplay = "All Day Coffee Boiling!";
                            behaviour2 = true;
                        } else if (fullClock < 16.30 && !behaviour2) {
                            coffeeDisplay = "All Day Coffee Boiling!";
                            behaviour2 = true;
                        } else if (time.getHour() == 4 && behaviour2) {
                            behaviour2 = false;
                        }
                    } else if (coffeeBehaviour.equals("3")) {
                        //Fresh Blend
                        if (time.getHour() < 7 && time.getHour() > 9 && travelTo.equals("KITCHEN") && !behaviour3) {
                            coffeeDisplay = "Fresh Blend, Morning Coffee Boiling!";
                            behaviour3 = true;
                        } else if (time.getHour() < 12 && time.getHour() > 14 && travelTo.equals("KITCHEN") && !behaviour3) {
                            coffeeDisplay = "Fresh Blend, Lunch Coffee Boiling!";
                            behaviour3 = true;
                        } else if (fullClock < 16.30 && time.getHour() > 18 && travelTo.equals("KITCHEN") && !behaviour3) {
                            coffeeDisplay = "Fresh Blend, Afternoon Coffee Boiling!";
                            behaviour3 = true;
                        } else if (time.getHour() == 4 && behaviour3) {
                            behaviour3 = false;
                        }
                    }

                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return coffeeDisplay;
    }

    private static String dynamicKettle() {
        //Users Set temp they want room to stay at
        String fileName = "ConfigFiles\\kettleConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays  status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                String kettleBehaviour;
                //KITCHEN - ON
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                    kettleBehaviour = values[3];

                    if (kettleBehaviour.equals("1") && travelTo.equals("KITCHEN") && !kettleBoiled) {
                        //Auto Boil - Turns on when person walks into kitchen
                        kettleDisplay = "Kettle has Started to Boil!";
                        kettleBoiled = true;
                    } else if (kettleBehaviour.equals("2") && travelTo.equals("KITCHEN") && !kettleBoiled) {
                        //Manual Boil - Randomly turns on when person in kitchen
                        Random rand = new Random();
                        //1 : 5 chance for weather to change every minute
                        int n = rand.nextInt(5) + 1;
                        kettleBoiled = true;
                        if (n == 1) {
                            kettleDisplay = "Kettle has Started to Boil!";
                        }
                    } else if (time.getHour() == 4 && kettleBoiled) {
                        kettleBoiled = false;
                    }

                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return  kettleDisplay;
    }

    private static String dynamicTv() {
        //Users Set temp they want room to stay at
        String fileName = "ConfigFiles\\tvConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                double tvOffTime;
                //LIVING ROOM - ON
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                    tvOffTime = Double.parseDouble(values[3]);

                    if (fullClock < 7.30 && travelTo.equals("LIVING ROOM") && !tvON) {
                        tvDisplay = "TV has Turned ON in LIVING ROOM!";
                        tvON = true;
                    } else if (tvOffTime < fullClock && travelTo.equals("LIVING ROOM") && tvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        tvON = false;
                    } else if (!travelTo.equals("LIVING ROOM") && tvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        tvON = false;
                    }

                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }

                //MAIN BEDROOM - ON
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                    tvOffTime = Double.parseDouble(values[3]);

                    if (fullClock < 7.30 && travelTo.equals("LIVING ROOM") && !tvON) {
                        tvDisplay = "TV has Turned ON in LIVING ROOM!";
                        tvON = true;
                    } else if (tvOffTime < fullClock && travelTo.equals("LIVING ROOM") && tvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        tvON = false;
                    } else if (!travelTo.equals("LIVING ROOM") && tvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        tvON = false;
                    }

                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return tvDisplay;
    }

    private static String dynamicOven() {
        //Users Set temp they want room to stay at
        String fileName = "ConfigFiles\\ovenConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                //KITCHEN - ON
                double morningAlarm;
                double lunchAlarm;
                double dinnerAlarm;
                if (values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                    morningAlarm = Double.parseDouble(values[3]);
                    morningChoice = Integer.parseInt(values[4]); // 1, 2, 3.

                    if (morningChoice == 1) {
                        morningMode = "Pancakes";
                    } else if (morningChoice == 2) {
                        morningMode = "Toast";
                    } else if (morningChoice == 3) {
                        morningMode = "Eggs and Bacon";
                    }

                    if (morningAlarm < fullClock && !morningBoolean) {
                        ovenDisplay = ("The Oven has Turned ON Your " + morningMode + " are/is Cooking!");
                        morningBoolean = true;
                        morningTotal = morningAlarm + 0.06;
                    }

                    if (morningTotal > fullClock && morningBoolean) {
                        ovenDisplay = ("The Oven has Turned OFF Your " + morningMode + " are/is Ready!");
                    }

                    lunchAlarm = Double.parseDouble(values[5]);
                    lunchChoice = Integer.parseInt(values[6]); // 1, 2, 3.

                    if (lunchChoice == 1) {
                        lunchMode = "Muffins";
                    } else if (lunchChoice == 2) {
                        lunchMode = "Toasted Sandwich";
                    } else if (lunchChoice == 3) {
                        lunchMode = "Chicken and Rice Salad";
                    }

                    if (lunchAlarm < fullClock && !lunchBoolean) {
                        ovenDisplay = ("The Oven has Turned ON Your " + lunchMode + " are/is Cooking!");
                        lunchBoolean = true;
                        lunchTotal = lunchAlarm + 0.12;
                    }

                    if (lunchTotal > fullClock && lunchBoolean) {
                        ovenDisplay = ("The Oven has Turned OFF Your " + lunchMode + " are/is Ready!");
                    }

                    dinnerAlarm = Double.parseDouble(values[7]);
                    dinnerChoice = Integer.parseInt(values[8]); // 1, 2, 3.

                    if (dinnerChoice == 1) {
                        dinnerMode = "Roast Pork & Veggies";
                    } else if (dinnerChoice == 2) {
                        dinnerMode = "Lasagna";
                    } else if (dinnerChoice == 3) {
                        dinnerMode = "Smoked Mackerel";
                    }


                    if (dinnerAlarm < fullClock && !dinnerBoolean) {
                        ovenDisplay = ("The Oven has Turned ON Your " + dinnerMode + " are/is Cooking!");
                        dinnerBoolean = true;
                        dinnerTotal = dinnerAlarm + 0.06;
                    }

                    if (dinnerTotal > fullClock && dinnerBoolean) {
                        ovenDisplay = ("The Oven has Turned OFF Your " + dinnerMode + " are/is Ready!");
                    }


                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    //Re-format user inputs to act as a refresher
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return ovenDisplay;
    }

    public static String[] getDisplayLine5() {
        return displayLine5;
    }

    public static void setDisplayLine5(String[] displayLine5) {
        Simulator.displayLine5 = displayLine5;
    }

    public static String[] getDisplayLine4() {
        return displayLine4;
    }

    public static void setDisplayLine4(String[] displayLine4) {
        Simulator.displayLine4 = displayLine4;
    }

    public static String[] getDisplayLine3() {
        return displayLine3;
    }

    public static void setDisplayLine3(String[] displayLine3) {
        Simulator.displayLine3 = displayLine3;
    }

    public static String[] getDisplayLine2() {
        return displayLine2;
    }

    public static void setDisplayLine2(String[] displayLine2) {
        Simulator.displayLine2 = displayLine2;
    }

    public static String[] getDisplayLine1() {
        return displayLine1;
    }

    public static void setDisplayLine1(String[] displayLine1) {
        Simulator.displayLine1 = displayLine1;
    }

    public static double getLivingRTemp() {
        return livingRTemp;
    }

    public static void setLivingRTemp(double livingRTemp) {
        Simulator.livingRTemp = livingRTemp;
    }

    public static double getMainRTemp() {
        return mainRTemp;
    }

    public static void setMainRTemp(double mainRTemp) {
        Simulator.mainRTemp = mainRTemp;
    }

    public static double getSecondRTemp() {
        return secondRTemp;
    }

    public static void setSecondRTemp(double secondRTemp) {
        Simulator.secondRTemp = secondRTemp;
    }

    public static double getKitchenTemp() {
        return kitchenTemp;
    }

    public static void setKitchenTemp(double kitchenTemp) {
        Simulator.kitchenTemp = kitchenTemp;
    }

    public static double getGarageTemp() {
        return garageTemp;
    }

    public static void setGarageTemp(double garageTemp) {
        Simulator.garageTemp = garageTemp;
    }

    public static double getGardenTemp() {
        return gardenTemp;
    }

    public static void setGardenTemp(double gardenTemp) {
        Simulator.gardenTemp = gardenTemp;
    }

    public static int getMorningChoice() {
        return morningChoice;
    }

    public static void setMorningChoice(int morningChoice) {
        Simulator.morningChoice = morningChoice;
    }

    public static int getLunchChoice() {
        return lunchChoice;
    }

    public static void setLunchChoice(int lunchChoice) {
        Simulator.lunchChoice = lunchChoice;
    }

    public static int getDinnerChoice() {
        return dinnerChoice;
    }

    public static void setDinnerChoice(int dinnerChoice) {
        Simulator.dinnerChoice = dinnerChoice;
    }

    public static String getMorningMode() {
        return morningMode;
    }

    public static void setMorningMode(String morningMode) {
        Simulator.morningMode = morningMode;
    }

    public static String getLunchMode() {
        return lunchMode;
    }

    public static void setLunchMode(String lunchMode) {
        Simulator.lunchMode = lunchMode;
    }

    public static String getDinnerMode() {
        return dinnerMode;
    }

    public static void setDinnerMode(String dinnerMode) {
        Simulator.dinnerMode = dinnerMode;
    }

}
