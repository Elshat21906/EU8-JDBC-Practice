package jdbcTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBC_Examples {

    String dbUrl = "jdbc:oracle:thin:@44.202.63.224:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @DisplayName("ResultSet Methods")
    @Test
    public void test1() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // move to first row
        //resultSet.next();

        //System.out.println(resultSet.getString(2));

        // display departments table in 10 - Administration - 200 - 1700 format
        //System.out.println(resultSet.getString(1) + "-" + resultSet.getString(2) +
        //     "-" +  resultSet.getInt(3) + "-" + resultSet.getInt(4));

        // code for iterating for ach row
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2)
            + "-" + resultSet.getInt(3) + "-" + resultSet.getInt(4));
        }
        System.out.println("----------------------------------------------------------------------");

        resultSet = statement.executeQuery("select * from regions ");
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
        }
        // Close connections
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // How to find how many rows we have for the query
        // move to last row first
        resultSet.last();

        // get the row count
        int rowCount = resultSet.getRow();

        System.out.println("rowCount = " + rowCount);

        // to move before first row after we use . last method
        resultSet.beforeFirst();

        // print all second column
        while(resultSet.next()){
            System.out.println(resultSet.getString(2));
        }


        // Close connections
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test3() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // get the database related data inside the dbMetadata object
        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());


        // Close connections
        resultSet.close();
        statement.close();
        connection.close();

    }

}
