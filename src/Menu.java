import java.util.Scanner;


public class Menu {
    static int weatherValue;
    private static int choice;
    static String weatherType;
    private static boolean initialStart = true;


    public static void main(String args[]) throws InterruptedException {
        //Welcome message
        System.out.println("Welcome to the Autonomous House Simulator");
        //Displays menu
        menuDisplay();
        //User choice to run option
        initialChoice();
        //Displays menu second time to re-run sim with changes
        menuDisplay();
        //User choice to run sim again
        secondChoice();
    }

    private static void menuDisplay() {
        //Menu options
        System.out.println("\n0)    Exit Program");
        System.out.println("-----------------------");
        System.out.println("1)    Run Simulation");
        System.out.println("2) Configure Simulation");
        System.out.println("3)    Access Device");
    }

    private static void initialChoice() throws InterruptedException {
        //Gets user input
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        //Makes sure use inputs 0, 1, 2 or 3 only
        while (choice >= 4) {
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
        } else if (choice == 2) {
            //Configure Appliances and Fixtures
            System.out.println("Configure opening...");
            if (initialStart) {
                Fixture.initialSetup();
                Appliance.initialSetup();
                initialStart = false;
            } else {
                //Add code for second try
            }
        } else if (choice == 3) {
            //Access Device
            System.out.println("Accessing Device...");

        } else if (choice == 0) {
            //Quit program
            System.out.println("Good Bye...");
        }
    }

    private static void secondChoice() throws InterruptedException {
        //Gets user input
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        //Makes sure use inputs 0, 1, 2 or 3 only
        while (choice >= 4) {
            System.out.println("Wrong input...");
            System.out.println("Please enter only (0), (1), (2) OR (3)");
            choice = input.nextInt();
        }

        //User choices
        if (choice == 1) {
            //Run simulation
            System.out.println("Simulation Started...");
            getSimInfo();
            //Simulator simulator = new Simulator();
            Simulator.runSimulator(weatherType);
            System.out.println("Simulation Finished...");
        } else if (choice == 2) {
            //Configure Appliances and Fixtures
            System.out.println("Configure opening...");
            if (initialStart) {
                Fixture.initialSetup();
                initialStart = false;
            } else {
                //Fixture.fixtureFlow();
                //Appliance.applianceFlow();
            }
        } else if (choice == 3) {
            //Access Device
            System.out.println("Accessing Device...");

        } else if (choice == 0) {
            //Quit program
            System.out.println("Good Bye...");
        }
    }

    static String getSimInfo() {
        weatherValue = Weather.getWeather();

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

