package service;

import entity.Book;
import entity.Magazine;
import entity.Novel;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    @Override
    public void addBook(Book book) {
        List<Book> books = getAllBook();
        books.add(book);
        FileUtil.saveObject(books);
    }

    @Override
    public void searchBookByTitle(String title) {
        List<Book> books = getAllBook();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)){
                try {
                    Novel novel=(Novel) books.get(i);
                    System.out.println("Novel Code : "+novel.getCode());
                    System.out.println("Novel Title : "+novel.getTitle());
                    System.out.println("Novel Publiser : "+novel.getPublisher());
                    System.out.println("Novel publication year : "+novel.getPublicationYear());
                    System.out.println("Novel Writer : "+novel.getWriter());
                    System.out.println();
                }catch (Exception e){
                    Magazine magazine=(Magazine) books.get(i);
                    System.out.println("Magazine Code : "+magazine.getCode());
                    System.out.println("Magazine Title : "+magazine.getTitle());
                    System.out.println("Magazine publication Periodr : "+magazine.getPublicationPeriod());
                    System.out.println("Magazine publication year : "+magazine.getPublicationYear());
                    System.out.println();
                }
            }
        }
    }

    @Override
    public void searchBookByCode(String code) {
        List<Book> books = getAllBook();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCode().equals(code)){
                try {
                    Novel novel=(Novel) books.get(i);
                    System.out.println("Novel Code : "+novel.getCode());
                    System.out.println("Novel Title : "+novel.getTitle());
                    System.out.println("Novel Publiser : "+novel.getPublisher());
                    System.out.println("Novel publication year : "+novel.getPublicationYear());
                    System.out.println("Novel Writer : "+novel.getWriter());
                    System.out.println();
                }catch (Exception e){
                    Magazine magazine=(Magazine) books.get(i);
                    System.out.println("Magazine Code : "+magazine.getCode());
                    System.out.println("Magazine Title : "+magazine.getTitle());
                    System.out.println("Magazine publication Periodr : "+magazine.getPublicationPeriod());
                    System.out.println("Magazine publication year : "+magazine.getPublicationYear());
                    System.out.println();
                }
            }
        }
    }

    @Override
    public void deleteBookByCode(List<Book> books) {
        FileUtil.saveObject(books);
    }

    @Override
    public List<Book> getAllBook() {
        Object object = FileUtil.readObject();
        if (object == null) {
            return new ArrayList<>();
        }
        return (List<Book>) object;
    }

    @Override
    public void updateBook(Book book, int code) {
        List<Book> books = getAllBook();
        books.set(code, book);
        FileUtil.saveObject(books);
    }
}
