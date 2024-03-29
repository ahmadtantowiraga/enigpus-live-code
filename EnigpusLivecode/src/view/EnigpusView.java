package view;

import entity.Book;
import entity.Magazine;
import entity.Novel;
import service.InventoryService;
import service.InventoryServiceImpl;
import util.Utility;

import java.io.IOException;
import java.util.ArrayList;
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
                        searchByTitle();
                        break;
                    case 3:
                        searchByCode();
                        break;
                    case 4:
                        deleteByCode();
                        break;
                    case 5:
                        getAllBookView();
                        break;
                    case 6:
                        updateBook();
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
                Book book=new Novel(title,publicationYear,publiser,writer,Utility.code1(publicationYear));
                inventoryService.addBook(book);
                break;
            }else if(type==2){
                String title=Utility.inputUtil("Input Magazine title : ");
                String publicationPeriod=Utility.inputUtil("select weekly or monthly : ");
                int publicationYear=Utility.inputIntUtil("Input publication Year (Must 4 Charackter) : ");
                Book magazine=new Magazine(title,publicationYear,publicationPeriod,Utility.code2(publicationYear));
                inventoryService.addBook(magazine);
                break;
            }else{
                System.out.println("The choice entered is incorrect, Please Input Again");
            }
        }
    }
    public void getAllBookView(){
        List<Book> books = inventoryService.getAllBook();
        System.out.println("Novel List:");
        String format = String.format("%-20s %-30s %-30s %-30s %-30s", "Novel Code", "Novel Title", "Novel Publiser",
                "Novel publication year","Novel Writer");
        System.out.println(format);
        for (int i = 0; i < books.size(); i++) {
            try {
                Novel novel = (Novel) books.get(i);
                System.out.printf("%-20s %-30s %-30s %-30s %-30s\n", novel.getCode(),novel.getTitle(),novel.getPublisher(),novel.getPublicationYear(),novel.getWriter());
            } catch (Exception e) {
                System.out.print("");
            }
        }
        System.out.println();
        System.out.println("Magazine List : ");
        String format2 = String.format("%-20s %-30s %-30s %-30s ", "Magazine Code", "Magazine Title ", "Magazine publication Periode",
                "Magazine publication year");
        System.out.println(format2);
        for (int i = 0; i < books.size(); i++) {
            try {
                Magazine magazine = (Magazine) books.get(i);
                System.out.printf("%-20s %-30s %-30s %-30s \n",magazine.getCode(),magazine.getTitle(),magazine.getPublicationPeriod(),magazine.getPublicationYear() );
            } catch (Exception e) {
                System.out.print("");
            }
        }
    }
    public void searchByTitle(){
        String title=Utility.inputUtil("Input the key title to seacrh data : ");
        inventoryService.searchBookByTitle(title);
    }
    public void searchByCode(){
        String code=Utility.inputUtil("Input the key Code to seacrh data : ");
        inventoryService.searchBookByCode(code);
    }
    public void deleteByCode(){
        String code=Utility.inputUtil("Input the key Code to delete data : ");
        List<Book> books = inventoryService.getAllBook();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCode().equals(code)){
                books.remove(i);
                inventoryService.deleteBookByCode(books);
            }
        }
    }
    public void updateBook() {
        System.out.println("The type of book you want to Update : ");
        System.out.println("1. Novel");
        System.out.println("2. Magazine");
        while(true){
            int type = Utility.inputIntUtil("Input 1 to Update Novel or Input 2 to Update Magazine: ");
            String updateCode = Utility.inputUtil("Enter the key code that will be updated : ");
            List<Book> books = inventoryService.getAllBook();
                if (type == 1) {
                    String title = Utility.inputUtil("Input Novel title : ");
                    String publiser = Utility.inputUtil("Input the publiser : ");
                    int publicationYear = Utility.inputIntUtil("Input publication year (Must 4 Charakter) : ");
                    String writer = Utility.inputUtil("Input the Writer : ");
                    Book book = new Novel(title, publicationYear, publiser, writer, Utility.code1(publicationYear));
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getCode().equals(updateCode)) {
                            inventoryService.updateBook(book, i);
                        }
                    }

                    break;
                } else if (type == 2) {
                    String title = Utility.inputUtil("Input Magazine title : ");
                    String publicationPeriod = Utility.inputUtil("select weekly or monthly : ");
                    int publicationYear = Utility.inputIntUtil("Input publication Year (Must 4 Charackter) : ");
                    Book magazine=new Magazine(title,publicationYear,publicationPeriod,Utility.code2(publicationYear));
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getCode().equals(updateCode)) {
                            inventoryService.updateBook(magazine, i);
                        }
                    }
                    break;
                } else {
                    System.out.println("The choice entered is incorrect, Please Input Again");
                }
        }
    }
}
