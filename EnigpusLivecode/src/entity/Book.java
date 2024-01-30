package entity;

public abstract class Book {
    private String title;
    private int publicationYear;
    private String code;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public abstract String getCode();
    public abstract void getTitle();
}
