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

    static String roomLocation, x1, x2, x3, x4, x5, x6, updatedList, updatedList1, updatedList2, updatedList3, updatedList4, updatedList5;
    static String[] displayLine, displayLine1, displayLine2, displayLine3, displayLine4, displayLine5, displayLine6;


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

    private static void cleanGarageDoor() throws FileNotFoundException {
        if (roomLocation.equals("GARAGE")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices garageDoorList = new Devices();
            List<Devices.garageDoor> list = new ArrayList<>();
            list.add(new Devices.garageDoor(Devices.getLocation()));
            list.add(new Devices.garageDoor("Garage Door"));
            list.add(new Devices.garageDoor("ON"));
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
        if (roomLocation.equals("GARDEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices gardenSprinkler = new Devices();
            List<Devices.gardenSprinkler> list = new ArrayList<>();
            list.add(new Devices.gardenSprinkler(Devices.getLocation()));
            list.add(new Devices.gardenSprinkler("Sprinkler"));
            list.add(new Devices.gardenSprinkler("ON"));
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
        if (roomLocation.equals("GARAGE")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices garageCar = new Devices();
            List<Devices.garageCar> list = new ArrayList<>();
            list.add(new Devices.garageCar(Devices.getLocation()));
            list.add(new Devices.garageCar("Car"));
            list.add(new Devices.garageCar("ON"));
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
        if (roomLocation.equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices kitchenOven = new Devices();
            List<Devices.kitchenOven> list = new ArrayList<>();
            list.add(new Devices.kitchenOven(Devices.getLocation()));
            list.add(new Devices.kitchenOven("Oven"));
            list.add(new Devices.kitchenOven("ON"));
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
        if (roomLocation.equals("LIVING ROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomTv = new Devices();
            List<Devices.roomTv> list = new ArrayList<>();
            list.add(new Devices.roomTv(Devices.getLocation()));
            list.add(new Devices.roomTv("TV"));
            list.add(new Devices.roomTv("ON"));
            list.add(new Devices.roomTv("0"));
            roomTv.setListRoomTv(list);

            updatedList = list.toString();
            x1 = String.valueOf((updatedList));

            updatedList1 = Arrays.toString(displayLine1);
            x2 = String.valueOf((updatedList1));

        } else if (roomLocation.equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomTv = new Devices();
            List<Devices.roomTv> list = new ArrayList<>();
            list.add(new Devices.roomTv(Devices.getLocation()));
            list.add(new Devices.roomTv("TV"));
            list.add(new Devices.roomTv("ON"));
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
        if (roomLocation.equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices kitchenKettle = new Devices();
            List<Devices.kitchenKettle> list = new ArrayList<>();
            list.add(new Devices.kitchenKettle(Devices.getLocation()));
            list.add(new Devices.kitchenKettle("Kettle"));
            list.add(new Devices.kitchenKettle("ON"));
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
        if (roomLocation.equals("KITCHEN")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices kitchenCoffeeMachine = new Devices();
            List<Devices.kitchenCoffeeMachine> list = new ArrayList<>();
            list.add(new Devices.kitchenCoffeeMachine(Devices.getLocation()));
            list.add(new Devices.kitchenCoffeeMachine("Coffee Machine"));
            list.add(new Devices.kitchenCoffeeMachine("ON"));
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
        if (roomLocation.equals("MAIN BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomAlarmClock = new Devices();
            List<Devices.roomAlarmClock> list = new ArrayList<>();
            list.add(new Devices.roomAlarmClock(Devices.getLocation()));
            list.add(new Devices.roomAlarmClock("Alarm Clock"));
            list.add(new Devices.roomAlarmClock("ON"));
            list.add(new Devices.roomAlarmClock("0"));
            list.add(new Devices.roomAlarmClock("0"));
            roomAlarmClock.setListRoomAlarmClock(list);

            updatedList = list.toString();
            x1 = String.valueOf((updatedList));

            updatedList1 = Arrays.toString(displayLine1);
            x2 = String.valueOf((updatedList1));

        } else if (roomLocation.equals("SECOND BEDROOM")) {
            Devices location = new Devices();
            location.setLocation(roomLocation);
            Devices roomAlarmClock = new Devices();
            List<Devices.roomAlarmClock> list = new ArrayList<>();
            list.add(new Devices.roomAlarmClock(Devices.getLocation()));
            list.add(new Devices.roomAlarmClock("Alarm Clock"));
            list.add(new Devices.roomAlarmClock("ON"));
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
