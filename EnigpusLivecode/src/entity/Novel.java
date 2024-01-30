package entity;

public class Novel extends Book{
    private String publisher;
    private String writer;
    public Novel(String title, int publicationYear,String publisher, String writer) {
        super(title, publicationYear);
        this.publisher=publisher;
        this.writer=writer;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTitle() {

        return null;
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
}
