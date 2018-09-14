class Sun {

    private static double sunLightChange, sunLight, time;
    private static String switchChoice;



    static double getSunLightChange() {
        switchChoice = Menu.weatherType;

        switch (switchChoice) {
            case "SUNNY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    sunLight = 0.00;
                } else if (time > 5.99 && time < 6.99) {
                    //6:00am
                    sunLight = 0.00;
                } else if (time > 6.99 && time < 7.99) {
                    //7:00am
                    sunLight = 40.00;
                } else if (time > 7.99 && time < 8.99) {
                    //8:00am
                    sunLight = 80.00;
                } else if (time > 8.99 && time < 9.99) {
                    //9:00am
                    sunLight = 85.00;
                } else if (time > 9.99 && time < 11.99) {
                    //10:00am
                    sunLight = 90.00;
                } else if (time > 10.99 && time < 11.99) {
                    //11:00am
                    sunLight = 95.00;
                } else if (time > 11.99 && time < 12.99) {
                    //12:00pm
                    sunLight = 100.00;
                } else if (time > 12.99 && time < 13.99) {
                    //1:00pm
                    sunLight = 100.00;
                } else if (time > 13.99 && time < 14.99) {
                    //2:00pm
                    sunLight = 95.00;
                } else if (time > 14.99 && time < 15.99) {
                    //3:00pm
                    sunLight = 90.00;
                } else if (time > 15.99 && time < 16.99) {
                    //4:00pm
                    sunLight = 85.00;
                } else if (time > 16.99 && time < 17.99) {
                    //5:00pm
                    sunLight = 40.00;
                } else if (time > 17.99 && time < 18.99) {
                    //6:00pm
                    sunLight = 0.00;
                }
                break;
            case "CLOUDY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    sunLight = 0.00;
                } else if (time > 5.99 && time < 6.99) {
                    //6:00am
                    sunLight = 0.00;
                } else if (time > 6.99 && time < 7.99) {
                    //7:00am
                    sunLight = 35.00;
                } else if (time > 7.99 && time < 8.99) {
                    //8:00am
                    sunLight = 70.00;
                } else if (time > 8.99 && time < 9.99) {
                    //9:00am
                    sunLight = 75.00;
                } else if (time > 9.99 && time < 11.99) {
                    //10:00am
                    sunLight = 80.00;
                } else if (time > 10.99 && time < 11.99) {
                    //11:00am
                    sunLight = 85.00;
                } else if (time > 11.99 && time < 12.99) {
                    //12:00pm
                    sunLight = 90.00;
                } else if (time > 12.99 && time < 13.99) {
                    //1:00pm
                    sunLight = 90.00;
                } else if (time > 13.99 && time < 14.99) {
                    //2:00pm
                    sunLight = 85.00;
                } else if (time > 14.99 && time < 15.99) {
                    //3:00pm
                    sunLight = 75.00;
                } else if (time > 15.99 && time < 16.99) {
                    //4:00pm
                    sunLight = 70.00;
                } else if (time > 16.99 && time < 17.99) {
                    //5:00pm
                    sunLight = 30.00;
                } else if (time > 17.99 && time < 18.99) {
                    //6:00pm
                    sunLight = 0.00;
                }
                break;
            case "RAINY":
                if (time <= 5 && time >= 0) {
                    //5:00am
                    sunLight = 0.00;
                } else if (time > 5.99 && time < 6.99) {
                    //6:00am
                    sunLight = 0.00;
                } else if (time > 6.99 && time < 7.99) {
                    //7:00am
                    sunLight = 30.00;
                } else if (time > 7.99 && time < 8.99) {
                    //8:00am
                    sunLight = 60.00;
                } else if (time > 8.99 && time < 9.99) {
                    //9:00am
                    sunLight = 65.00;
                } else if (time > 9.99 && time < 11.99) {
                    //10:00am
                    sunLight = 70.00;
                } else if (time > 10.99 && time < 11.99) {
                    //11:00am
                    sunLight = 75.00;
                } else if (time > 11.99 && time < 12.99) {
                    //12:00pm
                    sunLight = 80.00;
                } else if (time > 12.99 && time < 13.99) {
                    //1:00pm
                    sunLight = 80.00;
                } else if (time > 13.99 && time < 14.99) {
                    //2:00pm
                    sunLight = 75.00;
                } else if (time > 14.99 && time < 15.99) {
                    //3:00pm
                    sunLight = 60.00;
                } else if (time > 15.99 && time < 16.99) {
                    //4:00pm
                    sunLight = 55.00;
                } else if (time > 16.99 && time < 17.99) {
                    //5:00pm
                    sunLight = 25.00;
                } else if (time > 17.99 && time < 18.99) {
                    //6:00pm
                    sunLight = 0.00;
                }
                break;
        }
        return sunLight;
    }

    static double sunLightIncrease() {
        switchChoice = Menu.weatherType;
        time = Simulator.time;

        switch (switchChoice) {
            case "SUNNY":
                if (time > 4.99 && time < 5.99) {
                    //0% Light increase between 5 - 6am
                    sunLightChange = 0.00;
                } else if (time > 5.99 && time < 6.99) {
                    //40% Light increase between 6 - 7am
                    sunLightChange += 0.6666666666666667;
                } else if (time > 6.99 && time < 7.99) {
                    //40% Light increase between 7 - 8am
                    sunLightChange += 0.6666666666666667;
                } else if (time > 7.99 && time < 8.99) {
                    //5% Light increase between 8 - 9am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 8.99 && time < 9.99) {
                    //5% Light increase between 9 - 10am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 9.99 && time < 10.99) {
                    //5% Light increase between 10 - 11am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 10.99 && time < 11.99) {
                    //5% Light increase between 11am - 12pm
                    sunLightChange += 0.0833333333333333;
                } else if (time > 11.99 && time < 12.99) {
                    //0% Light between 12 - 1pm
                    sunLightChange = 0.00;
                } else if (time > 12.99 && time < 13.99) {
                    //5% Light decrease between 1 - 2pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 13.99 && time < 14.99) {
                    //5% Light decrease between 2 - 3pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 14.99 && time < 15.99) {
                    //5% Light decrease between 3 - 4pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 15.99 && time < 16.99) {
                    //45% Light decrease between 4 - 5pm
                    sunLightChange -= 0.75;
                } else if (time > 16.99 && time < 17.99) {
                    //40% Light decrease between 5 - 6pm
                    sunLightChange -= 0.6666666666666667;
                } else if (time > 17.99 && time < 18.99) {
                    //0% Light decrease between 6 - 7pm
                    sunLightChange = 0.00;
                }
                break;
            case "CLOUDY":
                if (time > 4.99 && time < 5.99) {
                    //0% Light increase between 5 - 6am
                    sunLightChange = 0.00;
                } else if (time > 5.99 && time < 6.99) {
                    //35% Light increase between 6 - 7am
                    sunLightChange += 0.5833333333333333;
                } else if (time > 6.99 && time < 7.99) {
                    //35% Light increase between 7 - 8am
                    sunLightChange += 0.5833333333333333;
                } else if (time > 7.99 && time < 8.99) {
                    //5% Light increase between 8 - 9am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 8.99 && time < 9.99) {
                    //5% Light increase between 9 - 10am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 9.99 && time < 10.99) {
                    //5% Light increase between 10 - 11am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 10.99 && time < 11.99) {
                    //5% Light increase between 11am - 12pm
                    sunLightChange += 0.0833333333333333;
                } else if (time > 11.99 && time < 12.99) {
                    //0% Light between 12 - 1pm
                    sunLightChange = 0.00;
                } else if (time > 12.99 && time < 13.99) {
                    //5% Light decrease between 1 - 2pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 13.99 && time < 14.99) {
                    //10% Light decrease between 2 - 3pm
                    sunLightChange -= 0.1666666666666667;
                } else if (time > 14.99 && time < 15.99) {
                    //5% Light decrease between 3 - 4pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 15.99 && time < 16.99) {
                    //40% Light decrease between 4 - 5pm
                    sunLightChange -= 0.6666666666666667;
                } else if (time > 16.99 && time < 17.99) {
                    //30% Light decrease between 5 - 6pm
                    sunLightChange -= 0.50;
                } else if (time > 17.99 && time < 18.99) {
                    //0% Light decrease between 6 - 7pm
                    sunLightChange = 0.00;
                }
                break;
            case "RAINY":
                if (time > 4.99 && time < 5.99) {
                    //0% Light increase between 5 - 6am
                    sunLightChange = 0.00;
                } else if (time > 5.99 && time < 6.99) {
                    //30% Light increase between 6 - 7am
                    sunLightChange += 0.50;
                } else if (time > 6.99 && time < 7.99) {
                    //30% Light increase between 7 - 8am
                    sunLightChange += 0.50;
                } else if (time > 7.99 && time < 8.99) {
                    //5% Light increase between 8 - 9am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 8.99 && time < 9.99) {
                    //5% Light increase between 9 - 10am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 9.99 && time < 10.99) {
                    //5% Light increase between 10 - 11am
                    sunLightChange += 0.0833333333333333;
                } else if (time > 10.99 && time < 11.99) {
                    //5% Light increase between 11am - 12pm
                    sunLightChange += 0.0833333333333333;
                } else if (time > 11.99 && time < 12.99) {
                    //0% Light between 12 - 1pm
                    sunLightChange = 0.00;
                } else if (time > 12.99 && time < 13.99) {
                    //5% Light decrease between 1 - 2pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 13.99 && time < 14.99) {
                    //5% Light decrease between 2 - 3pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 14.99 && time < 15.99) {
                    //5% Light between 3 - 4pm
                    sunLightChange -= 0.0833333333333333;
                } else if (time > 15.99 && time < 16.99) {
                    //30% Light decrease between 4 - 5pm
                    sunLightChange -= 0.50;
                } else if (time > 16.99 && time < 17.99) {
                    //25% Light decrease between 5 - 6pm
                    sunLightChange -= 0.4166666666666667;
                } else if (time > 17.99 && time < 19.99) {
                    //0% Light between 6 - 7pm & 7 - 8pm
                    sunLightChange = 0.00;
                }
                break;
            default:
                System.out.println("Sunlight failed to get...");
                break;
        }
        return sunLightChange;
    }


}
