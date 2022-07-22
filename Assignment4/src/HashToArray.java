import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashToArray {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            set.add(i);
        }
        System.out.println("Set is " + set.toString());
        int[] arr = new int[set.size()];
        int index = 0;
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()) {
            arr[index] = itr.next();
            index++;
        }
        System.out.println("Array is " + Arrays.toString(arr));
    }
}
