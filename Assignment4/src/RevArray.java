import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RevArray {
    public static void main(String[] arg) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("Before reverse " + list.toString());
        Collections.reverse(list);
        System.out.println("After reverse " + list.toString());
    }
}
