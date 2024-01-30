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
    public abstract String getTitle();

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
