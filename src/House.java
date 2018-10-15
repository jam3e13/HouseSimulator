import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class House {

    private static String data;
    private static String[] values, displayLine1, displayLine2, displayLine3, displayLine4, displayLine5, displayLine6;

    static void viewHouseDevices() {


        System.out.println("House Contents, (ON) - Set up, (OFF) - NOT Set up.");
        viewLivingRoomDevices();
        viewMainBedroomDevices();
        viewSecondBedroomDevices();
        viewKitchenDevices();
        viewGarageDevices();
        viewGardenDevices();
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
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine1));
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
                    displayLine2= data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine2));
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
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine3));
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
                    displayLine4 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine4));
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
                    displayLine5 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine5));
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
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine1));
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
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine2));
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
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine3));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Fan
        //Needs to be coded still

        //TV
        String fileName4 = "ConfigFiles\\tvConfig.txt";
        File file4 = new File(fileName4);
        try {
            Scanner inputStream = new Scanner(file4);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine5));
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
                    displayLine6 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine6 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine6));
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
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine1));
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
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine2));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Fan
        //Still needs to be coded

        //Alarm Clock
        String fileName3 = "ConfigFiles\\alarmClockConfig.txt";
        File file3 = new File(fileName3);
        try {
            Scanner inputStream = new Scanner(file3);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine4));
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
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine1));
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
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine2));
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
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine3));
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
                    displayLine4 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine4));
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
                    displayLine5 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine5));
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
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine1));
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
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine2));
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
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine3));
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
                    displayLine4 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine4));
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
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine1));
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
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine2));
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
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            System.out.println(Arrays.toString(displayLine3));
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
