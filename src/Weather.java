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
}
