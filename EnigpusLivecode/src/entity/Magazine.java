package entity;

import java.io.Serializable;

public class Magazine extends Book implements Serializable {
    public String title;
    public int publicationYear;
    public String code;
    private static final long serialVersionUID = 1L;
    private String publicationPeriod;

    public Magazine(String title, int publicationYear, String publicationPeriod) {
        this.title=title;
        this.publicationYear=publicationYear;
        this.publicationPeriod=publicationPeriod;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {

        return title;
    }

    public String getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(String publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
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
