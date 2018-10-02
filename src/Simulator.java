import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

class Simulator {
    static double temperature, inDoorTemp, inDoorTempSetter, ceilingFanTemp;
    static double acTemp, acTemp2, lightOn, lightOff, sunLightValue, ceilingFanListTemp, garageDoorList, sprinklerListTemp, gardenTemp;
    static double time = 5;
    static String weatherChange, oldWeather, simChoice, data, sprinklerMode;
    static boolean deviceLight, mainRoomAC, livingRoomAc, livingRoomCeilingFan, gardenSprinkler;
    static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5;
    static int ceilingFanSpeed, randomX;
    static int garageDoorCloseSequence = 0;

    static void runSimulator(String weatherType) throws InterruptedException, FileNotFoundException {

        do {
            simChoice = Menu.weatherType;
            time = Weather.timeCorrection();
            temperature = Weather.tempCorrection();
            sunLightValue = Sun.getSunLightChange();// change to solid light not increase


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

            dynamicWeather();
            dynamicLights();
            dynamicAC();
            dynamicCeilingFan();
            dynamicGarageDoor();
            dynamicSprinkler();

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
            time += 0.1;
        } while (time < 30);
    }

    private static void halfHourlyDisplay() {
        if (time == 5.00) {
            System.out.printf("%n" + "Time: 05:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 5.30 && time > 5.29) {
            System.out.printf("%n" + "Time: 05:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 6.00) {
            System.out.printf("%n" + "Time: 06:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 6.30 && time > 6.29) {
            System.out.printf("%n" + "Time: 06:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 7.00) {
            System.out.printf("%n" + "Time: 07:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 7.30 && time > 7.29) {
            System.out.printf("%n" + "Time: 07:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 8.00) {
            System.out.printf("%n" + "Time: 08:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 8.30 && time > 8.29) {
            System.out.printf("%n" + "Time: 08:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 9.00) {
            System.out.printf("%n" + "Time: 09:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 9.30 && time > 9.29) {
            System.out.printf("%n" + "Time: 09:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 10.00) {
            System.out.printf("%n" + "Time: 10:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 10.30 && time > 10.29) {
            System.out.printf("%n" + "Time: 10:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 11.00) {
            System.out.printf("%n" + "Time: 11:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 11.30 && time > 11.29) {
            System.out.printf("%n" + "Time: 11:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 12.00) {
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
            System.out.printf("%n" + "Time: 12:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 12.30 && time > 12.29) {
            System.out.printf("%n" + "Time: 12:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 13.00) {
            System.out.printf("%n" + "Time: 01:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 13.30 && time > 13.29) {
            System.out.printf("%n" + "Time: 01:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 14.00) {
            System.out.printf("%n" + "Time: 02:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 14.30 && time > 14.29) {
            System.out.printf("%n" + "Time: 02:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 15.00) {
            System.out.printf("%n" + "Time: 03:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 15.30 && time > 15.29) {
            System.out.printf("%n" + "Time: 03:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 16.00) {
            System.out.printf("%n" + "Time: 04:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 16.301 && time > 16.29) {
            System.out.printf("%n" + "Time: 04:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 17.00) {
            System.out.printf("%n" + "Time: 05:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 17.301 && time > 17.29) {
            System.out.printf("%n" + "Time: 05:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 18.00) {
            System.out.printf("%n" + "Time: 06:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 18.301 && time > 18.29) {
            System.out.printf("%n" + "Time: 06:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 19.00) {
            System.out.printf("%n" + "Time: 07:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 19.301 && time > 19.29) {
            System.out.printf("%n" + "Time: 07:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 20.00) {
            System.out.printf("%n" + "Time: 08:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 20.301 && time > 20.29) {
            System.out.printf("%n" + "Time: 08:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 21.00) {
            System.out.printf("%n" + "Time: 09:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 21.301 && time > 21.29) {
            System.out.printf("%n" + "Time: 09:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 22.00) {
            System.out.printf("%n" + "Time: 10:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 22.301 && time > 22.29) {
            System.out.printf("%n" + "Time: 10:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 23.00) {
            System.out.printf("%n" + "Time: 11:00 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 23.301 && time > 23.29) {
            System.out.printf("%n" + "Time: 11:30 pm");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 24.00) {
            System.out.printf("%n" + "Time: 00:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 24.301 && time > 24.29) {
            System.out.printf("%n" + "Time: 00:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 25.00) {
            System.out.printf("%n" + "Time: 01:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 25.301 && time > 25.29) {
            System.out.printf("%n" + "Time: 01:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 26.00) {
            System.out.printf("%n" + "Time: 02:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 26.301 && time > 26.29) {
            System.out.printf("%n" + "Time: 02:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 27.00) {
            System.out.printf("%n" + "Time: 03:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 27.301 && time > 27.29) {
            System.out.printf("%n" + "Time: 03:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time == 28.00) {
            System.out.printf("%n" + "Time: 04:00 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        } else if (time <= 28.301 && time > 28.29) {
            System.out.printf("%n" + "Time: 04:30 am");
            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
            System.out.print("°");
            System.out.printf("%n" + "Sunlight Percent: " + "%.2f", sunLightValue);
            System.out.print("%");
        }
    }

    private static void dynamicAC() {
        inDoorTempSetter = temperature;
        DecimalFormat decimalFormat = new DecimalFormat("#");

        //Change file name to be more specific for method
        String fileName = "C:\\Users\\James\\Desktop\\airConConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");

                //MAIN BEDROOM - ON
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    inDoorTemp = House.roomTemp();
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
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine1 = data.split(", ");
                    acTemp = 0;
                    values[3] = String.valueOf(acTemp);
                    //Re-format user inputs to act as a refresher
                }

                //LIVING ROOM - ON
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    inDoorTemp = House.livingRoomTemp();
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
                    //System.out.println(Arrays.toString(data.split("\t")));
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

        oldWeather = Menu.weatherType;

        if (n == 1) {
            weatherChange = Menu.getSimInfo();

            if (!weatherChange.equals(oldWeather)) {
                Menu.weatherType = weatherChange;
            }
        }
    }

    private static void dynamicLights() {
        lightOn = Fixture.lightSettingOn;
        lightOff = Fixture.lightSettingOff;

        if (time >= lightOn && !deviceLight) {
            System.out.println('\n' + Fixture.roomLocation + " Lights have turned on.");
            deviceLight = true;
        }

        if (time >= lightOff && !deviceLight) {
            System.out.println('\n' + Fixture.roomLocation + " Lights have turned off.");
            deviceLight = true;
        }

    }

    private static void dynamicCeilingFan() throws FileNotFoundException {
        DecimalFormat decimalFormat = new DecimalFormat("#");

        //Users Set temp they want room to stay at

        String fileName = "C:\\Users\\James\\Desktop\\ceilingFanConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                ceilingFanTemp = House.livingRoomTemp();
                values = data.split(",");
                //LIVING ROOM - ON
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    inDoorTemp = House.livingRoomTemp();
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
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine3 = data.split(", ");
                    ceilingFanListTemp = 0;
                    values[3] = String.valueOf(ceilingFanListTemp);
                    //Re-format user inputs to act as a refresher
                }

            }

        } catch (Exception e) {

        }
    }

    private static void dynamicGarageDoor() {
        String fileName = "C:\\Users\\James\\Desktop\\garageDoorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                //GARAGE - ON
                if (values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                    garageDoorList = Double.parseDouble(values[3]);


                    Random rand = new Random();
                    //1 : 4 chance for Garage Door display chance
                    randomX = rand.nextInt(4) + 1;

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

        } catch (Exception e) {

        }
    }

    private static void dynamicSprinkler() {
        //Users Set temp they want room to stay at
        String fileName = "C:\\Users\\James\\Desktop\\sprinklerConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);

            //Runs through each If statement and displays Ac status
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                //LIVING ROOM - ON
                if (values[0].equals("GARDEN") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                    sprinklerListTemp = Double.parseDouble(values[3]);

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

                    //LIVING ROOM - OFF
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    //System.out.println(Arrays.toString(data.split("\t")));
                    displayLine5 = data.split(", ");
                    sprinklerListTemp = 0;
                    values[3] = String.valueOf(sprinklerListTemp);
                    //Re-format user inputs to act as a refresher
                }

            }

        } catch (Exception e) {

        }
    }
}