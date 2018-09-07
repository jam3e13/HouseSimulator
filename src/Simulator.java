import java.util.Random;

class Simulator {
    private static double temperature, inDoorTemp;
    static double tempChange, acTemp;
    static double time = 5;
    static String weatherChange, oldWeather;
    static boolean deviceOn;

    static void runSimulator(String weatherType) throws InterruptedException {

        do {
            time = Weather.timeCorrection();
            temperature = Weather.tempCorrection();
            tempChange = Weather.dynamicIncrease();
            dynamicWeather();
            fixtureUpdate();
            //System.out.println("\n" + time);
            if (time >= 12) {
                temperature -= tempChange;
            } else {
                temperature += tempChange;
            }
            switch (Menu.weatherType) {

                case "SUNNY":

                    if (temperature >= 14) {


                        if (time == 5.00) {
                            System.out.printf("%n" + "Time: 05:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.printf("%n" + "Time: 05:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 6.00) {
                            System.out.printf("%n" + "Time: 06:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.printf("%n" + "Time: 06:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 7.00) {
                            System.out.printf("%n" + "Time: 07:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.printf("%n" + "Time: 07:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 8.00) {
                            System.out.printf("%n" + "Time: 08:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 8.30 && time > 8.29) {
                            System.out.printf("%n" + "Time: 08:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 9.00) {
                            System.out.printf("%n" + "Time: 09:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 9.30 && time > 9.29) {
                            System.out.printf("%n" + "Time: 09:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 10.00) {
                            System.out.printf("%n" + "Time: 10:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 10.30 && time > 10.29) {
                            System.out.printf("%n" + "Time: 10:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 11.00) {
                            System.out.printf("%n" + "Time: 11:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 11.30 && time > 11.29) {
                            System.out.printf("%n" + "Time: 11:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 12.00) {
                            System.out.printf("%n" + "Time: 12:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 12.30 && time > 12.29) {
                            System.out.printf("%n" + "Time: 12:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 13.00) {
                            System.out.printf("%n" + "Time: 01:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 13.30 && time > 13.29) {
                            System.out.printf("%n" + "Time: 01:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 14.00) {
                            System.out.printf("%n" + "Time: 02:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 14.30 && time > 14.29) {
                            System.out.printf("%n" + "Time: 02:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 15.00) {
                            System.out.printf("%n" + "Time: 03:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 15.30 && time > 15.29) {
                            System.out.printf("%n" + "Time: 03:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 16.00) {
                            System.out.printf("%n" + "Time: 04:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 16.301 && time > 16.29) {
                            System.out.printf("%n" + "Time: 04:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 17.00) {
                            System.out.printf("%n" + "Time: 05:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 17.301 && time > 17.29) {
                            System.out.printf("%n" + "Time: 05:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 18.00) {
                            System.out.printf("%n" + "Time: 06:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 18.301 && time > 18.29) {
                            System.out.printf("%n" + "Time: 06:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 19.00) {
                            System.out.printf("%n" + "Time: 07:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 19.301 && time > 19.29) {
                            System.out.printf("%n" + "Time: 07:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 20.00) {
                            System.out.printf("%n" + "Time: 08:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 20.301 && time > 20.29) {
                            System.out.printf("%n" + "Time: 08:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 21.00) {
                            System.out.printf("%n" + "Time: 09:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 21.301 && time > 21.29) {
                            System.out.printf("%n" + "Time: 09:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 22.00) {
                            System.out.printf("%n" + "Time: 10:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 22.301 && time > 22.29) {
                            System.out.printf("%n" + "Time: 10:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 23.00) {
                            System.out.printf("%n" + "Time: 11:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 23.301 && time > 23.29) {
                            System.out.printf("%n" + "Time: 11:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 24.00) {
                            System.out.printf("%n" + "Time: 00:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 24.301 && time > 24.29) {
                            System.out.printf("%n" + "Time: 00:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 25.00) {
                            System.out.printf("%n" + "Time: 01:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 25.301 && time > 25.29) {
                            System.out.printf("%n" + "Time: 01:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 26.00) {
                            System.out.printf("%n" + "Time: 02:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 26.301 && time > 26.29) {
                            System.out.printf("%n" + "Time: 02:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 27.00) {
                            System.out.printf("%n" + "Time: 03:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 27.301 && time > 27.29) {
                            System.out.printf("%n" + "Time: 03:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 28.00) {
                            System.out.printf("%n" + "Time: 04:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 28.301 && time > 28.29) {
                            System.out.printf("%n" + "Time: 04:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        }
                        Thread.sleep(100);
                    }
                    break;
                case "CLOUDY":
                    if (temperature >= 15) {
                        if (time == 5.00) {
                            System.out.printf("%n" + "Time: 05:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.printf("%n" + "Time: 05:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 6.00) {
                            System.out.printf("%n" + "Time: 06:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.printf("%n" + "Time: 06:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 7.00) {
                            System.out.printf("%n" + "Time: 07:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.printf("%n" + "Time: 07:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 8.00) {
                            System.out.printf("%n" + "Time: 08:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 8.30 && time > 8.29) {
                            System.out.printf("%n" + "Time: 08:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 9.00) {
                            System.out.printf("%n" + "Time: 09:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 9.30 && time > 9.29) {
                            System.out.printf("%n" + "Time: 09:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 10.00) {
                            System.out.printf("%n" + "Time: 10:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 10.30 && time > 10.29) {
                            System.out.printf("%n" + "Time: 10:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 11.00) {
                            System.out.printf("%n" + "Time: 11:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 11.30 && time > 11.29) {
                            System.out.printf("%n" + "Time: 11:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 12.00) {
                            System.out.printf("%n" + "Time: 12:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 12.30 && time > 12.29) {
                            System.out.printf("%n" + "Time: 12:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 13.00) {
                            System.out.printf("%n" + "Time: 01:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 13.30 && time > 13.29) {
                            System.out.printf("%n" + "Time: 01:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 14.00) {
                            System.out.printf("%n" + "Time: 02:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 14.30 && time > 14.29) {
                            System.out.printf("%n" + "Time: 02:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 15.00) {
                            System.out.printf("%n" + "Time: 03:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 15.30 && time > 15.29) {
                            System.out.printf("%n" + "Time: 03:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 16.00) {
                            System.out.printf("%n" + "Time: 04:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 16.301 && time > 16.29) {
                            System.out.printf("%n" + "Time: 04:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 17.00) {
                            System.out.printf("%n" + "Time: 05:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 17.301 && time > 17.29) {
                            System.out.printf("%n" + "Time: 05:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 18.00) {
                            System.out.printf("%n" + "Time: 06:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 18.301 && time > 18.29) {
                            System.out.printf("%n" + "Time: 06:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 19.00) {
                            System.out.printf("%n" + "Time: 07:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 19.301 && time > 19.29) {
                            System.out.printf("%n" + "Time: 07:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 20.00) {
                            System.out.printf("%n" + "Time: 08:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 20.301 && time > 20.29) {
                            System.out.printf("%n" + "Time: 08:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 21.00) {
                            System.out.printf("%n" + "Time: 09:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 21.301 && time > 21.29) {
                            System.out.printf("%n" + "Time: 09:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 22.00) {
                            System.out.printf("%n" + "Time: 10:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 22.301 && time > 22.29) {
                            System.out.printf("%n" + "Time: 10:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 23.00) {
                            System.out.printf("%n" + "Time: 11:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 23.301 && time > 23.29) {
                            System.out.printf("%n" + "Time: 11:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 24.00) {
                            System.out.printf("%n" + "Time: 00:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 24.301 && time > 24.29) {
                            System.out.printf("%n" + "Time: 00:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 25.00) {
                            System.out.printf("%n" + "Time: 01:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 25.301 && time > 25.29) {
                            System.out.printf("%n" + "Time: 01:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 26.00) {
                            System.out.printf("%n" + "Time: 02:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 26.301 && time > 26.29) {
                            System.out.printf("%n" + "Time: 02:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 27.00) {
                            System.out.printf("%n" + "Time: 03:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 27.301 && time > 27.29) {
                            System.out.printf("%n" + "Time: 03:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 28.00) {
                            System.out.printf("%n" + "Time: 04:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 28.301 && time > 28.29) {
                            System.out.printf("%n" + "Time: 04:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        }
                        Thread.sleep(100);
                    }
                    break;
                case "RAINY":
                    if (temperature >= 15) {
                        if (time == 5.00) {
                            System.out.printf("%n" + "Time: 05:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.printf("%n" + "Time: 05:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 6.00) {
                            System.out.printf("%n" + "Time: 06:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.printf("%n" + "Time: 06:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 7.00) {
                            System.out.printf("%n" + "Time: 07:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.printf("%n" + "Time: 07:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 8.00) {
                            System.out.printf("%n" + "Time: 08:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 8.30 && time > 8.29) {
                            System.out.printf("%n" + "Time: 08:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 9.00) {
                            System.out.printf("%n" + "Time: 09:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 9.30 && time > 9.29) {
                            System.out.printf("%n" + "Time: 09:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 10.00) {
                            System.out.printf("%n" + "Time: 10:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 10.30 && time > 10.29) {
                            System.out.printf("%n" + "Time: 10:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 11.00) {
                            System.out.printf("%n" + "Time: 11:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 11.30 && time > 11.29) {
                            System.out.printf("%n" + "Time: 11:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 12.00) {
                            System.out.printf("%n" + "Time: 12:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 12.30 && time > 12.29) {
                            System.out.printf("%n" + "Time: 12:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 13.00) {
                            System.out.printf("%n" + "Time: 01:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 13.30 && time > 13.29) {
                            System.out.printf("%n" + "Time: 01:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 14.00) {
                            System.out.printf("%n" + "Time: 02:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 14.30 && time > 14.29) {
                            System.out.printf("%n" + "Time: 02:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 15.00) {
                            System.out.printf("%n" + "Time: 03:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 15.30 && time > 15.29) {
                            System.out.printf("%n" + "Time: 03:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 16.00) {
                            System.out.printf("%n" + "Time: 04:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 16.301 && time > 16.29) {
                            System.out.printf("%n" + "Time: 04:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 17.00) {
                            System.out.printf("%n" + "Time: 05:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 17.301 && time > 17.29) {
                            System.out.printf("%n" + "Time: 05:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 18.00) {
                            System.out.printf("%n" + "Time: 06:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 18.301 && time > 18.29) {
                            System.out.printf("%n" + "Time: 06:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 19.00) {
                            System.out.printf("%n" + "Time: 07:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 19.301 && time > 19.29) {
                            System.out.printf("%n" + "Time: 07:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 20.00) {
                            System.out.printf("%n" + "Time: 08:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 20.301 && time > 20.29) {
                            System.out.printf("%n" + "Time: 08:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 21.00) {
                            System.out.printf("%n" + "Time: 09:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 21.301 && time > 21.29) {
                            System.out.printf("%n" + "Time: 09:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 22.00) {
                            System.out.printf("%n" + "Time: 10:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 22.301 && time > 22.29) {
                            System.out.printf("%n" + "Time: 10:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 23.00) {
                            System.out.printf("%n" + "Time: 11:00 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 23.301 && time > 23.29) {
                            System.out.printf("%n" + "Time: 11:30 pm");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 24.00) {
                            System.out.printf("%n" + "Time: 00:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 24.301 && time > 24.29) {
                            System.out.printf("%n" + "Time: 00:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 25.00) {
                            System.out.printf("%n" + "Time: 01:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 25.301 && time > 25.29) {
                            System.out.printf("%n" + "Time: 01:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 26.00) {
                            System.out.printf("%n" + "Time: 02:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 26.301 && time > 26.29) {
                            System.out.printf("%n" + "Time: 02:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 27.00) {
                            System.out.printf("%n" + "Time: 03:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 27.301 && time > 27.29) {
                            System.out.printf("%n" + "Time: 03:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time == 28.00) {
                            System.out.printf("%n" + "Time: 04:00 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        } else if (time <= 28.301 && time > 28.29) {
                            System.out.printf("%n" + "Time: 04:30 am");
                            System.out.printf("%n" + "Outdoor Temperature: " + "%.2f", temperature);
                        }
                        Thread.sleep(100);
                    }
                    break;
            }
            time += 0.01;
        } while (time < 30);
    }

    private static void fixtureUpdate() {

        acTemp = Fixture.acTempSetting;

        if (acTemp < inDoorTemp && !deviceOn) {
            inDoorTemp = acTemp;
            System.out.println('\n' + Fixture.roomLocation + " Ac has turned on.");
            System.out.println(Fixture.roomLocation + " Temperature: " + inDoorTemp);
            deviceOn = true;
        } else if (acTemp == inDoorTemp) {
            inDoorTemp = acTemp;
            deviceOn = false;
        } else {
            //Indoor temp
            inDoorTemp = (temperature);
            deviceOn = false;
        }

        if (acTemp > inDoorTemp && deviceOn) {
            System.out.println('\n' + Fixture.roomLocation + " Ac has turned off.");
            deviceOn = false;
        }


    }

    private static void dynamicWeather() {

        Random rand = new Random();
        int n = rand.nextInt(1000) + 1;

        oldWeather = Menu.weatherType;

        if (n == 5) {
            weatherChange = Menu.getSimInfo();

            if (!weatherChange.equals(oldWeather)) {
                Menu.weatherType = weatherChange;
            }
        }
    }


}