import java.util.Random;


public class Weather {
    static int weatherValue;

    public static void main(String[] args) {

    }

    public static int getWeather() {
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
