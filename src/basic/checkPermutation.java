package basic;

import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class checkPermutation {
    // check if one string is permutation of the other
    // comparison should be case sensitive. dog is not  "God"
    // white space is significant. "abc   " is not "abc"
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();

        checkPermutation p = new checkPermutation();
        System.out.println(p.check_perm(str1, str2));
        System.out.println(p.check_perm2(str1, str2));
    }

    @Test
    public void test() {
        checkPermutation s = new checkPermutation();
        assertTrue(s.check_perm("", ""));
        assertTrue(s.check_perm("a", "a"));
        assertFalse(s.check_perm("a", "b"));
        assertTrue(s.check_perm("abc", "bac"));
        assertTrue(s.check_perm("aabbc", "bcaba"));
        assertFalse(s.check_perm("abc", "ab"));
    }

    private boolean check_perm(String s1, String s2) {
        // space = O(1)
        // time = O(n)
        // this is more efficient
        int[] arr = new int[256]; // assume only 256 characters in string

        if (s1.length() != s2.length())
            return false;
        if (s1.equals("") && s2.equals(""))
            return true;
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]++;
            arr[s2.charAt(i)]--;
        }
        for (int i : arr)
            if (i != 0)
                return false;
        return true;
    }

    private boolean check_perm2(String s1, String s2) {
        // space = O(n)
        // time = O(nlogn)
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        if (s1.length() != s2.length())
            return false;
        if (s1.equals("") && s2.equals(""))
            return true;
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);

    }
}
