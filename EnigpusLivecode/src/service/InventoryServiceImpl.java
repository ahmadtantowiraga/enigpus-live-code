package service;

import entity.Book;
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
    public void searchBookByTitle() {

    }

    @Override
    public void searchBookByCode() {

    }

    @Override
    public void deleteBookByCode() {

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
    public void updateBook() {

    }
}
