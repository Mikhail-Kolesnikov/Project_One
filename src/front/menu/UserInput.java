package front.menu;

import java.util.Scanner;

public class UserInput {

    public int userInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int userInput = scanner.nextInt();
        return userInput;
    }

    public double userDouble(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        double userInput = scanner.nextDouble();
        return userInput;
    }

    public String userText(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String userInput = scanner.nextLine();
        return userInput;
    }

}
