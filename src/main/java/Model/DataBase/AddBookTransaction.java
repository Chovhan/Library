package Model.DataBase;

import Model.Objects.NewBook;
import org.apache.log4j.Logger;

import java.sql.*;

public class AddBookTransaction {

    public static final Logger logger = Logger.getLogger(AddBookTransaction.class);

    public void addBook(NewBook newBook) throws SQLException {
        logger.info("Add book transaction was started!");
        Connection connection = ConnectionPool.getConnection();
        Savepoint savepoint = null;;
        try {
            connection.setAutoCommit(false);
            logger.info("Auto commit set FALSE!");
            savepoint = connection.setSavepoint("savepoint");
            logger.info("Save point was sated with name: " + savepoint.getSavepointName());
            addBookTitleToDb(connection, newBook.getTitle());

            if (checkAuthorInDb(connection, newBook.getAuthorFirstName(), newBook.getAuthorLastName(), newBook.getAuthorBirthDate(), newBook.getAuthorBirthCountry())){
                logger.info("Author was find in data base!");
                setAuthorIdVar(connection, newBook.getAuthorFirstName(), newBook.getAuthorLastName(), newBook.getAuthorBirthDate(), newBook.getAuthorBirthCountry());
            } else {
                logger.info("Author wasn`t find in data base!");
                addAuthorToDb(connection, newBook.getAuthorFirstName(), newBook.getAuthorLastName(), newBook.getAuthorBirthCountry(), newBook.getAuthorBirthDate());
                addMaxAuthorIdVar(connection);
            }

            addAuthoringToDb(connection);

            if (checkPublishingHouseInDb(connection, newBook.getPbName(), newBook.getPbCountry(), newBook.getPbCity(), newBook.getPbStreet())) {
                logger.info("Publishing house was find in data base!");
                setMaxPublishingHouseIdVar(connection, newBook.getPbName(), newBook.getPbCountry(), newBook.getPbCity(), newBook.getPbStreet());
            } else {
                logger.info("Publishing house wasn`t find in data base!");
                addPublishingHouseToDb(connection, newBook.getPbName(), newBook.getPbCountry(), newBook.getPbCity(), newBook.getPbStreet());
                addMaxPublishinghouseIdVar(connection);
            }


            addContractToDb(connection);

            addIsbnToDb(connection, newBook.getIsbn());

            addBookInstanceToDb(connection);

            connection.commit();
            connection.close();
            logger.info("Transaction was commit!");
        } catch (SQLException e) {
            connection.rollback(savepoint);
            logger.info("We have some problems with transaction so we use ROLLBACK");
            connection.releaseSavepoint(savepoint);
            logger.error("SQLException: " + e);
        }
    }

    private void addBookTitleToDb(Connection connection, String title) throws SQLException {
        System.out.println("addBookTitleToDb()");
        logger.info("Book title was added to db");
        PreparedStatement addBookTitle = connection.prepareStatement("Insert into books(title) values (?);");
        addBookTitle.setString(1, title);
        addBookTitle.executeUpdate();
    }

    private boolean checkAuthorInDb(Connection connection, String authorFirstName, String authorLastName, String birthDate, String birthCountry) throws SQLException {
        System.out.println("checkAuthorInDb()");
        boolean authorInDb = false;
        PreparedStatement checkBook = connection.prepareStatement("select * " +
                "from author where firstName=(?) and lastName=(?) and birthDate=(?) and birthCountry=(?)");
        checkBook.setString(1, authorFirstName);
        checkBook.setString(2, authorLastName);
        checkBook.setString(3, birthDate);
        checkBook.setString(4, birthCountry);
        ResultSet resultSet = checkBook.executeQuery();
        if (resultSet.next()){
            authorInDb = true;
        }
        return authorInDb;
    }

    private void addAuthorToDb(Connection connection, String authorFirstName, String authorLastName, String birthCountry, String birthDate) throws SQLException {
        logger.info("New author was added to db");
        PreparedStatement addAuthor = connection.prepareStatement("" +
                "Insert into author(firstName, lastName, birthDate, birthCountry) " +
                "Values (?, ?, ?, ?);");
        addAuthor.setString(1, authorFirstName);
        addAuthor.setString(2, authorLastName);
        addAuthor.setString(3, birthDate);
        addAuthor.setString(4, birthCountry);
        addAuthor.executeUpdate();
    }

    private void addMaxAuthorIdVar(Connection connection) throws SQLException {
        logger.info("Variable with new author id was set!");
        PreparedStatement createMaxAuthorIdVar = connection.prepareStatement("Set @maxAuthorId=(Select Max(authorId) from author);");
        createMaxAuthorIdVar.executeUpdate();
    }

