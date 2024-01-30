package service;

import entity.Book;

import java.util.List;

public interface InventoryService {
    public void addBook(Book book);

   public void searchBookByTitle();
   public void searchBookByCode();
   public void deleteBookByCode(List<Book> books);
   public List<Book> getAllBook();

   public void updateBook();
}
