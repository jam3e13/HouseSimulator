//Appliances to add:
//1. Car
//2. Oven
//3. TV
//4. Kettle
//5. Coffee Machine
//6. Vacuum

public class Appliance {
    public String itemName;
    public int number;
    public boolean applianeSwitch;
    public int roomNumber;


    public static void main(String args[]) {

    }


    static void applianceFlow() {
        livingRoom();
        mainBedroom();
        secondBedroom();
        kitchen();
        garage();
        garden();
    }

    static void initialSetup() {
        System.out.println("Appliances: ");
    }

    private static void livingRoom() {
        //Living Room Appliances
        //1. TV
        //2. Vacuum
    }

    private static void mainBedroom() {
        //Living Room Appliances
        //1. TV
    }

    private static void secondBedroom() {
        //No Appliance
    }

    private static void kitchen() {
        //Living Room Appliances
        //1. Oven
        //2. Kettle
        //3. Coffee Machine
    }

    private static void garage() {
        //No Appliance
        //1. Car
    }

    private static void garden() {
        //No Appliance
    }


}
