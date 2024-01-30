package entity;

import java.io.Serializable;

public class Novel extends Book implements Serializable {
    private String title;
    private int publicationYear;
    private String code;
    private static final long serialVersionUID = 1L;
    private String publisher;
    private String writer;
    public Novel(String title, int publicationYear,String publisher, String writer, String code) {
        this.title=title;
        this.publicationYear=publicationYear;
        this.publisher=publisher;
        this.writer=writer;
        this.code=code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {

        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

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
