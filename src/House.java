import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class House {

    private static String data;
    private static String[] values;
    public static String[] livingRoomMotionSensor, livingRoomLights, livingRoomFan, livingRoomAC, livingRoomTV;
    public static String[] mainBedroomMotionSensor, mainBedroomLights, mainBedroomFan, mainBedroomTV, mainBedroomAC, mainBedroomAlarmClock;
    public static String[] secondBedroomMotionSensors, secondBedroomLights, secondBedroomFan, secondBedroomAlarmClock;
    public static String[] kitchenMotionSensors, kitchenLights, kitchenOven, kitchenKettle, kitchenCoffeeMachine;
    public static String[] garageMotionSensor, garageLights, garageCar, garageDoor;
    public static String[] gardenMotionSensors, gardenLights, gardenSprinklers;
    static deviceGUI gui;

    public static void main() {
        gui = new deviceGUI();
        gui.setVisible(true);
    }

    static void viewHouseDevices() {
        System.out.println("House Contents, (ON) - Set up, (OFF) - NOT Set up.");
        viewLivingRoomDevices();
        viewMainBedroomDevices();
        viewSecondBedroomDevices();
        viewKitchenDevices();
        viewGarageDevices();
        viewGardenDevices();
        gui.displayDevices();
    }

    private static void viewLivingRoomDevices() {
        //Motion Sensor
        String fileName = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomMotionSensor = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomMotionSensor = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(livingRoomMotionSensor));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Light
        String fileName1 = "ConfigFiles\\lightConfig.txt";
        File file1 = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomLights= data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomLights = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(livingRoomLights));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Air Conditioner
        String fileName2 = "ConfigFiles\\airConConfig.txt";
        File file2 = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomAC = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomAC = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(livingRoomAC));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Fan
        String fileName3 = "ConfigFiles\\ceilingFanConfig.txt";
        File file3 = new File(fileName3);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomFan = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomFan = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(livingRoomFan));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //TV
        String fileName4 = "ConfigFiles\\tvConfig.txt";
        File file4 = new File(fileName4);
        try {
            Scanner inputStream = new Scanner(file4);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    livingRoomTV = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    livingRoomTV = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(livingRoomTV));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void viewMainBedroomDevices() {
        //Motion Sensor
        String fileName = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");

                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomMotionSensor = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomMotionSensor = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(mainBedroomMotionSensor));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Light
        String fileName1 = "ConfigFiles\\lightConfig.txt";
        File file1 = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomLights = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomLights = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(mainBedroomLights));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Air Conditioner
        String fileName2 = "ConfigFiles\\airConConfig.txt";
        File file2 = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomAC = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomAC = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(mainBedroomAC));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Fan
        String fileName3 = "ConfigFiles\\ceilingFanConfig.txt";
        File file3 = new File(fileName3);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomFan = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomFan = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(mainBedroomFan));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //TV
        String fileName4 = "ConfigFiles\\tvConfig.txt";
        File file4 = new File(fileName4);
        try {
            Scanner inputStream = new Scanner(file4);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomTV = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomTV = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(mainBedroomTV));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Alarm Clock
        String fileName5 = "ConfigFiles\\alarmClockConfig.txt";
        File file5 = new File(fileName5);
        try {
            Scanner inputStream = new Scanner(file5);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    mainBedroomAlarmClock = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    mainBedroomAlarmClock = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(mainBedroomAlarmClock));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void viewSecondBedroomDevices() {
        //Motion Sensor
        String fileName = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomMotionSensors = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomMotionSensors = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(secondBedroomMotionSensors));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Light
        String fileName1 = "ConfigFiles\\lightConfig.txt";
        File file1 = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomLights = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomLights = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(secondBedroomLights));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Fan
        String fileName2 = "ConfigFiles\\ceilingFanConfig.txt";
        File file2 = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomFan = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomFan = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(secondBedroomFan));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Alarm Clock
        String fileName3 = "ConfigFiles\\alarmClockConfig.txt";
        File file3 = new File(fileName3);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    secondBedroomAlarmClock = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    secondBedroomAlarmClock = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(secondBedroomAlarmClock));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void viewKitchenDevices() {
        //Motion Sensor
        String fileName = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenMotionSensors = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenMotionSensors = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(kitchenMotionSensors));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Light
        String fileName1 = "ConfigFiles\\lightConfig.txt";
        File file1 = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenLights = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenLights = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(kitchenLights));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Oven
        String fileName2 = "ConfigFiles\\ovenConfig.txt";
        File file2 = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenOven = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenOven = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(kitchenOven));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Kettle
        String fileName3 = "ConfigFiles\\kettleConfig.txt";
        File file3 = new File(fileName3);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenKettle = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenKettle = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(kitchenKettle));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Coffee Machine
        String fileName4 = "ConfigFiles\\coffeeMachineConfig.txt";
        File file4 = new File(fileName4);
        try {
            Scanner inputStream = new Scanner(file4);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    kitchenCoffeeMachine = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    kitchenCoffeeMachine = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(kitchenCoffeeMachine));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void viewGarageDevices() {
        //Motion Sensor
        String fileName = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageMotionSensor = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageMotionSensor = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(garageMotionSensor));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Light
        String fileName1 = "ConfigFiles\\lightConfig.txt";
        File file1 = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageLights = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageLights = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(garageLights));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Garage Door
        String fileName2 = "ConfigFiles\\garageDoorConfig.txt";
        File file2 = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageDoor = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageDoor = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(garageDoor));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Car
        String fileName3 = "ConfigFiles\\carConfig.txt";
        File file3 = new File(fileName3);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    garageCar = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    garageCar = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(garageCar));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void viewGardenDevices() {
        //Motion Sensor
        String fileName = "ConfigFiles/motionSensorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[0].equals("GARDEN") && values[2].equals("ON")) {
                    gardenMotionSensors = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    gardenMotionSensors = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(gardenMotionSensors));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Light
        String fileName1 = "ConfigFiles\\lightConfig.txt";
        File file1 = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(file1);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[0].equals("GARDEN") && values[2].equals("ON")) {
                    gardenLights = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    gardenLights = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(gardenLights));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Sprinklers
        String fileName2 = "ConfigFiles\\sprinklerConfig.txt";
        File file2 = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(file2);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[0].equals("GARDEN") && values[2].equals("ON")) {
                    gardenSprinklers = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    gardenSprinklers = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(gardenSprinklers));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
