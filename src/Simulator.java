class Simulator {
    private static double temperature;


    static void runSimulator(String weatherType) throws InterruptedException {
        double time;
        switch (weatherType) {
            case "SUNNY":
                for (time = 5.00; time <= 7.59; time += .01)
                    if (temperature < 14) {
                        temperature = 14;
                    } else if (temperature >= 14) {
                        //Sets readable temperatures for time periods
                        if (temperature >= 14 && temperature < 17) {
                            //3 degree increase between 5 - 6am
                            temperature += .05;
                        } else if (temperature >= 17 && temperature < 22) {
                            //5 degree increase between 6 - 7am
                            temperature += 0.0833333333333333;
                        } else if (temperature >= 22 && temperature < 26) {
                            //4 degree increase between 7 - 8am
                            temperature += 0.0666666666666667;
                        }

                        //Corrects time values to next hour
                        if (time >= 5.59 && time < 5.61) {
                            time = 6;
                            temperature = 17;
                        } else if (time >= 6.59 && time < 6.61) {
                            time = 7;
                            temperature = 22;
                        }

                        if (time == 5.01) {
                            // ADD IN CODE TO ADD SPACES UNDER EACH LINE
                            System.out.println();
                            System.out.println("Time: 05:00 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.println();
                            System.out.println("Time: 05:30 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time == 6.01) {
                            System.out.println();
                            System.out.println("Time: 06:00 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.println();
                            System.out.println("Time: 06:30 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time == 7.00) {
                            System.out.println();
                            System.out.println("Time: 07:00 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time <= 7.30 && time > 7.29) {
                            System.out.println();
                            System.out.println("Time: 07:30 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        }
                        Thread.sleep(1000);
                    }
                break;
            case "CLOUDY":
                for (time = 5.00; time <= 5.59; time += .01)
                    if (temperature < 15) {
                        temperature = 15;
                    } else if (temperature >= 15) {
                        temperature += 0.0333333333333333;
                        if (time == 5.01) {
                            System.out.println();
                            System.out.println("Time: 05:00 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.println();
                            System.out.println("Time: 05:30 am");
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
                        if (time == 6.01) {
                            System.out.println();
                            System.out.println("Time: 06:00 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time <= 6.30 && time > 6.29) {
                            System.out.println();
                            System.out.println("Time: 06:30 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        }
                        Thread.sleep(1 * 1000);
                    }
                break;
            case "RAINY":
                for (time = 5; time <= 5.59; time += .01)
                    if (temperature < 16) {
                        temperature = 16;
                    } else if (temperature >= 16) {
                        temperature += 0.0166666666666667;
                        if (time == 5.01) {
                            System.out.println();
                            System.out.println("Time: 05:00 am");
                            System.out.printf("Temperature: " + "%.2f", temperature);
                            System.out.println();
                        } else if (time <= 5.30 && time > 5.29) {
                            System.out.println();
                            System.out.println("Time: 05:30 am");
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
                break;
            default:
                System.out.println("Weather failed to load...");
                break;
        }
    }


}