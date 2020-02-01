package Model.Objects;

public class NewBook {

    String title;
    String isbn;
    String authorFirstName;
    String authorLastName;
    String authorBirthDate;
    String authorBirthCountry;
    String pbName;
    String pbCountry;
    String pbCity;
    String pbStreet;
    String bookAvailability;

    public NewBook(String title, String isbn, String authorFirstName, String authorLastName, String authorBirthDate, String authorBirthCountry, String pbName, String pbCountry, String pbCity, String pbStreet, String bookAvailability) {
        this.title = title;
        this.isbn = isbn;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorBirthDate = authorBirthDate;
        this.authorBirthCountry = authorBirthCountry;
        this.pbName = pbName;
        this.pbCountry = pbCountry;
        this.pbCity = pbCity;
        this.pbStreet = pbStreet;
        this.bookAvailability = bookAvailability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorBirthDate() {
        return authorBirthDate;
    }

    public void setAuthorBirthDate(String authorBirthDate) {
        this.authorBirthDate = authorBirthDate;
    }

    public String getAuthorBirthCountry() {
        return authorBirthCountry;
    }

    public void setAuthorBirthCountry(String authorBirthCountry) {
        this.authorBirthCountry = authorBirthCountry;
    }

    public String getPbName() {
        return pbName;
    }

    public void setPbName(String pbName) {
        this.pbName = pbName;
    }

    public String getPbCountry() {
        return pbCountry;
    }

    public void setPbCountry(String pbCountry) {
        this.pbCountry = pbCountry;
    }

    public String getPbCity() {
        return pbCity;
    }

    public void setPbCity(String pbCity) {
        this.pbCity = pbCity;
    }

    public String getPbStreet() {
        return pbStreet;
    }

    public void setPbStreet(String pbStreet) {
        this.pbStreet = pbStreet;
    }

    public String getBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(String bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    @Override
    public String toString() {
        return "NewBook{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", authorBirthDate='" + authorBirthDate + '\'' +
                ", authorBirthCountry='" + authorBirthCountry + '\'' +
                ", pbName='" + pbName + '\'' +
                ", pbCountry='" + pbCountry + '\'' +
                ", pbCity='" + pbCity + '\'' +
                ", pbStreet='" + pbStreet + '\'' +
                ", bookAvailability='" + bookAvailability + '\'' +
                '}';
    }
}
