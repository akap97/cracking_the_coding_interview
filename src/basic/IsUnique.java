package basic;

import java.util.HashSet;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class IsUnique {
    //Implement an algorithm to determine if a string has all unique characters.What if you
    //cannot use additional data structures?
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        IsUnique u = new IsUnique();
        System.out.println(u.is_unique_hash(str)); // with hashmap
        System.out.println(u.is_unique_arr(str)); // with array
        System.out.println(u.is_unique_adv(str)); // bit manipulation

        u.test();
    }

    @Test
    public void test() {
        IsUnique s = new IsUnique();
        assertTrue(s.is_unique_adv(""));
        assertTrue(s.is_unique_adv("abide"));
        assertFalse(s.is_unique_adv("altar"));
    }

    private boolean is_unique_hash(String str) {
        // space = O(str.length)
        HashSet<Character> h = new HashSet<>();
        h.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (h.contains(str.charAt(i))) // O(str.length)
                return false;
            h.add(str.charAt((i)));
        }
        return true;
    }

    private boolean is_unique_arr(String str) {
        //space = 128x1bit
        boolean[] arr = new boolean[128];
        for (int i = 0; i < str.length(); i++) { // O(str.length)
            if (arr[str.charAt(i)])
                return false;
            arr[str.charAt(i)] = true;
        }
        return true;
    }

    private boolean is_unique_adv(String str) {
        // for this approach characters must be between a-z 26 chars
        // so that they can fit in 32 bit checker
        //space = 32bits(for int)
        int checker = 0;
        for (int i =0;i<str.length();i++) { // O(str.length)
            int val = str.charAt(i) - 'a'; // integer diff from 'a'
            int exists = checker & (1 << val); //check if char is already set at that position in checker
            if (exists > 0)
                return false;
            checker |= 1 << val; //set char at correct position in checker
        }
        return true;
    }
}
