import java.util.ArrayList;
import java.util.List;

public class Devices {

    private String deviceID;
    private static String location, powerSwitch;
    private int acTemp;
    private int sprinklerTemp;
    private int garageTemp;
    private int lightTemp;
    private int motionSensorTemp;
    private int carTemp;
    private int kettleTemp;
    private int coffeeMachineTemp;
    private double alarmClockTemp;
    private int alarmClockSmart;
    private static int ceilingFanTemp;
    private ArrayList<String> listTitles;

    //FIXTURES
    void setAcTemp(int acTemp) {
        this.acTemp = acTemp;
    }

    int getAcTemp() {
        return acTemp;
    }

    void setCeilingFanTemp(int ceilingFanTemp) {
        Devices.ceilingFanTemp = ceilingFanTemp;
    }

    int getCeilingFanTemp() {
        return ceilingFanTemp;
    }

    void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    String getDeviceID() {
        return deviceID;
    }


    void setLocation(String location) {
        Devices.location = location;
    }

    static String getLocation() {
        return location;
    }

    void setPowerSwitch(String powerSwitch) {
        Devices.powerSwitch = powerSwitch;
    }

    public String setPowerSwitch() {
        return powerSwitch;
    }

    static String getPowerSwitch() {
        return powerSwitch;
    }


    private List<airConditioner> listAirCon;

    void setListAirCon(List<airConditioner> list) {
        this.listAirCon = new ArrayList<airConditioner>(list);
    }

    public List<airConditioner> getListAirCon() {
        return new ArrayList<airConditioner>(this.listAirCon);
    }


    private List<ceilingFan> listCeilingFan;

    void setListCeilingFan(List<ceilingFan> list) {
        this.listCeilingFan = new ArrayList<ceilingFan>(list);
    }

    public List<ceilingFan> getListCeilingFan() {
        return new ArrayList<ceilingFan>(this.listCeilingFan);
    }

    public ArrayList<String> getListTitles() {
        return listTitles;
    }

    public void setListTitles(ArrayList<String> listTitles) {
        this.listTitles = listTitles;
    }


    static class ceilingFan {
        private String name;

        ceilingFan(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }


    static class airConditioner {
        private String name;

        airConditioner(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }


    }


    private List<garageDoor> listGarageDoor;

    void setListGarageDoor(List<garageDoor> list) {
        this.listGarageDoor = new ArrayList<>(list);
    }

    public List<garageDoor> getListGarageDoor() {
        return new ArrayList<>(this.listGarageDoor);
    }


    static class garageDoor {
        private String name;

