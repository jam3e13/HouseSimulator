public class Simulator {
    static String weatherType;
    private static double temperature = 14.00;

    public static void main(String[] args) {

    }


    public static void runSimulator(String weatherType) throws InterruptedException {
        double time = 5;
        //choice will be changed to SUNNY
        if (weatherType == "SUNNY") {
            for (time = 5; time <= 5.59; time += .01)
                if (temperature < 14) {
                    temperature = 14;
                } else if (temperature >= 14) {
                    temperature += .05;
                    if (time == 5.00) {
                        System.out.println();
                        System.out.println("Time 05:00 am");
                        System.out.printf("Temperature: " + "%.2f", temperature);
                        System.out.println();
                    } else if (time <= 5.30 && time > 5.29) {
                        System.out.println();
                        System.out.println("Time 05:30 am");
                        System.out.printf("Temperature: " + "%.2f", temperature);
                        System.out.println();
                    }
                    //System.out.printf("%.2f", time);
                    Thread.sleep(1 * 1000);
                }

            for (time = 6.00; time <= 7.59; time += 0.01)
                if (temperature < 17.00 && temperature > 20.00) {
                    temperature = 17.00;
                } else if (temperature >= 17.00) {
                    temperature += 0.010;
                    if (time == 6.00) {
                        System.out.println();
                        System.out.println("Time 06:00 am");
                        System.out.printf("Temperature: " + "%.2f", temperature);
                        System.out.println();
                    } else if (time <= 6.30 && time > 6.29) {
                        System.out.println();
                        System.out.println("Time 06:30 am");
                        System.out.printf("Temperature: " + "%.2f", temperature);
                        System.out.println();
                    }
                    Thread.sleep(1 * 1000);
                }
        }
    }


}