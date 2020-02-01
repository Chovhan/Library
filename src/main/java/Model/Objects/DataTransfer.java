package Model.Objects;

public class DataTransfer {

    String bookTitle;
    String authorFirstName;
    String authorLastName;
    String bookInstanceId;
    String bookGiveTime;
    String visitorFirstName;
    String visitorLastName;
    String visitorPhoneNumber;
    String visitorEmail;

    public DataTransfer(String bookTitle, String authorFirstName, String authorLastName, String bookInstanceId, String bookGiveTime, String visitorFirstName, String visitorLastName, String visitorPhoneNumber, String visitorEmail) {
        this.bookTitle = bookTitle;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.bookInstanceId = bookInstanceId;
        this.bookGiveTime = bookGiveTime;
        this.visitorFirstName = visitorFirstName;
        this.visitorLastName = visitorLastName;
        this.visitorPhoneNumber = visitorPhoneNumber;
        this.visitorEmail = visitorEmail;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public String getBookInstanceId() {
        return bookInstanceId;
    }

    public void setBookInstanceId(String bookInstanceId) {
        this.bookInstanceId = bookInstanceId;
    }

    public String getBookGiveTime() {
        return bookGiveTime;
    }

    public void setBookGiveTime(String bookGiveTime) {
        this.bookGiveTime = bookGiveTime;
    }

    public String getVisitorFirstName() {
        return visitorFirstName;
    }

    public void setVisitorFirstName(String visitorFirstName) {
        this.visitorFirstName = visitorFirstName;
    }

    public String getVisitorLastName() {
        return visitorLastName;
    }

    public void setVisitorLastName(String visitorLastName) {
        this.visitorLastName = visitorLastName;
    }

    public String getVisitorPhoneNumber() {
        return visitorPhoneNumber;
    }

    public void setVisitorPhoneNumber(String visitorPhoneNumber) {
        this.visitorPhoneNumber = visitorPhoneNumber;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    @Override
    public String toString() {
        return "DataTransfer{" +
                "bookTitle='" + bookTitle + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", bookInstanceId='" + bookInstanceId + '\'' +
                ", bookGiveTime='" + bookGiveTime + '\'' +
                ", visitorFirstName='" + visitorFirstName + '\'' +
                ", visitorLastName='" + visitorLastName + '\'' +
                ", visitorPhoneNumber='" + visitorPhoneNumber + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                '}';
    }
}
