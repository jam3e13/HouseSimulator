import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

class Simulator {
    static double inDoorTempSetter, time = 5;
    private static double temperature, inDoorTemp, lightOn, lightOn2, sunLightValue, livingRTemp;
    private static double mainRTemp, morningTotal, lunchTotal, dinnerTotal;
    private static double secondRTemp;
    private static double kitchenTemp;
    private static double garageTemp;
    private static double gardenTemp;
    private static String data, morningMode, lunchMode, dinnerMode;
    private static boolean tvON, kettleBoiled, behaviour1, behaviour2, behaviour3, mainRoomAC, livingRoomAc, livingRoomCeilingFan, carRunning, morningBoolean, lunchBoolean, dinnerBoolean, alarmSound, makeMainBedroomCoffee, makeSecondBedroomCoffee, alarmCoffee;
    private static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5;
    private static int ceilingFanSpeed, x, garageDoorCloseSequence = 0;
    private static int morningChoice, lunchChoice, dinnerChoice;
    static String travelTo = "";

    static void runSimulator(String weatherType) throws InterruptedException {

        do {
            String simChoice = Menu.weatherType;
            time = Weather.timeCorrection();
            temperature = Weather.tempCorrection();
            sunLightValue = Sun.getSunLightChange();// change to solid light not increase

            //Sets temperature for each room
            livingRTemp = Devices.livingRoomTemp();
            mainRTemp = Devices.roomTemp();
            secondRTemp = Devices.roomTemp();
            kitchenTemp = Devices.livingRoomTemp();
            garageTemp = Devices.garageTemp();
            gardenTemp = Devices.gardenTemps();

            //Time before 12:00pm
            if (time >= 12) {
                temperature += Weather.dynamicIncrease();
                sunLightValue += Sun.sunLightIncrease();
                //Time after 12:00pm
            } else if (time < 12) {
                temperature += Weather.dynamicIncrease();
                sunLightValue += Sun.sunLightIncrease();
            } else {
                System.out.println("Temperature change - Failed...");
            }

            //Gets the Weather for sim
            dynamicWeather();
            //Finds where the Person is for sim
            dynamicMotionSensors();
            //Turns on lights for user inputs/sensors
            dynamicLights();
            //Turns on AC for user inputs/sensors
            dynamicAC();
            //Turns on Ceiling Fan for user inputs/sensors
            dynamicCeilingFan();
            //Turns on Garage for user inputs/sensors
            dynamicGarageDoor();
            //Turns on Sprinklers for user inputs/sensors
            dynamicSprinkler();

            //Behaviour change for Alarm Clock
            dynamicAlarm();
            //Behaviour change for Car
            dynamicCar();
            //Behaviour change for Oven
            dynamicOven();
            //Behaviour change for Tv
            dynamicTv();
            //Behaviour change for Kettle
            dynamicKettle();
            //Behaviour change for Coffee Machine
            dynamicCoffeeMachine();

            if (temperature > 28) {
                simChoice = "SUNNY";
            }

            switch (simChoice) {

                case "SUNNY":
                    halfHourlyDisplay();
                    Thread.sleep(Menu.x);
                    break;
                case "CLOUDY":
                    halfHourlyDisplay();
                    Thread.sleep(Menu.x);
                    break;
                case "RAINY":
                    halfHourlyDisplay();
                    Thread.sleep(Menu.x);
                    break;
            }
            time += 0.06;// 10 hits every 60 minutes, 1 hit equals 6 minutes.
        } while (time < 30);
    }

