import java.util.ArrayList;
import java.util.List;

public class House {

    String deviceID;
    static String location, powerSwitch;
    int acTemp;
    private ArrayList<String> listTitles;


    void setAcTemp(int acTemp) {
        this.acTemp = acTemp;
    }

    int getAcTemp() {
        return acTemp;
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


}
