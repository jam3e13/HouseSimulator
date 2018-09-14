import java.util.Random;

class Weather {
    static int weatherValue;
    static double temperature, tempChange, time;
    private static String switchChoice;

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

    static double timeCorrection() {
        time = Simulator.time;

        if (time >= 5.59 && time < 5.61) {
            time = 6;
        } else if (time >= 6.59 && time < 6.61) {
            time = 7;
        } else if (time >= 7.59 && time < 7.61) {
            time = 8;
        } else if (time >= 8.59 && time < 8.61) {
            time = 9;
        } else if (time >= 9.59 && time < 9.61) {
            time = 10;
        } else if (time >= 10.59 && time < 10.61) {
            time = 11;
        } else if (time >= 11.59 && time < 11.61) {
            time = 12;
        } else if (time >= 12.59 && time < 12.61) {
            time = 13;
        } else if (time >= 13.59 && time < 13.61) {
            time = 14;
        } else if (time >= 14.59 && time < 14.61) {
            time = 15;
        } else if (time >= 15.59 && time < 15.61) {
            time = 16;
        } else if (time >= 16.59 && time < 16.61) {
            time = 17;
        } else if (time >= 17.59 && time < 17.61) {
            time = 18;
        } else if (time >= 18.59 && time < 18.61) {
            time = 19;
        } else if (time >= 19.59 && time < 19.61) {
            time = 20;
        } else if (time >= 20.59 && time < 20.61) {
            time = 21;
        } else if (time >= 21.59 && time < 21.61) {
            time = 22;
        } else if (time >= 22.59 && time < 22.61) {
            time = 23;
        } else if (time >= 23.59 && time < 23.61) {
            time = 24;
        } else if (time >= 24.59 && time < 24.61) {
            time = 25;
        } else if (time >= 25.59 && time < 25.61) {
            time = 26;
        } else if (time >= 26.59 && time < 26.61) {
            time = 27;
        } else if (time >= 27.59 && time < 27.61) {
            time = 28;
        } else if (time >= 28.59 && time < 28.61) {
            time = 29;
        } else if (time >= 29.59 && time < 29.61) {
            time = 30;
        }
        return time;
    }

