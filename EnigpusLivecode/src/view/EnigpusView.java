package view;

import java.util.Date;
import java.util.Scanner;

public class EnigpusView {
    public void showMenu(){
        while (true) {
            Integer noMenu=null;
            while(true){
                System.out.println("--------------------------------------");
                System.out.println("Main Menu");
                System.out.println("--------------------------------------");
                System.out.println("1. Add Book");
                System.out.println("2. Search Book By Title");
                System.out.println("3. Search Book By Code");
                System.out.println("4. Delete Book By Code");
                System.out.println("5. Get All Book");
                System.out.println("6. Update Book");
                System.out.println("7. EXIT");
                System.out.println("Input menu Option (1-7) : ");
                try {
                    String Menu = helper("");
                    noMenu=Integer.parseInt(Menu);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Hanya bisa memasukan angka");
                }
                if (noMenu < 1 || noMenu > 7) {
                    System.out.println("Masukan NO MENU yang benar (angka 1-7)");
                    System.out.println("Tekan ENTER untuk melanjutkan");
                    helper("");
                }else{
                    break;
                }
            }

            if (noMenu==7){
                break;
            }else {
                switch (noMenu) {
                    case 1:
                        System.out.println("pilihan 1");
                        break;
                    case 2:
                        System.out.println("pilihan 2");
                        break;
                    case 3:
                        System.out.println("Pilihan 3");
                        break;
                    case 4:
                        System.out.println("Pilihan 4");
                        break;
                    case 5:
                        System.out.println("pilihan 5");
                        break;
                    case 6:
                        System.out.println("pilihan 6");
                        break;
                }
            }
        }
    }
    private String helper(String data){
        Scanner scanner=new Scanner(System.in);
        System.out.print(data);
        String data2=scanner.nextLine();
        return data2;
    }
}
