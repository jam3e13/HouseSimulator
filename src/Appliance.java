//Appliances to add:
//1. Car
//2. Oven
//3. TV
//4. Kettle
//5. Coffee Machine
//6. Vacuum

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Appliance {

    private static int choice, fixtureChoice;
    static double alarmClockUserSettings, tvUserSettings, alarmClockAlarm1, setUpTvOption1, ovenAlarmMorning, ovenAlarmLunch, ovenAlarmDinner, morningAlarm1, lunchAlarm1, dinnerAlarm1;
    static int changeSettings, carSetting, alarmClockSetting, alarmClockAlarm, ovenMorning, ovenLunch, ovenDinner, morningAlarm, lunchAlarm, dinnerAlarm, setUpTvOption, tvMotionSensor;
    static String roomLocation, data, updatedList, fixtureSwitch, x1, x2, carMode, carDisplay, kettleMode, updatedList1, morningMode, lunchMode, dinnerMode;
    static String[] values, displayLine, displayLine1;

    static void applianceSetUp() throws InterruptedException, FileNotFoundException {
        System.out.println("APPLIANCES");
        System.out.println("Please select a Room to set up...");
        roomDisplay();
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        do {
            if (choice == 1) {
                //LIVING ROOM
                roomLocation = "LIVING ROOM";

                System.out.println("\nLIVING ROOM");
                System.out.println("\n1) TV");
                System.out.println("2) VACUUM");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 2) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1, 2 OR 0 - Exit");
                    System.out.println("\n1) TV");
                    System.out.println("2) VACUUM");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //TV
                    applianceTV();


                } else if (fixtureChoice == 2) {
                    //OVEN
                    applianceOven();


                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                }

            } else if (choice == 2) {
                //MAIN BEDROOM
                roomLocation = "MAIN BEDROOM";

                System.out.println("\nMAIN BEDROOM");
                System.out.println("\n1) TV");
                System.out.println("\n2) ALARM CLOCK");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 2) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1, 2 OR 0 - Exit");
                    System.out.println("\n1) TV");
                    System.out.println("2) ALARM CLOCK");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //TV
                    applianceTV();

                } else if (fixtureChoice == 2) {
                    applianceAlarmClock();
                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 3) {
                //SECOND BEDROOM
                roomLocation = "SECOND BEDROOM";

                System.out.println("\nSECOND BEDROOM");
                System.out.println("\n1) ALARM CLOCK");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 1) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1 OR 0 - Exit");
                    System.out.println("\n1) ALARM CLOCK");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    applianceAlarmClock();
                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 4) {
                //KITCHEN
                roomLocation = "KITCHEN";

                System.out.println("\nKITCHEN");
                System.out.println("\n1) OVEN");
                System.out.println("2) KETTLE");
                System.out.println("3) COFFEE MACHINE");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 3) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1, 2, 3 OR 0 - Exit");
                    System.out.println("\n1) OVEN");
                    System.out.println("2) KETTLE");
                    System.out.println("2) COFFEE MACHINE");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //OVEN
                    applianceOven();

                } else if (fixtureChoice == 2) {
                    //KETTLE
                    applianceKettle();

                } else if (fixtureChoice == 3) {
                    //COFFEE MACHINE
                    applianceCoffeeMachine();

                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 5) {
                //GARAGE
                roomLocation = "GARAGE";

                System.out.println("\n1) CAR");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1 OR 0 - Exit");
                    System.out.println("\n1) CAR");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //CAR
                    applianceCar();

                } else if (fixtureChoice == 0) {
                    applianceSetUp();
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
        System.out.println("2) MAIN BEDROOM");
        System.out.println("3) SECOND BEDROOM");
        System.out.println("4) KITCHEN");
        System.out.println("5) GARAGE");
    }

    private static void applianceAlarmClock() throws FileNotFoundException {
        //When user enters garage car turns on automatically
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "ConfigFiles\\alarmClockConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (roomLocation.equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("MAIN BEDROOM Alarm Clock is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                } else if (roomLocation.equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("SECOND BEDROOM Alarm Clock is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("MAIN BEDROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine));
            } else if (roomLocation.equals("SECOND BEDROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine1));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Gets alarm setting for time
        System.out.println("Enter Alarm Settings OR Enter 0 to EXIT anytime");
        System.out.println("\nPlease enter Alarm Clock alarm time; (5am - 12pm)");
        System.out.println("\nHour: ");
        alarmClockAlarm = input.nextInt();
        while (alarmClockAlarm > 12) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Alarm Clock Hours (5am - 12pm)");
            System.out.println("\nHour: ");
            alarmClockAlarm = input.nextInt();
        }
        while (alarmClockAlarm < 5) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Alarm Clock Hours (5am - 12pm)");
            System.out.println("\nHour: ");
            alarmClockAlarm = input.nextInt();
        }
        System.out.println("\nMinute: ");
        alarmClockAlarm1 = input.nextDouble();
        while (alarmClockAlarm1 > 60.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Alarm Clock Minutes (00 - 60)");
            System.out.println("Minute: ");
            alarmClockAlarm1 = input.nextDouble();
        }
        while (alarmClockAlarm1 < 00.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Alarm Clock Minutes (00 - 60)");
            System.out.println("Minute: ");
            alarmClockAlarm1 = input.nextDouble();
        }

        alarmClockUserSettings = alarmClockAlarm1 / 100;
        alarmClockUserSettings = alarmClockUserSettings + alarmClockAlarm;

        System.out.printf("Alarm Set: " + "%.2f", alarmClockUserSettings);

        //Gets Smart appliance settings
        System.out.println("\nPlease ENABLE Alarm Clock's Smart Ability;");
        System.out.println("1 - Morning Coffee always");
        System.out.println("2 - Morning Coffee never");
        alarmClockSetting = input.nextInt();

        //Makes sure use inputs are in range
        while (alarmClockSetting > 2) {
            System.out.println("Wrong Input...");
            System.out.println("Please enter either 1 or 2.");
            alarmClockSetting = input.nextInt();
        }


        //Exits if user chooses 0
        if (alarmClockAlarm == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (alarmClockAlarm1 == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //saves to user chosen room
        Devices alarmClockTemp = new Devices();
        alarmClockTemp.setAlarmClockTemp(alarmClockUserSettings);

        //saves smart choice
        Devices alarmClockSmart = new Devices();
        alarmClockSmart.setAlarmClockSmart(alarmClockSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                carDisplay = ("The " + roomLocation + " Alarm Clock has been set to: " + kettleMode);
                System.out.println(carDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("MAIN BEDROOM")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices roomAlarmClock = new Devices();
                    List<Devices.roomAlarmClock> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.roomAlarmClock(Devices.getLocation()));
                    //Device
                    list.add(new Devices.roomAlarmClock("Alarm Clock"));
                    //Calibration
                    list.add(new Devices.roomAlarmClock("ON"));
                    //User Settings
                    list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockTemp.getAlarmClockTemp())));
                    //Smart Settings
                    list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockSmart.getAlarmClockSmart())));
                    //Set list
                    roomAlarmClock.setListRoomAlarmClock(list);

                    updatedList = list.toString();
                    x1 = String.valueOf((updatedList));

                    updatedList1 = Arrays.toString(displayLine1);
                    x2 = String.valueOf((updatedList1));

                    //Full list view of what is being saved
                    System.out.println("Alarm Clock List for " + roomLocation + ": " + list);
                } else if (roomLocation.equals("SECOND BEDROOM")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices roomAlarmClock = new Devices();
                    List<Devices.roomAlarmClock> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.roomAlarmClock(Devices.getLocation()));
                    //Device
                    list.add(new Devices.roomAlarmClock("Alarm Clock"));
                    //Calibration
                    list.add(new Devices.roomAlarmClock("ON"));
                    //User Settings
                    list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockTemp.getAlarmClockTemp())));
                    //Smart Settings
                    list.add(new Devices.roomAlarmClock(String.valueOf(alarmClockSmart.getAlarmClockSmart())));
                    //Set list
                    roomAlarmClock.setListRoomAlarmClock(list);

                    updatedList = Arrays.toString(displayLine);
                    x1 = String.valueOf((updatedList));

                    updatedList1 = list.toString();
                    x2 = String.valueOf((updatedList1));

                    //Full list view of what is being saved
                    System.out.println("Alarm Clock List for " + roomLocation + ": " + list);

                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("ConfigFiles\\alarmClockConfig.txt");
                pw.close();

                StringBuilder sb = new StringBuilder();


                System.out.println(x1);

                System.out.println(x2);

                sb.append(x1).append("\n");
                sb.append(System.lineSeparator());
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("ConfigFiles\\alarmClockConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Alarm Clock List failed...");
                break;
        }
    }

    private static void applianceTV() throws FileNotFoundException {
        //When user enters garage car turns on automatically
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "ConfigFiles\\tvConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (roomLocation.equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("LIVING ROOM TV is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                } else if (roomLocation.equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("MAIN BEDROOM TV is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("LIVING ROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine));
            } else if (roomLocation.equals("MAIN BEDROOM")) {
                System.out.println("Status: " + Arrays.toString(displayLine1));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Gets alarm setting for time
        System.out.println("Enter Turn Off Time for TV OR Enter 0 to EXIT anytime");
        System.out.println("\nPlease enter Turn Off Time for Tv; (12pm - 12am)");
        System.out.println("\nHour: ");
        setUpTvOption = input.nextInt();

        //Exits if user chooses 0
        if (setUpTvOption == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (setUpTvOption == 1) {
            setUpTvOption = 13;
        } else if (setUpTvOption == 2) {
            setUpTvOption = 14;
        } else if (setUpTvOption == 3) {
            setUpTvOption = 15;
        } else if (setUpTvOption == 4) {
            setUpTvOption = 16;
        } else if (setUpTvOption == 5) {
            setUpTvOption = 17;
        } else if (setUpTvOption == 6) {
            setUpTvOption = 18;
        } else if (setUpTvOption == 7) {
            setUpTvOption = 19;
        } else if (setUpTvOption == 8) {
            setUpTvOption = 20;
        } else if (setUpTvOption == 9) {
            setUpTvOption = 21;
        } else if (setUpTvOption == 10) {
            setUpTvOption = 22;
        } else if (setUpTvOption == 11) {
            setUpTvOption = 23;
        } else if (setUpTvOption == 12) {
            setUpTvOption = 24;
        }

        while (setUpTvOption > 24) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (12pm - 12am)");
            System.out.println("\nHour: ");
            setUpTvOption = input.nextInt();
        }
        while (setUpTvOption < 12) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (12pm - 12am)");
            System.out.println("\nHour: ");
            setUpTvOption = input.nextInt();
        }
        System.out.println("\nMinute: ");
        setUpTvOption1 = input.nextDouble();
        while (setUpTvOption1 > 60.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            setUpTvOption1 = input.nextDouble();
        }
        while (setUpTvOption1 < 00.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            setUpTvOption1 = input.nextDouble();
        }

        tvUserSettings = setUpTvOption1 / 100;
        tvUserSettings = tvUserSettings + setUpTvOption;

        System.out.printf("Turn Off, Set: " + "%.2f", tvUserSettings);

        //saves to user chosen room
        //Timer settings
        Devices tvTimer = new Devices();
        tvTimer.setTvTimer(tvUserSettings);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                //Add to a list to be called in sim
                if (roomLocation.equals("LIVING ROOM")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices roomTv = new Devices();
                    List<Devices.roomTv> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.roomTv(Devices.getLocation()));
                    //Device
                    list.add(new Devices.roomTv("TV"));
                    //Calibration
                    list.add(new Devices.roomTv("ON"));
                    //User Settings
                    list.add(new Devices.roomTv(String.valueOf(tvTimer.getTvTimer())));
                    //Set list
                    roomTv.setListRoomTv(list);

                    updatedList = list.toString();
                    x1 = String.valueOf((updatedList));

                    updatedList1 = Arrays.toString(displayLine1);
                    x2 = String.valueOf((updatedList1));

                    //Full list view of what is being saved
                    System.out.println("TV List for " + roomLocation + ": " + list);
                } else if (roomLocation.equals("MAIN BEDROOM")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices roomTv = new Devices();
                    List<Devices.roomTv> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.roomTv(Devices.getLocation()));
                    //Device
                    list.add(new Devices.roomTv("TV"));
                    //Calibration
                    list.add(new Devices.roomTv("ON"));
                    //User Settings
                    list.add(new Devices.roomTv(String.valueOf(tvTimer.getTvTimer())));
                    //Set list
                    roomTv.setListRoomTv(list);

                    updatedList = Arrays.toString(displayLine);
                    x1 = String.valueOf((updatedList));

                    updatedList1 = list.toString();
                    x2 = String.valueOf((updatedList1));

                    //Full list view of what is being saved
                    System.out.println("TV List for " + roomLocation + ": " + list);
                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("ConfigFiles\\tvConfig.txt");
                pw.close();

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x1).append("\n");
                sb.append(System.lineSeparator());
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("ConfigFiles\\tvConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("TV List failed...");
                break;
        }
    }

    private static void applianceOven() throws FileNotFoundException {
        //When user enters garage car turns on automatically
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "ConfigFiles\\ovenConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (roomLocation.equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("KITCHEN Oven is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("KITCHEN")) {
                System.out.println("Status: " + Arrays.toString(displayLine));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Please Follow and Select options to configure Smart Oven below OR Enter 0 to Exit.");
        System.out.println("\nMorning:");
        System.out.println("1) Pancakes");
        System.out.println("2) Toast");
        System.out.println("3) Eggs and Bacon");
        ovenMorning = input.nextInt();

        //Exits if user chooses 0
        if (ovenMorning == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (ovenMorning == 1) {
            //1
            morningMode = "Pancakes";
        } else if (ovenMorning == 2) {
            //2
            morningMode = "Toast";
        } else if (ovenMorning == 3) {
            //3
            morningMode = "Eggs and Bacon";
        }

        System.out.println("Enter Time you'd like the " + morningMode + " to be ready. (6am - 9am)");
        System.out.println("\nPlease enter Oven alarm time;");
        System.out.println("\nHour: ");
        morningAlarm = input.nextInt();
        //MORNING 6 - 9
        while (morningAlarm > 9) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (6am - 9am)");
            System.out.println("\nHour: ");
            morningAlarm = input.nextInt();
        }
        while (morningAlarm < 6) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (6am - 9am)");
            System.out.println("\nHour: ");
            morningAlarm = input.nextInt();
        }
        System.out.println("\nMinute: ");
        morningAlarm1 = input.nextDouble();
        while (morningAlarm1 > 60.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            morningAlarm1 = input.nextDouble();
        }
        while (morningAlarm1 < 00.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            morningAlarm1 = input.nextDouble();
        }

        ovenAlarmMorning = morningAlarm1 / 100;
        ovenAlarmMorning = ovenAlarmMorning + morningAlarm;

        System.out.println("Morning breakfast: " + morningMode);
        System.out.printf("Ready at: " + "%.2f", ovenAlarmMorning);


        System.out.println("\nLunch: ");
        System.out.println("1) Muffins");
        System.out.println("2) Toasted Sandwich");
        System.out.println("3) Chicken and Rice Salad");
        ovenLunch = input.nextInt();

        if (ovenLunch == 1) {
            //1
            lunchMode = "Muffins";
        } else if (ovenLunch == 2) {
            //2
            lunchMode = "Toasted Sandwich";
        } else if (ovenLunch == 3) {
            //3
            lunchMode = "Chicken and Rice Salad";
        }

        System.out.println("Enter Time you'd like the " + lunchMode + " to be ready. (11am - 2pm)");
        System.out.println("\nPlease enter Oven alarm time;");
        System.out.println("\nHour: ");
        lunchAlarm = input.nextInt();

        if (lunchAlarm == 1) {
            lunchAlarm = 13;
        } else if (lunchAlarm == 2) {
            lunchAlarm = 14;
        }

        //LUNCH 11 - 2
        while (lunchAlarm > 14) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (11am - 2pm)");
            System.out.println("\nHour: ");
            lunchAlarm = input.nextInt();
        }
        while (lunchAlarm < 11) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (11am - 2pm)");
            System.out.println("\nHour: ");
            lunchAlarm = input.nextInt();
        }
        System.out.println("\nMinute: ");
        lunchAlarm1 = input.nextDouble();
        while (lunchAlarm1 > 60.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            lunchAlarm1 = input.nextDouble();
        }
        while (lunchAlarm1 < 00.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            lunchAlarm1 = input.nextDouble();
        }

        ovenAlarmLunch = lunchAlarm1 / 100;
        ovenAlarmLunch = ovenAlarmLunch + lunchAlarm;

        System.out.println("Lunch: " + lunchMode);
        System.out.printf("Ready at: " + "%.2f", ovenAlarmLunch);

        System.out.println("\nDinner: ");
        System.out.println("1) Roast Pork & Veggies");
        System.out.println("2) Lasagna");
        System.out.println("3) Smoked Mackerel");
        ovenDinner = input.nextInt();
        if (ovenDinner == 1) {
            //1
            dinnerMode = "Roast Pork + Veggies";
        } else if (ovenDinner == 2) {
            //2
            dinnerMode = "Lasagna";
        } else if (ovenDinner == 3) {
            //3
            dinnerMode = "Smoked Mackerel";
        }

        System.out.println("Enter Time you'd like the " + dinnerMode + " to be ready. (6pm - 9pm)");
        System.out.println("\nPlease enter Oven alarm time;");
        System.out.println("\nHour: ");
        dinnerAlarm = input.nextInt();

        if (dinnerAlarm == 6) {
            dinnerAlarm = 18;
        } else if (dinnerAlarm == 7) {
            dinnerAlarm = 19;
        } else if (dinnerAlarm == 8) {
            dinnerAlarm = 20;
        } else if (dinnerAlarm == 9) {
            dinnerAlarm = 21;
        }

        //DINNER 6 - 9
        while (dinnerAlarm > 21) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (6pm - 9pm)");
            System.out.println("\nHour: ");
            dinnerAlarm = input.nextInt();
        }
        while (dinnerAlarm < 18) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Hours (6pm - 9pm)");
            System.out.println("\nHour: ");
            dinnerAlarm = input.nextInt();
        }
        System.out.println("\nMinute: ");
        dinnerAlarm1 = input.nextDouble();
        while (dinnerAlarm1 > 60.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            dinnerAlarm1 = input.nextDouble();
        }
        while (dinnerAlarm1 < 00.00) {
            System.out.println("Wrong Minute Input...");
            System.out.println("\nPlease enter Minutes (00 - 60)");
            System.out.println("Minute: ");
            dinnerAlarm1 = input.nextDouble();
        }

        ovenAlarmDinner = dinnerAlarm1 / 100;
        ovenAlarmDinner = ovenAlarmDinner + dinnerAlarm;

        System.out.println("Dinner: " + dinnerMode);
        System.out.printf("Ready at: " + "%.2f", ovenAlarmDinner);

        //saves to user chosen room
        Devices kitchenOvenMorning = new Devices();
        kitchenOvenMorning.setKitchenOvenMorning(ovenAlarmMorning);

        Devices kitchenOvenOptionMorning = new Devices();
        kitchenOvenOptionMorning.setKitchenOvenOptionMorning(ovenMorning);

        Devices kitchenOvenLunch = new Devices();
        kitchenOvenLunch.setKitchenOvenLunch(ovenAlarmLunch);

        Devices kitchenOvenOptionLunch = new Devices();
        kitchenOvenOptionLunch.setKitchenOvenOptionLunch(ovenLunch);

        Devices kitchenOvenDinner = new Devices();
        kitchenOvenDinner.setKitchenOvenDinner(ovenAlarmDinner);

        Devices kitchenOvenOptionDinner = new Devices();
        kitchenOvenOptionDinner.setKitchenOvenOptionDinner(ovenDinner);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                //Add to a list to be called in sim
                if (roomLocation.equals("KITCHEN")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices kitchenOven = new Devices();
                    List<Devices.kitchenOven> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.kitchenOven(Devices.getLocation()));
                    //Device
                    list.add(new Devices.kitchenOven("Oven"));
                    //Calibration
                    list.add(new Devices.kitchenOven("ON"));
                    //User Settings
                    list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenMorning.getKitchenOvenMorning())));
                    list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenOptionMorning.getKitchenOvenOptionMorning())));
                    //User Settings
                    list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenLunch.getKitchenOvenLunch())));
                    list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenOptionLunch.getKitchenOvenOptionLunch())));
                    //User Settings
                    list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenDinner.getKitchenOvenDinner())));
                    list.add(new Devices.kitchenOven(String.valueOf(kitchenOvenOptionDinner.getKitchenOvenOptionDinner())));
                    //Set list
                    kitchenOven.setListKitchenOven(list);
                    updatedList = list.toString();
                    x2 = String.valueOf((updatedList));

                    //Full list view of what is being saved
                    System.out.println("Oven List for " + roomLocation + ": " + list);
                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("ConfigFiles\\ovenConfig.txt");
                pw.close();

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("ConfigFiles\\ovenConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Oven List failed...");
                break;
        }
    }

    private static void applianceCar() throws FileNotFoundException {
        //When user enters garage car turns on automatically
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "ConfigFiles\\carConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (roomLocation.equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("GARAGE Car is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("GARAGE")) {
                System.out.println("Status: " + Arrays.toString(displayLine));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter either; 1, 2 or 3 below, OR Enter 0 to EXIT.");
        System.out.println("\n1) Auto Start - Warms up engine before you enter Garage");
        System.out.println("2) Economy Start - Car Starts up when you enter Garage");
        System.out.println("3) Manual Start - Car won't start when enter Garage");

        carSetting = input.nextInt();

        //Exits if user chooses 0
        if (carSetting == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (carSetting > 3) {
            System.out.println("Wrong Input...");
            System.out.println("Please enter either 1, 2 or 3.");
            carSetting = input.nextInt();
        }

        if (carSetting == 1) {
            //1 Water - 6:00pm
            carMode = "Auto Start";
        } else if (carSetting == 2) {
            //2 Water - 9:00am / 6:00pm
            carMode = "Economy Start";
        } else if (carSetting == 3) {
            //3 Water - 9:00am / 6:00pm / 2:00am
            carMode = "Manual Start";
        }

        //saves to user chosen room
        Devices carTemp = new Devices();
        carTemp.setCarTemp(carSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                carDisplay = ("The " + roomLocation + " Car has been set to: " + carMode);
                System.out.println(carDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("GARAGE")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices garageCar = new Devices();
                    List<Devices.garageCar> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.garageCar(Devices.getLocation()));
                    //Device
                    list.add(new Devices.garageCar("Car"));
                    //Calibration
                    list.add(new Devices.garageCar("ON"));
                    //User Settings
                    list.add(new Devices.garageCar(String.valueOf(carTemp.getCarTemp())));
                    //Set list
                    garageCar.setListGarageCar(list);
                    updatedList = list.toString();
                    x2 = String.valueOf((updatedList));

                    //Full list view of what is being saved
                    System.out.println("Car List for " + roomLocation + ": " + list);
                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("ConfigFiles\\carConfig.txt");
                pw.close();

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("ConfigFiles\\carConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Car List failed...");
                break;
        }
    }

    private static void applianceKettle() throws FileNotFoundException {
        //When user enters garage car turns on automatically
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "ConfigFiles\\kettleConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (roomLocation.equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("KITCHEN Kettle is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("KITCHEN")) {
                System.out.println("Status: " + Arrays.toString(displayLine));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter either; 1 or 2 below, OR Enter 0 to EXIT.");
        System.out.println("\n1) Auto Boil - Kettle turns ON when you walk into kitchen");
        System.out.println("2) Manual Boil - Kettle turns ON when you want it to");

        carSetting = input.nextInt();

        //Exits if user chooses 0
        if (carSetting == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (carSetting > 2) {
            System.out.println("Wrong Input...");
            System.out.println("Please enter either 1 or 2.");
            carSetting = input.nextInt();
        }

        if (carSetting == 1) {
            //1 Water - 6:00pm
            kettleMode = "Auto Boil";
        } else if (carSetting == 2) {
            //2 Water - 9:00am / 6:00pm
            kettleMode = "Manual Boil";
        }

        //saves to user chosen room
        Devices kettleTemp = new Devices();
        kettleTemp.setKettleTemp(carSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                carDisplay = ("The " + roomLocation + " Kettle has been set to: " + kettleMode);
                System.out.println(carDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("KITCHEN")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices kitchenKettle = new Devices();
                    List<Devices.kitchenKettle> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.kitchenKettle(Devices.getLocation()));
                    //Device
                    list.add(new Devices.kitchenKettle("Kettle"));
                    //Calibration
                    list.add(new Devices.kitchenKettle("ON"));
                    //User Settings
                    list.add(new Devices.kitchenKettle(String.valueOf(kettleTemp.getKettleTemp())));
                    //Set list
                    kitchenKettle.setListKitchenKettle(list);
                    updatedList = list.toString();
                    x2 = String.valueOf((updatedList));

                    //Full list view of what is being saved
                    System.out.println("Kettle List for " + roomLocation + ": " + list);
                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("ConfigFiles\\kettleConfig.txt");
                pw.close();

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("ConfigFiles\\kettleConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Kettle List failed...");
                break;
        }
    }

    private static void applianceCoffeeMachine() throws FileNotFoundException {
        //When user enters garage car turns on automatically
        Scanner input = new Scanner(System.in);

        //Display rooms status
        String fileName = "ConfigFiles\\coffeeMachineConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (roomLocation.equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                    //Checks to see if device already set up
                    System.out.println("KITCHEN Coffee Machine is already set up.");
                    System.out.println("0) Exit");
                    System.out.println("1) Edit Settings");
                    changeSettings = input.nextInt();
                    while (changeSettings > 1) {
                        System.out.println("Wrong input...");
                        System.out.println("Please enter only (0) - Exit, (1) - Edit");
                        changeSettings = input.nextInt();
                    }
                    if (changeSettings == 1) {
                        System.out.println("Changing Settings..");
                    } else if (changeSettings == 0) {
                        System.out.println("Returning to Rooms...");
                        try {
                            applianceSetUp();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            System.out.println(roomLocation);
            if (roomLocation.equals("KITCHEN")) {
                System.out.println("Status: " + Arrays.toString(displayLine));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter either; 1, 2 or 3 below, OR Enter 0 to EXIT.");
        System.out.println("\n1) Coffee Addiction - Wakes you up to the smell of fresh coffee; every morning.");
        System.out.println("2) All day Coffee - Prepares; Breakfast, Lunch, Afternoon coffee.");
        System.out.println("3) Fresh Blend - Starts making coffee when you enter Kitchen; During specified times.");

        carSetting = input.nextInt();

        //Exits if user chooses 0
        if (carSetting == 0) {
            try {
                applianceSetUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Makes sure use inputs are in range
        while (carSetting > 3) {
            System.out.println("Wrong Input...");
            System.out.println("Please enter either 1, 2 or 3.");
            carSetting = input.nextInt();
        }

        if (carSetting == 1) {
            kettleMode = "Coffee Addiction";
        } else if (carSetting == 2) {
            kettleMode = "All day Coffee";
        } else if (carSetting == 3) {
            kettleMode = "Fresh Blend";
        }

        //saves to user chosen room
        Devices coffeeMachineTemp = new Devices();
        coffeeMachineTemp.setCoffeeMachineTemp(carSetting);

        fixtureSwitch = "ON";

        switch (fixtureSwitch) {
            case "ON":
                carDisplay = ("The " + roomLocation + " Coffee Machine has been set to: " + kettleMode);
                System.out.println(carDisplay);

                //Add to a list to be called in sim
                if (roomLocation.equals("KITCHEN")) {
                    Devices location = new Devices();
                    location.setLocation(roomLocation);
                    Devices kitchenCoffeeMachine = new Devices();
                    List<Devices.kitchenCoffeeMachine> list = new ArrayList<>();
                    //Location
                    list.add(new Devices.kitchenCoffeeMachine(Devices.getLocation()));
                    //Device
                    list.add(new Devices.kitchenCoffeeMachine("Coffee Machine"));
                    //Calibration
                    list.add(new Devices.kitchenCoffeeMachine("ON"));
                    //User Settings
                    list.add(new Devices.kitchenCoffeeMachine(String.valueOf(coffeeMachineTemp.getCoffeeMachineTemp())));
                    //Set list
                    kitchenCoffeeMachine.setListKitchenCoffeeMachine(list);
                    updatedList = list.toString();
                    x2 = String.valueOf((updatedList));

                    //Full list view of what is being saved
                    System.out.println("Coffee Machine List for " + roomLocation + ": " + list);
                }

                //Updates any new AC fixtures into one list
                //Refreshes the list by erasing then recreating
                PrintWriter pw = new PrintWriter("ConfigFiles\\coffeeMachineConfig.txt");
                pw.close();

                StringBuilder sb = new StringBuilder();
                //x2 = insert full updated list here
                sb.append(x2).append("\n");

                try {
                    Files.write(Paths.get("ConfigFiles\\coffeeMachineConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Coffee Machine List failed...");
                break;
        }
    }

}
