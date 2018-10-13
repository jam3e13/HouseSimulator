import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Clean {

    private static int choice, fixtureChoice;
    static int acTempSetting, changeSettings, ceilingFanTempSetting, garageDoorSetting, sprinklerSetting, lightSetting, motionSensorSetting;
    static String roomLocation, data, x1, x2, x3, x4, x5, x6, sprinklerMode, lightMode, updatedList, updatedList1, updatedList2, updatedList3, updatedList4, updatedList5, motionSensorMode;
    static String fixtureSwitch = "OFF";
    static String[] displayLine1, displayLine2, values, displayLine3, displayLine4, displayLine5, displayLine6;


    static void cleanUserInputs() throws FileNotFoundException, InterruptedException {

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
    }

    private static void cleanMotionSensors() throws FileNotFoundException {
        switch (roomLocation) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
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
                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
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
                break;
            }
            case "SECOND BEDROOM": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
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
                break;
            }
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
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
                break;
            }
            case "GARAGE": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
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
                break;
            }
            case "GARDEN": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allMotionSensors = new Devices();
                List<Devices.allMotionSensors> list = new ArrayList<>();
                list.add(new Devices.allMotionSensors(Devices.getLocation()));
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
                break;
            }
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
        if (roomLocation.equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices acList = new Devices();
            List<Devices.airConditioner> list = new ArrayList<>();
            list.add(new Devices.airConditioner(Devices.getLocation()));
            list.add(new Devices.airConditioner("Air Conditioner"));
            list.add(new Devices.airConditioner("ON"));
            list.add(new Devices.airConditioner("0"));
            acList.setListAirCon(list);

            updatedList1 = list.toString();
            x1 = String.valueOf((updatedList1));
            updatedList2 = Arrays.toString(displayLine2);
            x2 = String.valueOf((updatedList2));

        } else if (roomLocation.equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices acList = new Devices();
            List<Devices.airConditioner> list = new ArrayList<>();
            list.add(new Devices.airConditioner(Devices.getLocation()));
            list.add(new Devices.airConditioner("Air Conditioner"));
            list.add(new Devices.airConditioner("ON"));
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
        switch (roomLocation) {
            case "LIVING ROOM": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                list.add(new Devices.allLights(Devices.getLocation()));
                list.add(new Devices.allLights("Light"));
                list.add(new Devices.allLights("ON"));
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

                break;
            }
            case "MAIN BEDROOM": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                list.add(new Devices.allLights(Devices.getLocation()));
                list.add(new Devices.allLights("Light"));
                list.add(new Devices.allLights("ON"));
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

                break;
            }
            case "SECOND BEDROOM": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                list.add(new Devices.allLights(Devices.getLocation()));
                list.add(new Devices.allLights("Light"));
                list.add(new Devices.allLights("ON"));
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

                break;
            }
            case "KITCHEN": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                list.add(new Devices.allLights(Devices.getLocation()));
                list.add(new Devices.allLights("Light"));
                list.add(new Devices.allLights("ON"));
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

                break;
            }
            case "GARAGE": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                list.add(new Devices.allLights(Devices.getLocation()));
                list.add(new Devices.allLights("Light"));
                list.add(new Devices.allLights("ON"));
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

                break;
            }
            case "GARDEN": {
                Devices location = new Devices();
                location.setLocation(roomLocation);
                Devices allLights = new Devices();
                List<Devices.allLights> list = new ArrayList<>();
                list.add(new Devices.allLights(Devices.getLocation()));
                list.add(new Devices.allLights("Light"));
                list.add(new Devices.allLights("ON"));
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
                break;
            }
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
        if (roomLocation.equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices ceilingFanList = new Devices();
            List<Devices.ceilingFan> list = new ArrayList<>();
            list.add(new Devices.ceilingFan(Devices.getLocation()));
            list.add(new Devices.ceilingFan("Ceiling Fan"));
            list.add(new Devices.ceilingFan("ON"));
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

    private static void cleanGarageDoor() {

    }

    private static void cleanSprinklers() {
    }

    private static void cleanCar() {
    }

    private static void cleanOven() {
    }

    private static void cleanTv() {
    }

    private static void cleanKettle() {
    }

    private static void cleanCoffeeMachine() {
    }

    private static void cleanAlarmClock() {
    }


}
