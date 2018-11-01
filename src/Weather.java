import java.util.Random;

class Weather {
    static int weatherValue;

    static int getWeather() {
        Random rand = new Random();
        int n = rand.nextInt(10) + 1;

        if (n >= 1 && n <= 5) {
            weatherValue = 1;
        } else if (n >= 6 && n <= 8) {
            weatherValue = 2;
        } else {
            weatherValue = 3;
        }
        return n;
    }


    static double getTemperature() {
        int temperature = 0;
        switch (Menu.weatherType) {
            case "SUNNY":

                if (Simulator.time.getHour() == 1) {
                    //1:00am
                    temperature = 18;
                } else if (Simulator.time.getHour() == 2) {
                    //2:00am
                    temperature = 17;
                } else if (Simulator.time.getHour() == 3) {
                    //3:00am
                    temperature = 16;
                } else if (Simulator.time.getHour() == 4) {
                    //4:00am
                    temperature = 15;
                } else if (Simulator.time.getHour() == 5) {
                    //5:00am
                    temperature = 14;
                } else if (Simulator.time.getHour() == 6) {
                    //6:00am
                    temperature = 17;
                } else if (Simulator.time.getHour() == 7) {
                    //7:00am
                    temperature = 22;
                } else if (Simulator.time.getHour() == 8) {
                    //8:00am
                    temperature = 26;
                } else if (Simulator.time.getHour() == 9) {
                    //9:00am
                    temperature = 27;
                } else if (Simulator.time.getHour() == 10) {
                    //10:00am
                    temperature = 28;
                } else if (Simulator.time.getHour() == 11) {
                    //11:00am
                    temperature = 29;
                } else if (Simulator.time.getHour() == 12) {
                    //12:00pm
                    temperature = 30;
                } else if (Simulator.time.getHour() == 13) {
                    //1:00pm
                    temperature = 30;
                } else if (Simulator.time.getHour() == 14) {
                    //2:00pm
                    temperature = 29;
                } else if (Simulator.time.getHour() == 15) {
                    //3:00pm
                    temperature = 28;
                } else if (Simulator.time.getHour() == 16) {
                    //4:00pm
                    temperature = 27;
                } else if (Simulator.time.getHour() == 17) {
                    //5:00pm
                    temperature = 26;
                } else if (Simulator.time.getHour() == 18) {
                    //6:00pm
                    temperature = 25;
                } else if (Simulator.time.getHour() == 19) {
                    //7:00pm
                    temperature = 24;
                } else if (Simulator.time.getHour() == 20) {
                    //8:00pm
                    temperature = 23;
                } else if (Simulator.time.getHour() == 21) {
                    //9:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 22) {
                    //10:00pm
                    temperature = 21;
                } else if (Simulator.time.getHour() == 23) {
                    //11:00pm
                    temperature = 20;
                } else if (Simulator.time.getHour() == 0) {
                    //12:00am
                    temperature = 19;
                }
                break;
            case "CLOUDY":
                if (Simulator.time.getHour() == 1) {
                    //1:00am
                    temperature = 19;
                } else if (Simulator.time.getHour() == 2) {
                    //2:00am
                    temperature = 18;
                } else if (Simulator.time.getHour() == 3) {
                    //3:00am
                    temperature = 17;
                } else if (Simulator.time.getHour() == 4) {
                    //4:00am
                    temperature = 16;
                } else if (Simulator.time.getHour() == 5 ) {
                    //5:00am
                    temperature = 15;
                } else if (Simulator.time.getHour() == 6) {
                    //6:00am
                    temperature = 17;
                } else if (Simulator.time.getHour() == 7) {
                    //7:00am
                    temperature = 21;
                } else if (Simulator.time.getHour() == 8) {
                    //8:00am
                    temperature = 23;
                } else if (Simulator.time.getHour() == 9) {
                    //9:00am
                    temperature = 25;
                } else if (Simulator.time.getHour() == 10) {
                    //10:00am
                    temperature = 26;
                } else if (Simulator.time.getHour() == 11) {
                    //11:00am
                    temperature = 27;
                } else if (Simulator.time.getHour() == 12) {
                    //12:00pm
                    temperature = 28;
                } else if (Simulator.time.getHour() == 13) {
                    //1:00pm
                    temperature = 28;
                } else if (Simulator.time.getHour() == 14) {
                    //2:00pm
                    temperature = 27;
                } else if (Simulator.time.getHour() == 15) {
                    //3:00pm
                    temperature = 26;
                } else if (Simulator.time.getHour() == 16) {
                    //4:00pm
                    temperature = 25;
                } else if (Simulator.time.getHour() == 17) {
                    //5:00pm
                    temperature = 24;
                } else if (Simulator.time.getHour() == 18) {
                    //6:00pm
                    temperature = 23;
                } else if (Simulator.time.getHour() == 19) {
                    //7:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 20) {
                    //8:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 21) {
                    //9:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 22) {
                    //10:00pm
                    temperature = 21;
                } else if (Simulator.time.getHour() == 23) {
                    //11:00pm
                    temperature = 21;
                } else if (Simulator.time.getHour() == 0) {
                    //12:00am
                    temperature = 20;
                }
                break;
            case "RAINY":
                if (Simulator.time.getHour() == 1) {
                    //1:00am
                    temperature = 19;
                } else if (Simulator.time.getHour() == 2) {
                    //2:00am
                    temperature = 18;
                } else if (Simulator.time.getHour() == 3) {
                    //3:00am
                    temperature = 18;
                } else if (Simulator.time.getHour() == 4) {
                    //4:00am
                    temperature = 17;
                } else if (Simulator.time.getHour() == 5) {
                    //5:00am
                    temperature = 16;
                } else if (Simulator.time.getHour() == 6) {
                    //6:00am
                    temperature = 17;
                } else if (Simulator.time.getHour() == 7) {
                    //7:00am
                    temperature = 19;
                } else if (Simulator.time.getHour() == 8) {
                    //8:00am
                    temperature = 20;
                } else if (Simulator.time.getHour() == 9) {
                    //9:00am
                    temperature = 22;
                } else if (Simulator.time.getHour() == 10) {
                    //10:00am
                    temperature = 23;
                } else if (Simulator.time.getHour() == 11) {
                    //11:00am
                    temperature = 25;
                } else if (Simulator.time.getHour() == 12) {
                    //12:00pm
                    temperature = 26;
                } else if (Simulator.time.getHour() == 13) {
                    //1:00pm
                    temperature = 26;
                } else if (Simulator.time.getHour() == 14) {
                    //2:00pm
                    temperature = 25;
                } else if (Simulator.time.getHour() == 15) {
                    //3:00pm
                    temperature = 24;
                } else if (Simulator.time.getHour() == 16) {
                    //4:00pm
                    temperature = 24;
                } else if (Simulator.time.getHour() == 17) {
                    //5:00pm
                    temperature = 23;
                } else if (Simulator.time.getHour() == 18) {
                    //6:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 19) {
                    //7:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 20) {
                    //8:00pm
                    temperature = 22;
                } else if (Simulator.time.getHour() == 21) {
                    //9:00pm
                    temperature = 21;
                } else if (Simulator.time.getHour() == 22) {
                    //10:00pm
                    temperature = 21;
                } else if (Simulator.time.getHour() == 23) {
                    //11:00pm
                    temperature = 20;
                } else if (Simulator.time.getHour() == 0) {
                    //12:00am
                    temperature = 19;
                }
                break;
        }
        return temperature;
    }

