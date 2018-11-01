import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;
import java.math.BigDecimal;


class Simulator extends JFrame {
    private static final LocalTime SIM_START_TIME = LocalTime.parse("05:00");
    public static LocalTime time = SIM_START_TIME;
    private static final LocalTime ALARM_TIME = LocalTime.parse("00:00");
    public static LocalTime alarm = ALARM_TIME;
    private static final LocalTime ALARM_SOUND = LocalTime.parse("00:00");
    public static LocalTime alarmSound = ALARM_SOUND;
    public static String travelToDisplay;
    static double inDoorTempSetter;
    public static double temperature, tempChange, inDoorTemp, lightOn, lightOn2, sunLight, sunLightValue, sunLightChange, livingRTemp;
    public static double mainRTemp, morningTotal, lunchTotal, dinnerTotal;
    public static double secondRTemp, kitchenTemp, garageTemp;
    public static double lightEnergyUsed, acEnergyUsed, mainRoomAcEnergy, mainRoomLightEnergy, livingRoomLightEnergy, livingRoomAcEnergy, secondRoomLightEnergy, kitchenLightEnergy, garageLightEnergy, gardenLightEnergy, mainBedroomTotalEnergy, secondBedroomTotalEnergy, livingRoomTotalEnergy, kitchenTotalEnergy, garageTotalEnergy, gardenTotalEnergy;
    static double gardenTemp;
    public static String data, morningMode, lunchMode, dinnerMode, ovenDisplay, tvDisplay, coffeeDisplay, kettleDisplay, carDisplay, alarmDisplay, sprinklerDisplay, garageDoorDisplay, acDisplay, lightDisplay, fanDisplay;
    public static boolean mainRoomTvON, livingRoomTvON, kettleBoiled, behaviour1, behaviour2, behaviour3, mainRoomAC, livingRoomAc, carRunning, morningBoolean, lunchBoolean, dinnerBoolean, makeMainBedroomCoffee, makeSecondBedroomCoffee, alarmCoffee;
    public static boolean secondRoomCeilingFan, mainRoomCeilingFan, livingRoomCeilingFan, livingRoomLights, mainRoomLights, kitchenLights, secondRoomLights, garageLights, gardenLights, gardenSprinkler, mainBedroomAlarmSound, secondBedroomAlarmSound;
    private static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5;
    public static int ceilingFanSpeed, x, garageDoorCloseSequence = 0;
    private static int morningChoice, lunchChoice, dinnerChoice;
    public static double sprinklerWaterUsage, sprinklerEnergyUsage, waterUsage, totalWater, powerUsage, powerUsageCost, fanSpeedEnergy, livingRoomFanEnergy, mainRoomFanEnergy, secondRoomFanEnergy, gardenSprinklerEnergy, ovenEnergy, morningOvenEnergy, lunchOvenEnergy, dinnerOvenEnergy, totalOvenEnergy, dinnerOnFor, morningOnFor, lunchOnFor, tvEnergyFromSize, tvLivingRoomEnergyFromSize;
    public static double alarmTotal, timeDouble, alarmClockTotal, livingRoomTvOEnergy, mainRoomTvEnergy, kettleEnergyUsed, kettleEnergy, coffeeMachineEnergy, coffeeMachineEnergyUsage, mainRoomAlarmEnergy, secondRoomAlarmEnergy, alarmClockEnergyUsage, alarmHourSensor, alarmMinuteSensor;
    public static int lightsInRoom, sprinklerPressure, alarmHour, alarmMinute;
    static String travelTo = "";
    static GUI gui;

    public static void main() {
        gui = new GUI();
        gui.setVisible(true);
    }