    private static void halfHourlyDisplay() {
        if (time == 5.00) {
            System.out.printf("%n" + "Time: 05:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 5.301 && time > 5.29) {
            System.out.printf("%n" + "Time: 05:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 6.00) {
            System.out.printf("%n" + "Time: 06:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 6.301 && time > 6.29) {
            System.out.printf("%n" + "Time: 06:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 7.00) {
            System.out.printf("%n" + "Time: 07:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 7.301 && time > 7.29) {
            System.out.printf("%n" + "Time: 07:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 8.00) {
            System.out.printf("%n" + "Time: 08:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 8.301 && time > 8.29) {
            System.out.printf("%n" + "Time: 08:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 9.00) {
            System.out.printf("%n" + "Time: 09:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 9.301 && time > 9.29) {
            System.out.printf("%n" + "Time: 09:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 10.00) {
            System.out.printf("%n" + "Time: 10:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 10.301 && time > 10.29) {
            System.out.printf("%n" + "Time: 10:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 11.00) {
            System.out.printf("%n" + "Time: 11:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 11.301 && time > 11.29) {
            System.out.printf("%n" + "Time: 11:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 12.00) {
            System.out.printf("%n" + "Time: 12:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 12.301 && time > 12.29) {
            System.out.printf("%n" + "Time: 12:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 13.00) {
            System.out.printf("%n" + "Time: 01:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 13.301 && time > 13.29) {
            System.out.printf("%n" + "Time: 01:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 14.00) {
            System.out.printf("%n" + "Time: 02:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 14.301 && time > 14.29) {
            System.out.printf("%n" + "Time: 02:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 15.00) {
            System.out.printf("%n" + "Time: 03:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 15.301 && time > 15.29) {
            System.out.printf("%n" + "Time: 03:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 16.00) {
            System.out.printf("%n" + "Time: 04:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 16.301 && time > 16.29) {
            System.out.printf("%n" + "Time: 04:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 17.00) {
            System.out.printf("%n" + "Time: 05:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 17.301 && time > 17.29) {
            System.out.printf("%n" + "Time: 05:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 18.00) {
            System.out.printf("%n" + "Time: 06:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 18.301 && time > 18.29) {
            System.out.printf("%n" + "Time: 06:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 19.00) {
            System.out.printf("%n" + "Time: 07:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 19.301 && time > 19.29) {
            System.out.printf("%n" + "Time: 07:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 20.00) {
            System.out.printf("%n" + "Time: 08:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 20.301 && time > 20.29) {
            System.out.printf("%n" + "Time: 08:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 21.00) {
            System.out.printf("%n" + "Time: 09:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 21.301 && time > 21.29) {
            System.out.printf("%n" + "Time: 09:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 22.00) {
            System.out.printf("%n" + "Time: 10:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 22.301 && time > 22.29) {
            System.out.printf("%n" + "Time: 10:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 23.00) {
            System.out.printf("%n" + "Time: 11:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 23.301 && time > 23.29) {
            System.out.printf("%n" + "Time: 11:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 24.00) {
            System.out.printf("%n" + "Time: 00:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 24.301 && time > 24.29) {
            System.out.printf("%n" + "Time: 00:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 25.00) {
            System.out.printf("%n" + "Time: 01:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 25.301 && time > 25.29) {
            System.out.printf("%n" + "Time: 01:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 26.00) {
            System.out.printf("%n" + "Time: 02:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 26.301 && time > 26.29) {
            System.out.printf("%n" + "Time: 02:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 27.00) {
            System.out.printf("%n" + "Time: 03:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 27.301 && time > 27.29) {
            System.out.printf("%n" + "Time: 03:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time == 28.00) {
            System.out.printf("%n" + "Time: 04:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        } else if (time <= 28.301 && time > 28.29) {
            System.out.printf("%n" + "Time: 04:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            dynamicTravel();
        }
    }

    private static void dynamicAC() {
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
                        System.out.println(" ");
                        System.out.println("\nMain Room AC has switched ON!");
                        System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        System.out.print("°");
                        System.out.println("Main Room Temperature set to: " + decimalFormat.format(inDoorTemp) + "°");
                        mainRoomAC = true;
                    }

                    if (acTemp > inDoorTemp && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nMain Room AC has switched OFF!");
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
                        System.out.println(" ");
                        System.out.println("\nLiving Room AC has switched ON!");
                        System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        System.out.print("°");
                        System.out.println("Temperature set to: " + decimalFormat.format(inDoorTemp) + "°");
                        livingRoomAc = true;
                    }

                    if (acTemp2 > inDoorTemp && livingRoomAc) {
                        System.out.println(" ");
                        System.out.println("\nLiving Room AC has switched OFF!");
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
    }

    private static void dynamicWeather() {

        Random rand = new Random();
        //1 : 150 chance for weather to change every minute
        int n = rand.nextInt(150) + 1;

        String oldWeather = Menu.weatherType;

        if (n == 1) {
            String weatherChange = Menu.getSimInfo();

            if (!weatherChange.equals(oldWeather)) {
                Menu.weatherType = weatherChange;
            }
        }
    }

    private static String dynamicMotionSensors() {
        if (time > 21) {
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

    private static void dynamicTravel() {
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
    }

    private static void dynamicLights() {
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
                        if (lightOn > sunLightValue && lightOn2 < time) {
                            System.out.println(" ");
                            System.out.println("\nMain Room Lights have switched ON!");
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nMain Room Lights have switched ON!");
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time) {
                            System.out.println(" ");
                            System.out.println("\nMain Room Lights have switched OFF!");
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nMain Room Lights have switched OFF!");
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
                        if (lightOn > sunLightValue && lightOn2 < time) {
                            System.out.println(" ");
                            System.out.println("\nLiving Room Lights have switched ON!");
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nLiving Room Lights have switched ON!");
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time) {
                            System.out.println(" ");
                            System.out.println("\nLiving Room Lights have switched OFF!");
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nLiving Room Lights have switched OFF!");
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
                        if (lightOn > sunLightValue && lightOn2 < time) {
                            System.out.println(" ");
                            System.out.println("\nSecond Bedroom Lights have switched ON!");
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nSecond Bedroom Lights have switched ON!");
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time) {
                            System.out.println(" ");
                            System.out.println("\nSecond Bedroom Lights have switched OFF!");
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nSecond Bedroom Lights have switched OFF!");
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
                        if (lightOn > sunLightValue && lightOn2 < time) {
                            System.out.println(" ");
                            System.out.println("\nKitchen Lights have switched ON!");
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nKitchen Lights have switched ON!");
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time) {
                            System.out.println(" ");
                            System.out.println("\nKitchen Lights have switched OFF!");
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nKitchen Lights have switched OFF!");
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
                        if (lightOn > sunLightValue && lightOn2 < time) {
                            System.out.println(" ");
                            System.out.println("\nGarage Lights have switched ON!");
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nGarage Lights have switched ON!");
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time) {
                            System.out.println(" ");
                            System.out.println("\nGarage Lights have switched OFF!");
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nGarage Lights have switched OFF!");
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
                        if (lightOn > sunLightValue && lightOn2 < time) {
                            System.out.println(" ");
                            System.out.println("\nGarden Lights have switched ON!");
                            mainRoomAC = true;
                        }
                    } else if (lightOn > sunLightValue && !mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nGarden Lights have switched ON!");
                        mainRoomAC = true;
                    }

                    if (lightOn < sunLightValue && mainRoomAC && values[3].equals("1")) {
                        if (lightOn < sunLightValue && lightOn2 > time) {
                            System.out.println(" ");
                            System.out.println("\nGarden Lights have switched OFF!");
                            mainRoomAC = false;
                        }
                    } else if (lightOn < sunLightValue && mainRoomAC) {
                        System.out.println(" ");
                        System.out.println("\nGarden Lights have switched OFF!");
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
    }

    private static void dynamicCeilingFan() {
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
                        System.out.println(" ");
                        System.out.println("\nLiving Room Ceiling Fan has switched ON!");
                        System.out.printf("Outdoor Temperature: " + "%.2f", temperature);
                        System.out.print("°");
                        System.out.println("\nTemperature set to: " + decimalFormat.format(inDoorTemp) + "°");
                        System.out.println("Ceiling Fan Speed set to: " + ceilingFanSpeed);
                        livingRoomCeilingFan = true;
                    }

                    if (ceilingFanListTemp > inDoorTemp && livingRoomCeilingFan) {
                        System.out.println(" ");
                        System.out.println("\nLiving Room Ceiling Fan has switched OFF!");
                        livingRoomCeilingFan = false;
                    }
                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    //Re-format user inputs to act as a refresher
                }

            }

        } catch (FileNotFoundException | NumberFormatException ignored) {

        }
    }

    private static void dynamicGarageDoor() {
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
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                    garageDoorList = Double.parseDouble(values[3]);


                    Random rand = new Random();
                    //1 : 4 chance for Garage Door display chance
                    int randomX = rand.nextInt(4) + 1;

                    if ((randomX == 1) && (time <= 7.301 && time > 7.29)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door is opening Now!");
                        garageDoorCloseSequence = 1;
                    } else if ((randomX == 4) && (time <= 7.301 && time > 7.29)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door accessed via Secure Mobile!");
                        garageDoorCloseSequence = 1;
                    } else if ((randomX < 4 && randomX > 1) && (time <= 7.301 && time > 7.29)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door accessed remotely! Please Inspect!!");
                        garageDoorCloseSequence = 1;
                    }

                    if ((time <= 12.301 && time > 12.29) && (randomX == 1)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door is opening Now!");
                        garageDoorCloseSequence = 1;
                    } else if ((time <= 12.301 && time > 12.29) && (randomX == 4)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door accessed via Secure Mobile!");
                        garageDoorCloseSequence = 1;
                    } else if ((time <= 12.301 && time > 12.29) && (randomX < 4 && randomX > 1)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door accessed remotely! Please Inspect!!");
                        garageDoorCloseSequence = 1;
                    }

                    if ((time <= 17.301 && time > 17.29) && (randomX == 1)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door is opening Now!");
                        garageDoorCloseSequence = 1;
                    } else if ((time <= 17.301 && time > 17.29) && (randomX == 4)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door accessed via Secure Mobile!");
                        garageDoorCloseSequence = 1;
                    } else if ((time <= 17.301 && time > 17.29) && (randomX < 4 && randomX > 1)) {
                        System.out.println(" ");
                        System.out.println("\nGarage Door accessed remotely! Please Inspect!!");
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
    }

    private static void dynamicSprinkler() {
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
                                if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time > 8.59 && time < 9.01) {
                                    //9:00am
                                    gardenTemp = 27;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                } else if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //3 Water - 9:00am / 6:00pm / 2:00am
                                sprinklerMode = "Full Flow Mode";
                                if (time >= 8.59 && time < 9.01) {
                                    //9:00am
                                    gardenTemp = 27;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                } else if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 25;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                } else if (time > 25.59 && time < 26.01) {
                                    //2:00am
                                    gardenTemp = 17;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                        case "CLOUDY":
                            // NO FULL FLOW ON CLOUDY DAYS
                            if (sprinklerListTemp == 1) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time > 8.59 && time < 9.01) {
                                    //9:00am
                                    gardenTemp = 25;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                } else if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //2 Water - 9:00am / 6:00pm
                                sprinklerMode = "Water Saver Mode";
                                if (time > 8.59 && time < 9.01) {
                                    //9:00am
                                    gardenTemp = 25;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                } else if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 23;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            }
                            break;
                        case "RAINY":
                            // NO FULL FLOW OR WATER SAVER ON RAINY DAYS
                            if (sprinklerListTemp == 1) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 2) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
                                }
                            } else if (sprinklerListTemp == 3) {
                                //1 Water - 6:00pm
                                sprinklerMode = "Extreme Water Saver Mode";
                                if (time > 17.59 && time < 18.01) {
                                    //6:00pm
                                    gardenTemp = 22;
                                    System.out.println("\n" + sprinklerMode + " - Now Watering");
                                    System.out.println("Garden Temperature: " + gardenTemp);
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
    }

    private static void dynamicAlarm() {
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

                    if (alarmTime < time && !alarmSound) {
                        System.out.println("\nAlarm has Turned ON");
                        System.out.println("BEEP.. BEEP.. BEEP..");
                        alarmSound = true;
                    } else if (time <= 29) {
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

                    if (alarmTime < time && !alarmSound) {
                        System.out.println("\nAlarm has Turned ON");
                        System.out.println("BEEP.. BEEP.. BEEP..");
                        alarmSound = true;
                    } else if (time <= 29) {
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
    }

    private static void dynamicCar() {
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
                                System.out.println("\nCar Status: " + carMode + ", Turning Engine ON now...");
                                carRunning = true;
                            }

                            if (!travelTo.equals("GARAGE") && carRunning) {
                                carRunning = false;
                                System.out.println("\nCar Status: Returned, Engine OFF...");
                            } else if (!travelTo.equals("GARAGE")) {
                                carRunning = false;
                            }
                            break;
                        case "2":
                            carMode = "Economy Start";
                            if (travelTo.equals("GARAGE") && !carRunning) {
                                System.out.println("\nCar Status: " + carMode + ", Turning Engine ON when enter Garage...");
                            }

                            if (!travelTo.equals("GARAGE") && carRunning) {
                                carRunning = false;
                                System.out.println("\nCar Status: Returned, Engine OFF...");
                            } else if (!travelTo.equals("GARAGE")) {
                                carRunning = false;
                            }
                            break;
                        case "3":
                            carMode = "Manual Start";
                            if (travelTo.equals("GARAGE") && !carRunning) {
                                System.out.println("\nCar Status: " + carMode + ", Turning Engine ON once in Car...");
                            }

                            if (!travelTo.equals("GARAGE") && carRunning) {
                                carRunning = false;
                                System.out.println("\nCar Status: Returned, Engine OFF...");
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
    }

    private static void dynamicCoffeeMachine() {
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
                        System.out.println("\nMorning Coffee Boiling!");
                        alarmCoffee = true;
                    } else if (makeMainBedroomCoffee && !alarmCoffee) {
                        System.out.println("\nMorning Coffee Boiling!");
                        alarmCoffee = true;
                    } else if (makeSecondBedroomCoffee && !alarmCoffee) {
                        System.out.println("\nMorning Coffee Boiling!");
                        alarmCoffee = true;
                    } else if (time <= 29 && alarmCoffee) {
                        alarmCoffee = false;
                    }
                    coffeeBehaviour = values[3];

                    if (coffeeBehaviour.equals("1") && !alarmCoffee) {
                        //Coffee Addiction
                        if (time < 7 && !behaviour1) {
                            behaviour1 = true;
                            System.out.println("\nMorning Coffee Boiling!");
                        } else if (time <= 29 && behaviour1) {
                            behaviour1 = false;
                        }
                    } else if (coffeeBehaviour.equals("2")) {
                        //All day Coffee
                        if (time < 7 && !behaviour2) {
                            System.out.println("\nAll Day Coffee Boiling!");
                            behaviour2 = true;
                        } else if (time < 12 && !behaviour2) {
                            System.out.println("\nAll Day Coffee Boiling!");
                            behaviour2 = true;
                        } else if (time < 16.30 && !behaviour2) {
                            System.out.println("\nAll Day Coffee Boiling!");
                            behaviour2 = true;
                        } else if (time <= 29 && behaviour2) {
                            behaviour2 = false;
                        }
                    } else if (coffeeBehaviour.equals("3")) {
                        //Fresh Blend
                        if (time < 7 && time > 9 && travelTo.equals("KITCHEN") && !behaviour3) {
                            System.out.println("\nFresh Blend, Morning Coffee Boiling!");
                            behaviour3 = true;
                        } else if (time < 12 && time > 14 && travelTo.equals("KITCHEN") && !behaviour3) {
                            System.out.println("\nFresh Blend, Lunch Coffee Boiling!");
                            behaviour3 = true;
                        } else if (time < 16.30 && time > 18 && travelTo.equals("KITCHEN") && !behaviour3) {
                            System.out.println("\nFresh Blend, Afternoon Coffee Boiling!");
                            behaviour3 = true;
                        } else if (time <= 29 && behaviour3) {
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
    }

    private static void dynamicKettle() {
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
                        System.out.println("\nKettle has Started to Boil!");
                        kettleBoiled = true;
                    } else if (kettleBehaviour.equals("2") && travelTo.equals("KITCHEN") && !kettleBoiled) {
                        //Manual Boil - Randomly turns on when person in kitchen
                        Random rand = new Random();
                        //1 : 5 chance for weather to change every minute
                        int n = rand.nextInt(5) + 1;
                        kettleBoiled = true;
                        if (n == 1) {
                            System.out.println("\nKettle has Started to Boil!");
                        }
                    } else if (time <= 29 && kettleBoiled) {
                        kettleBoiled = false;
                    }

                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
    }

    private static void dynamicTv() {
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

                    if (time < 7.30 && travelTo.equals("LIVING ROOM") && !tvON) {
                        System.out.println("\nTV has Turned ON in LIVING ROOM!");
                        tvON = true;
                    } else if (tvOffTime < time && travelTo.equals("LIVING ROOM") && tvON) {
                        System.out.println("\nTV has Turned OFF in LIVING ROOM!");
                        tvON = false;
                    } else if (!travelTo.equals("LIVING ROOM") && tvON) {
                        tvON = false;
                        System.out.println("\nTV has Turned OFF in LIVING ROOM!");
                    }

                    //LIVING ROOM - OFF
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }

                //MAIN BEDROOM - ON
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                    tvOffTime = Double.parseDouble(values[3]);

                    if (time < 7.30 && travelTo.equals("LIVING ROOM") && !tvON) {
                        System.out.println("\nTV has Turned ON in LIVING ROOM!");
                        tvON = true;
                    } else if (tvOffTime < time && travelTo.equals("LIVING ROOM") && tvON) {
                        System.out.println("\nTV has Turned OFF in LIVING ROOM!");
                        tvON = false;
                    } else if (!travelTo.equals("LIVING ROOM") && tvON) {
                        tvON = false;
                        System.out.println("\nTV has Turned OFF in LIVING ROOM!");
                    }

                    //MAIN BEDROOM - OFF
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
    }

    private static void dynamicOven() {
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

                    if (morningAlarm < time && !morningBoolean) {
                        System.out.println("\nThe Oven has Turned ON");
                        System.out.println("Your " + morningMode + " are/is Cooking.");
                        morningBoolean = true;
                        morningTotal = morningAlarm + 0.06;
                    }

                    if (morningTotal > time && morningBoolean) {
                        System.out.println("\nThe Oven has Turned OFF");
                        System.out.println("Your " + morningMode + " are/is Ready!");
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

                    if (lunchAlarm < time && !lunchBoolean) {
                        System.out.println("The Oven has Turned ON");
                        System.out.println("Your " + lunchMode + " are/is Cooking.");
                        lunchBoolean = true;
                        lunchTotal = lunchAlarm + 0.12;
                    }

                    if (lunchTotal > time && lunchBoolean) {
                        System.out.println("The Oven has Turned OFF");
                        System.out.println("Your " + lunchMode + " are/is Ready!");
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


                    if (dinnerAlarm < time && !dinnerBoolean) {
                        System.out.println("The Oven has Turned ON");
                        System.out.println("Your " + dinnerMode + " are/is Cooking.");
                        dinnerBoolean = true;
                        dinnerTotal = dinnerAlarm + 0.06;
                    }

                    if (dinnerTotal > time && dinnerBoolean) {
                        System.out.println("The Oven has Turned OFF");
                        System.out.println("Your " + dinnerMode + " are/is Ready!");
                    }


                    //KITCHEN - OFF
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                    //Re-format user inputs to act as a refresher
                }
            }

        } catch (FileNotFoundException | NumberFormatException ignored) {
        }
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