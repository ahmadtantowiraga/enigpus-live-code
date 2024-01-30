package entity;

public class Magazine extends Book{
    private String publicationPeriod;

    public Magazine(String title, int publicationYear, String publicationPeriod) {
        super(title, publicationYear);
        this.publicationPeriod=publicationPeriod;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTitle() {

        return null;
    }

    public String getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(String publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }
}