    static void runSimulator() {
        do {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Adds 1 integer every loop
                    time = time.plusMinutes(1);

                    //Gets the initial temperature value
                    temperature = Weather.getTemperature();

                    //Gets the initial light value
                    sunLight = Sun.getSunLight();

                    //Gets temperature change per hour
                    tempChange += Weather.temperatureAdjust();

                    //Gets light change per hour
                    sunLightChange += Sun.sunLightAdjust();

                    //Reformat every hour to display correctly
                    fixTempChange();
                    fixSunChange();

                    //Formats doubles correctly for temp and light
                    BigDecimal.valueOf(temperature += tempChange);
                    BigDecimal.valueOf(sunLight += sunLightChange);

                    //Gets the water usage from devices set up only
                    waterUsage = getWaterUsage();
                    //Gets the power usage from each room and its devices
                    powerUsage = getPowerUsage();

                    //Sets temperature for each room
                    Devices.livingRoomTemp();
                    Devices.roomTemp();
                    Devices.garageTemp();
                    Devices.gardenTemps();

                    livingRTemp = Devices.tempLivingRoom;
                    mainRTemp = Devices.tempMainRoom;
                    secondRTemp = Devices.tempMainRoom;
                    kitchenTemp = Devices.tempLivingRoom;
                    garageTemp = Devices.tempGarage;
                    gardenTemp = Devices.tempGarden;

                    //Fixtures
                    //Gets the Weather for sim
                    Menu.weatherType = dynamicWeather();
                    //Finds where the Person is for sim
                    travelTo = dynamicMotionSensors();
                    //Turns on lights for user inputs/sensors
                    lightDisplay = dynamicLights();
                    //Turns on AC for user inputs/sensors
                    acDisplay = dynamicAC(); //Powered by - AC
                    //Turns on Ceiling Fan for user inputs/sensors
                    fanDisplay = dynamicCeilingFan(); //Powered by - AC
                    //Turns on Garage for user inputs/sensors
                    garageDoorDisplay = dynamicGarageDoor(); //Powered by - Batteries
                    //Turns on Sprinklers for user inputs/sensors
                    sprinklerDisplay = dynamicSprinkler(); //Powered by - AC

                    //Appliances
                    //Behaviour change for Alarm Clock
                    alarmDisplay = dynamicAlarm(); //Powered by - AC

                    if (alarmHour < 9 && alarmMinute > 10) {
                        alarm = LocalTime.parse("0" + (String.valueOf(alarmHour) + ":" + (String.valueOf(alarmMinute))));
                    } else if (alarmHour < 9 && alarmMinute < 10) {
                        alarm = LocalTime.parse("0" + (String.valueOf(alarmHour) + ":" + "0" + (String.valueOf(alarmMinute))));
                    } else if (alarmHour > 9 && alarmMinute > 10) {
                        alarm = LocalTime.parse((String.valueOf(alarmHour) + ":" + (String.valueOf(alarmMinute))));
                    } else if (alarmHour > 9 && alarmMinute < 10) {
                        alarm = LocalTime.parse((String.valueOf(alarmHour) + ":"  + "0" + (String.valueOf(alarmMinute))));
                    }

                    if (alarmHour < 9) {
                        alarmSound = LocalTime.parse("0" + (String.valueOf(alarmHour) + ":" +(String.valueOf(alarmMinute + 10))));
                    } else if (alarmHour > 9) {
                        alarmSound = LocalTime.parse((String.valueOf(alarmHour) + ":" + (String.valueOf(alarmMinute + 10))));
                    }

                    System.out.println(mainBedroomAlarmSound);
                    System.out.println(alarm);
                    System.out.println(alarmSound);

                    //Behaviour change for Car
                    carDisplay = dynamicCar(); //Powered by - Batteries
                    //Behaviour change for Oven
                    ovenDisplay = dynamicOven(); //Powered by - AC
                    //Behaviour change for Tv
                    tvDisplay = dynamicTv(); //Powered by - AC
                    //Behaviour change for Kettle
                    kettleDisplay = dynamicKettle(); //Powered by - AC
                    //Behaviour change for Coffee Machine
                    coffeeDisplay = dynamicCoffeeMachine(); //Powered by - AC

                    //Update
                    //Updates string to say what room person is in and change location
                    travelTo = dynamicTravel();
                    //Updates GUI
                    gui.updateDisplay();
                    //Updates where the person is in the GUI
                    gui.updateRoomLocation();
                    //Updates Room temperatures
                    gui.updateRoomTemp();
                    //Updates to show active devices in room by color
                    gui.updateRoomDeviceStickers();
                    //Updates room devices behaviour status changes
                    gui.updateRoomStatus();
                    //Display for System.out
                    halfHourlyDisplay();
                }
            });
            //Start timer
            timer.start();
            //Loop finish once 24 Hours has passed.
        } while (!(time == SIM_START_TIME));
    }

    private static double getPowerUsage() {
        //MAIN BEDROOM
        mainBedroomTotalEnergy = mainRoomLightEnergy + mainRoomAcEnergy + mainRoomFanEnergy + mainRoomTvEnergy + mainRoomAlarmEnergy;
        //SECOND BEDROOM
        secondBedroomTotalEnergy = secondRoomLightEnergy + secondRoomFanEnergy;
        //LIVING ROOM
        livingRoomTotalEnergy = livingRoomLightEnergy + livingRoomAcEnergy + livingRoomFanEnergy + livingRoomTvOEnergy;
        //KITCHEN
        kitchenTotalEnergy = kitchenLightEnergy + totalOvenEnergy + kettleEnergy + coffeeMachineEnergy;
        //GARAGE
        garageTotalEnergy = garageLightEnergy;
        //GARDEN
        gardenTotalEnergy = gardenLightEnergy + gardenSprinklerEnergy;

        powerUsage = mainBedroomTotalEnergy + secondBedroomTotalEnergy + livingRoomTotalEnergy + kitchenTotalEnergy + garageTotalEnergy + gardenTotalEnergy;
        powerUsageCost = powerUsage * 0.00048; //1Kw = $0.46
        return powerUsage;
    }

    private static double getWaterUsage() {
        double waterPerMinute;
        //Gets water usage per minute
        waterPerMinute = sprinklerWaterUsage / 60;

        if (waterPerMinute < 0) {
            waterUsage = totalWater + waterPerMinute;
        }

        return waterUsage;
    }

    private static void fixSunChange() {
        if (Simulator.time.getHour() == 6 && Simulator.time.getMinute() == 0) {
            //6:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 7 && Simulator.time.getMinute() == 0) {
            //7:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 8 && Simulator.time.getMinute() == 0) {
            //8:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 9 && Simulator.time.getMinute() == 0) {
            //9:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 10 && Simulator.time.getMinute() == 0) {
            //10:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 11 && Simulator.time.getMinute() == 0) {
            //11:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 12 && Simulator.time.getMinute() == 0) {
            //12:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 13 && Simulator.time.getMinute() == 0) {
            //1:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 14 && Simulator.time.getMinute() == 0) {
            //2:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 15 && Simulator.time.getMinute() == 0) {
            //3:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 16 && Simulator.time.getMinute() == 0) {
            //4:00m
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 17 && Simulator.time.getMinute() == 0) {
            //5:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 18 && Simulator.time.getMinute() == 0) {
            //6:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 19 && Simulator.time.getMinute() == 0) {
            //7:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 20 && Simulator.time.getMinute() == 0) {
            //8:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 21 && Simulator.time.getMinute() == 0) {
            //9:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 22 && Simulator.time.getMinute() == 0) {
            //10:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 23 && Simulator.time.getMinute() == 0) {
            //11:00pm
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 0 && Simulator.time.getMinute() == 0) {
            //12:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 1 && Simulator.time.getMinute() == 0) {
            //1:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 2 && Simulator.time.getMinute() == 0) {
            //2:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 3 && Simulator.time.getMinute() == 0) {
            //3:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 4 && Simulator.time.getMinute() == 0) {
            //4:00am
            sunLightChange = 0;
        } else if (Simulator.time.getHour() == 5 && Simulator.time.getMinute() == 0) {
            //5:00am
            sunLightChange = 0;
        }
    }

    private static void fixTempChange() {
        if (Simulator.time.getHour() == 6 && Simulator.time.getMinute() == 0) {
            //6:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 7 && Simulator.time.getMinute() == 0) {
            //7:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 8 && Simulator.time.getMinute() == 0) {
            //8:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 9 && Simulator.time.getMinute() == 0) {
            //9:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 10 && Simulator.time.getMinute() == 0) {
            //10:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 11 && Simulator.time.getMinute() == 0) {
            //11:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 12 && Simulator.time.getMinute() == 0) {
            //12:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 13 && Simulator.time.getMinute() == 0) {
            //1:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 14 && Simulator.time.getMinute() == 0) {
            //2:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 15 && Simulator.time.getMinute() == 0) {
            //3:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 16 && Simulator.time.getMinute() == 0) {
            //4:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 17 && Simulator.time.getMinute() == 0) {
            //5:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 18 && Simulator.time.getMinute() == 0) {
            //6:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 19 && Simulator.time.getMinute() == 0) {
            //7:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 20 && Simulator.time.getMinute() == 0) {
            //8:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 21 && Simulator.time.getMinute() == 0) {
            //9:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 22 && Simulator.time.getMinute() == 0) {
            //10:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 23 && Simulator.time.getMinute() == 0) {
            //11:00pm
            tempChange = 0;
        } else if (Simulator.time.getHour() == 0 && Simulator.time.getMinute() == 0) {
            //12:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 1 && Simulator.time.getMinute() == 0) {
            //1:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 2 && Simulator.time.getMinute() == 0) {
            //2:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 3 && Simulator.time.getMinute() == 0) {
            //3:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 4 && Simulator.time.getMinute() == 0) {
            //4:00am
            tempChange = 0;
        } else if (Simulator.time.getHour() == 5 && Simulator.time.getMinute() == 0) {
            //5:00am
            tempChange = 0;
        }
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
        } else if (time.getHour() == 12) {
            System.out.println(time + " pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLight);
            System.out.print("%\n");
        }
    }

    private static String dynamicAC() {
        inDoorTempSetter = temperature;
        acDisplay = "EMPTY";
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
                    acEnergyUsed = 3000; // Energy used per hour (watts)
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
                    acEnergyUsed = 0; // Energy used per hour (watts)
                    displayLine1 = data.split(", ");
                    acTemp = 0;
                    values[3] = String.valueOf(acTemp);
                    acDisplay = "EMPTY";
                }

                //LIVING ROOM - ON
                double acTemp2;
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    acEnergyUsed = 4000; // Energy used per hour (watts)
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
                    acEnergyUsed = 0; // Energy used per hour (watts)
                    displayLine2 = data.split(", ");
                    acTemp2 = 0;
                    values[3] = String.valueOf(acTemp2);
                    acDisplay = "EMPTY";
                }
            }

            if (mainRoomAC) {
                mainRoomAcEnergy = acEnergyUsed / 60;
                mainRoomAcEnergy++;
            }

            if (livingRoomAc) {
                livingRoomAcEnergy = acEnergyUsed / 60;
                livingRoomAcEnergy++;
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
        if (time.getHour() < 21) {
            travelTo = "MAIN BEDROOM";
        }

        String fileAlarmClock = "ConfigFiles/alarmClockConfig.txt";
        File file11 = new File(fileAlarmClock);
        try {
            Scanner inputStream = new Scanner(file11);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    alarmHourSensor = Double.parseDouble(values[3]);
                    alarmMinuteSensor = Double.parseDouble(values[4]);

                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    alarmClockTotal = 4.59;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (alarmHourSensor < time.getHour()) {
            if (alarmMinuteSensor < time.getMinute()) {
                //Person wakes up
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
                    travelToDisplay = ("Person Moved from: " + oldRoom + " to " + changeRoom);
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                } else {
                    travelToDisplay = "EMPTY";
                }
                break;
            case "LIVING ROOM":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    travelToDisplay = ("Person Moved from: " + oldRoom + " to " + changeRoom);
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                } else {
                    travelToDisplay = "EMPTY";
                }
                break;
            case "SECOND BEDROOM":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    travelToDisplay = ("Person Moved from: " + oldRoom + " to " + changeRoom);
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                } else {
                    travelToDisplay = "EMPTY";
                }
                break;
            case "KITCHEN":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    travelToDisplay = ("Person Moved from: " + oldRoom + " to " + changeRoom);
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                } else {
                    travelToDisplay = "EMPTY";
                }
                break;
            case "GARAGE":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    travelToDisplay = ("Person Moved from: " + oldRoom + " to " + changeRoom);
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                } else {
                    travelToDisplay = "EMPTY";
                }
                break;
            case "GARDEN":
                oldRoom = travelTo;
                changeRoom = dynamicMotionSensors();
                if (!changeRoom.equals(oldRoom)) {
                    travelTo = changeRoom;
                    travelToDisplay = ("Person Moved from: " + oldRoom + " to " + changeRoom);
                    System.out.println("\nPerson Moved from: " + oldRoom + " to " + changeRoom);
                } else {
                    travelToDisplay = "EMPTY";
                }
                break;
        }
        return travelTo;
    }

    private static String dynamicLights() {
        lightEnergyUsed = 40.00; //Energy used per hour (watts) per light bulb
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
                    lightsInRoom = 2;

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
                    if (lightOn > sunLightValue && !mainRoomLights && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Main Room Lights have switched OFF!";
                            mainRoomLights = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomLights) {
                        lightDisplay = "Main Room Lights have switched OFF!";
                        mainRoomLights = true;
                    }

                    if (lightOn < sunLightValue && mainRoomLights && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Main Room Lights have switched OFF!";
                            mainRoomLights = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomLights) {
                        lightDisplay = "Main Room Lights have switched OFF!";
                        mainRoomLights = false;
                    }

                    if (mainRoomLights) {
                        mainRoomLightEnergy += (lightEnergyUsed * lightsInRoom) / 60;
                    }


                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    lightEnergyUsed = 0.00; //Energy off
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
                    lightsInRoom = 2;

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
                    if (lightOn > sunLightValue && !livingRoomLights && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Living Room Lights have switched ON!";
                            livingRoomLights = true;
                        }
                    } else if (lightOn > sunLightValue && !livingRoomLights) {
                        lightDisplay = "Living Room Lights have switched ON!";
                        livingRoomLights = true;
                    }

                    if (lightOn < sunLightValue && livingRoomLights && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Living Room Lights have switched OFF!";
                            livingRoomLights = false;
                        }
                    } else if (lightOn < sunLightValue && livingRoomLights) {
                        lightDisplay = "Living Room Lights have switched OFF!";
                        livingRoomLights = false;
                    }

                    if (livingRoomLights) {
                        livingRoomLightEnergy += (lightEnergyUsed * lightsInRoom) / 60;
                    }

                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    lightEnergyUsed = 0.00; //Energy off
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
                    lightsInRoom = 2;

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
                    if (lightOn > sunLightValue && !secondRoomLights && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Second Bedroom Lights have switched ON!";
                            secondRoomLights = true;
                        }
                    } else if (lightOn > sunLightValue && !secondRoomLights) {
                        lightDisplay = "Second Bedroom Lights have switched ON!";
                        secondRoomLights = true;
                    }

                    if (lightOn < sunLightValue && secondRoomLights && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Second Bedroom Lights have switched OFF!";
                            secondRoomLights = false;
                        }
                    } else if (lightOn < sunLightValue && secondRoomLights) {
                        lightDisplay = "Second Bedroom Lights have switched OFF!";
                        secondRoomLights = false;
                    }

                    if (secondRoomLights) {
                        secondRoomLightEnergy += (lightEnergyUsed * lightsInRoom) / 60;
                    }

                    //SECOND BEDROOM - OFF
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    lightEnergyUsed = 0.00; //Energy off
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
                    lightsInRoom = 4;

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
                    if (lightOn > sunLightValue && !kitchenLights && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Kitchen Lights have switched ON!";
                            kitchenLights = true;
                        }
                    } else if (lightOn > sunLightValue && !kitchenLights) {
                        lightDisplay = "Kitchen Lights have switched ON!";
                        kitchenLights = true;
                    }

                    if (lightOn < sunLightValue && kitchenLights && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Kitchen Lights have switched OFF!";
                            kitchenLights = false;
                        }
                    } else if (lightOn < sunLightValue && kitchenLights) {
                        lightDisplay = "Kitchen Lights have switched OFF!";
                        kitchenLights = false;
                    }

                    if (kitchenLights) {
                        kitchenLightEnergy += (lightEnergyUsed * lightsInRoom) / 60;
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
                    lightsInRoom = 2;

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
                    if (lightOn > sunLightValue && !garageLights && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Garage Lights have switched ON!";
                            garageLights = true;
                        }
                    } else if (lightOn > sunLightValue && !garageLights) {
                        lightDisplay = "Garage Lights have switched ON!";
                        garageLights = true;
                    }

                    if (lightOn < sunLightValue && garageLights && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Garage Lights have switched OFF!";
                            garageLights = false;
                        }
                    } else if (lightOn < sunLightValue && garageLights) {
                        lightDisplay = "Garage Lights have switched OFF!";
                        garageLights = false;
                    }

                    if (garageLights) {
                        garageLightEnergy += (lightEnergyUsed * lightsInRoom) / 60;
                    }

                    //GARAGE - OFF
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    lightEnergyUsed = 0.00; //Energy off
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
                    lightsInRoom = 8;

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
                    if (lightOn > sunLightValue && !gardenLights && values[3].equals("1")) {
                        if (lightOn > sunLightValue && lightOn2 < time.getHour()) {
                            lightDisplay = "Garden Lights have switched ON!";
                            gardenLights = true;
                        }
                    } else if (lightOn > sunLightValue && !gardenLights) {
                        lightDisplay = "Garden Lights have switched ON!";
                        gardenLights = true;
                    }

                    if (lightOn < sunLightValue && gardenLights && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time.getHour()) {
                            lightDisplay = "Garden Lights have switched OFF!";
                            gardenLights = false;
                        }
                    } else if (lightOn < sunLightValue && gardenLights) {
                        lightDisplay = "Garden Lights have switched OFF!";
                        gardenLights = false;
                    }

                    //GARDEN - OFF
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    lightEnergyUsed = 0.00; //Energy off
                    displayLine1 = data.split(", ");
                    lightTemp = 0;
                    values[3] = String.valueOf(lightTemp);
                    lightDisplay = "EMPTY";
                }
                if (garageLights) {
                    gardenLightEnergy += (lightEnergyUsed * lightsInRoom) / 60;
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
                                fanSpeedEnergy = 50; //watts per hour
                            } else if (ceilingFanTemp < 26 && ceilingFanTemp > 24) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if (ceilingFanTemp < 24 && ceilingFanTemp > 22) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 29 && inDoorTemp >= 29) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                        // 28 - 1
                        case "CLOUDY":
                            if ((ceilingFanTemp < 26 && ceilingFanTemp > 24) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                                fanSpeedEnergy = 50;
                            } else if ((ceilingFanTemp < 24 && ceilingFanTemp > 22) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 0;
                            } else if ((ceilingFanTemp < 22 && ceilingFanTemp > 20) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 60;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 27 && inDoorTemp >= 27) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                        // 26
                        case "RAINY":
                            if ((ceilingFanTemp < 25 && ceilingFanTemp > 23) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                                fanSpeedEnergy = 55;
                            } else if ((ceilingFanTemp < 23 && ceilingFanTemp > 21) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 65;
                            } else if ((ceilingFanTemp < 21 && ceilingFanTemp > 19) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 80;
                            } else if (ceilingFanTemp >= 26 && inDoorTemp >= 26) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
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
                    fanDisplay = "EMPTY";
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
                                fanSpeedEnergy = 50;
                            } else if (ceilingFanTemp < 26 && ceilingFanTemp > 24) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if (ceilingFanTemp < 24 && ceilingFanTemp > 22) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 29 && inDoorTemp >= 29) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                        // 28 - 1
                        case "CLOUDY":
                            if ((ceilingFanTemp < 26 && ceilingFanTemp > 24) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                                fanSpeedEnergy = 50;
                            } else if ((ceilingFanTemp < 24 && ceilingFanTemp > 22) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if ((ceilingFanTemp < 22 && ceilingFanTemp > 20) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 27 && inDoorTemp >= 27) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                        // 26
                        case "RAINY":
                            if ((ceilingFanTemp < 25 && ceilingFanTemp > 23) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                                fanSpeedEnergy = 50;
                            } else if ((ceilingFanTemp < 23 && ceilingFanTemp > 21) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if ((ceilingFanTemp < 21 && ceilingFanTemp > 19) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 26 && inDoorTemp >= 26) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                    }

                    //Display when device switches on and off
                    if (ceilingFanListTemp < inDoorTemp && !mainRoomCeilingFan) {
                        fanDisplay = ("Main Bedroom Ceiling Fan has switched ON! Fan Speed: " + ceilingFanSpeed);
                        mainRoomCeilingFan = true;
                    }

                    if (ceilingFanListTemp > inDoorTemp && mainRoomCeilingFan) {
                        fanDisplay = ("Main Bedroom Ceiling Fan has switched OFF! ");
                        mainRoomCeilingFan = false;
                    }
                    //LIVING ROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    fanDisplay = "EMPTY";
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
                                fanSpeedEnergy = 50;
                            } else if (ceilingFanTemp < 26 && ceilingFanTemp > 24) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if (ceilingFanTemp < 24 && ceilingFanTemp > 22) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 29 && inDoorTemp >= 29) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                        // 28 - 1
                        case "CLOUDY":
                            if ((ceilingFanTemp < 26 && ceilingFanTemp > 24) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                                fanSpeedEnergy = 50;
                            } else if ((ceilingFanTemp < 24 && ceilingFanTemp > 22) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if ((ceilingFanTemp < 22 && ceilingFanTemp > 20) && (inDoorTemp < 27 && inDoorTemp > 22)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 27 && inDoorTemp >= 27) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                        // 26
                        case "RAINY":
                            if ((ceilingFanTemp < 25 && ceilingFanTemp > 23) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 2 degrees
                                ceilingFanSpeed = 1;
                                fanSpeedEnergy = 50;
                            } else if ((ceilingFanTemp < 23 && ceilingFanTemp > 21) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 4 degrees
                                ceilingFanSpeed = 2;
                                fanSpeedEnergy = 60;
                            } else if ((ceilingFanTemp < 21 && ceilingFanTemp > 19) && (inDoorTemp < 26 && inDoorTemp > 21)) {
                                //Cool the room down by 6 degrees
                                ceilingFanSpeed = 3;
                                fanSpeedEnergy = 75;
                            } else if (ceilingFanTemp >= 26 && inDoorTemp >= 26) {
                                ceilingFanSpeed = 0;
                                fanSpeedEnergy = 0;
                            }
                            break;
                    }

                    //Display when device switches on and off
                    if (ceilingFanListTemp < inDoorTemp && !secondRoomCeilingFan) {
                        fanDisplay = ("Second Bedroom Ceiling Fan has switched ON! Fan Speed: " + ceilingFanSpeed);
                        secondRoomCeilingFan = true;
                    }

                    if (ceilingFanListTemp > inDoorTemp && secondRoomCeilingFan) {
                        fanDisplay = ("Second Bedroom Ceiling Fan has switched OFF! ");
                        secondRoomCeilingFan = false;
                    }
                    //LIVING ROOM - OFF
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    fanDisplay = "EMPTY";
                }

            }

            if (livingRoomCeilingFan) {
                livingRoomFanEnergy += fanSpeedEnergy / 60;
            }

            if (mainRoomCeilingFan) {
                mainRoomFanEnergy += fanSpeedEnergy / 60;
            }

            if (secondRoomCeilingFan) {
                secondRoomFanEnergy += fanSpeedEnergy / 60;
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
                    garageDoorDisplay = "EMPTY";
                }

            }

        } catch (Exception ignored) {

        }
        return garageDoorDisplay;
    }

    private static String dynamicSprinkler() {
        //Users Set temp they want room to stay at
        sprinklerEnergyUsage = 60; //watts used to power water pump per hour
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
                    gardenSprinkler = false;
                    double gardenTemp;
                    String sprinklerMode;
                    switch (Menu.weatherType) {
                        case "SUNNY":
                            if (sprinklerListTemp == 1) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 250;

                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 1;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 500;
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 27;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 2;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 2;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 1000;
                                //3 Water - 9:00am / 6:00pm / 2:00am
                                sprinklerMode = "Full Flow Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 27;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 3;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 3;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 2) {
                                    //2:00am
                                    gardenTemp = 17;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 3;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                        case "CLOUDY":
                            // NO FULL FLOW ON CLOUDY DAYS
                            if (sprinklerListTemp == 1) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 200;
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 1;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 400;
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 25;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 2;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 2;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 400;
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode (Cloudy - Forced)";
                                if (time.getHour() == 9) {
                                    //9:00am
                                    gardenTemp = 25;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 2;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                } else if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 1;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                        case "RAINY":
                            // NO FULL FLOW OR WATER SAVER ON RAINY DAYS
                            if (sprinklerListTemp == 1) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 100;
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 1;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 100;
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode (Rainy - Forced)";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 1;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //Liters used per Hour
                                sprinklerWaterUsage = 100;
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode (Rainy - Forced)";
                                if (time.getHour() == 18) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    gardenSprinkler = true;
                                    sprinklerPressure = 1;
                                    sprinklerDisplay = (sprinklerMode + " - Now Watering Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                    }

                    //GARDEN - OFF
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                    sprinklerListTemp = 0;
                    sprinklerWaterUsage = 0;
                    values[3] = String.valueOf(sprinklerListTemp);
                    //Re-format user inputs to act as a refresher
                    sprinklerDisplay = "EMPTY";
                }

            }

            if (gardenSprinkler) {
                gardenSprinklerEnergy += (sprinklerEnergyUsage * sprinklerPressure) / 60;
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {

        }
        return sprinklerDisplay;
    }

    private static String dynamicAlarm() {
        alarmClockEnergyUsage = 0.08333333; //5 watts per hour
        alarmDisplay = "EMPTY";
        String fileName = "ConfigFiles\\alarmClockConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");

                //MAIN BEDROOM - ON
                String alarmBehaviour;
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                    alarmHour = Integer.parseInt((values[3]));
                    alarmMinute = Integer.parseInt((values[4]));
                    alarmBehaviour = values[5];

                    if (ALARM_TIME.equals(time)) {
                        System.out.println("Alarm!");
                        alarmDisplay = "Alarm has Turned ON!";
                        mainBedroomAlarmSound = true;

                    } else if (ALARM_SOUND.equals(time)) {
                        mainBedroomAlarmSound = false;
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
                    alarmDisplay = "EMPTY";

                }
                mainRoomAlarmEnergy += alarmClockEnergyUsage / 60;
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
                    carDisplay = "EMPTY";
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return carDisplay;
    }

    private static String dynamicCoffeeMachine() {
        coffeeMachineEnergyUsage = 2400; //watts per hour
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
/*
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
*/
                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    coffeeDisplay = "EMPTY";
                }
            }

            if (behaviour1) {
                coffeeMachineEnergy += coffeeMachineEnergyUsage / 60;
            } else if (behaviour2) {
                coffeeMachineEnergy += coffeeMachineEnergyUsage / 60;
            } else if (behaviour3) {
                coffeeMachineEnergy += coffeeMachineEnergyUsage / 60;
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return coffeeDisplay;
    }

    private static String dynamicKettle() {
        kettleEnergyUsed = 40; //watts used per hour
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
                    kettleDisplay = "EMPTY";
                }
            }

            if (kettleBoiled) {
                kettleEnergy += kettleEnergyUsed / 60;
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return kettleDisplay;
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
                    tvLivingRoomEnergyFromSize = 400; //watts used per hour
                    displayLine5 = data.split(", ");
                    tvOffTime = Double.parseDouble(values[3]);

                    //TODO Fix fullClock instances
                    /*
                    if (fullClock < 7.30 && travelTo.equals("LIVING ROOM") && !livingRoomTvON) {
                        tvDisplay = "TV has Turned ON in LIVING ROOM!";
                        livingRoomTvON = true;
                    } else if (tvOffTime < fullClock && travelTo.equals("LIVING ROOM") && livingRoomTvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        livingRoomTvON = false;
                    } else if (!travelTo.equals("LIVING ROOM") && livingRoomTvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        livingRoomTvON = false;
                    }
                    */

                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    tvLivingRoomEnergyFromSize = 0;
                    displayLine5 = data.split(", ");

                    tvDisplay = "EMPTY";
                }

                //MAIN BEDROOM - ON
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    tvEnergyFromSize = 300;
                    displayLine5 = data.split(", ");
                    tvOffTime = Double.parseDouble(values[3]);