    private void setAuthorIdVar(Connection connection, String firstName, String lastName, String birthDate, String birthCounty) throws SQLException {
        System.out.println("setAuthorIdVar()");
        logger.info("Variable with author id was set!");
        System.out.println(firstName + " " + lastName + " " + birthDate + " " + birthCounty);
        PreparedStatement createMaxAuthorIdVar = connection.prepareStatement(
                "Set @maxAuthorId=(" +
                        "Select authorId " +
                        "from author " +
                        "where author.firstName = (?) and author.lastName=(?) and author.birthDate=(?) and author.birthCountry=(?));");
        createMaxAuthorIdVar.setString(1, firstName);
        createMaxAuthorIdVar.setString(2, lastName);
        createMaxAuthorIdVar.setString(3, birthDate);
        createMaxAuthorIdVar.setString(4, birthCounty);
        createMaxAuthorIdVar.executeUpdate();
        System.out.println("MaxAuthorId is set!");
    }

    private void addAuthoringToDb(Connection connection) throws SQLException {
        System.out.println("addAuthoringToDb()");
        logger.info("Authoring row was added to data base!");
        PreparedStatement createMaxBookIdVar = connection.prepareStatement("Set @maxBookId=(Select Max(bookId) from books);");
        createMaxBookIdVar.executeUpdate();
        PreparedStatement addAuthoringRow = connection.prepareStatement(
                "Insert into authoring(bookId, authorId) Values (@maxBookId, @maxAuthorId);");
        addAuthoringRow.executeUpdate();
    }

    private boolean checkPublishingHouseInDb(Connection connection, String pbName, String pbCountry, String pbCity, String pbStreet) throws SQLException {
        System.out.println("checkPublishingHouseInDb()");
        boolean pbInDb = false;
        PreparedStatement checkPb = connection.prepareStatement(
                "Select publishinghouseId " +
                        "from publishinghouse " +
                        "Where publishinghouse.publishingHouseName=(?) " +
                        "and publishinghouse.country=(?) " +
                        "and publishinghouse.city=(?) " +
                        "and publishinghouse.street=(?);");
        checkPb.setString(1, pbName);
        checkPb.setString(2, pbCountry);
        checkPb.setString(3, pbCity);
        checkPb.setString(4, pbStreet);
        ResultSet resultSet = checkPb.executeQuery();
        if (resultSet.next()){
            pbInDb = true;
        }
        return pbInDb;
    }

    private void addMaxPublishinghouseIdVar(Connection connection) throws SQLException {
        logger.info("Variable with new publishing house was added!");
        PreparedStatement createVarMaxPbId = connection.prepareStatement(
                "Set @maxPbId=(Select Max(publishinghouseid) from publishinghouse);");
        createVarMaxPbId.executeUpdate();
    }

    private void setMaxPublishingHouseIdVar(Connection connection, String pbName, String pbCountry, String pbCity, String pbStreet) throws SQLException {
        logger.info("Variable with publishing house was added!");
        PreparedStatement createVarMaxPbId = connection.prepareStatement(
                "Set @maxPbId=(Select publishinghouseId " +
                        "from publishinghouse " +
                        "Where publishinghouse.publishingHouseName=(?) " +
                        "and publishinghouse.country=(?) " +
                        "and publishinghouse.city=(?) " +
                        "and publishinghouse.street=(?));");
        createVarMaxPbId.setString(1, pbName);
        createVarMaxPbId.setString(2, pbCountry);
        createVarMaxPbId.setString(3, pbCity);
        createVarMaxPbId.setString(4, pbStreet);
        createVarMaxPbId.executeUpdate();
    }

    private void addPublishingHouseToDb(Connection connection, String pbName, String pbCountry, String pbCity, String pbStreet) throws SQLException {
        logger.info("Publishing house was added to data base!");
        PreparedStatement addPublishingHouse = connection.prepareStatement("" +
                "Insert into publishinghouse(publishingHouseName, country, city, street) " +
                "Values (?, ?, ?, ?);");
        addPublishingHouse.setString(1, pbName);
        addPublishingHouse.setString(2, pbCountry);
        addPublishingHouse.setString(3, pbCity);
        addPublishingHouse.setString(4, pbStreet);
        addPublishingHouse.executeUpdate();
    }

    private void addContractToDb(Connection connection) throws SQLException {
        logger.info("Contract row was added to data base!");
        PreparedStatement addContractRow = connection.prepareStatement(
                "Insert into contract(authorId, publishingHouseId) Values (@maxAuthorId, @maxPbId);");
        addContractRow.executeUpdate();
    }

    private void addIsbnToDb(Connection connection, String isbn) throws SQLException {
        logger.info("Isbn was added to data base!");
        PreparedStatement addIsbn = connection.prepareStatement(
                "Insert into isbn(bookId, publishingHouseId, isbnNumber) Values (@maxBookId, @maxPbId, ?);");
        addIsbn.setString(1, isbn);
        addIsbn.executeUpdate();
    }

    private void addBookInstanceToDb(Connection connection) throws SQLException {
        logger.info("Book instance row was added to data base!");
        PreparedStatement addBookInstance = connection.prepareStatement(
                "Insert into bookistance(bookId, bookAvailibility) Values (@maxBookId, 'Yes');");
        addBookInstance.executeUpdate();
    }
}
