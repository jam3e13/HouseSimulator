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
                    tempIncrease = dynamicTemp();
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
                    tempIncrease = dynamicTemp();
                    System.out.print(temperature);
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
                    if (temperature < 16) {
                        temperature = 16;
                    } else if (temperature >= 16) {
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
            time += 0.1;
        }while(time < 30);




/*

        for (time = 5.00; time <= 29.59; time += .1)
            switch (weatherType) {
                case "SUNNY":
                    temperature = Weather.tempCorrection();
                    time = Weather.timeCorrection();
                    tempIncrease = dynamicTemp();
                    System.out.print(tempIncrease);
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
                    if (temperature >= 15) {
                        //Sets readable temperatures for time periods
                        temperature = dynamicTemp();
                        time = Weather.timeCorrection();
                        //Corrects time values to next hour

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
                    if (temperature < 16) {
                        temperature = 16;
                    } else if (temperature >= 16) {
                        //Sets readable temperatures for time periods
                        temperature = dynamicTemp();
                        time = Weather.timeCorrection();
                        //Corrects time values to next hour

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
                default:
                    System.out.println("Weather failed to load...");
                    break;
        }


*/
    }



    private static void dynamicWeather() {

        Random rand = new Random();
        int n = rand.nextInt(10) + 1;

        oldWeather = Menu.weatherType;

        if (n >= 1 && n <= 5) {
            weatherChange = Menu.getSimInfo();

            if (weatherChange.equals(oldWeather)) {
                System.out.println("weather not updated");
            } else {
                Menu.weatherType = weatherChange;
                System.out.println("weather updated");
            }
        }
    }

    private static double dynamicTemp() {

        switch (Menu.weatherType) {
            case "SUNNY":

                if (temperature >= 14 && temperature < 17) {
                    //3 degree increase between 5 - 6am
                    tempIncrease = .05;
                } else if (temperature >= 17 && temperature < 22) {
                    //5 degree increase between 6 - 7am
                    tempIncrease = 0.0833333333333333;
                } else if (temperature >= 22 && temperature < 26) {
                    //4 degree increase between 7 - 8am
                    tempIncrease = 0.0666666666666667;
                }
                break;
            case "CLOUDY":

                break;
            case "RAINY":

                break;
            default:
                System.out.println("dynamic temp failed...");
                break;
        }


        return tempIncrease;
    }


}