/*
                    if (fullClock < 7.30 && travelTo.equals("LIVING ROOM") && !mainRoomTvON) {
                        tvDisplay = "TV has Turned ON in LIVING ROOM!";
                        mainRoomTvON = true;
                    } else if (tvOffTime < fullClock && travelTo.equals("LIVING ROOM") && mainRoomTvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        mainRoomTvON = false;
                    } else if (!travelTo.equals("LIVING ROOM") && mainRoomTvON) {
                        tvDisplay = "TV has Turned OFF in LIVING ROOM!";
                        mainRoomTvON = false;
                    }
*/
                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    tvEnergyFromSize = 0;
                    displayLine5 = data.split(", ");

                    tvDisplay = "EMPTY";
                }
            }

            if (livingRoomTvON) {
                livingRoomTvOEnergy += tvLivingRoomEnergyFromSize / 60;
            }

            if (mainRoomTvON) {
                mainRoomTvEnergy += tvEnergyFromSize / 60;
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
        return tvDisplay;
    }

    private static String dynamicOven() {
        ovenEnergy = 2400; //watts used per hour
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
                        morningOnFor = 0.25;
                    } else if (morningChoice == 2) {
                        morningMode = "Toast";
                        morningOnFor = 0.05;
                    } else if (morningChoice == 3) {
                        morningMode = "Eggs and Bacon";
                        morningOnFor = 0.3;
                    }
