import java.io.FileNotFoundException;
import java.util.Scanner;


public class Menu {
    static int x;
    static String weatherType;


    public static void main(String args[]) throws InterruptedException, FileNotFoundException {
        //Welcome message
        System.out.println("Welcome to the Autonomous Devices Simulator");
        System.out.println("\n" + "Please Enter the simulation run speed");
        System.out.println("1) Normal Speed");
        System.out.println("2) Test Speed");

        Scanner input = new Scanner(System.in);
        int simSpeed = input.nextInt();
        //Makes sure user inputs 1 or 2 only
        while (simSpeed >= 3) {
            System.out.println("Wrong input...");
            System.out.println("Please enter only (0), (1)");
            simSpeed = input.nextInt();
        }

        if (simSpeed == 1) {
            x = 1000;
        } else if (simSpeed == 2) {
            x = 100;
        }

        //Displays menu
        menuDisplay();
        //User choice to run option
        initialChoice();
    }

    static void menuDisplay() {
        //Menu options
        System.out.println("\n0) Exit Program");
        System.out.println("1) Run Simulation");
        System.out.println("2) Configure Simulation");
        System.out.println("3) House Contents");
    }

    static void initialChoice() throws InterruptedException, FileNotFoundException {
        //Gets user input
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        //Makes sure use inputs 0, 1 or 2 only
        while (choice > 3) {
            System.out.println("Wrong input...");
            System.out.println("Please enter only (0), (1), (2) OR (3)");
            choice = input.nextInt();
        }

        //User choices
        if (choice == 1) {
            //Run simulation
            System.out.println("Simulation Started...");
            getSimInfo();
            Simulator.runSimulator(weatherType);
            System.out.println("Simulation Finished...");
            //Displays menu
            menuDisplay();
            //User choice to run option
            initialChoice();
        } else if (choice == 2) {
            //Configure Appliances and Fixtures
            System.out.println("Configure opening...");

            System.out.println("1) Fixtures");
            System.out.println("2) Appliances");
            System.out.println("3) Wipe Config Files Clean");
            System.out.println("0) Back");
            int configChoice = input.nextInt();

            if (configChoice == 1) {
                Fixture.fixtureSetUp();
            } else if (configChoice == 2) {
                Appliance.applianceSetUp();
            } else if (configChoice == 3) {
                System.out.println("Are you sure you want to erase previous user inputs?");
                System.out.println("1) - Continue");
                System.out.println("0) - Back");
                int eraseChoice = input.nextInt();
                if (eraseChoice == 1) {
                    Clean.cleanUserInputs();
                } else if (eraseChoice == 2) {
                    //Displays menu
                    menuDisplay();
                    //User choice to run option
                    initialChoice();
                }

                while (eraseChoice > 2) {
                    System.out.println("Wrong input...");
                    System.out.println("Please enter only (1) OR (0)");
                    eraseChoice = input.nextInt();
                }
            } else if (configChoice == 0) {
                //Displays menu
                menuDisplay();
                //User choice to run option
                initialChoice();
            }

            while (configChoice > 3) {
                System.out.println("Wrong input...");
                System.out.println("Please enter only (0), (1), (2) OR (3)");
                configChoice = input.nextInt();
            }
            //Displays menu
            menuDisplay();
            //User choice to run option
            initialChoice();

        } else if (choice == 3) {
            House.viewHouseDevices();
            //Displays menu
            menuDisplay();
            //User choice to run option
            initialChoice();
        } else if (choice == 0) {
            //Quit program
            System.out.println("Good Bye...");
        }
    }

    static String getSimInfo() {
        int weatherValue = Weather.getWeather();

        if (weatherValue >= 1 && weatherValue <= 5) {
            weatherType = "SUNNY";
        } else if (weatherValue >= 6 && weatherValue <= 8) {
            weatherType = "CLOUDY";
        } else {
            weatherType = "RAINY";
        }

        System.out.println('\n' + "Current weather: " + weatherType);

        return weatherType;
    }
}

