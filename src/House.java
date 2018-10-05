import java.util.ArrayList;
import java.util.List;

public class House {

    String deviceID;
    static String location, powerSwitch;
    int acTemp, sprinklerTemp, garageTemp, lightTemp, motionSensorTemp;
    static int ceilingFanTemp;
    private ArrayList<String> listTitles;
    static double tempMainRoom, tempLivingRoom, tempGarage, tempGarden;


    void setAcTemp(int acTemp) {
        this.acTemp = acTemp;
    }

    int getAcTemp() {
        return acTemp;
    }

    void setCeilingFanTemp(int ceilingFanTemp) {
        this.ceilingFanTemp = ceilingFanTemp;
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
        this.location = location;
    }

    static String getLocation() {
        return location;
    }

    void setPowerSwitch(String powerSwitch) {
        this.powerSwitch = powerSwitch;
    }

    public String setPowerSwitch() {
        return this.powerSwitch;
    }

    static String getPowerSwitch() {
        return powerSwitch;
    }


    private List<airConditioner> listAirCon;

    public void setListAirCon(List<airConditioner> list) {
        this.listAirCon = new ArrayList<airConditioner>(list);
    }

    public List<airConditioner> getListAirCon() {
        return new ArrayList<airConditioner>(this.listAirCon);
    }





    private List<ceilingFan> listCeilingFan;

    public void setListCeilingFan(List<ceilingFan> list) {
        this.listCeilingFan = new ArrayList<ceilingFan>(list);
    }

    public List<ceilingFan> getListCeilingFan() {
        return new ArrayList<ceilingFan>(this.listCeilingFan);
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

    public void setListGarageDoor(List<garageDoor> list) {
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

    public void setListLights(List<allLights> list) {
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

    public void setListMotionSensors(List<allMotionSensors> list) {
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

    public void setListGardenSprinkler(List<gardenSprinkler> list) {
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


    //Main Bedroom & Second Bedroom Temp settings (-2)
    static double roomTemp() {
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

    //Living Room & Kitchen Temp settings (-1)
    static double garageTemp() {
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

    //Living Room & Kitchen Temp settings (+2)
    static double gardenTemps() {
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
