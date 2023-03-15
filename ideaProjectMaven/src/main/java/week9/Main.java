package week9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String errorMessage = "Некорректное число";

    public static void main(String[] args) {
        String enteredNumber = getUserNumber();
        int verificatedNumber = verificatedNumber(enteredNumber);
        int countedNumber = countedNumber(verificatedNumber);
        System.out.println(countedNumber);
    }

    public static String getUserNumber() {


        Scanner predel = new Scanner(System.in);
        System.out.print("Введите любое целое положительное число: ");
        String userNumberString = predel.nextLine();
        return userNumberString;
    }

    public static int verificatedNumber(String userNumberString) {
        //   String errorMessage = "Некорректное число";

        try {
            int userNumber = Integer.parseInt(userNumberString);
            if (userNumber > 0) {
                return userNumber;
            } else {
                throw new RuntimeException(errorMessage);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            throw new RuntimeException(errorMessage);
        }
    }


    public static int countedNumber(int userNumber) {
        int sum = 0;

        for (
                int i = 1;
                i <= userNumber; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
