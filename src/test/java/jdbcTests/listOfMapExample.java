package jdbcTests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listOfMapExample {

    String dbUrl = "jdbc:oracle:thin:@44.202.63.224:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1(){

        // creating list for keeping all the rows map
        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();
        row1.put("first_name","Steven");
        row1.put("last_name","king");
        row1.put("salary",24000);
        row1.put("job_id","AD_PRES");

        System.out.println(row1.toString());

        Map<String,Object> row2 = new HashMap<>();
        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("job_id","AD_VP");

        System.out.println(row2.toString());

        System.out.println("----------------------------------------------------------------------");

        // adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);

        // get the Steven last name directly from the list
        System.out.println(queryData.get(0).get("last_name"));

    }

}
