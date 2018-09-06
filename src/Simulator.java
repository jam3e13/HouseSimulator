import java.util.Random;

class Simulator {
    private static double temperature;
    static double tempIncrease;
    static double time = 5;
    static String weatherChange;
    static String oldWeather;

    static void runSimulator(String weatherType) throws InterruptedException {

        do {
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = Weather.tempCorrection();
                    time = Weather.timeCorrection();
                    tempIncrease = Weather.dynamicTemp();
                    //System.out.print(temperature);
                    if (temperature >= 14) {
                        //Sets readable temperatures for time periods
                        temperature += tempIncrease;
                        //Corrects time values to next hour
                        time = Weather.timeCorrection();

                        if (time == 5.00) {
                            System.out.printf("%n" + "Time: 05:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.printf("%n" + "Time: 05:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);

                            dynamicWeather();

                        } else if (time == 6.00) {
                            System.out.printf("%n" + "Time: 06:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.printf("%n" + "Time: 06:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                            dynamicWeather();
                        } else if (time == 7.00) {
                            System.out.printf("%n" + "Time: 07:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.printf("%n" + "Time: 07:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                            dynamicWeather();
                        }
                        Thread.sleep(1000);
                    }
                    break;
                case "CLOUDY":
                    temperature = Weather.tempCorrection();
                    time = Weather.timeCorrection();
                    tempIncrease = Weather.dynamicTemp();
                    if (temperature >= 15) {
                        //Sets readable temperatures for time periods
                        temperature += tempIncrease;
                        //Corrects time values to next hour
                        time = Weather.timeCorrection();

                        if (time == 5.00) {
                            System.out.printf("%n" + "Time: 05:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.printf("%n" + "Time: 05:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);

                            dynamicWeather();

                        } else if (time == 6.00) {
                            System.out.printf("%n" + "Time: 06:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.printf("%n" + "Time: 06:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                            dynamicWeather();
                        } else if (time == 7.00) {
                            System.out.printf("%n" + "Time: 07:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.printf("%n" + "Time: 07:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                            dynamicWeather();
                        }
                        Thread.sleep(1000);
                    }
                    break;
                case "RAINY":
                    temperature = Weather.tempCorrection();
                    time = Weather.timeCorrection();
                    tempIncrease = Weather.dynamicTemp();
                    if (temperature >= 15) {
                        //Sets readable temperatures for time periods
                        temperature += tempIncrease;
                        //Corrects time values to next hour
                        time = Weather.timeCorrection();

                        if (time == 5.00) {
                            System.out.printf("%n" + "Time: 05:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.printf("%n" + "Time: 05:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);

                            dynamicWeather();

                        } else if (time == 6.00) {
                            System.out.printf("%n" + "Time: 06:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.printf("%n" + "Time: 06:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                            dynamicWeather();
                        } else if (time == 7.00) {
                            System.out.printf("%n" + "Time: 07:00 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.printf("%n" + "Time: 07:30 am");
                            System.out.printf("%n" + "Temperature: " + "%.2f", temperature);
                            dynamicWeather();
                        }
                        Thread.sleep(1000);
                    }
                    break;
            }
            time += 0.01;
        } while (time < 30);
    }

    private static void dynamicWeather() {

        Random rand = new Random();
        int n = rand.nextInt(10) + 1;

        oldWeather = Menu.weatherType;

        if (n >= 1 && n <= 5) {
            weatherChange = Menu.getSimInfo();

            if (!weatherChange.equals(oldWeather)) {
                Menu.weatherType = weatherChange;
            }
        }
    }


}