/*
                    if (morningAlarm < fullClock && !morningBoolean) {
                        ovenDisplay = ("The Oven has Turned ON Your " + morningMode + " are/is Cooking!");
                        morningBoolean = true;
                        morningTotal = morningAlarm + 0.06;
                    }

                    if (morningTotal > fullClock && morningBoolean) {
                        morningBoolean = false;
                        ovenDisplay = ("The Oven has Turned OFF Your " + morningMode + " are/is Ready!");
                    }
*/
                    lunchAlarm = Double.parseDouble(values[5]);
                    lunchChoice = Integer.parseInt(values[6]); // 1, 2, 3.

                    if (lunchChoice == 1) {
                        lunchMode = "Muffins";
                        lunchOnFor = 1;
                    } else if (lunchChoice == 2) {
                        lunchMode = "Toasted Sandwich";
                        lunchOnFor = 0.2;
                    } else if (lunchChoice == 3) {
                        lunchMode = "Chicken and Rice Salad";
                        lunchOnFor = 1.2;
                    }
/*
                    if (lunchAlarm < fullClock && !lunchBoolean) {
                        ovenDisplay = ("The Oven has Turned ON Your " + lunchMode + " are/is Cooking!");
                        lunchBoolean = true;
                        lunchTotal = lunchAlarm + 0.12;
                    }

                    if (lunchTotal > fullClock && lunchBoolean) {
                        lunchBoolean = false;
                        ovenDisplay = ("The Oven has Turned OFF Your " + lunchMode + " are/is Ready!");
                    }
*/
                    dinnerAlarm = Double.parseDouble(values[7]);
                    dinnerChoice = Integer.parseInt(values[8]); // 1, 2, 3.

                    if (dinnerChoice == 1) {
                        dinnerMode = "Roast Pork & Veggies";
                        dinnerOnFor = 2; //whole numbers are hours spent cooking
                    } else if (dinnerChoice == 2) {
                        dinnerMode = "Lasagna";
                        dinnerOnFor = 1.5;
                    } else if (dinnerChoice == 3) {
                        dinnerMode = "Smoked Mackerel";
                        dinnerOnFor = 0.5;
                    }

/*
                    if (dinnerAlarm < fullClock && !dinnerBoolean) {
                        ovenDisplay = ("The Oven has Turned ON Your " + dinnerMode + " are/is Cooking!");
                        dinnerBoolean = true;
                        dinnerTotal = dinnerAlarm + 0.06;
                    }

                    if (dinnerTotal > fullClock && dinnerBoolean) {
                        dinnerBoolean = false;
                        ovenDisplay = ("The Oven has Turned OFF Your " + dinnerMode + " are/is Ready!");
                    }
*/

                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    ovenDisplay = "EMPTY";
                }
            }

            if (morningBoolean) { //Energy used when cooking in the morning
                morningOvenEnergy += (ovenEnergy * morningOnFor) / 60;
            }

            if (lunchBoolean) { //Energy used when cooking in the afternoon
                lunchOvenEnergy += (ovenEnergy * lunchOnFor) / 60;
            }

            if (dinnerBoolean) { //Energy used when cooking in the evening
                dinnerOvenEnergy += (ovenEnergy * dinnerOnFor) / 60;
            }

            totalOvenEnergy = morningOvenEnergy + lunchOvenEnergy + dinnerOvenEnergy;

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
