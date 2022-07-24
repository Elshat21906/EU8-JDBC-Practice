package jdbcTests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBC_Examples {

    String dbUrl = "jdbc:oracle:thin:@44.202.63.224:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

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

        // Close connections
        resultSet.close();
        statement.close();
        connection.close();

    }

}
