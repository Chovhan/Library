package Model.Objects;

public class Book {

    String title;
    String authorFirstName;
    String authorLastName;
    int bookId;
    int bookInstanceId;
    String bookAvailability;

    public Book (String title, String authorFirstName, String authorLastName, int bookId, int bookInstanceId, String bookAvailability) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.bookId = bookId;
        this.bookInstanceId = bookInstanceId;
        this.bookAvailability = bookAvailability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookInstanceId() {
        return bookInstanceId;
    }

    public void setBookInstanceId(int bookInstanceId) {
        this.bookInstanceId = bookInstanceId;
    }

    public String getBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(String bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookAvailability='" + bookAvailability + '\'' +
                '}';
    }
}
