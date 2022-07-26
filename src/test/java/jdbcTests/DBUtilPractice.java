package jdbcTests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void test1(){

        // create connection
        DBUtils.createConnection();

        String query = "select first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum < 6";

        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> row : queryResultMap) {

            System.out.println(row.toString());

        }

        // close the connection
        DBUtils.destroy();
    }


    @Test
    public void test2(){

        // create connection
        DBUtils.createConnection();

        String query = "select first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum < 2";

        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println(rowMap.toString());

        // close the connection
        DBUtils.destroy();



    }

}