        garageDoor(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setGarageTemp(int garageTemp) {
        this.garageTemp = garageTemp;
    }

    int getGarageTemp() {
        return garageTemp;
    }

    private List<allLights> listAllLights;

    void setListLights(List<allLights> list) {
        this.listAllLights = new ArrayList<>(list);
    }

    public List<allLights> getListLights() {
        return new ArrayList<>(this.listAllLights);
    }


    static class allLights {
        private String name;

        allLights(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setLightTemp(int lightTemp) {
        this.lightTemp = lightTemp;
    }

    int getLightTemp() {
        return lightTemp;
    }


    private List<allMotionSensors> listAllMotionSensors;

    void setListMotionSensors(List<allMotionSensors> list) {
        this.listAllMotionSensors = new ArrayList<>(list);
    }

    public List<allMotionSensors> getListMotionSensors() {
        return new ArrayList<>(this.listAllMotionSensors);
    }


    static class allMotionSensors {
        private String name;

        allMotionSensors(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setMotionSensorTemp(int motionSensorTemp) {
        this.motionSensorTemp = motionSensorTemp;
    }

    int getMotionSensorTemp() {
        return motionSensorTemp;
    }


    private List<gardenSprinkler> listGardenSprinkler;

    void setListGardenSprinkler(List<gardenSprinkler> list) {
        this.listGardenSprinkler = new ArrayList<>(list);
    }

    public List<gardenSprinkler> getListGardenSprinkler() {
        return new ArrayList<>(this.listGardenSprinkler);
    }


    static class gardenSprinkler {
        private String name;

        gardenSprinkler(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setSprinklerTemp(int sprinklerTemp) {
        this.sprinklerTemp = sprinklerTemp;
    }

    int getSprinklerTemp() {
        return sprinklerTemp;
    }
//END - FIXTURES

//APPLIANCES

    private List<garageCar> listGarageCar;

    void setListGarageCar(List<garageCar> list) {
        this.listGarageCar = new ArrayList<>(list);
    }

    public List<garageCar> getListGarageCar() {
        return new ArrayList<>(this.listGarageCar);
    }


    static class garageCar {
        private String name;

        garageCar(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setCarTemp(int carTemp) {
        this.carTemp = carTemp;
    }

    int getCarTemp() {
        return carTemp;
    }


    private List<kitchenKettle> listKitchenKettle;

    void setListKitchenKettle(List<kitchenKettle> list) {
        this.listKitchenKettle = new ArrayList<>(list);
    }

    public List<kitchenKettle> getListKitchenKettle() {
        return new ArrayList<>(this.listKitchenKettle);
    }


    static class kitchenKettle {
        private String name;

        kitchenKettle(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setKettleTemp(int kettleTemp) {
        this.kettleTemp = kettleTemp;
    }

    int getKettleTemp() {
        return kettleTemp;
    }


    private List<kitchenCoffeeMachine> listKitchenCoffeeMachine;

    void setListKitchenCoffeeMachine(List<kitchenCoffeeMachine> list) {
        this.listKitchenCoffeeMachine = new ArrayList<>(list);
    }

    public List<kitchenCoffeeMachine> getListKitchenCoffeeMachine() {
        return new ArrayList<>(this.listKitchenCoffeeMachine);
    }


    static class kitchenCoffeeMachine {
        private String name;

        kitchenCoffeeMachine(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setCoffeeMachineTemp(int coffeeMachineTemp) {
        this.coffeeMachineTemp = coffeeMachineTemp;
    }

    int getCoffeeMachineTemp() {
        return coffeeMachineTemp;
    }




    private List<roomAlarmClock> listRoomAlarmClock;

    void setListRoomAlarmClock(List<roomAlarmClock> list) {
        this.listRoomAlarmClock = new ArrayList<>(list);
    }

    public List<roomAlarmClock> getListRoomAlarmClock() {
        return new ArrayList<>(this.listRoomAlarmClock);
    }


    static class roomAlarmClock {
        private String name;

        roomAlarmClock(String name) {
            this.name = name;
        }


        String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    void setAlarmClockTemp(double alarmClockTemp) {
        this.alarmClockTemp = alarmClockTemp;
    }

    double getAlarmClockTemp() {
        return alarmClockTemp;
    }

    void setAlarmClockSmart(int alarmClockSmart) {
        this.alarmClockSmart = alarmClockSmart;
    }

    int getAlarmClockSmart() {
        return alarmClockSmart;
    }


//END - APPLIANCES

    //Main Bedroom & Second Bedroom Temp settings (-2)
    static double roomTemp() {
        double tempMainRoom;
        switch (Menu.weatherType) {
            case "SUNNY":
                tempMainRoom = Simulator.inDoorTempSetter - 1;
                break;
            case "CLOUDY":
                tempMainRoom = Simulator.inDoorTempSetter - 1;
                break;
            case "RAINY":
                tempMainRoom = Simulator.inDoorTempSetter - 2;
                break;
            default:
                tempMainRoom = Simulator.inDoorTempSetter;
                break;
        }
        return tempMainRoom;
    }

    //Living Room & Kitchen Temp settings (-3)
    static double livingRoomTemp() {
        double tempLivingRoom;
        switch (Menu.weatherType) {
            case "SUNNY":
                tempLivingRoom = Simulator.inDoorTempSetter - 1;
                break;
            case "CLOUDY":
                tempLivingRoom = Simulator.inDoorTempSetter - 2;
                break;
            case "RAINY":
                tempLivingRoom = Simulator.inDoorTempSetter - 2;
                break;
            default:
                tempLivingRoom = Simulator.inDoorTempSetter;
                break;
        }
        return tempLivingRoom;
    }

    //Garage Temp settings (-1)
    static double garageTemp() {
        double tempGarage;
        switch (Menu.weatherType) {
            case "SUNNY":
                tempGarage = Simulator.inDoorTempSetter - 1;
                break;
            case "CLOUDY":
                tempGarage = Simulator.inDoorTempSetter - 1;
                break;
            case "RAINY":
                tempGarage = Simulator.inDoorTempSetter - 1;
                break;
            default:
                tempGarage = Simulator.inDoorTempSetter;
                break;
        }
        return tempGarage;
    }

    //Garden Temp settings (+2)
    static double gardenTemps() {
        double tempGarden;
        switch (Menu.weatherType) {
            case "SUNNY":
                tempGarden = Simulator.inDoorTempSetter + 2;
                break;
            case "CLOUDY":
                tempGarden = Simulator.inDoorTempSetter - 1;
                break;
            case "RAINY":
                tempGarden = Simulator.inDoorTempSetter - 2;
                break;
            default:
                tempGarden = Simulator.inDoorTempSetter;
                break;
        }
        return tempGarden;
    }


}
