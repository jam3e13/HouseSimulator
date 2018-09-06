import java.util.Random;

class Weather {
    static int weatherValue;
    static double temperature;
    static double tempIncrease;
    static double time;

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
            time = 0;
        } else if (time >= 25.59 && time < 25.61) {
            time = 1;
        } else if (time >= 26.59 && time < 26.61) {
            time = 2;
        } else if (time >= 27.59 && time < 27.61) {
            time = 3;
        } else if (time >= 28.59 && time < 28.61) {
            time = 4;
        } else if (time >= 29.59 && time < 29.61) {
            time = 5;
        }
        return time;
    }

    static double tempCorrection() {
        switch (Menu.weatherType) {
            case "SUNNY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    temperature = 14;
                } else if (time >= 6 && time < 6.59) {
                    //6:00am
                    temperature = 17;
                } else if (time >= 6.59 && time <= 7) {
                    //7:00am
                    temperature = 22;
                } else if (time >= 7.59 && time <= 8) {
                    //8:00am
                    temperature = 26;
                } else if (time >= 8.59 && time < 8.61) {
                    //9:00am
                    temperature = 27;
                } else if (time >= 9.59 && time < 9.61) {
                    //10:00am
                    temperature = 28;
                } else if (time >= 10.59 && time < 10.61) {
                    //11:00am
                    temperature = 29;
                } else if (time >= 11.59 && time < 11.61) {
                    //12:00pm
                    temperature = 30;
                } else if (time >= 12.59 && time < 12.61) {
                    //1:00pm
                    temperature = 30;
                } else if (time >= 13.59 && time < 13.61) {
                    //2:00pm
                    temperature = 29;
                } else if (time >= 14.59 && time < 14.61) {
                    //3:00pm
                    temperature = 28;
                } else if (time >= 15.59 && time < 15.61) {
                    //4:00pm
                    temperature = 27;
                } else if (time >= 16.59 && time < 16.61) {
                    //5:00pm
                    temperature = 26;
                } else if (time >= 17.59 && time < 17.61) {
                    //6:00pm
                    temperature = 25;
                } else if (time >= 18.59 && time < 18.61) {
                    //7:00pm
                    temperature = 24;
                } else if (time >= 19.59 && time < 19.61) {
                    //8:00pm
                    temperature = 23;
                } else if (time >= 20.59 && time < 20.61) {
                    //9:00pm
                    temperature = 22;
                } else if (time >= 21.59 && time < 21.61) {
                    //10:00pm
                    temperature = 21;
                } else if (time >= 22.59 && time < 22.61) {
                    //11:00pm
                    temperature = 20;
                } else if (time >= 23.59 && time < 23.61) {
                    //12:00pm
                    temperature = 19;
                } else if (time >= 24.59 && time < 24.61) {
                    //1:00am
                    temperature = 18;
                } else if (time >= 25.59 && time < 25.61) {
                    //2:00am
                    temperature = 17;
                } else if (time >= 26.59 && time < 26.61) {
                    //3:00am
                    temperature = 16;
                } else if (time >= 27.59 && time < 27.61) {
                    //4:00am
                    temperature = 15;
                }
                break;
            case "CLOUDY":
                if (time <= 5 && time >= 0) {
                    temperature = 15;
                } else if (time >= 6 && time < 6.59) {
                    temperature = 17;
                } else if (time >= 6.59 && time <= 7) {
                    temperature = 21;
                } else if (time >= 7.59 && time < 7.61) {
                    temperature = 23;
                } else if (time >= 8.59 && time < 8.61) {
                    temperature = 25;
                } else if (time >= 9.59 && time < 9.61) {
                    temperature = 26;
                } else if (time >= 10.59 && time < 10.61) {
                    temperature = 27;
                } else if (time >= 11.59 && time < 11.61) {
                    temperature = 28;
                } else if (time >= 12.59 && time < 12.61) {
                    temperature = 28;
                } else if (time >= 13.59 && time < 13.61) {
                    temperature = 27;
                } else if (time >= 14.59 && time < 14.61) {
                    temperature = 26;
                } else if (time >= 15.59 && time < 15.61) {
                    temperature = 25;
                } else if (time >= 16.59 && time < 16.61) {
                    temperature = 24;
                } else if (time >= 17.59 && time < 17.61) {
                    temperature = 23;
                } else if (time >= 18.59 && time < 18.61) {
                    temperature = 22;
                } else if (time >= 19.59 && time < 19.61) {
                    temperature = 22;
                } else if (time >= 20.59 && time < 20.61) {
                    temperature = 22;
                } else if (time >= 21.59 && time < 21.61) {
                    temperature = 21;
                } else if (time >= 22.59 && time < 22.61) {
                    temperature = 21;
                } else if (time >= 23.59 && time < 23.61) {
                    temperature = 20;
                } else if (time >= 24.59 && time < 24.61) {
                    temperature = 19;
                } else if (time >= 25.59 && time < 25.61) {
                    temperature = 18;
                } else if (time >= 26.59 && time < 26.61) {
                    temperature = 17;
                } else if (time >= 27.59 && time < 27.61) {
                    temperature = 16;
                }
                break;
            case "RAINY":
                if (time <= 5 && time >= 0) {
                    temperature = 16;
                } else if (time >= 6 && time < 6.59) {
                    temperature = 17;
                } else if (time >= 6.59 && time <= 7) {
                    temperature = 19;
                } else if (time >= 7.59 && time < 7.61) {
                    temperature = 20;
                } else if (time >= 8.59 && time < 8.61) {
                    temperature = 22;
                } else if (time >= 9.59 && time < 9.61) {
                    temperature = 23;
                } else if (time >= 10.59 && time < 10.61) {
                    temperature = 25;
                } else if (time >= 11.59 && time < 11.61) {
                    temperature = 26;
                } else if (time >= 12.59 && time < 12.61) {
                    temperature = 26;
                } else if (time >= 13.59 && time < 13.61) {
                    temperature = 25;
                } else if (time >= 14.59 && time < 14.61) {
                    temperature = 24;
                } else if (time >= 15.59 && time < 15.61) {
                    temperature = 24;
                } else if (time >= 16.59 && time < 16.61) {
                    temperature = 23;
                } else if (time >= 17.59 && time < 17.61) {
                    temperature = 22;
                } else if (time >= 18.59 && time < 18.61) {
                    temperature = 22;
                } else if (time >= 19.59 && time < 19.61) {
                    temperature = 22;
                } else if (time >= 20.59 && time < 20.61) {
                    temperature = 21;
                } else if (time >= 21.59 && time < 21.61) {
                    temperature = 21;
                } else if (time >= 22.59 && time < 22.61) {
                    temperature = 20;
                } else if (time >= 23.59 && time < 23.61) {
                    temperature = 19;
                } else if (time >= 24.59 && time < 24.61) {
                    temperature = 19;
                } else if (time >= 25.59 && time < 25.61) {
                    temperature = 18;
                } else if (time >= 26.59 && time < 26.61) {
                    temperature = 18;
                } else if (time >= 27.59 && time < 27.61) {
                    temperature = 17;
                }
                break;
        }
        return temperature;
    }

    static double dynamicTemp() {

        switch (Menu.weatherType) {
            case "SUNNY":
                if (temperature >= 14 && temperature < 17) {
                    //3 degree increase between 5 - 6am
                    tempIncrease += .05;
                } else if (temperature >= 17 && temperature < 22) {
                    //5 degree increase between 6 - 7am
                    tempIncrease += 0.0833333333333333;
                } else if (temperature >= 22 && temperature < 26) {
                    //4 degree increase between 7 - 8am
                    tempIncrease += 0.0666666666666667;
                } else if (temperature >= 26 && temperature < 27) {
                    //1 degree increase between 8 - 9am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 27 && temperature < 28) {
                    //1 degree increase between 9 - 10am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 28 && temperature < 29) {
                    //1 degree increase between 10 - 11am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 29 && temperature < 30) {
                    //1 degree increase between 11am - 12pm
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 30 && temperature < 30) {
                    //0 degree between 12 - 1pm
                    tempIncrease += 0;
                } else if (temperature >= 30 && temperature < 29) {
                    //1 degree decrease between 1 - 2pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 29 && temperature < 28) {
                    //1 degree decrease between 2 - 3pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 28 && temperature < 27) {
                    //1 degree decrease between 3 - 4pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 27 && temperature < 26) {
                    //1 degree decrease between 4 - 5pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 26 && temperature < 25) {
                    //1 degree decrease between 5 - 6pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 25 && temperature < 24) {
                    //1 degree decrease between 6 - 7pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 24 && temperature < 23) {
                    //1 degree decrease between 7 - 8pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 23 && temperature < 22) {
                    //1 degree decrease between 8 - 9pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 22 && temperature < 21) {
                    //1 degree decrease between 9 - 10pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 21 && temperature < 20) {
                    //1 degree decrease between 10 - 11pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 20 && temperature < 19) {
                    //1 degree decrease between 11 - 12pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 19 && temperature < 18) {
                    //1 degree decrease between 12 - 1am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 18 && temperature < 17) {
                    //1 degree decrease between 1 - 2am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 17 && temperature < 16) {
                    //1 degree decrease between 2 - 3am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 16 && temperature < 15) {
                    //1 degree decrease between 3 - 4am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 15 && temperature < 14) {
                    //1 degree decrease between 4 - 4:59am
                    tempIncrease -= 0.0166666666666667;
                }
                break;
            case "CLOUDY":
                if (temperature >= 15 && temperature < 17) {
                    //2 degree increase between 5 - 6am
                    tempIncrease += 0.0333333333333333;
                } else if (temperature >= 17 && temperature < 21) {
                    //4 degree increase between 6 - 7am
                    tempIncrease += 0.0666666666666667;
                } else if (temperature >= 21 && temperature < 23) {
                    //2 degree increase between 7 - 8am
                    tempIncrease += 0.0333333333333333;
                } else if (temperature >= 23 && temperature < 25) {
                    //2 degree increase between 8 - 9am
                    tempIncrease += 0.0333333333333333;
                } else if (temperature >= 25 && temperature < 26) {
                    //1 degree increase between 9 - 10am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 26 && temperature < 27) {
                    //1 degree increase between 10 - 11am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 27 && temperature < 28) {
                    //1 degree increase between 11am - 12pm
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 28 && temperature < 28) {
                    //0 degree between 12 - 1pm
                    tempIncrease += 0;
                } else if (temperature >= 28 && temperature < 27) {
                    //1 degree decrease between 1 - 2pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 27 && temperature < 26) {
                    //1 degree decrease between 2 - 3pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 26 && temperature < 25) {
                    //1 degree decrease between 3 - 4pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 25 && temperature < 24) {
                    //1 degree decrease between 4 - 5pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 24 && temperature < 23) {
                    //1 degree decrease between 5 - 6pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 23 && temperature < 22) {
                    //1 degree decrease between 6 - 7pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 22 && temperature < 22) {
                    //0 degree between 7 - 8pm && 8 - 9am
                    tempIncrease -= 0;
                } else if (temperature >= 22 && temperature < 21) {
                    //1 degree decrease between 9 - 10pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 21 && temperature < 20) {
                    //1 degree decrease between 10 - 11pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 20 && temperature < 19) {
                    //1 degree decrease between 11 - 12pm & 12 - 1am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 19 && temperature < 18) {
                    //1 degree decrease between 1 - 2am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 18 && temperature < 17) {
                    //1 degree decrease between 2 - 3am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 17 && temperature < 16) {
                    //1 degree decrease between 3 - 4am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 16 && temperature < 15) {
                    //1 degree decrease between 4 - 4:59am
                    tempIncrease -= 0.0166666666666667;
                }
                break;
            case "RAINY":
                if (temperature >= 16 && temperature < 17) {
                    //1 degree increase between 5 - 6am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 17 && temperature < 19) {
                    //2 degree increase between 6 - 7am
                    tempIncrease += 0.0333333333333333;
                } else if (temperature >= 19 && temperature < 20) {
                    //1 degree increase between 7 - 8am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 20 && temperature < 22) {
                    //2 degree increase between 8 - 9am
                    tempIncrease += 0.0333333333333333;
                } else if (temperature >= 22 && temperature < 23) {
                    //1 degree increase between 9 - 10am
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 23 && temperature < 25) {
                    //2 degree increase between 10 - 11am
                    tempIncrease += 0.0333333333333333;
                } else if (temperature >= 25 && temperature < 26) {
                    //1 degree increase between 11am - 12pm
                    tempIncrease += 0.0166666666666667;
                } else if (temperature >= 26 && temperature < 26) {
                    //0 degree between 12 - 1pm
                    tempIncrease += 0;
                } else if (temperature >= 26 && temperature < 25) {
                    //1 degree decrease between 1 - 2pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 25 && temperature < 24) {
                    //1 degree decrease between 2 - 3pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 24 && temperature < 24) {
                    //0 degree between 3 - 4pm
                    tempIncrease -= 0;
                } else if (temperature >= 24 && temperature < 23) {
                    //1 degree decrease between 4 - 5pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 23 && temperature < 22) {
                    //1 degree decrease between 5 - 6pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 22 && temperature < 22) {
                    //0 degree between 6 - 7pm & 7 - 8pm
                    tempIncrease -= 0;
                } else if (temperature >= 22 && temperature < 21) {
                    //1 degree decrease between 8 - 9pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 21 && temperature < 20) {
                    //1 degree decrease between 9 - 10pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 20 && temperature < 19) {
                    //1 degree decrease between 10 - 11pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 19 && temperature < 19) {
                    //1 degree decrease between 11 - 12pm
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 19 && temperature < 18) {
                    //1 degree decrease between 12 - 1am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 18 && temperature < 18) {
                    //0 degree between 1 - 2am
                    tempIncrease -= 0;
                } else if (temperature >= 18 && temperature < 17) {
                    //1 degree decrease between 2 - 3am
                    tempIncrease -= 0.0166666666666667;
                } else if (temperature >= 17 && temperature < 16) {
                    //1 degree decrease between 3 - 4am
                    tempIncrease -= 0.0166666666666667;
                }
                break;
            default:
                System.out.println("dynamic temp failed...");
                break;
        }
        return tempIncrease;
    }
}