    static double tempCorrection() {
        switchChoice = Menu.weatherType;

        switch (switchChoice) {
            case "SUNNY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    temperature = 14;
                } else if (time > 5.99 && time < 6.99) {
                    //6:00am
                    temperature = 17;
                } else if (time > 6.99 && time < 7.99) {
                    //7:00am
                    temperature = 22;
                } else if (time > 7.99 && time < 8.99) {
                    //8:00am
                    temperature = 26;
                } else if (time > 8.99 && time < 9.99) {
                    //9:00am
                    temperature = 27;
                } else if (time > 9.99 && time < 11.99) {
                    //10:00am
                    temperature = 28;
                } else if (time > 10.99 && time < 11.99) {
                    //11:00am
                    temperature = 29;
                } else if (time > 11.99 && time < 12.99) {
                    //12:00pm
                    temperature = 30;
                } else if (time > 12.99 && time < 13.99) {
                    //1:00pm
                    temperature = 30;
                } else if (time > 13.99 && time < 14.99) {
                    //2:00pm
                    temperature = 29;
                } else if (time > 14.99 && time < 15.99) {
                    //3:00pm
                    temperature = 28;
                } else if (time > 15.99 && time < 16.99) {
                    //4:00pm
                    temperature = 27;
                } else if (time > 16.99 && time < 17.99) {
                    //5:00pm
                    temperature = 26;
                } else if (time > 17.99 && time < 18.99) {
                    //6:00pm
                    temperature = 25;
                } else if (time > 18.99 && time < 19.99) {
                    //7:00pm
                    temperature = 24;
                } else if (time > 19.99 && time < 20.99) {
                    //8:00pm
                    temperature = 23;
                } else if (time > 20.99 && time < 21.99) {
                    //9:00pm
                    temperature = 22;
                } else if (time > 21.99 && time < 22.99) {
                    //10:00pm
                    temperature = 21;
                } else if (time > 22.99 && time < 23.99) {
                    //11:00pm
                    temperature = 20;
                } else if (time > 23.99 && time < 24.99) {
                    //12:00am
                    temperature = 19;
                } else if (time > 24.99 && time < 25.99) {
                    //1:00am
                    temperature = 18;
                } else if (time > 25.99 && time < 26.99) {
                    //2:00am
                    temperature = 17;
                } else if (time > 26.99 && time < 27.99) {
                    //3:00am
                    temperature = 16;
                } else if (time > 27.99 && time < 28.99) {
                    //4:00am
                    temperature = 15;
                }
                break;
            case "CLOUDY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    temperature = 15;
                } else if (time > 5.99 && time < 6.99) {
                    //6:00am
                    temperature = 17;
                } else if (time > 6.99 && time < 7.99) {
                    //7:00am
                    temperature = 21;
                } else if (time > 7.99 && time < 8.99) {
                    //8:00am
                    temperature = 23;
                } else if (time > 8.99 && time < 9.99) {
                    //9:00am
                    temperature = 25;
                } else if (time > 9.99 && time < 11.99) {
                    //10:00am
                    temperature = 26;
                } else if (time > 10.99 && time < 11.99) {
                    //11:00am
                    temperature = 27;
                } else if (time > 11.99 && time < 12.99) {
                    //12:00pm
                    temperature = 28;
                } else if (time > 12.99 && time < 13.99) {
                    //1:00pm
                    temperature = 28;
                } else if (time > 13.99 && time < 14.99) {
                    //2:00pm
                    temperature = 27;
                } else if (time > 14.99 && time < 15.99) {
                    //3:00pm
                    temperature = 26;
                } else if (time > 15.99 && time < 16.99) {
                    //4:00pm
                    temperature = 25;
                } else if (time > 16.99 && time < 17.99) {
                    //5:00pm
                    temperature = 24;
                } else if (time > 17.99 && time < 18.99) {
                    //6:00pm
                    temperature = 23;
                } else if (time > 18.99 && time < 19.99) {
                    //7:00pm
                    temperature = 22;
                } else if (time > 19.99 && time < 20.99) {
                    //8:00pm
                    temperature = 22;
                } else if (time > 20.99 && time < 21.99) {
                    //9:00pm
                    temperature = 22;
                } else if (time > 21.99 && time < 22.99) {
                    //10:00pm
                    temperature = 21;
                } else if (time > 22.99 && time < 23.99) {
                    //11:00pm
                    temperature = 21;
                } else if (time > 23.99 && time < 24.99) {
                    //12:00am
                    temperature = 20;
                } else if (time > 24.99 && time < 25.99) {
                    //1:00am
                    temperature = 19;
                } else if (time > 25.99 && time < 26.99) {
                    //2:00am
                    temperature = 18;
                } else if (time > 26.99 && time < 27.99) {
                    //3:00am
                    temperature = 17;
                } else if (time > 27.99 && time < 28.99) {
                    //4:00am
                    temperature = 16;
                }
                break;
            case "RAINY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    temperature = 16;
                } else if (time > 5.99 && time < 6.99) {
                    //6:00am
                    temperature = 17;
                } else if (time > 6.99 && time < 7.99) {
                    //7:00am
                    temperature = 19;
                } else if (time > 7.99 && time < 8.99) {
                    //8:00am
                    temperature = 20;
                } else if (time > 8.99 && time < 9.99) {
                    //9:00am
                    temperature = 22;
                } else if (time > 9.99 && time < 11.99) {
                    //10:00am
                    temperature = 23;
                } else if (time > 10.99 && time < 11.99) {
                    //11:00am
                    temperature = 25;
                } else if (time > 11.99 && time < 12.99) {
                    //12:00pm
                    temperature = 26;
                } else if (time > 12.99 && time < 13.99) {
                    //1:00pm
                    temperature = 26;
                } else if (time > 13.99 && time < 14.99) {
                    //2:00pm
                    temperature = 25;
                } else if (time > 14.99 && time < 15.99) {
                    //3:00pm
                    temperature = 24;
                } else if (time > 15.99 && time < 16.99) {
                    //4:00pm
                    temperature = 24;
                } else if (time > 16.99 && time < 17.99) {
                    //5:00pm
                    temperature = 23;
                } else if (time > 17.99 && time < 18.99) {
                    //6:00pm
                    temperature = 22;
                } else if (time > 18.99 && time < 19.99) {
                    //7:00pm
                    temperature = 22;
                } else if (time > 19.99 && time < 20.99) {
                    //8:00pm
                    temperature = 22;
                } else if (time > 20.99 && time < 21.99) {
                    //9:00pm
                    temperature = 21;
                } else if (time > 21.99 && time < 22.99) {
                    //10:00pm
                    temperature = 21;
                } else if (time > 22.99 && time < 23.99) {
                    //11:00pm
                    temperature = 20;
                } else if (time > 23.99 && time < 24.99) {
                    //12:00am
                    temperature = 19;
                } else if (time > 24.99 && time < 25.99) {
                    //1:00am
                    temperature = 19;
                } else if (time > 25.99 && time < 26.99) {
                    //2:00am
                    temperature = 18;
                } else if (time > 26.99 && time < 27.99) {
                    //3:00am
                    temperature = 18;
                } else if (time > 27.99 && time < 28.99) {
                    //4:00am
                    temperature = 17;
                }
                break;
        }
        return temperature;
    }

    static double dynamicIncrease() {
        switchChoice = Menu.weatherType;

        switch (switchChoice) {
            case "SUNNY":
                if (time > 4.99 && time < 5.99) {
                    //3 degree increase between 5 - 6am
                    tempChange += 0.05;
                } else if (time > 5.99 && time < 6.99) {
                    //5 degree increase between 6 - 7am
                    tempChange += 0.0833333333333333;
                } else if (time > 6.99 && time < 7.99) {
                    //4 degree increase between 7 - 8am
                    tempChange += 0.0666666666666667;
                } else if (time > 7.99 && time < 8.99) {
                    //1 degree increase between 8 - 9am
                    tempChange += 0.0166666666666667;
                } else if (time > 8.99 && time < 9.99) {
                    //1 degree increase between 9 - 10am
                    tempChange += 0.0166666666666667;
                } else if (time > 9.99 && time < 10.99) {
                    //1 degree increase between 10 - 11am
                    tempChange += 0.0166666666666667;
                } else if (time > 10.99 && time < 11.99) {
                    //1 degree increase between 11am - 12pm
                    tempChange += 0.0166666666666667;
                } else if (time > 11.99 && time < 12.99) {
                    //0 degree between 12 - 1pm
                    tempChange = 0;
                } else if (time > 12.99 && time < 13.99) {
                    //1 degree decrease between 1 - 2pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 13.99 && time < 14.99) {
                    //1 degree decrease between 2 - 3pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 14.99 && time < 15.99) {
                    //1 degree decrease between 3 - 4pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 15.99 && time < 16.99) {
                    //1 degree decrease between 4 - 5pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 16.99 && time < 17.99) {
                    //1 degree decrease between 5 - 6pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 17.99 && time < 18.99) {
                    //1 degree decrease between 6 - 7pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 18.99 && time < 19.99) {
                    //1 degree decrease between 7 - 8pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 19.99 && time < 20.99) {
                    //1 degree decrease between 8 - 9pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 20.99 && time < 21.99) {
                    //1 degree decrease between 9 - 10pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 21.99 && time < 22.99) {
                    //1 degree decrease between 10 - 11pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 22.99 && time < 23.99) {
                    //1 degree decrease between 11 - 12pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 23.99 && time < 24.99) {
                    //1 degree decrease between 12 - 1am
                    tempChange -= 0.0166666666666667;
                } else if (time > 24.99 && time < 25.99) {
                    //1 degree decrease between 1 - 2am
                    tempChange -= 0.0166666666666667;
                } else if (time > 25.99 && time < 26.99) {
                    //1 degree decrease between 2 - 3am
                    tempChange -= 0.0166666666666667;
                } else if (time > 26.99 && time < 27.99) {
                    //1 degree decrease between 3 - 4am
                    tempChange -= 0.0166666666666667;
                } else if (time > 27.99 && time < 28.99) {
                    //1 degree decrease between 4 - 4:59am
                    tempChange -= 0.0166666666666667;
                }
                break;
            case "CLOUDY":
                if (time > 4.99 && time < 5.99) {
                    //2 degree increase between 5 - 6am
                    tempChange += 0.0333333333333333;
                } else if (time > 5.99 && time < 6.99) {
                    //4 degree increase between 6 - 7am
                    tempChange += 0.0666666666666667;
                } else if (time > 6.99 && time < 7.99) {
                    //2 degree increase between 7 - 8am
                    tempChange += 0.0333333333333333;
                } else if (time > 7.99 && time < 8.99) {
                    //2 degree increase between 8 - 9am
                    tempChange += 0.0333333333333333;
                } else if (time > 8.99 && time < 9.99) {
                    //1 degree increase between 9 - 10am
                    tempChange += 0.0166666666666667;
                } else if (time > 9.99 && time < 10.99) {
                    //1 degree increase between 10 - 11am
                    tempChange += 0.0166666666666667;
                } else if (time > 10.99 && time < 11.99) {
                    //1 degree increase between 11am - 12pm
                    tempChange += 0.0166666666666667;
                } else if (time > 11.99 && time < 12.99) {
                    //0 degree between 12 - 1pm
                    tempChange = 0;
                } else if (time > 12.99 && time < 13.99) {
                    //1 degree decrease between 1 - 2pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 13.99 && time < 14.99) {
                    //1 degree decrease between 2 - 3pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 14.99 && time < 15.99) {
                    //1 degree decrease between 3 - 4pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 15.99 && time < 16.99) {
                    //1 degree decrease between 4 - 5pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 16.99 && time < 17.99) {
                    //1 degree decrease between 5 - 6pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 17.99 && time < 18.99) {
                    //1 degree decrease between 6 - 7pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 18.99 && time < 20.99) {
                    //0 degree between 7 - 8pm && 8 - 9am
                    tempChange = 0;
                } else if (time > 20.99 && time < 21.99) {
                    //1 degree decrease between 9 - 10pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 21.99 && time < 22.99) {
                    //1 degree decrease between 10 - 11pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 22.99 && time < 24.99) {
                    //1 degree decrease between 11 - 12pm & 12 - 1am
                    tempChange -= 0.0166666666666667;
                } else if (time > 24.99 && time < 25.99) {
                    //1 degree decrease between 1 - 2am
                    tempChange -= 0.0166666666666667;
                } else if (time > 25.99 && time < 26.99) {
                    //1 degree decrease between 2 - 3am
                    tempChange -= 0.0166666666666667;
                } else if (time > 26.99 && time < 27.99) {
                    //1 degree decrease between 3 - 4am
                    tempChange -= 0.0166666666666667;
                } else if (time > 27.99 && time < 28.99) {
                    //1 degree decrease between 4 - 4:59am
                    tempChange -= 0.0166666666666667;
                }
                break;
            case "RAINY":
                if (time > 4.99 && time < 5.99) {
                    //1 degree increase between 5 - 6am
                    tempChange += 0.0166666666666667;
                } else if (time > 5.99 && time < 6.99) {
                    //2 degree increase between 6 - 7am
                    tempChange += 0.0333333333333333;
                } else if (time > 6.99 && time < 7.99) {
                    //1 degree increase between 7 - 8am
                    tempChange += 0.0166666666666667;
                } else if (time > 7.99 && time < 8.99) {
                    //2 degree increase between 8 - 9am
                    tempChange += 0.0333333333333333;
                } else if (time > 8.99 && time < 9.99) {
                    //1 degree increase between 9 - 10am
                    tempChange += 0.0166666666666667;
                } else if (time > 9.99 && time < 10.99) {
                    //2 degree increase between 10 - 11am
                    tempChange += 0.0333333333333333;
                } else if (time > 10.99 && time < 11.99) {
                    //1 degree increase between 11am - 12pm
                    tempChange += 0.0166666666666667;
                } else if (time > 11.99 && time < 12.99) {
                    //0 degree between 12 - 1pm
                    tempChange = 0;
                } else if (time > 12.99 && time < 13.99) {
                    //1 degree decrease between 1 - 2pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 13.99 && time < 14.99) {
                    //1 degree decrease between 2 - 3pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 14.99 && time < 15.99) {
                    //0 degree between 3 - 4pm
                    tempChange = 0;
                } else if (time > 15.99 && time < 16.99) {
                    //1 degree decrease between 4 - 5pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 16.99 && time < 17.99) {
                    //1 degree decrease between 5 - 6pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 17.99 && time < 19.99) {
                    //0 degree between 6 - 7pm & 7 - 8pm
                    tempChange = 0;
                } else if (time > 19.99 && time < 20.99) {
                    //1 degree decrease between 8 - 9pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 20.99 && time < 21.99) {
                    //1 degree decrease between 9 - 10pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 21.99 && time < 22.99) {
                    //1 degree decrease between 10 - 11pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 22.99 && time < 23.99) {
                    //1 degree decrease between 11 - 12pm
                    tempChange -= 0.0166666666666667;
                } else if (time > 23.99 && time < 24.99) {
                    //1 degree decrease between 12 - 1am
                    tempChange -= 0.0166666666666667;
                } else if (time > 24.99 && time < 25.99) {
                    //0 degree between 1 - 2am
                    tempChange = 0;
                } else if (time > 25.99 && time < 26.99) {
                    //1 degree decrease between 2 - 3am
                    tempChange -= 0.0166666666666667;
                } else if (time > 26.99 && time < 27.99) {
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
