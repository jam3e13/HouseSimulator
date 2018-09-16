import java.util.Scanner;


public class Menu {
    static int weatherValue;
    private static int choice;
    static int x;
    static String weatherType;
    private static boolean initialStart = true;


    public static void main(String args[]) throws InterruptedException {
        //Welcome message
        System.out.println("Welcome to the Autonomous House Simulator");
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
        //Displays menu second time to re-run sim with changes
        //menuDisplay();
        //User choice to run sim again
        //secondChoice();
    }

    static void menuDisplay() {
        //Menu options
        System.out.println("\n0) Exit Program");
        System.out.println("1) Run Simulation");
        System.out.println("2) Configure Simulation");
        System.out.println("3) Access Device - Not done");
    }

    static void initialChoice() throws InterruptedException {
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
                //Appliance.initialSetup();
                initialStart = false;
                //Displays menu
                menuDisplay();
                //User choice to run option
                initialChoice();
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

