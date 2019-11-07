import java.util.*;

/**
 * This program demonstrates the use of a map with key type string and value Emplyee.
 * @version 1.11 2019
 * @author wzw
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> staff = new HashMap<>();
        staff.put("144-25-5464","Amy Lee");
        staff.put("567-24-2546","Harry Hacker");
        staff.put("157-62-7935","Gary Cooper");
        staff.put("456-62--5527","France Cruz");
        //print all entries
        System.out.println(staff);
        //remove an entry
        staff.remove("567-24-2546");
        //replace an entry
        staff.put("456-62-5527","Francesca Miller");
        //look up a value
        System.out.println(staff.get("157-62-7935"));
        //iterate through all entries
        staff.forEach((k,v) ->
                System.out.println("key="+k+",value="+v));
    }
}
