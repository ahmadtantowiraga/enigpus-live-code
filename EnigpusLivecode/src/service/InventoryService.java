package service;

import entity.Book;

public interface InventoryService {
    public void addBook(Book book);
   public void searchBookByTitle();
   public void searchBookByCode();
   public void deleteBookByCode();
   public void getAllBook();
   public void updateBook();
}
