import java.util.Random;

class Weather {
    static int weatherValue;
    static double temperature;
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
        if (time <= 5 && time >= 0) {
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 14;
                    break;
                case "CLOUDY":
                    temperature = 15;
                    break;
                case "RAINY":
                    temperature = 16;
                    break;
            }
        } else if (time == 6) {
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 17;
                    break;
                case "CLOUDY":
                    temperature = 17;
                    break;
                case "RAINY":
                    temperature = 17;
                    break;
            }

        } else if (time >= 6.59 && time < 6.61) {
            time = 7;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 22;
                    break;
                case "CLOUDY":
                    temperature = 21;
                    break;
                case "RAINY":
                    temperature = 19;
                    break;
            }
        } else if (time >= 7.59 && time < 7.61) {
            time = 8;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 26;
                    break;
                case "CLOUDY":
                    temperature = 23;
                    break;
                case "RAINY":
                    temperature = 20;
                    break;
            }
        } else if (time >= 8.59 && time < 8.61) {
            time = 9;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 27;
                    break;
                case "CLOUDY":
                    temperature = 25;
                    break;
                case "RAINY":
                    temperature = 22;
                    break;
            }
        } else if (time >= 9.59 && time < 9.61) {
            time = 10;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 28;
                    break;
                case "CLOUDY":
                    temperature = 26;
                    break;
                case "RAINY":
                    temperature = 23;
                    break;
            }
        } else if (time >= 10.59 && time < 10.61) {
            time = 11;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 29;
                    break;
                case "CLOUDY":
                    temperature = 27;
                    break;
                case "RAINY":
                    temperature = 25;
                    break;
            }
        } else if (time >= 11.59 && time < 11.61) {
            time = 12;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 30;
                    break;
                case "CLOUDY":
                    temperature = 28;
                    break;
                case "RAINY":
                    temperature = 26;
                    break;
            }
        } else if (time >= 12.59 && time < 12.61) {
            time = 13;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 30;
                    break;
                case "CLOUDY":
                    temperature = 28;
                    break;
                case "RAINY":
                    temperature = 26;
                    break;
            }
        } else if (time >= 13.59 && time < 13.61) {
            time = 14;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 29;
                    break;
                case "CLOUDY":
                    temperature = 27;
                    break;
                case "RAINY":
                    temperature = 25;
                    break;
            }
        } else if (time >= 14.59 && time < 14.61) {
            time = 15;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 28;
                    break;
                case "CLOUDY":
                    temperature = 26;
                    break;
                case "RAINY":
                    temperature = 24;
                    break;
            }
        } else if (time >= 15.59 && time < 15.61) {
            time = 16;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 27;
                    break;
                case "CLOUDY":
                    temperature = 25;
                    break;
                case "RAINY":
                    temperature = 24;
                    break;
            }
        } else if (time >= 16.59 && time < 16.61) {
            time = 17;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 26;
                    break;
                case "CLOUDY":
                    temperature = 24;
                    break;
                case "RAINY":
                    temperature = 23;
                    break;
            }
        } else if (time >= 17.59 && time < 17.61) {
            time = 18;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 25;
                    break;
                case "CLOUDY":
                    temperature = 23;
                    break;
                case "RAINY":
                    temperature = 22;
                    break;
            }
        } else if (time >= 18.59 && time < 18.61) {
            time = 19;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 24;
                    break;
                case "CLOUDY":
                    temperature = 22;
                    break;
                case "RAINY":
                    temperature = 22;
                    break;
            }
        } else if (time >= 19.59 && time < 19.61) {
            time = 20;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 23;
                    break;
                case "CLOUDY":
                    temperature = 22;
                    break;
                case "RAINY":
                    temperature = 22;
                    break;
            }
        } else if (time >= 20.59 && time < 20.61) {
            time = 21;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 22;
                    break;
                case "CLOUDY":
                    temperature = 22;
                    break;
                case "RAINY":
                    temperature = 21;
                    break;
            }
        } else if (time >= 21.59 && time < 21.61) {
            time = 22;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 21;
                    break;
                case "CLOUDY":
                    temperature = 21;
                    break;
                case "RAINY":
                    temperature = 21;
                    break;
            }
        } else if (time >= 22.59 && time < 22.61) {
            time = 23;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 20;
                    break;
                case "CLOUDY":
                    temperature = 21;
                    break;
                case "RAINY":
                    temperature = 21;
                    break;
            }
        } else if (time >= 23.59 && time < 23.61) {
            time = 24;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 19;
                    break;
                case "CLOUDY":
                    temperature = 20;
                    break;
                case "RAINY":
                    temperature = 19;
                    break;
            }
        } else if (time >= 24.59 && time < 24.61) {
            time = 25;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 18;
                    break;
                case "CLOUDY":
                    temperature = 19;
                    break;
                case "RAINY":
                    temperature = 19;
                    break;
            }
        } else if (time >= 25.59 && time < 25.61) {
            time = 26;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 17;
                    break;
                case "CLOUDY":
                    temperature = 18;
                    break;
                case "RAINY":
                    temperature = 18;
                    break;
            }
        } else if (time >= 26.59 && time < 26.61) {
            time = 27;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 16;
                    break;
                case "CLOUDY":
                    temperature = 17;
                    break;
                case "RAINY":
                    temperature = 18;
                    break;
            }
        } else if (time >= 27.59 && time < 27.61) {
            time = 28;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 16;
                    break;
                case "CLOUDY":
                    temperature = 17;
                    break;
                case "RAINY":
                    temperature = 18;
                    break;
            }
        } else if (time >= 28.59 && time < 28.61) {
            time = 29;
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 15;
                    break;
                case "CLOUDY":
                    temperature = 16;
                    break;
                case "RAINY":
                    temperature = 17;
                    break;
            }
        } else if (time < 5 && time > 4.61) {
            switch (Menu.weatherType) {
                case "SUNNY":
                    temperature = 14;
                    break;
                case "CLOUDY":
                    temperature = 15;
                    break;
                case "RAINY":
                    temperature = 16;
                    break;
            }
        }

        return temperature;
    }
}
