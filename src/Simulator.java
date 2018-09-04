import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) throws InterruptedException {
        String weather;
        int choice;
        double temperature = 14.00;
        double light = 0.00;
        double time = 05.00;
        double viewableTime;


        System.out.println("0)    Exit Program");
        System.out.println("-----------------------");
        System.out.println("1)    Run Simulation");
        System.out.println("2) Configure Simulation");
        System.out.println("3)    Access Device");

        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        System.out.println(choice);

        //choice will be changed to SUNNY
        if (choice == 1) {
            for (time = 5.00; time <= 5.60; time+= 0.01)
                if (temperature >= 14.00) {
                    temperature += 0.010;
                    light += 0.010;

                    //Display area

                    System.out.printf("Time: " + "%.2f", time,  " am");
                    System.out.println();
                    System.out.printf("Temperature: " + "%.2f", temperature, "°");
                    System.out.println();
                    System.out.printf("Light at: " + "%.2f", light, "%");
                    System.out.println(" ");

                    Thread.sleep(1 * 1000);
                }
        }


    }


}