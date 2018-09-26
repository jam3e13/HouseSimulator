import java.util.ArrayList;
import java.util.List;

public class House {

    String deviceID;
    static String location, powerSwitch;
    int acTemp;
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
