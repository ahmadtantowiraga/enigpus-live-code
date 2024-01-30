package service;

import entity.Book;

import java.util.List;

public interface InventoryService {
    public void addBook(Book book);

   public void searchBookByTitle(String title);
   public void searchBookByCode(String code);
   public void deleteBookByCode(List<Book> books);
   public List<Book> getAllBook();

   public void updateBook(Book book, int code);
}
