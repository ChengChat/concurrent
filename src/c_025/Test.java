package c_025;

import java.util.Collections;
import java.util.LinkedHashSet;

public class Test {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);
        System.out.println(set);
    }
}