    static double temperatureAdjust() {
        double tempChange = 0;
        switch (Menu.weatherType) {
            case "SUNNY":
                if (Simulator.time.getHour() > 4.99 && Simulator.time.getHour() < 5.99) {
                    //3 degree increase between 5 - 6am
                    tempChange += 0.05;
                } else if (Simulator.time.getHour() > 5.99 && Simulator.time.getHour() < 6.99) {
                    //5 degree increase between 6 - 7am
                    tempChange += 0.0833333333333333;
                } else if (Simulator.time.getHour() > 6.99 && Simulator.time.getHour() < 7.99) {
                    //4 degree increase between 7 - 8am
                    tempChange += 0.0666666666666667;
                } else if (Simulator.time.getHour() > 7.99 && Simulator.time.getHour() < 8.99) {
                    //1 degree increase between 8 - 9am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 8.99 && Simulator.time.getHour() < 9.99) {
                    //1 degree increase between 9 - 10am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 9.99 && Simulator.time.getHour() < 10.99) {
                    //1 degree increase between 10 - 11am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 10.99 && Simulator.time.getHour() < 11.99) {
                    //1 degree increase between 11am - 12pm
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 11.99 && Simulator.time.getHour() < 12.99) {
                    //0 degree between 12 - 1pm
                    tempChange += 0;
                } else if (Simulator.time.getHour() > 12.99 && Simulator.time.getHour() < 13.99) {
                    //1 degree decrease between 1 - 2pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 13.99 && Simulator.time.getHour() < 14.99) {
                    //1 degree decrease between 2 - 3pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 14.99 && Simulator.time.getHour() < 15.99) {
                    //1 degree decrease between 3 - 4pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 15.99 && Simulator.time.getHour() < 16.99) {
                    //1 degree decrease between 4 - 5pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 16.99 && Simulator.time.getHour() < 17.99) {
                    //1 degree decrease between 5 - 6pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 17.99 && Simulator.time.getHour() < 18.99) {
                    //1 degree decrease between 6 - 7pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 18.99 && Simulator.time.getHour() < 19.99) {
                    //1 degree decrease between 7 - 8pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 19.99 && Simulator.time.getHour() < 20.99) {
                    //1 degree decrease between 8 - 9pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 20.99 && Simulator.time.getHour() < 21.99) {
                    //1 degree decrease between 9 - 10pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 21.99 && Simulator.time.getHour() < 22.99) {
                    //1 degree decrease between 10 - 11pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 22.99 && Simulator.time.getHour() < 23.99) {
                    //1 degree decrease between 11 - 12pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 23.99 && Simulator.time.getHour() < 24.99) {
                    //1 degree decrease between 12 - 1am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 24.99 && Simulator.time.getHour() < 25.99) {
                    //1 degree decrease between 1 - 2am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 25.99 && Simulator.time.getHour() < 26.99) {
                    //1 degree decrease between 2 - 3am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 26.99 && Simulator.time.getHour() < 27.99) {
                    //1 degree decrease between 3 - 4am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 27.99 && Simulator.time.getHour() < 28.99) {
                    //1 degree decrease between 4 - 4:59am
                    tempChange -= 0.0166666666666667;
                }
                break;
            case "CLOUDY":
                if (Simulator.time.getHour() > 4.99 && Simulator.time.getHour() < 5.99) {
                    //2 degree increase between 5 - 6am
                    tempChange += 0.0333333333333333;
                } else if (Simulator.time.getHour() > 5.99 && Simulator.time.getHour() < 6.99) {
                    //4 degree increase between 6 - 7am
                    tempChange += 0.0666666666666667;
                } else if (Simulator.time.getHour() > 6.99 && Simulator.time.getHour() < 7.99) {
                    //2 degree increase between 7 - 8am
                    tempChange += 0.0333333333333333;
                } else if (Simulator.time.getHour() > 7.99 && Simulator.time.getHour() < 8.99) {
                    //2 degree increase between 8 - 9am
                    tempChange += 0.0333333333333333;
                } else if (Simulator.time.getHour() > 8.99 && Simulator.time.getHour() < 9.99) {
                    //1 degree increase between 9 - 10am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 9.99 && Simulator.time.getHour() < 10.99) {
                    //1 degree increase between 10 - 11am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 10.99 && Simulator.time.getHour() < 11.99) {
                    //1 degree increase between 11am - 12pm
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 11.99 && Simulator.time.getHour() < 12.99) {
                    //0 degree between 12 - 1pm
                    tempChange += 0;
                } else if (Simulator.time.getHour() > 12.99 && Simulator.time.getHour() < 13.99) {
                    //1 degree decrease between 1 - 2pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 13.99 && Simulator.time.getHour() < 14.99) {
                    //1 degree decrease between 2 - 3pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 14.99 && Simulator.time.getHour() < 15.99) {
                    //1 degree decrease between 3 - 4pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 15.99 && Simulator.time.getHour() < 16.99) {
                    //1 degree decrease between 4 - 5pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 16.99 && Simulator.time.getHour() < 17.99) {
                    //1 degree decrease between 5 - 6pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 17.99 && Simulator.time.getHour() < 18.99) {
                    //1 degree decrease between 6 - 7pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 18.99 && Simulator.time.getHour() < 20.99) {
                    //0 degree between 7 - 8pm && 8 - 9am
                    tempChange += 0;
                } else if (Simulator.time.getHour() > 20.99 && Simulator.time.getHour() < 21.99) {
                    //1 degree decrease between 9 - 10pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 21.99 && Simulator.time.getHour() < 22.99) {
                    //1 degree decrease between 10 - 11pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 22.99 && Simulator.time.getHour() < 24.99) {
                    //1 degree decrease between 11 - 12pm & 12 - 1am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 24.99 && Simulator.time.getHour() < 25.99) {
                    //1 degree decrease between 1 - 2am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 25.99 && Simulator.time.getHour() < 26.99) {
                    //1 degree decrease between 2 - 3am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 26.99 && Simulator.time.getHour() < 27.99) {
                    //1 degree decrease between 3 - 4am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 27.99 && Simulator.time.getHour() < 28.99) {
                    //1 degree decrease between 4 - 4:59am
                    tempChange -= 0.0166666666666667;
                }
                break;
            case "RAINY":
                if (Simulator.time.getHour() > 4.99 && Simulator.time.getHour() < 5.99) {
                    //1 degree increase between 5 - 6am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 5.99 && Simulator.time.getHour() < 6.99) {
                    //2 degree increase between 6 - 7am
                    tempChange += 0.0333333333333333;
                } else if (Simulator.time.getHour() > 6.99 && Simulator.time.getHour() < 7.99) {
                    //1 degree increase between 7 - 8am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 7.99 && Simulator.time.getHour() < 8.99) {
                    //2 degree increase between 8 - 9am
                    tempChange += 0.0333333333333333;
                } else if (Simulator.time.getHour() > 8.99 && Simulator.time.getHour() < 9.99) {
                    //1 degree increase between 9 - 10am
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 9.99 && Simulator.time.getHour() < 10.99) {
                    //2 degree increase between 10 - 11am
                    tempChange += 0.0333333333333333;
                } else if (Simulator.time.getHour() > 10.99 && Simulator.time.getHour() < 11.99) {
                    //1 degree increase between 11am - 12pm
                    tempChange += 0.0166666666666667;
                } else if (Simulator.time.getHour() > 11.99 && Simulator.time.getHour() < 12.99) {
                    //0 degree between 12 - 1pm
                    tempChange += 0;
                } else if (Simulator.time.getHour() > 12.99 && Simulator.time.getHour() < 13.99) {
                    //1 degree decrease between 1 - 2pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 13.99 && Simulator.time.getHour() < 14.99) {
                    //1 degree decrease between 2 - 3pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 14.99 && Simulator.time.getHour() < 15.99) {
                    //0 degree between 3 - 4pm
                    tempChange -= 0;
                } else if (Simulator.time.getHour() > 15.99 && Simulator.time.getHour() < 16.99) {
                    //1 degree decrease between 4 - 5pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 16.99 && Simulator.time.getHour() < 17.99) {
                    //1 degree decrease between 5 - 6pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 17.99 && Simulator.time.getHour() < 19.99) {
                    //0 degree between 6 - 7pm & 7 - 8pm
                    tempChange -= 0;
                } else if (Simulator.time.getHour() > 19.99 && Simulator.time.getHour() < 20.99) {
                    //1 degree decrease between 8 - 9pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 20.99 && Simulator.time.getHour() < 21.99) {
                    //1 degree decrease between 9 - 10pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 21.99 && Simulator.time.getHour() < 22.99) {
                    //1 degree decrease between 10 - 11pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 22.99 && Simulator.time.getHour() < 23.99) {
                    //1 degree decrease between 11 - 12pm
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 23.99 && Simulator.time.getHour() < 24.99) {
                    //1 degree decrease between 12 - 1am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 24.99 && Simulator.time.getHour() < 25.99) {
                    //0 degree between 1 - 2am
                    tempChange -= 0;
                } else if (Simulator.time.getHour() > 25.99 && Simulator.time.getHour() < 26.99) {
                    //1 degree decrease between 2 - 3am
                    tempChange -= 0.0166666666666667;
                } else if (Simulator.time.getHour() > 26.99 && Simulator.time.getHour() < 27.99) {
                    //1 degree decrease between 3 - 4am
                    tempChange -= 0.0166666666666667;
                }
                break;
            default:
                System.out.println("dynamic temp failed...");
                break;
        }
        return tempChange;
    }
}
