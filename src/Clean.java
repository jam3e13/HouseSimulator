import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Clean {

    static String roomLocation, x1, x2, x3, x4, x5, x6, data, updatedList, updatedList1, updatedList2, updatedList3, updatedList4, updatedList5;
    static String[] values, displayLine, displayLine1, displayLine2, displayLine3, displayLine4, displayLine5, displayLine6;


    static void cleanUserInputs() throws FileNotFoundException {

        //Fixtures overwrite with empty user inputs
        cleanMotionSensors();
        cleanAirCon();
        cleanLights();
        cleanCeilingFan();
        cleanGarageDoor();
        cleanSprinklers();

        //Appliances overwrite with empty user inputs
        cleanCar();
        cleanOven();
        cleanTv();
        cleanKettle();
        cleanCoffeeMachine();
        cleanAlarmClock();

        System.out.println("\nConfig Files have been emptied...");
    }

    private static void cleanMotionSensors() throws FileNotFoundException {
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

                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }

                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }

                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }

                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }

                if (values[0].equals("GARDEN") && values[0].equals("GARDEN") && values[2].equals("ON")) {
                    displayLine6 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine6 = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allMotionSensors = new Devices();
            List<Devices.allMotionSensors> list = new ArrayList<>();
            list.add(new Devices.allMotionSensors("LIVING ROOM"));
            list.add(new Devices.allMotionSensors("Motion Sensor"));
            list.add(new Devices.allMotionSensors("ON"));
            list.add(new Devices.allMotionSensors("0"));
            allMotionSensors.setListMotionSensors(list);

            updatedList = list.toString();
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allMotionSensors = new Devices();
            List<Devices.allMotionSensors> list = new ArrayList<>();
            list.add(new Devices.allMotionSensors("MAIN BEDROOM"));
            list.add(new Devices.allMotionSensors("Motion Sensor"));
            list.add(new Devices.allMotionSensors("ON"));
            list.add(new Devices.allMotionSensors("0"));
            allMotionSensors.setListMotionSensors(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = list.toString();
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("SECOND BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allMotionSensors = new Devices();
            List<Devices.allMotionSensors> list = new ArrayList<>();
            list.add(new Devices.allMotionSensors("SECOND BEDROOM"));
            list.add(new Devices.allMotionSensors("Motion Sensor"));
            list.add(new Devices.allMotionSensors("ON"));
            list.add(new Devices.allMotionSensors("0"));
            allMotionSensors.setListMotionSensors(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = list.toString();
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allMotionSensors = new Devices();
            List<Devices.allMotionSensors> list = new ArrayList<>();
            list.add(new Devices.allMotionSensors("KITCHEN"));
            list.add(new Devices.allMotionSensors("Motion Sensor"));
            list.add(new Devices.allMotionSensors("ON"));
            list.add(new Devices.allMotionSensors("0"));
            allMotionSensors.setListMotionSensors(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = list.toString();
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));


        } else if (values[0].equals("GARAGE")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allMotionSensors = new Devices();
            List<Devices.allMotionSensors> list = new ArrayList<>();
            list.add(new Devices.allMotionSensors("GARAGE"));
            list.add(new Devices.allMotionSensors("Motion Sensor"));
            list.add(new Devices.allMotionSensors("ON"));
            list.add(new Devices.allMotionSensors("0"));
            allMotionSensors.setListMotionSensors(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = list.toString();
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("GARDEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allMotionSensors = new Devices();
            List<Devices.allMotionSensors> list = new ArrayList<>();
            list.add(new Devices.allMotionSensors("GARDEN"));
            list.add(new Devices.allMotionSensors("Motion Sensor"));
            list.add(new Devices.allMotionSensors("ON"));
            list.add(new Devices.allMotionSensors("0"));
            allMotionSensors.setListMotionSensors(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = list.toString();
            x6 = String.valueOf((updatedList5));

        }

        PrintWriter pw = new PrintWriter("ConfigFiles/motionSensorConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x2).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x3).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x4).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x5).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x6).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles/motionSensorConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void cleanAirCon() throws FileNotFoundException {
        String fileName = "ConfigFiles\\airConConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }

                if (values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices acList = new Devices();
            List<Devices.airConditioner> list = new ArrayList<>();
            list.add(new Devices.airConditioner("MAIN BEDROOM"));
            list.add(new Devices.airConditioner("Air Conditioner"));
            list.add(new Devices.airConditioner("OFF"));
            list.add(new Devices.airConditioner("0"));
            acList.setListAirCon(list);

            updatedList1 = list.toString();
            x1 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList2));

        } else if (values[0].equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices acList = new Devices();
            List<Devices.airConditioner> list = new ArrayList<>();
            list.add(new Devices.airConditioner("LIVING ROOM"));
            list.add(new Devices.airConditioner("Air Conditioner"));
            list.add(new Devices.airConditioner("OFF"));
            list.add(new Devices.airConditioner("0"));
            acList.setListAirCon(list);

            updatedList1 = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList1));
            updatedList2 = list.toString();
            x2 = String.valueOf((updatedList2));
        }

        PrintWriter pw = new PrintWriter("ConfigFiles\\airConConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\airConConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanLights() throws FileNotFoundException {
        String fileName = "ConfigFiles\\lightConfig.txt";
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
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine2 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine2 = data.split(", ");
                }
                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine4 = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine4 = data.split(", ");
                }
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine5 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine5 = data.split(", ");
                }
                if (values[0].equals("GARDEN") && values[0].equals("GARDEN") && values[2].equals("ON")) {
                    displayLine6 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine6 = data.split(", ");
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allLights = new Devices();
            List<Devices.allLights> list = new ArrayList<>();
            list.add(new Devices.allLights("LIVING ROOM"));
            list.add(new Devices.allLights("Light"));
            list.add(new Devices.allLights("OFF"));
            list.add(new Devices.allLights("0"));
            allLights.setListLights(list);

            updatedList = list.toString();
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allLights = new Devices();
            List<Devices.allLights> list = new ArrayList<>();
            list.add(new Devices.allLights("MAIN BEDROOM"));
            list.add(new Devices.allLights("Light"));
            list.add(new Devices.allLights("OFF"));
            list.add(new Devices.allLights("0"));
            allLights.setListLights(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = list.toString();
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("SECOND BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allLights = new Devices();
            List<Devices.allLights> list = new ArrayList<>();
            list.add(new Devices.allLights("SECOND BEDROOM"));
            list.add(new Devices.allLights("Light"));
            list.add(new Devices.allLights("OFF"));
            list.add(new Devices.allLights("0"));
            allLights.setListLights(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = list.toString();
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allLights = new Devices();
            List<Devices.allLights> list = new ArrayList<>();
            list.add(new Devices.allLights("KITCHEN"));
            list.add(new Devices.allLights("Light"));
            list.add(new Devices.allLights("OFF"));
            list.add(new Devices.allLights("0"));
            allLights.setListLights(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = list.toString();
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("GARAGE")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allLights = new Devices();
            List<Devices.allLights> list = new ArrayList<>();
            list.add(new Devices.allLights("GARAGE"));
            list.add(new Devices.allLights("Light"));
            list.add(new Devices.allLights("OFF"));
            list.add(new Devices.allLights("0"));
            allLights.setListLights(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = list.toString();
            x5 = String.valueOf((updatedList4));
            updatedList5 = Arrays.toString(displayLine6);
            x6 = String.valueOf((updatedList5));

        } else if (values[0].equals("GARDEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices allLights = new Devices();
            List<Devices.allLights> list = new ArrayList<>();
            list.add(new Devices.allLights("GARDEN"));
            list.add(new Devices.allLights("Light"));
            list.add(new Devices.allLights("OFF"));
            list.add(new Devices.allLights("0"));
            allLights.setListLights(list);

            updatedList = Arrays.toString(displayLine1);
            x1 = String.valueOf((updatedList));
            updatedList1 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine3);
            x3 = String.valueOf((updatedList2));
            updatedList3 = Arrays.toString(displayLine4);
            x4 = String.valueOf((updatedList3));
            updatedList4 = Arrays.toString(displayLine5);
            x5 = String.valueOf((updatedList4));
            updatedList5 = list.toString();
            x6 = String.valueOf((updatedList5));

        }


        PrintWriter pw = new PrintWriter("ConfigFiles\\lightConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x2).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x3).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x4).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x5).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x6).append("\n");


        try {
            Files.write(Paths.get("ConfigFiles\\lightConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanCeilingFan() throws FileNotFoundException {
        String fileName = "ConfigFiles\\ceilingFanConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices ceilingFanList = new Devices();
            List<Devices.ceilingFan> list = new ArrayList<>();
            list.add(new Devices.ceilingFan("LIVING ROOM"));
            list.add(new Devices.ceilingFan("Ceiling Fan"));
            list.add(new Devices.ceilingFan("OFF"));
            list.add(new Devices.ceilingFan("0"));
            ceilingFanList.setListCeilingFan(list);

            updatedList2 = list.toString();
            x2 = String.valueOf((updatedList2));

        }
        PrintWriter pw = new PrintWriter("ConfigFiles\\ceilingFanConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\ceilingFanConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanGarageDoor() throws FileNotFoundException {
        String fileName = "ConfigFiles\\garageDoorConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("GARAGE")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices garageDoorList = new Devices();
            List<Devices.garageDoor> list = new ArrayList<>();
            list.add(new Devices.garageDoor("GARAGE"));
            list.add(new Devices.garageDoor("Garage Door"));
            list.add(new Devices.garageDoor("OFF"));
            list.add(new Devices.garageDoor("0"));
            garageDoorList.setListGarageDoor(list);

            updatedList2 = list.toString();
            x2 = String.valueOf((updatedList2));

        }
        PrintWriter pw = new PrintWriter("ConfigFiles\\garageDoorConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\garageDoorConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void cleanSprinklers() throws FileNotFoundException {
        String fileName = "ConfigFiles\\sprinklerConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARDEN") && values[0].equals("GARDEN") && values[2].equals("ON")) {
                    displayLine3 = data.split(", ");
                } else if (values[0].equals("GARDEN") && values[2].equals("OFF")) {
                    displayLine3 = data.split(", ");
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if (values[0].equals("GARDEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices gardenSprinkler = new Devices();
            List<Devices.gardenSprinkler> list = new ArrayList<>();
            list.add(new Devices.gardenSprinkler("GARDEN"));
            list.add(new Devices.gardenSprinkler("Sprinkler"));
            list.add(new Devices.gardenSprinkler("OFF"));
            list.add(new Devices.gardenSprinkler("0"));
            gardenSprinkler.setListGardenSprinkler(list);

            updatedList2 = list.toString();
            x2 = String.valueOf((updatedList2));
        }

        PrintWriter pw = new PrintWriter("ConfigFiles\\sprinklerConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\sprinklerConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanCar() throws FileNotFoundException {
        String fileName = "ConfigFiles\\carConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("GARAGE") && values[0].equals("GARAGE") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                } else if (values[0].equals("GARAGE") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("GARAGE")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices garageCar = new Devices();
            List<Devices.garageCar> list = new ArrayList<>();
            list.add(new Devices.garageCar("GARAGE"));
            list.add(new Devices.garageCar("Car"));
            list.add(new Devices.garageCar("OFF"));
            list.add(new Devices.garageCar("0"));
            garageCar.setListGarageCar(list);
            updatedList = list.toString();
            x2 = String.valueOf((updatedList));
        }
        PrintWriter pw = new PrintWriter("ConfigFiles\\carConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\carConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanOven() throws FileNotFoundException {
        String fileName = "ConfigFiles\\ovenConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices kitchenOven = new Devices();
            List<Devices.kitchenOven> list = new ArrayList<>();
            list.add(new Devices.kitchenOven("KITCHEN"));
            list.add(new Devices.kitchenOven("Oven"));
            list.add(new Devices.kitchenOven("OFF"));
            list.add(new Devices.kitchenOven("0"));
            list.add(new Devices.kitchenOven("0"));
            list.add(new Devices.kitchenOven("0"));
            list.add(new Devices.kitchenOven("0"));
            list.add(new Devices.kitchenOven("0"));
            list.add(new Devices.kitchenOven("0"));
            kitchenOven.setListKitchenOven(list);
            updatedList = list.toString();
            x2 = String.valueOf((updatedList));
        }

        PrintWriter pw = new PrintWriter("ConfigFiles\\ovenConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\ovenConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanTv() throws FileNotFoundException {
        String fileName = "ConfigFiles\\tvConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("LIVING ROOM") && values[0].equals("LIVING ROOM") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                } else if (values[0].equals("LIVING ROOM") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomTv = new Devices();
            List<Devices.roomTv> list = new ArrayList<>();
            list.add(new Devices.roomTv("LIVING ROOM"));
            list.add(new Devices.roomTv("TV"));
            list.add(new Devices.roomTv("OFF"));
            list.add(new Devices.roomTv("0"));
            roomTv.setListRoomTv(list);

            updatedList = list.toString();
            x1 = String.valueOf((updatedList));

            updatedList1 = Arrays.toString(displayLine1);
            x2 = String.valueOf((updatedList1));

        } else if (values[0].equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomTv = new Devices();
            List<Devices.roomTv> list = new ArrayList<>();
            list.add(new Devices.roomTv("MAIN BEDROOM"));
            list.add(new Devices.roomTv("TV"));
            list.add(new Devices.roomTv("OFF"));
            list.add(new Devices.roomTv("0"));
            roomTv.setListRoomTv(list);

            updatedList = Arrays.toString(displayLine);
            x1 = String.valueOf((updatedList));

            updatedList1 = list.toString();
            x2 = String.valueOf((updatedList1));

        }
        PrintWriter pw = new PrintWriter("ConfigFiles\\tvConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\tvConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanKettle() throws FileNotFoundException {
        String fileName = "ConfigFiles\\kettleConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices kitchenKettle = new Devices();
            List<Devices.kitchenKettle> list = new ArrayList<>();
            list.add(new Devices.kitchenKettle("KITCHEN"));
            list.add(new Devices.kitchenKettle("Kettle"));
            list.add(new Devices.kitchenKettle("OFF"));
            list.add(new Devices.kitchenKettle("0"));
            kitchenKettle.setListKitchenKettle(list);
            updatedList = list.toString();
            x2 = String.valueOf((updatedList));
        }

        PrintWriter pw = new PrintWriter("ConfigFiles\\kettleConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\kettleConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanCoffeeMachine() throws FileNotFoundException {
        String fileName = "ConfigFiles\\coffeeMachineConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("KITCHEN") && values[0].equals("KITCHEN") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                } else if (values[0].equals("KITCHEN") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices kitchenCoffeeMachine = new Devices();
            List<Devices.kitchenCoffeeMachine> list = new ArrayList<>();
            list.add(new Devices.kitchenCoffeeMachine("KITCHEN"));
            list.add(new Devices.kitchenCoffeeMachine("Coffee Machine"));
            list.add(new Devices.kitchenCoffeeMachine("OFF"));
            list.add(new Devices.kitchenCoffeeMachine("0"));
            //Set list
            kitchenCoffeeMachine.setListKitchenCoffeeMachine(list);
            updatedList = list.toString();
            x2 = String.valueOf((updatedList));
        }
        PrintWriter pw = new PrintWriter("ConfigFiles\\coffeeMachineConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\coffeeMachineConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cleanAlarmClock() throws FileNotFoundException {
        String fileName = "ConfigFiles\\alarmClockConfig.txt";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                data = inputStream.nextLine();
                values = data.split(",");
                if (values[0].equals("MAIN BEDROOM") && values[0].equals("MAIN BEDROOM") && values[2].equals("ON")) {
                    displayLine = data.split(", ");
                } else if (values[0].equals("MAIN BEDROOM") && values[2].equals("OFF")) {
                    displayLine = data.split(", ");
                }

                if (values[0].equals("SECOND BEDROOM") && values[0].equals("SECOND BEDROOM") && values[2].equals("ON")) {
                    displayLine1 = data.split(", ");
                } else if (values[0].equals("SECOND BEDROOM") && values[2].equals("OFF")) {
                    displayLine1 = data.split(", ");
                }
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (values[0].equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomAlarmClock = new Devices();
            List<Devices.roomAlarmClock> list = new ArrayList<>();
            list.add(new Devices.roomAlarmClock("MAIN BEDROOM"));
            list.add(new Devices.roomAlarmClock("Alarm Clock"));
            list.add(new Devices.roomAlarmClock("OFF"));
            list.add(new Devices.roomAlarmClock("0"));
            list.add(new Devices.roomAlarmClock("0"));
            roomAlarmClock.setListRoomAlarmClock(list);

            updatedList = list.toString();
            x1 = String.valueOf((updatedList));

            updatedList1 = Arrays.toString(displayLine1);
            x2 = String.valueOf((updatedList1));

        } else if (values[0].equals("SECOND BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomAlarmClock = new Devices();
            List<Devices.roomAlarmClock> list = new ArrayList<>();
            list.add(new Devices.roomAlarmClock("SECOND BEDROOM"));
            list.add(new Devices.roomAlarmClock("Alarm Clock"));
            list.add(new Devices.roomAlarmClock("OFF"));
            list.add(new Devices.roomAlarmClock("0"));
            list.add(new Devices.roomAlarmClock("0"));
            roomAlarmClock.setListRoomAlarmClock(list);

            updatedList = Arrays.toString(displayLine);
            x1 = String.valueOf((updatedList));

            updatedList1 = list.toString();
            x2 = String.valueOf((updatedList1));
        }
        PrintWriter pw = new PrintWriter("ConfigFiles\\alarmClockConfig.txt");
        pw.close();

        StringBuilder sb = new StringBuilder();

        sb.append(x1).append("\n");
        sb.append(System.lineSeparator());
        sb.append(x2).append("\n");

        try {
            Files.write(Paths.get("ConfigFiles\\alarmClockConfig.txt"), sb.toString().replace("[", "").replace("]", "").replace(", ", ",").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
