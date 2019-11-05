package linkedList;
import java.util.*;

/**
 * This program demonstrate operations on linked lists.
 * @version 1.0 20191105
 * @author wzw
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("carl");
        a.add("erica");

        List<String> b = new LinkedList<>();
        b.add("bob");
        b.add("doug");
        b.add("frances");
        b.add("glorea");

        //merge the words from b to a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        // remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        //bulk operation:remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}
