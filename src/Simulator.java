import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

class Simulator {
    static double temperature, inDoorTemp, inDoorTempSetter;
    static double acTemp, acTemp2, lightOn, lightOff, sunLightValue;
    static double time = 5;
    static String weatherChange, oldWeather, simChoice, data;
    static boolean deviceLight, mainRoomAC, livingRoomAc;
    static String[] displayLine1, displayLine2, values;

    static void runSimulator(String weatherType) throws InterruptedException {

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
        DecimalFormat decimalFormat=new DecimalFormat("#");

        //Change file name to be more specific for method
        String fileName = "C:\\Users\\James\\Desktop\\input.txt";
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


}