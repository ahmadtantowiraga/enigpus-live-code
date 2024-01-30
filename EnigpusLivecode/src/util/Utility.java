package util;

import entity.Book;
import entity.Magazine;
import entity.Novel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
    private static final List<String> code=new ArrayList<>();

    public static String code1( int year){
        code.add(year+"-"+"A"+"-"+code.size());
        return code.get(code.size()-1);
    }
    public static String code2(int year){
        code.add(year+"-"+"A"+"-"+code.size());
        return code.get(code.size()-1);
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
