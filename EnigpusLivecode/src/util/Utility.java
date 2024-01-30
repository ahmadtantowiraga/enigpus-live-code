package util;

import entity.Book;

import java.util.Scanner;

public class Utility {
    private static final int[] code = new int[1];

    public static int code(){
        return code[code.length-1]+=1;
    }
    public static String inputUtil(String info) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s", info);
            String result = scanner.nextLine();
            if (result.isEmpty() || result.isBlank()) {
                continue;
            }
            return result;
        }
    }

    public static int inputIntUtil(String info) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s", info);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println();
                System.out.println("ONLY INPUT NUMBERS");
                System.out.println();
                continue;

            }
        }
    }
}
