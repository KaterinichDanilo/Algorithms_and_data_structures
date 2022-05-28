package Homework1;

public class Homework1 {
    public static int reduceToPower(int number, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }

    public static int reduceToPowerUsingParity(int number, int power) {
        if (power % 2 == 0) {
            while (power != 1) {
                number *= number;
                power /= 2;
            }
            return number;
        } else {
            int result = 1;
            for (int i = 0; i < power; i++) {
                result *= number;
            }
            return result;
        }
    }

    public static int sumFrom0To100() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }

}
