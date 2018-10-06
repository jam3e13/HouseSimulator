//Appliances to add:
//1. Car
//2. Oven
//3. TV
//4. Kettle
//5. Coffee Machine
//6. Vacuum

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Appliance {

    private static int choice, fixtureChoice;
    static String roomLocation;

    static void applianceSetUp() throws InterruptedException, FileNotFoundException {
        System.out.println("Please select a Room to set up...");
        roomDisplay();
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        do {
            if (choice == 1) {
                //LIVING ROOM
                roomLocation = "LIVING ROOM";
                System.out.println(roomLocation + " - Appliances...");

                System.out.println("\n1) TV");
                System.out.println("2) VACUUM");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 2) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1, 2 OR 0 - Exit");
                    System.out.println("\n1) TV");
                    System.out.println("2) VACUUM");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //TV
                    applianceTV();


                } else if (fixtureChoice == 2) {
                    //OVEN
                    applianceOven();


                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                }

            } else if (choice == 2) {
                //MAIN BEDROOM
                roomLocation = "MAIN BEDROOM";
                System.out.println(roomLocation + " - Appliances...");

                System.out.println("\n1) TV");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 1) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1 OR 0 - Exit");
                    System.out.println("\n1) TV");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //TV
                    applianceTV();

                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 3) {
                //KITCHEN
                roomLocation = "KITCHEN";
                System.out.println(roomLocation + " - Appliances...");

                System.out.println("\n1) OVEN");
                System.out.println("2) KETTLE");
                System.out.println("3) COFFEE MACHINE");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 3) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1, 2, 3 OR 0 - Exit");
                    System.out.println("\n1) OVEN");
                    System.out.println("2) KETTLE");
                    System.out.println("2) COFFEE MACHINE");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //OVEN
                    applianceOven();

                } else if (fixtureChoice == 2) {
                    //KETTLE
                    applianceKettle();

                } else if (fixtureChoice == 3) {
                    //COFFEE MACHINE
                    applianceCoffeeMachine();

                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                } else {
                    System.out.println("Wrong input...");
                }

            } else if (choice == 4) {
                //GARAGE
                roomLocation = "GARAGE";
                System.out.println(roomLocation + " - Appliances...");

                System.out.println("\n1) CAR");
                System.out.println("0) BACK");

                fixtureChoice = input.nextInt();

                while (fixtureChoice > 4) {
                    System.out.println("Wrong input...");
                    System.out.println("Please Enter: 1 OR 0 - Exit");
                    System.out.println("\n1) CAR");
                    System.out.println("0) BACK");
                    fixtureChoice = input.nextInt();
                }

                if (fixtureChoice == 1) {
                    //CAR
                    applianceCar();

                } else if (fixtureChoice == 0) {
                    applianceSetUp();
                } else {
                    System.out.println("Wrong input...");
                }

            }

            //Displays menu
            Menu.menuDisplay();
            //User choice to run option
            Menu.initialChoice();
        } while (choice != 0);

    }

    private static void roomDisplay() {
        //Menu options
        System.out.println("\n0) Menu");
        System.out.println("1) LIVING ROOM");
        System.out.println("2) MAIN BEDROOM");
        System.out.println("3) KITCHEN");
        System.out.println("4) GARAGE");
    }

    private static void applianceTV() {
    }

    private static void applianceOven() {
    }

    private static void applianceCar() {
        //When user enters garage car turns on automatically
    }

    private static void applianceKettle() {
    }

    private static void applianceCoffeeMachine() {
    }

}
