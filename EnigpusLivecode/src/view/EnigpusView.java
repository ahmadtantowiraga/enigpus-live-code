package view;

import entity.Book;
import entity.Magazine;
import entity.Novel;
import service.InventoryService;
import service.InventoryServiceImpl;
import util.Utility;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EnigpusView {
    private final InventoryService inventoryService;

    public EnigpusView() {
        this.inventoryService = new InventoryServiceImpl();
    }

    public void showMenu(){
        while (true) {
            Integer Menu=null;
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
                Menu = Utility.inputIntUtil("Input menu Option (1-7) : ");
                if (Menu < 1 || Menu > 7) {
                    System.out.println("Masukan NO MENU yang benar (angka 1-7)");
                    System.out.println("Tekan ENTER untuk melanjutkan");
                    Utility.inputUtil("");
                }else{
                    break;
                }
            }

            if (Menu==7){
                break;
            }else {
                switch (Menu) {
                    case 1:
                        addBookView();
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
                        getAllBookView();
                        break;
                    case 6:
                        System.out.println("pilihan 6");
                        break;
                }
            }
        }
    }
    public void addBookView() {
        System.out.println("The type of book you want to add : ");
        System.out.println("1. Novel");
        System.out.println("2. Magazine");
        while (true) {
            int type = Utility.inputIntUtil("Input 1 to add Novel or Input 2 to Add Magazine: ");
            if (type==1){
                String title=Utility.inputUtil("Input Novel title : ");
                String publiser =Utility.inputUtil("Input the publiser : ");
                int publicationYear=Utility.inputIntUtil("Input publication year (Must 4 Charakter) : ");
                String writer = Utility.inputUtil("Input the Writer : ");
                Novel book=new Novel(title,publicationYear,publiser,writer);
                book.setCode(publicationYear+"-"+"A"+"-"+Utility.code());
                inventoryService.addBook(book);
                break;
            }else if(type==2){
                String title=Utility.inputUtil("Input Magazine title : ");
                String publicationPeriod=Utility.inputUtil("select weekly or monthly : ");
                int publicationYear=Utility.inputIntUtil("Input publication Year (Must 4 Charackter) : ");
                Magazine magazine=new Magazine(title,publicationYear,publicationPeriod);
                magazine.setCode(publicationYear+"-"+"B"+"-"+Utility.code());
                inventoryService.addBook(magazine);
                break;
            }else{
                System.out.println("The choice entered is incorrect, Please Input Again");
            }
        }
    }
    public void getAllBookView(){
        List<Book> books = inventoryService.getAllBook();
        System.out.println("Novel List : ");
        String format = String.format("%-15s %-15s %-15s %-15s %-15s", "Novel Code", "Novel Title",
                "Novel Publiser", "Novel Publication Year", "Novel Writer");
        System.out.println(format);
        for (int i = 0; i < books.size(); i++) {
            Novel novel=(Novel) books.get(i);
            if (books.get(0).getCode().charAt(5)=='A'){
                System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", novel.getCode(), novel.getTitle(),
                        novel.getPublisher(),novel.getPublicationYear(),novel.getWriter());
                System.out.println();
            }
        }
        System.out.println("Magazine List : ");
        String format2 = String.format("%-15s %-15s %-15s %-15s", "Magazine Code", "Magazine Title",
                "Magazine publication Period", "Magazine Publication Year");
        System.out.println(format2);
        for (int i = 0; i < books.size(); i++) {
            Magazine magazine=(Magazine) books.get(i);
            if (books.get(0).getCode().charAt(5)=='B'){
                System.out.printf("%-15s %-15s %-15s %-15s\n", magazine.getCode(),magazine.getTitle(),
                        magazine.getCode(), magazine.getPublicationYear());
                System.out.println();
            }
        }
    }
}
